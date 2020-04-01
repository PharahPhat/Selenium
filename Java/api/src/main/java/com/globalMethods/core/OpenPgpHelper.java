package com.globalMethods.core;

import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.bc.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Iterator;

public class OpenPgpHelper {

    private  String privatePassword = "sandata";
    private  String sandataPrivateKeylocation =System.getProperty("user.dir") +File.separator+"lib"+File.separator;
    private  String sandataPrivateKeyFile = "intf_san_molina_pkey.asc";
   
    public synchronized String decryptFiles(String fileToDecryptPath,String fileName,String decryptedFilePath) throws InterruptedException, java.text.ParseException,  Exception {
        return decryptFile(fileToDecryptPath, decryptedFilePath, privatePassword,fileName);
    }

    public synchronized String encryptFile(String fileToEncryptPath, String encryptedFilePath,String keyPath) throws InterruptedException, java.text.ParseException,  Exception {

        File fileToEncrypt = new File(fileToEncryptPath);

        Path path = Paths.get(encryptedFilePath);
        //Files.createDirectories(path.getParent());
        FileOutputStream fileOutputStream = new FileOutputStream(path.toFile());
        encryptFile(fileOutputStream, fileToEncrypt, readPublic(keyPath));
        
        fileOutputStream.close();
        return path.toFile().getAbsolutePath();
    }

    private synchronized PGPPublicKey readPublic(String publicFileKeyPath) throws InterruptedException, java.text.ParseException,  IOException, PGPException {

        File publicFileKey = new File(publicFileKeyPath);
        FileInputStream fileInputStream = new FileInputStream(publicFileKey);
        InputStream inputStream = PGPUtil.getDecoderStream(fileInputStream);
        PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(inputStream, new BcKeyFingerprintCalculator());
        PGPPublicKey key = null;
        Iterator iterator = pgpPub.getKeyRings();
        while (key == null && iterator.hasNext()) {
            PGPPublicKeyRing kRing = (PGPPublicKeyRing) iterator.next();
            Iterator kIt = kRing.getPublicKeys();
            while (key == null && kIt.hasNext()) {
                PGPPublicKey k = (PGPPublicKey) kIt.next();
                if (k.isEncryptionKey()) {
                    key = k;
                }
            }
        }
        if (key == null) {
            throw new IllegalArgumentException("Can't find encryption key inputStream key ring.");
        }

        fileInputStream.close();
        inputStream.close();

        return key;
    }
  
    private synchronized PGPSecretKey readPrivate(String privateFileKeyPath, long keyId) throws InterruptedException, java.text.ParseException,  IOException, PGPException {

       // ClassLoader classLoader = OpenPgpHelper.class.getClassLoader();
        File privateFileKey = new File(sandataPrivateKeylocation+sandataPrivateKeyFile);

        InputStream inputStream = PGPUtil.getDecoderStream(new FileInputStream(privateFileKey));
        PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(inputStream, new BcKeyFingerprintCalculator());

        PGPSecretKey key = pgpSec.getSecretKey(keyId);

        if (key == null) {
            throw new IllegalArgumentException("Can't find encryption key inputStream key ring.");
        }

        return key;
    }

    @SuppressWarnings("unchecked")
	private synchronized String decryptFile(String fileToDecryptPath, String decryptedFilePath, String password,String fileName) throws InterruptedException, java.text.ParseException,  IOException, PGPException {

      //  ClassLoader classLoader = OpenPgpHelper.class.getClassLoader();
        File fileToDecrypt = new File(fileToDecryptPath+fileName);

        InputStream inputStream = PGPUtil.getDecoderStream(new FileInputStream(fileToDecrypt));

        Security.addProvider(new BouncyCastleProvider());

        PGPObjectFactory pgpObjectFactory = new PGPObjectFactory(inputStream, new BcKeyFingerprintCalculator());

        Object nextObject = pgpObjectFactory.nextObject();
        PGPEncryptedDataList pgpEncryptedDataList;

        if (nextObject instanceof PGPEncryptedDataList) {
            pgpEncryptedDataList = (PGPEncryptedDataList) nextObject;
        } else {
            pgpEncryptedDataList = (PGPEncryptedDataList) pgpObjectFactory.nextObject();
        }

        Iterator<PGPPublicKeyEncryptedData> iterator = pgpEncryptedDataList.getEncryptedDataObjects();
        PGPPrivateKey sKey = null;
        PGPSecretKey secKey;
        PGPPublicKeyEncryptedData encP = null;
        while (sKey == null && iterator.hasNext()) {
            encP = iterator.next();
            secKey = readPrivate(sandataPrivateKeylocation, encP.getKeyID());
            sKey = secKey.extractPrivateKey(new BcPBESecretKeyDecryptorBuilder(new BcPGPDigestCalculatorProvider()).build(password.toCharArray()));
        }

        if (sKey == null) {
            throw new IllegalArgumentException("Secret key for message not found.");
        }

        InputStream encPDataStream = encP.getDataStream(new BcPublicKeyDataDecryptorFactory(sKey));

        JcaPGPObjectFactory jcaPGPObjectFactory;

        jcaPGPObjectFactory = new JcaPGPObjectFactory(encPDataStream);

        PGPCompressedData c1 = (PGPCompressedData) jcaPGPObjectFactory.nextObject();

        jcaPGPObjectFactory = new JcaPGPObjectFactory(c1.getDataStream());

        PGPLiteralData pgpLiteralData = (PGPLiteralData) jcaPGPObjectFactory.nextObject();
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        InputStream literalDataStream = pgpLiteralData.getDataStream();

        int ch;
        while ((ch = literalDataStream.read()) >= 0) {
            bOut.write(ch);
        }

        String result = new String(bOut.toByteArray());

        @SuppressWarnings("unused")
		Path path = Paths.get(decryptedFilePath);
        //Files.createDirectories(path.getParent());

        bOut.writeTo(new FileOutputStream(decryptedFilePath+ fileName.replace(".gpg", "")));

        bOut.close();

        return result;
    }

    private synchronized void encryptFile(OutputStream out, File fileToEncrypt, PGPPublicKey encKey) throws InterruptedException, java.text.ParseException,  IOException, NoSuchProviderException, PGPException {

        Security.addProvider(new BouncyCastleProvider());

        ByteArrayOutputStream bOut = new ByteArrayOutputStream();

        PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(PGPCompressedData.ZIP);

        PGPUtil.writeFileToLiteralData(comData.open(bOut), PGPLiteralData.BINARY, fileToEncrypt);

        comData.close();

        PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(new BcPGPDataEncryptorBuilder(SymmetricKeyAlgorithmTags.TRIPLE_DES).setSecureRandom(new SecureRandom()));

        cPk.addMethod(new BcPublicKeyKeyEncryptionMethodGenerator(encKey));

        byte[] bytes = bOut.toByteArray();

        OutputStream cOut = cPk.open(out, bytes.length);

        cOut.write(bytes);

        cOut.close();

        out.close();
    }
}