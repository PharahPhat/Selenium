package com.ohio.provider;

import java.io.File;

public class GlobalVariables_provider {
	
	//################################# Provider ohio  File  #######################################


	
	public static String getOhioproviderlocation= System.getProperty("user.dir")+ File.separator +"src" + File.separator + "test"+File.separator+ "resources"+File.separator+"Ohioprovider"+File.separator;	
	public static String OhioProviderFtpLocationfull =CommonMethodsProvider.propertyfileReader("SFTPLocation_control_Ohio_full");
	public static String OhioProviderFtpLocationcontract =CommonMethodsProvider.propertyfileReader("SFTPLocation_control_Ohio_contract");
	public static String OhioProviderFtpLocationspec =CommonMethodsProvider.propertyfileReader("SFTPLocation_control_Ohio_spec");
	
	public static String SAK_PROV= "10028";
	

	public static String CDE_COUNTY ="23";
	
	public static String DTE_CYCLE ="N10/14/201512/31/2299DEFAULT";

	public static String ID_PROVIDER_NPI="1679765770NPIY";
	
	public static String DERIVED ="0000001/01/0101";
	public static String DERIVED1="01/01/010104/17/199412/31/2299YNI";
	public static String DERIVED2="10/14/2015000";
	public static String NA="000000000";
	public static String NA1="000000000000000000000000000000000000";
	public static String CDE_ORGANIZ="2099";
	public static String NUM_PROV_LIC="35064190";
	public static String DTE_EFF_MCD_AGREEMENT="04/17/199401/01/2021";
	public static String DERIVED3="01/01/0101BS3488283000001/01/0101";
	public static String DERIVED4="N N1";
	
	public static String NUM_PHONE_INT="0000000000";
	public static String DERIVED5="01/01/010112/31/2299PHYS";
	public static String NUM_LONGITUDE="0000.0000000000.000000S010021601/01/0101000000000000000000000000000000000000000000000";
	public static String NA2="00000000000000000000000000000000000000000000000000000000000000000000000000000000001/01/0101000000000000000000000000000";
	public static String NA3="00000000000000000000000000000000000000000000000000000000000000000000000000000000004/17/199420901/01/0101";
	
	public static String DTE_EFFECTIVE="AC04/17/1994AC04/17/1994AC04/17/19940000000000000000000000000001A";
	public static String NA4="000000000308300000000000000000008/16/200608/07/20060000000000000000000000000001A";
	public static String NA5="000000031597700000000000000000005/13/200905/04/20090000000000000000000000000001A";
	public static String NA6="000000002887600000000000000000005/13/200905/04/20090000000000000000000000000001A";
	public static String NA7="000000002103400000000000000000005/13/200905/04/20090000000000000000000000000001A";
	public static String NA8="000000002890600000000000000000005/13/200905/04/200901/01/010112/31/2299N";
	public static String DTE_EFFECTIVE3="01/01/010112/31/2299";
	public static String DTE_EFFECTIVE1="01/01/010112/31/22994939179";
	public static String DTE_EFFECTIVE2="10/25/199512/31/2299000000000000000000000001/01/010101/01/010112/31/2299   18707";
    public static String NA9="0000000000OHWEB1891574068786360000000000OHWEB1891574068745050000000000OHWEB18915401 N EWING ST                                              LANCASTER";
	public static String CDE_PROV_PGM="         OH4313033727406874505          OHWEB18915PO BOX 948                                                  LANCASTER";
	public static String Add5="         OH4313005860000000000          OHWEB18915401 N EWING ST                                              LANCASTER";
	public static String Add6="         OH4313033727406874505          OHWEB18915                    01/01/010112/31/2299                     01/01/010101/01/0101";
	public static String contract1="000046061";
	public static String contract2="   1366523961";
    public static String contract3 = "09/21/201707/30/201912/31/2299PDN  AC15";
  
	public static String special1="    46061";
	public static String specialpart2="09/21/198212/31/2299";
	



}
