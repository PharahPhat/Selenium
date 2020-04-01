package com.AltEVV.client.generic_5455;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.globalMethods.core.CommonMethods;
import com.globalMethods.core.Constant_SQL;
import com.globalMethods.core.DataBaseVerifier;
import com.globalMethods.core.GenerateUniqueParam;
import com.globalMethods.core.globalVariables;

import Utills_ExtentReport_Log4j.BaseTest;

public class GlobalVariable_AltEVV_Generic_Client extends BaseTest{

	
	public static String altevv_clients="altevv_clients";
	public static String altevv_clients_get="altevv_clients_get";
	public static String clientNotFoundError="Client not found";
}
