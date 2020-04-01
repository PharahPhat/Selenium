package com.interop.common.constants.utils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public final class ZipFileUtils {

    private static final Logger logger = LoggerFactory.getLogger(ZipFileUtils.class);

    private ZipFileUtils() {
    }

    public static void zip(String targetPath, File... files) throws IOException {
        try {
            ZipFile zipFile = new ZipFile(targetPath);
            ZipParameters params = new ZipParameters();
            params.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            params.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_MAXIMUM);

            for (File file : files) {
                zipFile.addFile(file, params);
            }

        } catch (Exception ex) {
            throw new IOException(ex);
        }
    }

    public static void zip(String targetPath, String password, File... files) throws IOException {
        if (StringUtils.isBlank(password)) {
            zip(targetPath, files);
            return;
        }

        try {
            ZipFile zipFile = new ZipFile(targetPath);
            ZipParameters params = new ZipParameters();
            params.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            params.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_MAXIMUM);
            params.setPassword(password);
            params.setEncryptFiles(true);
            params.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
            params.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);

            for (File file : files) {
                zipFile.addFile(file, params);
            }

        } catch (Exception ex) {
            throw new IOException(ex);
        }
    }

    public static void zip(String orginalFilePath, String zippedFilePath, String password) throws IOException {
        if (StringUtils.isBlank(password)) {
            zip(orginalFilePath, zippedFilePath);
            return;
        }

        try {
            ZipFile zipFile = new ZipFile(zippedFilePath);
            ZipParameters params = new ZipParameters();
            params.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            params.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_MAXIMUM);
            params.setPassword(password);
            params.setEncryptFiles(true);
            params.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
            params.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
            zipFile.addFile(new File(orginalFilePath), params);
        } catch (Exception ex) {
            throw new IOException(ex);
        }
    }


    /**
     * Decompress the zipped file.
     *
     * @param zippedFile
     * @param destinationFolderPath
     * @throws IOException
     */
    public static void unzip(File zippedFile, String destinationFolderPath) throws IOException {
        try {
            ZipFile zipFile = new ZipFile(zippedFile.getAbsolutePath());
            zipFile.extractAll(destinationFolderPath);
        } catch (ZipException e) {
            logger.error("Error while unzip file {} to folder {}.", zippedFile.getAbsolutePath(), destinationFolderPath);
            throw new IOException(e);
        }
    }

    /**
     * Decompress the encryped zipped file.
     *
     * @param zippedFile
     * @param password
     * @param destinationFolderPath
     * @throws IOException
     */
    public static void unzipEncryptedFile(File zippedFile, char[] password, String destinationFolderPath) throws IOException {
        try {
            ZipFile zipFile = new ZipFile(zippedFile.getAbsolutePath());
            if (zipFile.isEncrypted()) {
                zipFile.setPassword(password);
            }
            zipFile.extractAll(destinationFolderPath);
        } catch (ZipException e) {
            logger.error("Error while unzip file {} to folder {}.", zippedFile.getAbsolutePath(), destinationFolderPath);
            throw new IOException(e);
        }
    }

}
