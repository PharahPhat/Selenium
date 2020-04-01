package com.interop.common.constants.utils;

import com.interop.common.constants.utils.exceptions.PGPDecryptException;
import com.interop.common.constants.utils.exceptions.PGPEncryptException;
import org.apache.log4j.Logger;
import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.bc.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Iterator;

import static org.bouncycastle.bcpg.CompressionAlgorithmTags.ZIP;

public final class PGPUtils {
    private static final Logger LOGGER = Logger.getLogger(PGPUtils.class);
    private static final int BUFFER_SIZE = 4096;

    private PGPUtils() {
    }

    /**
     * Get public key from File input stream
     *
     * @inputStreamPublicKey: full path public key file
     */
    private static PGPPublicKey getPublicKey(InputStream inputStreamPublicKey) throws IOException, PGPException {
        PGPPublicKeyRingCollection publicKeyRings = new PGPPublicKeyRingCollection(PGPUtil.getDecoderStream(inputStreamPublicKey), new BcKeyFingerprintCalculator());

        PGPPublicKey publicKey = null;
        Iterator<PGPPublicKeyRing> keyRingIterator = publicKeyRings.getKeyRings();

        while (publicKey == null && keyRingIterator.hasNext()) {
            PGPPublicKeyRing kRing = keyRingIterator.next();
            Iterator<PGPPublicKey> publicKeyIterator = kRing.getPublicKeys();

            while (publicKey == null && publicKeyIterator.hasNext()) {
                PGPPublicKey key = publicKeyIterator.next();
                if (key.isEncryptionKey()) {
                    publicKey = key;
                }
            }
        }

        if (publicKey == null) {
            throw new IllegalArgumentException("Can't find public key in the key ring.");
        }

        return publicKey;
    }

    private static PGPPrivateKey getPrivateKey(InputStream inputStreamPrivateKey, long keyID, char[] pass) throws IOException, PGPException {
        PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(inputStreamPrivateKey), new BcKeyFingerprintCalculator());
        PGPSecretKey pgpSecKey = pgpSec.getSecretKey(keyID);
        if (pgpSecKey == null) {
            throw new IllegalArgumentException("Can't find encryption key inputStream key ring.");
        }

        return pgpSecKey.extractPrivateKey(new BcPBESecretKeyDecryptorBuilder(new BcPGPDigestCalculatorProvider()).build(pass));
    }

    /**
     * @param encryptedAlgorithm one of the {@link SymmetricKeyAlgorithmTags supported symmetric cipher
     *                           *            algorithms}. May not be {@link SymmetricKeyAlgorithmTags#NULL}.
     */
    public static void encryptFile(String encryptedFilePath, String fileToEncrypt, String publicKeyPath,
                                   boolean armor, boolean withIntegrityCheck, int encryptedAlgorithm) throws IOException {

        Path encryptedFile = Paths.get(encryptedFilePath);
        Files.createDirectories(encryptedFile.getParent());
        try (
                FileOutputStream encryptedFileOutputStream = new FileOutputStream(encryptedFile.toFile())) {
            encryptFile(encryptedFileOutputStream, fileToEncrypt, new FileInputStream(publicKeyPath), armor, withIntegrityCheck, encryptedAlgorithm);
        } catch (Exception e) {
            throw new PGPEncryptException(String.format("Encrypt file %s failed", fileToEncrypt), e);
        }
    }

    private static void encryptFile(OutputStream encryptedFileOutputStream, String fileToEncrypt, InputStream publicKeyInputStream,
                                    boolean armor, boolean withIntegrityCheck, int encryptedAlgorithm) throws IOException, PGPException {
        Security.addProvider(new BouncyCastleProvider());

        PGPPublicKey publicKey = getPublicKey(publicKeyInputStream);

        BcPGPDataEncryptorBuilder dataEncryptor = new BcPGPDataEncryptorBuilder(encryptedAlgorithm);
        dataEncryptor.setWithIntegrityPacket(withIntegrityCheck);
        dataEncryptor.setSecureRandom(new SecureRandom());

        PGPEncryptedDataGenerator encryptedDataGenerator = new PGPEncryptedDataGenerator(dataEncryptor);
        encryptedDataGenerator.addMethod(new BcPublicKeyKeyEncryptionMethodGenerator(publicKey));

        ByteArrayOutputStream tempDataOutputSteam = new ByteArrayOutputStream();
        PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(ZIP);
        PGPUtil.writeFileToLiteralData(comData.open(tempDataOutputSteam), PGPLiteralData.BINARY, new File(fileToEncrypt)); // NOSONAR:
        comData.close();
        byte[] bytes = tempDataOutputSteam.toByteArray();
        try {
            // comData close will also close returned OutputStream
            writeEncryptedDataToFile(encryptedFileOutputStream, encryptedDataGenerator, bytes, armor);
        } finally {
            tempDataOutputSteam.close();
            encryptedDataGenerator.close();
        }
    }

    private static void writeEncryptedDataToFile(OutputStream encryptedFileOutputStream, PGPEncryptedDataGenerator encryptedDataGenerator, byte[] bytes, boolean armor) throws IOException, PGPException {
        OutputStream encryptedFileOutputStreamWriter = null;
        try (ArmoredOutputStream armoredEncryptedFileOutputStream = new ArmoredOutputStream(encryptedFileOutputStream)) {
            if (armor) {
                encryptedFileOutputStreamWriter = encryptedDataGenerator.open(armoredEncryptedFileOutputStream, bytes.length);
            } else {
                encryptedFileOutputStreamWriter = encryptedDataGenerator.open(encryptedFileOutputStream, bytes.length);
            }
            encryptedFileOutputStreamWriter.write(bytes);
        } finally {
            if (encryptedFileOutputStreamWriter != null) encryptedFileOutputStreamWriter.close();
        }
    }

    public static void decryptFile(String encryptedFilePath, String decryptedFilePath, String privateKeyPath, String password) throws IOException {
        Path decryptedFile = Paths.get(decryptedFilePath);
        Files.createDirectories(decryptedFile.getParent());
        try (
                FileInputStream encryptedFileInputStream = new FileInputStream(encryptedFilePath);
                FileInputStream privateKeyFileInputStream = new FileInputStream(privateKeyPath);
                FileOutputStream decryptedFileOutputStream = new FileOutputStream(decryptedFile.toFile())) {

            decryptFile(encryptedFileInputStream, privateKeyFileInputStream, decryptedFileOutputStream, password.toCharArray());

        } catch (Exception e) {
            throw new PGPDecryptException(String.format("Decrypt file %s failed", encryptedFilePath), e);
        }
    }

    @SuppressWarnings("unchecked")
    private static void decryptFile(InputStream encryptedFileInputStream, InputStream privateKeyInputStream, OutputStream decryptedFileOutputStream, char[] password) throws IOException, PGPException {
        Security.addProvider(new BouncyCastleProvider());

        PGPObjectFactory pgpObjectFactory = new PGPObjectFactory(PGPUtil.getDecoderStream(encryptedFileInputStream), new BcKeyFingerprintCalculator());
        PGPEncryptedDataList pgpEncryptedDataList;
        Object nextObject = pgpObjectFactory.nextObject();
        if (nextObject instanceof PGPEncryptedDataList) {
            pgpEncryptedDataList = (PGPEncryptedDataList) nextObject;
        } else {
            pgpEncryptedDataList = (PGPEncryptedDataList) pgpObjectFactory.nextObject();
        }

        if (pgpEncryptedDataList == null) {
            throw new PGPDecryptException("Failed to get PGPEncryptedDataList!");
        }

        Iterator<PGPPublicKeyEncryptedData> iterator = pgpEncryptedDataList.getEncryptedDataObjects();
        PGPPrivateKey pgpPrivateKey = null;
        PGPPublicKeyEncryptedData pgpPublicKeyEncryptedData = null;

        while (pgpPrivateKey == null && iterator.hasNext()) {
            pgpPublicKeyEncryptedData = iterator.next();
            pgpPrivateKey = getPrivateKey(privateKeyInputStream, pgpPublicKeyEncryptedData.getKeyID(), password);
        }

        if (pgpPrivateKey == null) {
            throw new PGPDecryptException("PGP Secret key not found!");
        }

        InputStream encPDataStream = pgpPublicKeyEncryptedData.getDataStream(new BcPublicKeyDataDecryptorFactory(pgpPrivateKey));
        PGPObjectFactory plainFact = new PGPObjectFactory(encPDataStream, new BcKeyFingerprintCalculator());
        Object message = plainFact.nextObject();

        if (message instanceof PGPCompressedData) {
            PGPCompressedData cData = (PGPCompressedData) message;
            PGPObjectFactory pgpFact = new PGPObjectFactory(cData.getDataStream(), new BcKeyFingerprintCalculator());
            message = pgpFact.nextObject();
        }

        if (message instanceof PGPLiteralData) {
            PGPLiteralData pgpLiteralData = (PGPLiteralData) message;
            InputStream literalDataStream = pgpLiteralData.getInputStream();

            byte[] buffer = new byte[BUFFER_SIZE];
            int length;
            while ((length = literalDataStream.read(buffer)) != -1) {
                decryptedFileOutputStream.write(buffer, 0, length);
            }

        } else if (message instanceof PGPOnePassSignatureList) {
            throw new PGPException("Encrypted message contains a signed message - not literal data.");
        } else {
            throw new PGPException("Message is not a simple encrypted file - type unknown.");
        }

        if (pgpPublicKeyEncryptedData.isIntegrityProtected() && !pgpPublicKeyEncryptedData.verify()) {
            throw new PGPException("Message failed integrity check");
        }
    }

    public static void closeResourceQuitely(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                LOGGER.error("Error on PGP Utils class" + e.getMessage());
            }
        }
    }
}
