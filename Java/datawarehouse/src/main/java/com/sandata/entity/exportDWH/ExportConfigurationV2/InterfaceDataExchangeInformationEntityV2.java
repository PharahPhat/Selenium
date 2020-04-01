package com.sandata.entity.exportDWH.ExportConfigurationV2;

public class InterfaceDataExchangeInformationEntityV2 {
    public String fileNamePattern;
    public String timestamp; 
    public boolean setHeader;
    public String quote;
    public String recordSeparator;
    public String quoteMode;
    public String pgpPublicKeyPath;
    public String payerId;
    public String controlFileExtension;
    public String specVersion;
    public String fileExtension;
    public String delimiter;
    public String specNumber;
    public Boolean withLastFailedExport;
    public boolean quoteNullValue;
    public boolean multiDesignees;
    public boolean exportClientSchedule = true;
    public boolean exportVisitTask = true;
    public boolean exportVisitClaimStack = true;


    public String getSpecNumber() {
        return specNumber;
    }

    public void setSpecNumber(String specNumber) {
        this.specNumber = specNumber;
    }

    public String getFileNamePattern() {
        return fileNamePattern;
    }

    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean getSetHeader() {
        return setHeader;
    }

    public void setSetHeader(boolean setHeader) {
        this.setHeader = setHeader;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getRecordSeparator() {
        return recordSeparator;
    }

    public void setRecordSeparator(String recordSeparator) {
        this.recordSeparator = recordSeparator;
    }

    public String getQuoteMode() {
        return quoteMode;
    }

    public void setQuoteMode(String quoteMode) {
        this.quoteMode = quoteMode;
    }

    public String getPgpPublicKeyPath() {
        return pgpPublicKeyPath;
    }

    public void setPgpPublicKeyPath(String pgpPublicKeyPath) {
        this.pgpPublicKeyPath = pgpPublicKeyPath;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getControlFileExtension() {
        return controlFileExtension;
    }

    public void setControlFileExtension(String controlFileExtension) {
        this.controlFileExtension = controlFileExtension;
    }

    public String getSPecVersion() {
        return specVersion;
    }

    public void setSPecVersion(String specVersion) {
        this.specVersion = specVersion;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
