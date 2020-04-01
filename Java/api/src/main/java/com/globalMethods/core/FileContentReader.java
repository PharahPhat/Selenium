package com.globalMethods.core;

import junit.framework.Assert;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertNotEquals;

public class FileContentReader {

    public static String batFileNamePsftpbat = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "put.bat";
    public static String batFileNamePsftpbatget = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "get.bat";
    public static String batFileNamePsftpbatdelete = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "delete.bat";
    private static Logger LOGGER = Logger.getLogger(FileContentReader.class);
    private static String keyPath = System.getProperty("user.dir") + File.separator + "lib" + File.separator + "intf_molina_publickey.asc";
    SftpUtils SftpUtils = new SftpUtils();
    OpenPgpHelper OpenPgpHelper = new OpenPgpHelper();

    public synchronized void runCommand(String filePath, String fileContent) throws Exception {

        try {
            createFile(filePath, fileContent);
            Thread.sleep(10);
            Runtime.getRuntime().exec(filePath);
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("IOException", e);
        }
    }

    public synchronized void deleteFile(String filePath) {
        File file = new File(filePath);

        if (file.exists()) {
            file.delete();
        }
    }

    public synchronized void createFile(String filepath, String fileContent) throws InterruptedException, java.text.ParseException, IOException {
        File file = new File(filepath);

        if (file.exists()) {
            deleteFile(filepath);
        }

        file.createNewFile();
        FileWriter filewriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bufferedwriter = new BufferedWriter(filewriter);
        bufferedwriter.write(fileContent);

        bufferedwriter.close();

    }

    public synchronized void createPipeDelimitedFiles(Map<String, String> fileUpdateValue, String Filepath) throws InterruptedException, java.text.ParseException, IOException {

        StringBuffer Finalvalue = new StringBuffer();
        int i = 0;
        for (String keyvalue : fileUpdateValue.keySet()) {
            Finalvalue = Finalvalue.append(fileUpdateValue.get(keyvalue));

            System.out.println(fileUpdateValue.size());
            System.out.println(i);
            if (i != fileUpdateValue.size() - 1) {
                Finalvalue.append("|");
            }
            i++;
        }
        String finalvalueString = Finalvalue.toString();

        createFile(Filepath, finalvalueString);


    }

    @SuppressWarnings("resource")
    public synchronized void verifyFileContainString(String FilePath, List<String> Compare, int Row) {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator<String> iterator = Compare.iterator();
        while (iterator.hasNext()) {
            String comparevalue = iterator.next();
            System.out.println(mapdataByRow.get(Row).get(0));
            if (mapdataByRow.get(Row).get(0).contains(comparevalue)) {
                System.out.println(comparevalue + " is present in File");
            } else {
                Assert.fail(comparevalue + " is not present in  File");
            }
        }

    }

    @SuppressWarnings("resource")
    public synchronized int verifyFileContainStringInrow(String FilePath, String Compare) {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();
        int rowNumber = 1;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;


            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = 0;
        for (int i = 1; i <= rowNumber; i++) {
            System.out.println(mapdataByRow.get(i).get(0));
            if (mapdataByRow.get(i).get(0).contains(Compare)) {
                System.out.println(Compare + " is present in File");
                count = i;
                break;
            }

        }
        return count;

    }

    @SuppressWarnings("resource")
    public synchronized void Verify_numberofrows_infile(String Filepath, int getrow) throws IOException {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();

        BufferedReader reader = new BufferedReader(new FileReader(Filepath));
        String row = null;

        int rowNumber = 1;
        while ((row = reader.readLine()) != null) {
            mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
            if (rowNumber < getrow) {
                System.out.println(rowNumber + " rows are availaible");
            } else {
                Assert.fail(rowNumber + " row number availaible so failed.");
            }
            rowNumber++;
        }
    }

    @SuppressWarnings("resource")
    public synchronized String createPipeDelimFileAndConvertToGPG(String FilePath, Map<String, String> mapdataByValue, String fileFormat, String type, String timeStamp) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();

        String[] tcname = Thread.currentThread().getStackTrace()[2].getMethodName().split("_");
        String latestFileName = fileFormat + tcname[2] + "_" + type + "_" + timeStamp + ".csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            String[] mapdataByRowStringArray = mapdataByRowString.split(Pattern.quote("|"));

            String mapdataByRowavalue = mapdataByRow.get(3).get(0);
            String[] mapdataByRowvalueArray = mapdataByRowavalue.split(Pattern.quote("|"));
            for (Map.Entry<String, String> valueEntry : mapdataByValue.entrySet()) {

                for (int i = 0; i < mapdataByRowStringArray.length; i++) {

                    if (mapdataByRowStringArray[i].equalsIgnoreCase("\"" + valueEntry.getKey() + "\"")) {

                        mapdataByRowvalueArray[i] = "\"" + valueEntry.getValue() + "\"";
                        break;
                    }
                }
            }


            StringBuffer Finalvalue = new StringBuffer();
            for (int i = 0; i < mapdataByRowvalueArray.length; i++) {
                Finalvalue = Finalvalue.append(mapdataByRowvalueArray[i]);
                if (i != mapdataByRowvalueArray.length - 1) {
                    Finalvalue.append("|");
                }
            }
            String finalvalueString = Finalvalue.toString();

            createFile(globalVariables.Encryptfile + latestFileName, mapdataByRowString + "\n" + finalvalueString);

            String result = OpenPgpHelper.encryptFile(globalVariables.Encryptfile + latestFileName, globalVariables.EncryptedfileResult + latestFileName + ".gpg", keyPath);
            assertNotNull(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latestFileName;

    }

    public String returnStringforMultipleField(List<Map<String, String>> mapdataByValue, Map<Integer, List<String>> mapdataByRow, String mapdataByRowString) {
        List<String> arrayFinalvalue = new ArrayList<String>();

        String[] mapdataByRowStringArray = mapdataByRowString.split(Pattern.quote("|"));

        for (int j = 0; j < mapdataByValue.size(); j++) {
            String mapdataByRowavalue = mapdataByRow.get(3).get(0);
            String[] mapdataByRowvalueArray = mapdataByRowavalue.split(Pattern.quote("|"));
            for (Map.Entry<String, String> valueEntry : mapdataByValue.get(j).entrySet()) {

                for (int i = 0; i < mapdataByRowStringArray.length; i++) {

                    if (mapdataByRowStringArray[i].equalsIgnoreCase("\"" + valueEntry.getKey() + "\"")) {

                        mapdataByRowvalueArray[i] = "\"" + valueEntry.getValue() + "\"";
                        break;
                    }
                }
            }


            StringBuffer Finalvalue = new StringBuffer();
            for (int i = 0; i < mapdataByRowvalueArray.length; i++) {
                Finalvalue = Finalvalue.append(mapdataByRowvalueArray[i]);
                if (i != mapdataByRowvalueArray.length - 1) {
                    Finalvalue.append("|");
                }
            }

            arrayFinalvalue.add(Finalvalue.toString());
        }
        StringBuffer Finalvalue1 = new StringBuffer();
        for (String arrayFinal : arrayFinalvalue) {
            Finalvalue1.append("\n");
            Finalvalue1.append(arrayFinal);
        }
        return Finalvalue1.toString();
    }

    @SuppressWarnings("resource")
    public synchronized String createPipeDelimFileAndConvertToGPGMultiple(String FilePath, List<Map<String, String>> mapdataByValue, String fileFormat, String type, String timeStamp) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();
        //String abc = null	;
        String[] tcname = Thread.currentThread().getStackTrace()[2].getMethodName().split("_");
        String latestFileName = fileFormat + tcname[2] + "_" + type + "_" + timeStamp + ".csv";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            createFile(globalVariables.Encryptfile + latestFileName, mapdataByRowString + returnStringforMultipleField(mapdataByValue, mapdataByRow, mapdataByRowString));

            String result = OpenPgpHelper.encryptFile(globalVariables.Encryptfile + latestFileName, globalVariables.EncryptedfileResult + latestFileName + ".gpg", keyPath);
            assertNotNull(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latestFileName;

    }

    public synchronized String createPipeDelimFileAndConvertToGPGWithRemovalField(String FilePath, List<String> mapDataToRemove, String timeStamp) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();
        String latestFileName = globalVariables.memberGenericFileName + timeStamp + ".csv";

        try {
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            String[] mapdataByRowStringArray = mapdataByRowString.split(Pattern.quote("|"));
            List<String> list = new ArrayList<String>(Arrays.asList(mapdataByRowStringArray));

            String mapdataByRowavalue = mapdataByRow.get(3).get(0);
            String[] mapdataByRowvalueArray = mapdataByRowavalue.split(Pattern.quote("|"));
            List<String> listvalue = new ArrayList<String>(Arrays.asList(mapdataByRowvalueArray));
            for (String valueEntry : mapDataToRemove) {

                for (int i = 0; i < mapdataByRowStringArray.length; i++) {

                    if (mapdataByRowStringArray[i].equalsIgnoreCase("\"" + valueEntry + "\"")) {
                        list.remove(mapdataByRowStringArray[i]);
                        listvalue.remove(mapdataByRowvalueArray[i]);
                        break;
                    }
                }
            }


            StringBuffer Finalvalue = new StringBuffer();
            StringBuffer FinalField = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                Finalvalue = Finalvalue.append(listvalue.get(i));
                if (i != listvalue.size() - 1) {
                    Finalvalue.append("|");
                }
            }
            for (int i = 0; i < listvalue.size(); i++) {
                FinalField = FinalField.append(list.get(i));
                if (i != list.size() - 1) {
                    FinalField.append("|");
                }
            }
            String finalvalueString = Finalvalue.toString();
            String finalFieldString = FinalField.toString();

            createFile(globalVariables.Encryptfile + latestFileName, finalFieldString + "\n" + finalvalueString);
            runCommand(globalVariables.batFileCreation, globalVariables.batcommandwrite);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latestFileName;

    }

    @SuppressWarnings("resource")
    public synchronized Map<String, String> readFileDataAddToMap(String FilePath) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();

        Map<String, String> mapdataByValue = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            String[] mapdataByRowStringArray = mapdataByRowString.split(Pattern.quote("|"));

            String mapdataByRowavalue = mapdataByRow.get(2).get(0);
            String[] mapdataByRowvalueArray = mapdataByRowavalue.split(Pattern.quote("|"));
            for (int i = 0; i < mapdataByRowStringArray.length; i++) {
                mapdataByValue.put(mapdataByRowStringArray[i], mapdataByRowvalueArray[i]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapdataByValue;

    }

    public synchronized Map<String, String> readFileDataAddToMapWithRowNo(String FilePath, int rows) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();

        Map<String, String> mapdataByValue = new HashMap<>();
        try {
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            String[] mapdataByRowStringArray = mapdataByRowString.split(Pattern.quote("|"));

            String mapdataByRowavalue = mapdataByRow.get(rows).get(0);
            String[] mapdataByRowvalueArray = mapdataByRowavalue.split(Pattern.quote("|"));
            for (int i = 0; i < mapdataByRowStringArray.length; i++) {
                mapdataByValue.put(mapdataByRowStringArray[i], mapdataByRowvalueArray[i]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mapdataByValue;

    }

    @SuppressWarnings("resource")
    public synchronized Map<String, String> getFileDataOnMap(String FilePath) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();
        Map<String, String> finalMapapdataByRow = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            String[] mapdataByRowStringArray = mapdataByRowString.split(Pattern.quote("|"));

            String mapdataByRowavalue = mapdataByRow.get(2).get(0);
            String[] mapdataByRowvalueArray = mapdataByRowavalue.split(Pattern.quote("|"));

            for (int i = 0; i < mapdataByRowStringArray.length; i++) {

                finalMapapdataByRow.put(mapdataByRowStringArray[i].replace("\"", ""), mapdataByRowvalueArray[i].replace("\"", ""));

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalMapapdataByRow;
    }

    public synchronized List<String> getFileNamesInDirectory(String directoryPath) {

        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        List<String> fileNames = new ArrayList<>();
        for (File file : files) {
            fileNames.add(file.getName());
        }
        return fileNames;
    }

    public synchronized void deletefilesFromServer(List<String> putFile, List<String> getfileNames) {

        List<String> fileNames = new ArrayList<String>();
        for (String putFiles : putFile) {
            fileNames.add(globalVariables.memberFtpLocation + "/" + putFiles);
        }

        for (String getfileName : getfileNames) {
            fileNames.add(globalVariables.memberFtpLocationErrorControlFile + "/" + getfileName);
        }


        SftpUtils.deleteFiles(fileNames);

    }

    @SuppressWarnings("unused")
    public synchronized List<String> getFIleFromftpLocation(List<String> getFile, String errorFile, String timeStamp) throws Exception {
        List<String> fileNamesToDecrypt = new ArrayList<String>();
        File file;
        List<String> processedFileList = new ArrayList<String>();

        for (String getfiles : getFile) {
            file = SftpUtils.getFile(globalVariables.memberFtpLocation, globalVariables.decryptedfileResult, getfiles);
        }


        processedFileList.add(CommonMethods.generateInboundControlFile(timeStamp, globalVariables.memberGenericFileNameControlFile));

        if (errorFile != null) {
            String[] tcname = Thread.currentThread().getStackTrace()[3].getMethodName().split("_");
            processedFileList.add(globalVariables.memberGenericFileNameControlFile + tcname[2] + "_" + errorFile + "_Error_" + timeStamp + ".csv.gpg");
        }

        TimeUnit.SECONDS.sleep(50);

        for (String processedFileLists : processedFileList) {
            SftpUtils.isSftpFileExisted(globalVariables.memberFtpLocationErrorControlFile + "/" + processedFileLists);

            file = SftpUtils.getFile(globalVariables.memberFtpLocationErrorControlFile, globalVariables.decryptedfileResult, processedFileLists);
        }

        System.out.println("---------------Decrypting the files --------------------");

        fileNamesToDecrypt.addAll(getFile);
        fileNamesToDecrypt.addAll(processedFileList);

        for (String fileName : fileNamesToDecrypt) {
            System.out.println(fileNamesToDecrypt);
            String result = OpenPgpHelper.decryptFiles(globalVariables.decryptedfileResult, fileName, globalVariables.decryptedfileResultTo);
        }

        return processedFileList;
    }

    public synchronized String createOutboundFileAndEncrypt(Map<String, String> processedFile, String timeStamp) throws Exception {
        String[] tcname = Thread.currentThread().getStackTrace()[2].getMethodName().split("_");


        String outBoundFileName = "MEDHHS_EVV_" + tcname[2] + "_Outbound_ControlFile_" + timeStamp + ".csv";
        StringBuffer Finalvalue = new StringBuffer();
        Finalvalue.append("\"FileName\"|\"RecordCount\"" + "\n");
        for (String fileName : processedFile.keySet()) {
            Finalvalue.append("\"" + fileName + "\"|\"" + processedFile.get(fileName) + "\"\n");

        }
        Finalvalue.append("\"" + outBoundFileName + "\"|\"" + (processedFile.size() + 2) + "\"\n");
        Finalvalue.append("\"" + CommonMethods.generatePastDate_MMddYYYY() + "\" - \"" + CommonMethods.generateFutureDate_YYYY_MM_dd_Time() + "\"");

        createFile(globalVariables.Encryptfile + outBoundFileName, Finalvalue.toString());
        String result = OpenPgpHelper.encryptFile(globalVariables.Encryptfile + outBoundFileName, globalVariables.EncryptedfileResult + outBoundFileName + ".gpg", keyPath);
        assertNotNull(result);
        return outBoundFileName + ".gpg";
    }

    public synchronized List<String> putGetFilefromServer(String FileName, String OutBoundFileName, String errorFile, String timeStamp) throws Exception {
        System.out.println("------------------Prcessing the File Using Ftp-----------------");
        List<String> putFile = new ArrayList<String>();
        List<String> fileNames = new ArrayList<String>();

        putFile.add(FileName + ".gpg");
        putFile.add(OutBoundFileName);

        System.out.println("------------------put the File Using Ftp-----------------");

        for (String putFiles : putFile) {
            SftpUtils.sftpSendFile(globalVariables.EncryptedfileResult + putFiles, globalVariables.memberFtpLocation);
        }

        Thread.sleep(20000);

        List<String> getfileName = getFIleFromftpLocation(putFile, errorFile, timeStamp);

        //deletefilesFromServer(putFile,getfileName);
        fileNames.addAll(putFile);
        fileNames.addAll(getfileName);
        return fileNames;
    }


    public synchronized void deleteAllFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        for (File file : directory.listFiles()) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    public synchronized List<String> putGetFilefromServer_Control(Map<String, String> FileName, String OutBoundFileName, String errorFile, String timeStamp) throws Exception {

        System.out.println("------------------Prcessing the File Using Ftp-----------------");
        List<String> putFile = new ArrayList<String>();

        for (String filename : FileName.keySet()) {
            putFile.add(filename + ".gpg");
        }

        putFile.add(OutBoundFileName);

        System.out.println("------------------put the File Using Ftp-----------------");
        for (String putFiles : putFile) {
            SftpUtils.sftpSendFile(globalVariables.EncryptedfileResult + putFiles, globalVariables.memberFtpLocation);
        }
        Thread.sleep(20000);


        List<String> getfileName = getFIleFromftpLocation(putFile, errorFile, timeStamp);

        deletefilesFromServer(putFile, getfileName);
        List<String> fileNames = getFileNamesInDirectory(globalVariables.decryptedfileResultTo);


        return fileNames;
    }

    //Ohio

    public synchronized void deletefilesFromServerOHIO(List<String> getfileNames) {

        List<String> fileNames = new ArrayList<String>();


        for (String getfileName : getfileNames) {
            fileNames.add(globalVariables.ohioClaimFtpLocation + "/" + getfileName);
        }


        SftpUtils.deleteFiles(fileNames);

    }

    @SuppressWarnings("unused")
    public synchronized List<String> getFIleFromftpLocationOHIO(List<String> getFile, String errorFile, String timeStamp, String batchId) throws Exception {

        File file;
        List<String> processedFileList = new ArrayList<String>();

        processedFileList.add(globalVariables.ohioproductionFileNamegenerated + timeStamp + "_" + batchId + ".dsv");

        processedFileList.add(globalVariables.ohiInboundFileNamegenerated + batchId + "_Controlfile_" + timeStamp + ".dsv");

        if (errorFile != null) {
            processedFileList.add(globalVariables.memberGenericFileNameControlFile + errorFile + "_Error_" + timeStamp + ".csv.gpg");

        }
        TimeUnit.SECONDS.sleep(5);
        for (String processedFileLists : processedFileList) {
            SftpUtils.isSftpFileExisted(globalVariables.ohioClaimFtpLocation + "/" + processedFileLists);

            file = SftpUtils.getFile(globalVariables.ohioClaimFtpLocation, globalVariables.getOhioClaimFileDrop, processedFileLists);
        }

        return processedFileList;
    }

    public synchronized List<String> OhioputFileonServer(String FileName, String Filename2, String filename3) throws Exception {
        System.out.println("------------------Prcessing the File Using Ftp-----------------");
        List<String> putFile = new ArrayList<String>();
        List<String> fileNames = new ArrayList<String>();

        putFile.add(FileName);
        putFile.add(Filename2);
        putFile.add(filename3);

        System.out.println("------------------put the File Using Ftp-----------------");

        SftpUtils.sftpSendFile(globalVariables.getOhioproviderlocation + FileName, globalVariables.OhioProviderFtpLocationfull);
        SftpUtils.sftpSendFile(globalVariables.getOhioproviderlocation + Filename2, globalVariables.OhioProviderFtpLocationcontract);
        SftpUtils.sftpSendFile(globalVariables.getOhioproviderlocation + filename3, globalVariables.OhioProviderFtpLocationspec);

        return fileNames;
    }

    public synchronized List<String> OhioputFileonServer4Files(String FileName, String Filename2, String filename3, String filename4) throws Exception {
        System.out.println("------------------Prcessing the File Using Ftp-----------------");
        List<String> putFile = new ArrayList<String>();
        List<String> fileNames = new ArrayList<String>();

        putFile.add(FileName);
        putFile.add(Filename2);
        putFile.add(filename3);
        putFile.add(filename4);

        System.out.println("------------------put the File Using Ftp-----------------");

        SftpUtils.sftpSendFile(globalVariables.getOhioproviderlocation + filename3, globalVariables.OhioProviderFtpLocationspec);
        SftpUtils.sftpSendFile(globalVariables.getOhioproviderlocation + Filename2, globalVariables.OhioProviderFtpLocationcontract);
        SftpUtils.sftpSendFile(globalVariables.getOhioproviderlocation + filename4, globalVariables.OhioProviderFtpLocationfull);
        Thread.sleep(3000);
        SftpUtils.sftpSendFile(globalVariables.getOhioproviderlocation + FileName, globalVariables.OhioProviderFtpLocationfull);

        return fileNames;
    }

    @SuppressWarnings("unused")
    public synchronized List<String> getFIleFromftpLocationOHIO_withoutoutbound(List<String> getFile, String errorFile, String timeStamp, String batchId) throws Exception {

        File file;
        List<String> processedFileList = new ArrayList<String>();

        processedFileList.add(globalVariables.ohioproductionFileNamegenerated + "." + timeStamp + "." + batchId + ".txt");
        processedFileList.add(globalVariables.ohiInboundFileNamegenerated + "." + timeStamp + "." + batchId + ".txt");
        if (errorFile != null) {
            processedFileList.add(globalVariables.memberGenericFileNameControlFile + errorFile + "_Error_" + timeStamp + ".csv.gpg");

        }
        TimeUnit.SECONDS.sleep(5);

        for (String processedFileLists : processedFileList) {
            if (SftpUtils.isSftpFileExisted(globalVariables.ohioClaimFtpLocation + "/" + processedFileLists) != true) {
                assertNotEquals((globalVariables.ohiInboundFileNamegenerated + "." + timeStamp + "." + batchId + ".txt"), (globalVariables.ohioClaimFtpLocation + "/" + processedFileLists));
            }

            file = SftpUtils.getFile(globalVariables.ohioClaimFtpLocation, globalVariables.getOhioClaimFileDrop, processedFileLists);
        }


        return processedFileList;
    }

    public synchronized String createOutboundFileOhio(Map<String, String> processedFile, String timeStamp, String batchId) throws Exception {
        String outBoundFileName = globalVariables.ohiooutboundFileNamegenerated + batchId + "_Controlfile_" + timeStamp + ".dsv";

        StringBuffer Finalvalue = new StringBuffer();
        Finalvalue.append("\"FileName\"|\"RecordCount\"\n");
        for (String fileName : processedFile.keySet()) {
            Finalvalue.append("\"" + fileName + "\"|\"" + processedFile.get(fileName) + "\"\n");
        }

        Finalvalue.append("\"|\"" + "2019-01-23T08:00:00Z" + "\"|\"" + "2019-01-23T11:00:00Z" + "\"|\"\"");

        createFile(globalVariables.getOhioClaimFilePick + outBoundFileName, Finalvalue.toString());

        return outBoundFileName;
    }

    public synchronized List<String> putGetFilefromServerOhio(String FileName, String OutBoundFileName, String errorFile, String timeStamp, String batchId) throws Exception {
        System.out.println("------------------Processing the File Using Ftp-----------------");
        List<String> putFile = new ArrayList<String>();

        putFile.add(FileName);
        putFile.add(OutBoundFileName);

        //CleanUp bad data
        List<String> listFileOnSFTP = SftpUtils.getAllFileNames(com.globalMethods.core.SftpUtils.SFTP_CONFIG,globalVariables.ohioClaimFtpLocationload,"dsv");
        SftpUtils.deleteFiles(listFileOnSFTP);

        System.out.println("------------------put the File Using Ftp-----------------");
        for (String putFiles : putFile) {
            SftpUtils.sftpSendFile(globalVariables.getOhioClaimFilePick + putFiles, globalVariables.ohioClaimFtpLocationload);
        }


        List<String> getfileName = getFIleFromftpLocationOHIO(putFile, errorFile, timeStamp, batchId);

        deletefilesFromServerOHIO(getfileName);
        List<String> fileNames = getFileNamesInDirectory(globalVariables.getOhioClaimFileDrop);


        return fileNames;
    }

    public synchronized List<String> putGetFilefromServerOhio_without_outbound(String FileName, String errorFile, String timeStamp, String batchId) throws Exception {
        System.out.println("------------------Prcessing the File Using Ftp-----------------");
        List<String> putFile = new ArrayList<String>();

        putFile.add(FileName);


        System.out.println("------------------put the File Using Ftp-----------------");
        for (String putFiles : putFile) {
            SftpUtils.sftpSendFile(globalVariables.getOhioClaimFilePick + putFiles, globalVariables.ohioClaimFtpLocationload);
        }


        List<String> getfileName = getFIleFromftpLocationOHIO_withoutoutbound(putFile, errorFile, timeStamp, batchId);

        deletefilesFromServerOHIO(getfileName);
        List<String> fileNames = getFileNamesInDirectory(globalVariables.getOhioClaimFileDrop);


        return fileNames;
    }

    @SuppressWarnings("resource")
    public synchronized String createPipeDelimFilefileohio(String FilePath, Map<String, String> mapdataByValue, String timeStamp) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();
        String latestFileName = (globalVariables.ohioproductionFileName + timeStamp + "_" + mapdataByValue.get(globalVariables.batchid) + ".dsv");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            String[] mapdataByRowStringArray = mapdataByRowString.split(Pattern.quote("|"));

            String mapdataByRowavalue = mapdataByRow.get(2).get(0);
            String[] mapdataByRowvalueArray = mapdataByRowavalue.split(Pattern.quote("|"));
            for (Map.Entry<String, String> valueEntry : mapdataByValue.entrySet()) {

                for (int i = 0; i < mapdataByRowStringArray.length; i++) {
                    if (mapdataByRowStringArray[i].equalsIgnoreCase("\"" + valueEntry.getKey() + "\"")) {

                        mapdataByRowvalueArray[i] = "\"" + valueEntry.getValue() + "\"";
                        break;
                    }
                }
            }


            StringBuffer Finalvalue = new StringBuffer();
            for (int i = 0; i < mapdataByRowvalueArray.length; i++) {
                Finalvalue = Finalvalue.append(mapdataByRowvalueArray[i]);
                if (i != mapdataByRowvalueArray.length - 1) {
                    Finalvalue.append("|");
                }
            }
            String finalvalueString = Finalvalue.toString();

            File pickUpDir = new File(globalVariables.getOhioClaimFilePick);
            File dropDir = new File(globalVariables.getOhioClaimFileDrop);
            if (!pickUpDir.exists()) {
                System.out.println("Create dir: " + pickUpDir.getAbsolutePath());
                pickUpDir.mkdir();
            }
            if (!dropDir.exists()) {
                System.out.println("Create dir: " + dropDir.getAbsolutePath());
                dropDir.mkdir();
            }
            createFile(globalVariables.getOhioClaimFilePick + latestFileName, mapdataByRowString + "\n" + finalvalueString);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latestFileName;

    }

    @SuppressWarnings("resource")
    public synchronized String createPipeDelimFilefileohioMultiple(String FilePath, List<Map<String, String>> mapMultipleEntry, String timeStamp, String batch) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();
        String latestFileName = (globalVariables.ohioproductionFileName + timeStamp + "_" + batch + ".dsv");


        try {
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            createFile(globalVariables.getOhioClaimFilePick + latestFileName, mapdataByRowString + returnStringforMultipleField(mapMultipleEntry, mapdataByRow, mapdataByRowString));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latestFileName;

    }


    public void cleanupOHIO() {
		/*deleteAllFilesInDirectory(globalVariables.getOhioClaimFilePick);
		deleteAllFilesInDirectory(globalVariables.getOhioClaimFileDrop);*/


    }

    // Indiana

    public synchronized String createOutboundFileAndEncryptGeneric(Map<String, String> processedFile, String timeStamp, String fileFormate) throws Exception {
        String[] tcname = Thread.currentThread().getStackTrace()[2].getMethodName().split("_");

        String outBoundFileName = fileFormate + tcname[2] + "_Outbound_ControlFile_" + timeStamp + ".csv";
        StringBuffer Finalvalue = new StringBuffer();
        Finalvalue.append("\"FileName\"|\"RecordCount\"" + "\n");
        for (String fileName : processedFile.keySet()) {
            Finalvalue.append("\"" + fileName + "\"|\"" + processedFile.get(fileName) + "\"\n");

        }
        Finalvalue.append("\"" + outBoundFileName + "\"|\"" + (processedFile.size() + 2) + "\"\n");
        Finalvalue.append("\"" + CommonMethods.generatePastDate_MMddYYYY() + "\" - \"" + CommonMethods.generateFutureDate_YYYY_MM_dd_Time() + "\"");

        createFile(globalVariables.Encryptfile + outBoundFileName, Finalvalue.toString());
        String result = OpenPgpHelper.encryptFile(globalVariables.Encryptfile + outBoundFileName, globalVariables.EncryptedfileResult + outBoundFileName + ".gpg", keyPath);
        assertNotNull(result);
        return outBoundFileName + ".gpg";
    }

    @SuppressWarnings("unused")
    public synchronized List<String> getFIleFromftpLocationindiana(List<String> getFile, String errorFile, String timeStamp) throws Exception {
        List<String> fileNames;
        List<String> fileNamesToDecrypt = new ArrayList<String>();
        File file;
        List<String> processedFileList = new ArrayList<String>();
        for (String getfiles : getFile) {
            file = SftpUtils.getFile(globalVariables.indianaFtpControlLocation, globalVariables.decryptedfileResult, getfiles);
        }
        fileNames = getFileNamesInDirectory(globalVariables.decryptedfileResult);
        processedFileList.add(CommonMethods.generateInboundControlFile(timeStamp, globalVariables.indianaGenericFileFormat));
        if (errorFile != null) {
            String[] tcname = Thread.currentThread().getStackTrace()[3].getMethodName().split("_");
            processedFileList.add(globalVariables.indianaGenericFileFormat + tcname[2] + "_" + errorFile + "_" + "Error" + "_" + timeStamp + ".csv.gpg");
        }

        TimeUnit.SECONDS.sleep(50);
        for (String processedFileLists : processedFileList) {
            SftpUtils.isSftpFileExisted(globalVariables.indianaFtpInboundLocation + "/" + processedFileLists);

            file = SftpUtils.getFile(globalVariables.indianaFtpInboundLocation, globalVariables.decryptedfileResult, processedFileLists);
        }
        System.out.println("---------------Decrypting the files --------------------");
        fileNamesToDecrypt.addAll(getFile);
        fileNamesToDecrypt.addAll(processedFileList);

        for (String fileName : fileNamesToDecrypt) {
            System.out.println(fileNamesToDecrypt);
            String result = OpenPgpHelper.decryptFiles(globalVariables.decryptedfileResult, fileName, globalVariables.decryptedfileResultTo);
        }

        return processedFileList;
    }

    @SuppressWarnings("unused")
    public synchronized List<String> getFIleFromftpLocationPensolvania(List<String> getFile, String errorFile, String timeStamp) throws Exception {
        List<String> fileNames;
        List<String> fileNamesToDecrypt = new ArrayList<String>();
        File file;
        List<String> processedFileList = new ArrayList<String>();
        for (String getfiles : getFile) {
            file = SftpUtils.getFile(globalVariables.pensolvaniaFtpControlLocation, globalVariables.decryptedfileResult, getfiles);
        }
        fileNames = getFileNamesInDirectory(globalVariables.decryptedfileResult);
        processedFileList.add(CommonMethods.generateInboundControlFile(timeStamp, globalVariables.PAGenericFileFormat));
        if (errorFile != null) {
            String[] tcname = Thread.currentThread().getStackTrace()[3].getMethodName().split("_");
            processedFileList.add(globalVariables.PAGenericFileFormat + tcname[2] + "_" + errorFile + "_" + "Error" + "_" + timeStamp + ".csv.gpg");
        }

        TimeUnit.SECONDS.sleep(50);
        for (String processedFileLists : processedFileList) {
            SftpUtils.isSftpFileExisted(globalVariables.pensolvaniaFtpInboundLocation + "/" + processedFileLists);

            file = SftpUtils.getFile(globalVariables.pensolvaniaFtpInboundLocation, globalVariables.decryptedfileResult, processedFileLists);
        }
        System.out.println("---------------Decrypting the files --------------------");
        fileNamesToDecrypt.addAll(getFile);
        fileNamesToDecrypt.addAll(processedFileList);

        for (String fileName : fileNamesToDecrypt) {
            System.out.println(fileNamesToDecrypt);
            String result = OpenPgpHelper.decryptFiles(globalVariables.decryptedfileResult, fileName, globalVariables.decryptedfileResultTo);
        }

        return processedFileList;
    }

    public synchronized List<String> putGetFilefromServerIndiana(String FileName, String OutBoundFileName, String errorFile, String timeStamp) throws Exception {
        System.out.println("------------------Processing the File Using FTP-----------------");
        List<String> putFile = new ArrayList<String>();
        List<String> fileNames = new ArrayList<String>();

        putFile.add(FileName + ".gpg");
        putFile.add(OutBoundFileName);

        System.out.println("------------------put the File Using Ftp-----------------");
        for (String putFiles : putFile) {
            SftpUtils.sftpSendFile(globalVariables.EncryptedfileResult + putFiles, globalVariables.indianaFtpControlLocation);
        }

        Thread.sleep(20000);

        List<String> getfileName = getFIleFromftpLocationindiana(putFile, errorFile, timeStamp);

        //deletefilesFromServerIndiana(putFile,getfileName);
        fileNames.addAll(putFile);
        fileNames.addAll(getfileName);


        return fileNames;
    }

    public synchronized List<String> putGetFilefromServerPensolvania(String FileName, String OutBoundFileName, String errorFile, String timeStamp) throws Exception {
        System.out.println("------------------Processing the File Using FTP-----------------");
        List<String> putFile = new ArrayList<String>();
        List<String> fileNames = new ArrayList<String>();

        putFile.add(FileName + ".gpg");
        putFile.add(OutBoundFileName);

        System.out.println("------------------put the File Using Ftp-----------------");
        for (String putFiles : putFile) {
            SftpUtils.sftpSendFile(globalVariables.EncryptedfileResult + putFiles, globalVariables.pensolvaniaFtpControlLocation);
        }

        Thread.sleep(20000);

        List<String> getfileName = getFIleFromftpLocationPensolvania(putFile, errorFile, timeStamp);

        deletefilesFromServerpenselvania(putFile, getfileName);
        fileNames.addAll(putFile);
        fileNames.addAll(getfileName);


        return fileNames;
    }

    public synchronized void deletefilesFromServerIndiana(List<String> putFile, List<String> getfileNames) {

        List<String> fileNames = new ArrayList<String>();
        for (String putFiles : putFile) {
            fileNames.add(globalVariables.indianaFtpControlLocation + "/" + putFiles);
        }

        for (String getfileName : getfileNames) {
            fileNames.add(globalVariables.indianaFtpInboundLocation + "/" + getfileName);
        }


        SftpUtils.deleteFiles(fileNames);

    }

    public synchronized void deletefilesFromServerpenselvania(List<String> putFile, List<String> getfileNames) {

        List<String> fileNames = new ArrayList<String>();
        for (String putFiles : putFile) {
            fileNames.add(globalVariables.pensolvaniaFtpControlLocation + "/" + putFiles);
        }

        for (String getfileName : getfileNames) {
            fileNames.add(globalVariables.pensolvaniaFtpInboundLocation + "/" + getfileName);
        }


        SftpUtils.deleteFiles(fileNames);

    }

    public synchronized void putReportFileIndiana(List<String> FileNames) throws Exception {

        System.out.println("------------------put the File Using Ftp-----------------");

        for (int i = 0; i < FileNames.size(); i++) {
            SftpUtils.sftpSendFile(globalVariables.indianaReports + FileNames.get(i), globalVariables.indianaDownloadLocation);
        }

        for (int i = 0; i < FileNames.size(); i++) {
            SftpUtils.isSftpFileExisted(globalVariables.indianaDownloadLocation + "/" + FileNames.get(i));

            LOGGER.info(FileNames.get(i) + " " + "exist");
        }

    }

    public synchronized boolean isFileExist_Encrypted_Indiana(List<String> FileNames) throws Exception {
        Thread.sleep(120000);
        System.out.println("------------------Validate files are processed and encrypted-----------------");
        boolean isExist = false;
        for (int i = 0; i < FileNames.size(); i++) {
            if (FileNames.get(i).endsWith(".gpg")) {
                isExist = SftpUtils.isSftpFileExisted(globalVariables.indianaUploadLocation + "/" + FileNames.get(i));
                LOGGER.info(FileNames.get(i) + " " + "exist");
                Assert.assertTrue(isExist = true);
            } else if (FileNames.get(i).endsWith(".csv") || FileNames.get(i).endsWith(".txt")) {

                LOGGER.info(FileNames.get(i) + " " + "did not encrypt");
                Assert.assertTrue(isExist = false);
            }
        }
        return isExist;
    }

    public synchronized boolean isFileDeleted_Indiana(List<String> FileNames) throws Exception {

        System.out.println("------------------Validate processed file is deleted-----------------");
        boolean isExist = false;
        for (int i = 0; i < FileNames.size(); i++) {
            if (FileNames.get(i).endsWith(".gpg")) {
                isExist = SftpUtils.isSftpFileExisted(globalVariables.indianaDownloadLocation + "/" + FileNames.get(i));
                LOGGER.info(FileNames.get(i) + " " + "is deleted");
                Assert.assertTrue(isExist);
            } else if (FileNames.get(i).endsWith(".csv") || FileNames.get(i).endsWith(".txt")) {

                LOGGER.info(FileNames.get(i) + " " + "did not processed");
                Assert.assertFalse(isExist);
            }
        }
        return isExist;
    }

    public synchronized String createPipeDelimFileAndConvertToGPGWithRemovalField(String FilePath, List<String> mapDataToRemove, String type, String timeStamp) throws Exception {
        Map<Integer, List<String>> mapdataByRow = new HashMap<>();

        String[] tcname = Thread.currentThread().getStackTrace()[2].getMethodName().split("_");
        String latestFileName = globalVariables.memberGenericFileName + tcname[2] + "_" + type + "_" + timeStamp + ".csv";

        try {
            @SuppressWarnings("resource")
            BufferedReader reader = new BufferedReader(new FileReader(FilePath));
            String row = null;

            int rowNumber = 1;
            while ((row = reader.readLine()) != null) {
                mapdataByRow.put(rowNumber, Arrays.asList(row.split(",(=(?:[^\"]*\"[^\"]*\")*[^\"]*$)")));
                rowNumber++;
            }
            String mapdataByRowString = mapdataByRow.get(1).get(0);
            String[] mapdataByRowStringArray = mapdataByRowString.split(Pattern.quote("|"));
            List<String> list = new LinkedList<>(Arrays.asList(mapdataByRowStringArray));

            String mapdataByRowavalue = mapdataByRow.get(3).get(0);
            String[] mapdataByRowvalueArray = mapdataByRowavalue.split(Pattern.quote("|"));
            List<String> listvalue = new LinkedList<>(Arrays.asList(mapdataByRowvalueArray));

            for (String valueEntry : mapDataToRemove) {

                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).equalsIgnoreCase("\"" + valueEntry + "\"")) {
                        list.remove(i);
                        listvalue.remove(i);
                    }
                }
            }


            StringBuffer Finalvalue = new StringBuffer();
            StringBuffer FinalField = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                Finalvalue = Finalvalue.append(listvalue.get(i));
                if (i != listvalue.size() - 1) {
                    Finalvalue.append("|");
                }
            }
            for (int i = 0; i < listvalue.size(); i++) {
                FinalField = FinalField.append(list.get(i));
                if (i != list.size() - 1) {
                    FinalField.append("|");
                }
            }
            String finalvalueString = Finalvalue.toString();
            String finalFieldString = FinalField.toString();

            createFile(globalVariables.Encryptfile + latestFileName, finalFieldString + "\n" + finalvalueString);

            String result = OpenPgpHelper.encryptFile(globalVariables.Encryptfile + latestFileName, globalVariables.EncryptedfileResult + latestFileName + ".gpg", keyPath);
            assertNotNull(result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return latestFileName;

    }

    public synchronized List<String> putGetFilefromServerSegmentField(String FileName, String OutBoundFileName, String errorFile, String timeStamp) throws Exception {
        System.out.println("------------------Prcessing the File Using Ftp-----------------");
        List<String> putFile = new ArrayList<String>();
        List<String> fileNames = new ArrayList<String>();

        putFile.add(FileName + ".gpg");
        putFile.add(OutBoundFileName);

        System.out.println("------------------put the File Using Ftp-----------------");

        for (String putFiles : putFile) {
            SftpUtils.sftpSendFile(globalVariables.EncryptedfileResult + putFiles, globalVariables.memberFtpLocationSegment);
        }

        Thread.sleep(20000);

        List<String> getfileName = getFIleFromftpLocationSegment(putFile, errorFile, timeStamp);

        deletefilesFromServerSegment(putFile, getfileName);
        fileNames.addAll(putFile);
        fileNames.addAll(getfileName);
        return fileNames;
    }

    @SuppressWarnings("unused")
    public synchronized List<String> getFIleFromftpLocationSegment(List<String> getFile, String errorFile, String timeStamp) throws Exception {
        List<String> fileNamesToDecrypt = new ArrayList<String>();
        File file;
        List<String> processedFileList = new ArrayList<String>();

        for (String getfiles : getFile) {
            file = SftpUtils.getFile(globalVariables.memberFtpLocationSegment, globalVariables.decryptedfileResult, getfiles);
        }


        processedFileList.add(CommonMethods.generateInboundControlFileSegment(timeStamp, globalVariables.memberGenericFileNameControlFile));

        if (errorFile != null) {
            String[] tcname = Thread.currentThread().getStackTrace()[3].getMethodName().split("_");
            processedFileList.add(globalVariables.memberGenericFileNameControlFile + tcname[2] + "_" + errorFile + "_Error_" + timeStamp + ".csv.gpg");
        }

        TimeUnit.SECONDS.sleep(50);

        for (String processedFileLists : processedFileList) {
            SftpUtils.isSftpFileExisted(globalVariables.memberFtpLocationErrorControlFileSegment + "/" + processedFileLists);

            file = SftpUtils.getFile(globalVariables.memberFtpLocationErrorControlFileSegment, globalVariables.decryptedfileResult, processedFileLists);
        }

        System.out.println("---------------Decrypting the files --------------------");

        fileNamesToDecrypt.addAll(getFile);
        fileNamesToDecrypt.addAll(processedFileList);

        for (String fileName : fileNamesToDecrypt) {
            System.out.println(fileNamesToDecrypt);
            String result = OpenPgpHelper.decryptFiles(globalVariables.decryptedfileResult, fileName, globalVariables.decryptedfileResultTo);
        }

        return processedFileList;
    }

    public synchronized void deletefilesFromServerSegment(List<String> putFile, List<String> getfileNames) {

        List<String> fileNames = new ArrayList<String>();
        for (String putFiles : putFile) {
            fileNames.add(globalVariables.memberFtpLocationSegment + "/" + putFiles);
        }

        for (String getfileName : getfileNames) {
            fileNames.add(globalVariables.memberFtpLocationErrorControlFileSegment + "/" + getfileName);
        }


        SftpUtils.deleteFiles(fileNames);

    }
}

