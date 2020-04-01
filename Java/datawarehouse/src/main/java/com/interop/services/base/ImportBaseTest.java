package com.interop.services.base;

import com.interop.common.Commons;
import com.interop.common.StateAccount;
import com.sandata.core.BaseTest;
import com.sandata.utilities.sftp.utils.SftpUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;

public class ImportBaseTest extends BaseTest {
    public static final Logger LOGGER = Logger.getLogger(ImportBaseTest.class);
    private String dstPath;
    private String toInboxPath;
    public static final StateAccount stateAccount = StateAccount.loadStateAccount();
    protected Commons commons = new Commons();

    @Override
    public String getTestType() {
        return "importFile";
    }

    @BeforeTest(alwaysRun = true)
    public void initEnvironment() {
        this.initSFTPConfig(); }

    public String getDstPath() {
        return dstPath;
    }

    public void setDstPath(String dstPath) {
        this.dstPath = dstPath;
    }

    public String getToInboxPath() {
        return toInboxPath;
    }

    public void setToInboxPath(String toInboxPath) {
        this.toInboxPath = toInboxPath;
    }

    private void initSFTPConfig() {
        SftpUtils.SFTP_CONFIG.setUsername("H4mAD4DM");
        SftpUtils.SFTP_CONFIG.setPassword("ckgz4zcU");
    }
}
