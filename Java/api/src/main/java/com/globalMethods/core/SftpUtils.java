package com.globalMethods.core;

import com.jcraft.jsch.*;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import static java.util.Comparator.comparingInt;

public class SftpUtils {

	private static final int CONS_SFTP_SEND_FILE_RETRYCOUNT = 50;
	public static final String CHANNEL_TYPE_SFTP = "sftp";
	public static final String STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking";
	public static final String SFTP_HOST = "nhdevftp.sandata.com";
	public static final String SFTP_PORT = "22";
	public static final String SFTP_USER_NAME = "H4mAD4DM";
	public static final String SFTP_PASSWORD = "ckgz4zcU";//NOSONAR
	public static final SftpConfig SFTP_CONFIG = new SftpConfig();

	public interface SftpCallback {
		Object execute(ChannelSftp channelSftp) throws InterruptedException, java.text.ParseException,  SftpException, IOException;
	}

	static {
		SFTP_CONFIG.setHost(SFTP_HOST);
		SFTP_CONFIG.setPort(Integer.parseInt(SFTP_PORT));
		SFTP_CONFIG.setUsername(SFTP_USER_NAME);
		SFTP_CONFIG.setPassword(SFTP_PASSWORD);
	}

	private static Logger LOGGER = Logger.getLogger(SftpUtils.class);

	SftpUtils(){}

	public synchronized static Object execute(SftpCallback callback) throws InterruptedException, java.text.ParseException,  SftpException, JSchException, IOException {
		return execute(SFTP_CONFIG, callback);
	}

	public synchronized static Object execute(SftpConfig config, SftpCallback callback) throws InterruptedException, java.text.ParseException,  JSchException, SftpException, IOException {
		Session session = new JSch().getSession(
				config.getUsername(),
				config.getHost(),
				config.getPort());
		session.setConfig(STRICT_HOST_KEY_CHECKING, "no");
		session.setPassword(config.getPassword());
		session.connect();
		ChannelSftp channel = (ChannelSftp)session.openChannel(CHANNEL_TYPE_SFTP);
		channel.connect();
		try {
			return callback.execute(channel);
		} catch (Exception ex) {
			LOGGER.error("SFTP error: " + ex.getMessage());
			throw ex;
		} finally {
			channel.disconnect();
			session.disconnect();
		}
	}

	public  static String downloadLatestFile(String fileNamePrefix, String remoteDir, FileType fileType, String localDir) throws InterruptedException, java.text.ParseException,  JSchException, SftpException, IOException {
		return downloadLatestFileWithComparator(
				fileNamePrefix,
				remoteDir,
				fileType,
				localDir,
				Comparator.comparing(o -> getFileTimestamp(o.getFilename()))
				);
	}

	public synchronized String downloadLatestFileByModifiedTime(String fileNamePrefix, String remoteDir, FileType fileType, String localDir) throws InterruptedException, java.text.ParseException,  JSchException, SftpException, IOException {
		return downloadLatestFileWithComparator(
				fileNamePrefix,
				remoteDir,
				fileType,
				localDir,
				comparingInt(o -> o.getAttrs().getMTime())
				);
	}

	@SuppressWarnings("unchecked")
	public synchronized static String downloadLatestFileWithComparator(
			String fileNamePrefix,
			String remoteDir,
			FileType fileType,
			String localDir,
			Comparator<ChannelSftp.LsEntry> fileComparator) throws InterruptedException, java.text.ParseException,  JSchException, SftpException, IOException {
		return (String) execute(channelSftp -> {
			Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteDir);//NOSONAR
			ChannelSftp.LsEntry latestEntry = files.stream()
					.filter(entry -> !".".equals(entry.getFilename()) && !"..".equals(entry.getFilename()))
					.filter(entry -> entry.getFilename().toLowerCase().endsWith(fileType.getExtension()))
					.filter(entry -> entry.getFilename().startsWith(fileNamePrefix))
					.peek(entry -> LOGGER.info("Found remote file: " + entry.getFilename()))
					.max(fileComparator)
					.orElse(null);
			if (Objects.isNull(latestEntry)) {
				return null;
			}
			Path localDirPath = Paths.get(localDir);
			if (!localDirPath.toFile().exists()) {
				Files.createDirectory(localDirPath);
			}
			String downloadedFile = Paths.get(localDir, latestEntry.getFilename()).toString();
			String remoteFileAbsPath = remoteDir + "/" + latestEntry.getFilename();
			LOGGER.info("Downloading remote file " + remoteFileAbsPath);
			channelSftp.get(
					remoteFileAbsPath,
					downloadedFile);
			LOGGER.info("File downloaded at " + downloadedFile);
			return downloadedFile;
		});
	}

	private synchronized static String getFileTimestamp(String fileName) {
		// We expect the filename should be "prefix_<timestamp>.extension"
		return fileName.substring(fileName.lastIndexOf('_') + 1, fileName.indexOf('.'));
	}

	public  enum FileType {
		ZIP(".zip"), CSV(".csv"), TXT(".txt");

		String extension;

		FileType(String extension) {
			this.extension = extension;
		}

		public String getExtension() {
			return extension;
		}
	}

	public synchronized File getFile(String dstAbsolutePath, SftpUtils.FileType fileType, String fileNamePrefix, String localDir) throws InterruptedException, java.text.ParseException,  Exception {
		String filePath = null;
		File file = new File(localDir + "/" + fileNamePrefix + fileType.getExtension());

		if (!file.exists()){
			LOGGER.info("No file available in local = " + localDir);
			LOGGER.info("Finding latest file from the remote = " + dstAbsolutePath);

			filePath = SftpUtils.downloadLatestFile(
					fileNamePrefix,
					dstAbsolutePath,
					fileType, localDir);
			LOGGER.info("Downloaded latest file = " + filePath);
			if (fileNamePrefix.equalsIgnoreCase("SAMDataExtracts_")){
				LOGGER.info("Extracting the .zip file");
				file = new File(localDir + fileNamePrefix + fileType.getExtension());
			}else {
				file = new File(filePath);
			}
		}
		LOGGER.info("file.getPath() = " + file.getPath());
		return file;
	}

	@SuppressWarnings("unchecked")
	public synchronized ChannelSftp.LsEntry getLatestFileInSftpDirectory(
			String fileNamePrefix,
			String remoteDir,
			FileType fileType) throws InterruptedException, java.text.ParseException,  JSchException, SftpException, IOException {
		return (ChannelSftp.LsEntry) execute(channelSftp -> {
			Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteDir);//NOSONAR
			ChannelSftp.LsEntry latestEntry = files.stream()
					.filter(entry -> !".".equals(entry.getFilename()) && !"..".equals(entry.getFilename()))
					.filter(entry -> entry.getFilename().toLowerCase().endsWith(fileType.getExtension()))
					.filter(entry -> entry.getFilename().startsWith(fileNamePrefix))
					.peek(entry -> LOGGER.info("Found remote file: " + entry.getFilename()))
					.max(comparingInt(o -> o.getAttrs().getMTime()))
					.orElse(null);
			if (Objects.isNull(latestEntry)) {
				return null;
			}
			return latestEntry;
		});
	}

	@SuppressWarnings("unchecked")
	public synchronized String waitForFileExported(String remoteDir,
			String fileNamePrefix,
			FileType fileType,
			int sleepInterval,
			int timeout) throws InterruptedException, ParseException {
		ChannelSftp.LsEntry entry = null;
		long startTime = System.currentTimeMillis();
		do {
			try {
				entry = (ChannelSftp.LsEntry) execute(channelSftp -> {
					Vector<ChannelSftp.LsEntry> files = channelSftp.ls(remoteDir);
					return files.stream()
							.filter(e -> !".".equals(e.getFilename()) && !"..".equals(e.getFilename()))
							.filter(e -> e.getFilename().toLowerCase().endsWith(fileType.getExtension()))
							.filter(e -> e.getFilename().startsWith(fileNamePrefix))
							.peek(e -> LOGGER.debug("Found remote file: " + e.getFilename()))
							.findFirst()
							.orElse(null);
				});
			} catch (SftpException | JSchException | IOException e) {
				LOGGER.warn("Error occurs: " + e.getMessage());
			}
			if (Objects.nonNull(entry)) {
				break;
			}
			try {
				LOGGER.debug("File not found, sleeping " + sleepInterval + "ms");
				Thread.sleep(sleepInterval);
			} catch (InterruptedException e) {
				LOGGER.warn("Error occurs: " + e.getMessage());
				return null;
			}
		} while ((System.currentTimeMillis() - startTime) < timeout);

		if (Objects.isNull(entry)) {
			String message = "Fail to find expected file after " + ((System.currentTimeMillis() - startTime) + "ms");
			LOGGER.error(message);
		}
		return entry.getFilename();
	}

	public synchronized File getFile(String remoteDir, String localDir, String remoteFileName) throws InterruptedException, ParseException {
		try {
			return  (File) execute(channelSftp -> {
				String remoteAbsPath = remoteDir + "/" + remoteFileName;
				String localAbsPath = localDir + "/" + remoteFileName;
				Path localDirPath = Paths.get(localDir);
				if (!Files.exists(localDirPath)) {
					LOGGER.info("Creating directory " + localDir);
					Files.createDirectory(localDirPath);
				}
				LOGGER.info("Download from " + remoteAbsPath + " to " + localAbsPath);
				channelSftp.get(remoteAbsPath, localAbsPath);
				LOGGER.info("Download successfully to " + localAbsPath);
				return new File(localAbsPath);
			});
		} catch (SftpException | JSchException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public synchronized void sftpSendFile(String srcAbsolutePath, String dstAbsolutePath) throws InterruptedException, java.text.ParseException,  SftpException, IOException, InterruptedException {
		int retryConnectionCount = 3;
		boolean verify = false;
		while (!verify && retryConnectionCount > 0) {
			try {
				execute(channelSftp -> {
					channelSftp.put(srcAbsolutePath, dstAbsolutePath);
					return null;
				});
				verify = true;
				LOGGER.info("Successfully uploaded file " + srcAbsolutePath + " to " + dstAbsolutePath);
			} catch (JSchException e) {
				LOGGER.error("sftpSendFile fail by error", e);
				LOGGER.info("retryConnectionCount = " + retryConnectionCount);
				LOGGER.info("Sleeping 1 minute(s) ... ");
				Thread.sleep(60000);
				retryConnectionCount--;
			}

		}
	}

	public synchronized boolean isSftpListFileExisted(String dstAbsolutePath, List<String> fileNames) throws InterruptedException, java.text.ParseException,  InterruptedException
	{
		for(String filename: fileNames){
			boolean isExist  = getFile(dstAbsolutePath + filename, 5);
			if(isExist == false)
				return false;
		}
		return true;
	}

	public synchronized boolean isSftpFileExisted(String dstAbsolutePath) throws InterruptedException, java.text.ParseException,  InterruptedException {
		return getFile(dstAbsolutePath, CONS_SFTP_SEND_FILE_RETRYCOUNT);
	}

	public synchronized boolean isSftpFileExisted(String dstAbsolutePath, int retryCount) throws InterruptedException, java.text.ParseException,  InterruptedException {
		return getFile(dstAbsolutePath, retryCount);
	}

	private synchronized boolean getFile(String dstAbsolutePath, int retryCount) throws InterruptedException, java.text.ParseException,  InterruptedException {
		AtomicBoolean isExisted = new AtomicBoolean(false);
		while (!isExisted.get() && retryCount > 0) {
			try {
				execute(channelSftp -> {
					channelSftp.stat(dstAbsolutePath);
					isExisted.set(true);
					return true;
				});
			} catch (SftpException | JSchException | IOException e) {
				LOGGER.info("Caught exception. " + e.getMessage());
				LOGGER.info("retryCount = " + retryCount);
				LOGGER.info("Sleeping 10 Seconds(s) ... ");
				TimeUnit.SECONDS.sleep(10);
				retryCount--;
			}
		}
		return isExisted.get();
	}

	@SuppressWarnings("unchecked")
	public synchronized List<String> getAllFileNames(SftpConfig config, String folderPath, String extension) {
		Session session = null;
		ChannelSftp channelSftp = null;
		List<String> fileNames = new ArrayList<>();
		try {
			session = new JSch().getSession(
					config.getUsername(),
					config.getHost(),
					config.getPort());
			session.setConfig(STRICT_HOST_KEY_CHECKING, "no");
			session.setPassword(config.getPassword());
			session.connect();
			channelSftp = (ChannelSftp)session.openChannel(CHANNEL_TYPE_SFTP);
			channelSftp.connect();
			Vector<ChannelSftp.LsEntry> list = channelSftp.ls(folderPath + "/*." + extension);
			for(ChannelSftp.LsEntry entry : list) {
				fileNames.add(folderPath + "/" + entry.getFilename());
				System.out.println(entry.getFilename());
			}
		}  catch (JSchException|SftpException e) {
			LOGGER.error("SFTP error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			channelSftp.disconnect();
			session.disconnect();
		}
		return fileNames;
	}

	public synchronized void deleteFiles( List<String> fileNames) {
		Session session = null;
		SftpConfig config =SFTP_CONFIG;
		ChannelSftp channelSftp = null;
		try {
			session = new JSch().getSession(
					config.getUsername(),
					config.getHost(),
					config.getPort());
			session.setConfig(STRICT_HOST_KEY_CHECKING, "no");
			session.setPassword(config.getPassword());
			session.connect();
			channelSftp = (ChannelSftp)session.openChannel(CHANNEL_TYPE_SFTP);
			channelSftp.connect();
			deleteFiles(channelSftp, fileNames);
		}  catch (JSchException e) {
			LOGGER.error("SFTP error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			channelSftp.disconnect();
			session.disconnect();
		}
	}

	private synchronized void deleteFiles(ChannelSftp channelSftp, List<String> fileNames) {
		for(String fileName : fileNames) {
			try {

				channelSftp.rm(fileName);
				LOGGER.error("Delete file successfully: " + fileNames);
			} catch (Exception e) {
				LOGGER.error("Delete file error: " + e.getMessage());
			}
		}
	}
}
