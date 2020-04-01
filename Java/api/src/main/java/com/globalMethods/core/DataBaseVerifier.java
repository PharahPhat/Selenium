package com.globalMethods.core;

import Utills_ExtentReport_Log4j.BaseTest;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DataBaseVerifier extends BaseTest {  


	public Map<String, String> executeQuery(String sql_Query) throws InterruptedException, SQLException, ClassNotFoundException

	{
		Map<String,String> map =new HashMap<>();
		if(connection==null){
			connection=CommonMethods.CreateConnection();
		}
		System.out.println(sql_Query);
		try(Statement stmt = connection.createStatement()){
			for(int j=0;j<3;j++){
                Thread.sleep(60000);//Increase time avoid data is not stored to Db
				try(ResultSet rs = stmt.executeQuery(sql_Query)) {
					if(rs.next())
					{
						ResultSetMetaData md = rs.getMetaData();
						int columns = md.getColumnCount();
						map = new HashMap<>(columns);
						for (int i = 1; i <= columns; ++i) {
							map.put(md.getColumnName(i), rs.getString(i));
						}
						System.out.println(map);
						break;
					}
					System.out.println("Query Retry time: " + j);
				}
			}
			if(map.isEmpty())
			{
				Assert.fail("No data is inserted in Db and MAp is returning null");
			}
			return map;
		}
	}

	List<Map<String, String>> getDataMap(String sql_Query) throws InterruptedException, SQLException, ClassNotFoundException

	{
		List<Map<String, String>> list = new ArrayList<>();
		if(connection==null){
			connection=CommonMethods.CreateConnection();
		}
		System.out.println(sql_Query);
		try(Statement stmt = connection.createStatement()){
			try(ResultSet rs = stmt.executeQuery(sql_Query)) {
				while(rs.next())
				{
					ResultSetMetaData md = rs.getMetaData();
					int columns = md.getColumnCount();
					Map<String,String> map = new HashMap<>(columns);
					for (int i = 1; i <= columns; ++i) {
						map.put(md.getColumnName(i), rs.getString(i));
					}
					list.add(map);
				}
			}
			if(list.isEmpty())
			{
				Assert.fail("No data is inserted in Db and MAp is returning null");
			}
			return list;
		}
	}

	public Map<String, String> executeQuery(int retryCount,String sql_Query,int waitTime) throws InterruptedException, SQLException, ClassNotFoundException

	{
		Map<String,String> map1 =new HashMap<>();
		if(connection==null){
			connection=CommonMethods.CreateConnection();
		}
		System.out.println(sql_Query);
		try(Statement stmt = connection.createStatement()){
			for(int j=1;j<retryCount;j++){
				Thread.sleep(waitTime);
				try(ResultSet rs = stmt.executeQuery(sql_Query)) {
					if(rs.next())
					{
						ResultSetMetaData md = rs.getMetaData();
						int columns = md.getColumnCount();
						Map<String, String> map = new HashMap<>(columns);


						for (int i = 1; i <= columns; ++i) {
							map.put(md.getColumnName(i), rs.getString(i));
						}

						System.out.println(map);

						map1.putAll(map);
						break;

					}
				}
			}
			if(map1.isEmpty())
			{
				Assert.fail("No data is inserted in Db and MAp is returning null");
			}
			return map1;


		}
	}

	public void compareMap(Map<String, String> mapToCompare , Map<String, String> mapFromCompare) {
		System.out.println("Comparing two map");
		Map<String, String> mapTotree = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		mapTotree.putAll(mapToCompare); 
		Map<String, String> mapFromtree = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		mapFromtree.putAll(mapFromCompare); 

		Set<String> bKeys = mapTotree.keySet();
		SoftAssert softAssert = new SoftAssert();
		for(String key :bKeys){

			if (!mapFromtree.containsKey(key)) {
				softAssert.fail(key + " is not present");
			}
		}
		mapFromCompare.keySet().stream()
		.filter(bKeys::contains)
		.distinct()
		.map(key -> {
			String valB = String.valueOf(mapTotree.get(key)); 

			String valA = String.valueOf(mapFromtree.get(key));
			if(!valA.equalsIgnoreCase(valB)) {
				softAssert.fail(key + " " + valA + " vs " + valB + " mismatched");
			}
			return key + " " + valA + " vs " + valB ;
		})
		.filter(Objects::nonNull)
		.forEach(System.out::println);
		softAssert.assertAll();
	}

	public int returnRowNumber(String sql_Query) throws InterruptedException, SQLException, ClassNotFoundException {
		if (connection == null) {
			connection = CommonMethods.CreateConnection();
		}
		System.out.println(sql_Query);
		try (Statement stmt = connection.createStatement()) {
			Thread.sleep(3000);
			try (ResultSet rs = stmt.executeQuery(sql_Query)) {
				int count = 0;
				while (rs.next()) {
					count++;
				}
				return count;
			}
		}
	}

	public  String executeQueryString(String sql_Query) throws InterruptedException, SQLException, ClassNotFoundException

	{
		String col_Data = null;
		Thread.sleep(5000);
		if(connection==null){
			connection=CommonMethods.CreateConnection();
		}
		System.out.println(sql_Query);
		try (Statement stmt = connection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql_Query)) {
				while (rs.next())
				{
					col_Data =rs.getString(1);
				}
			}
		}
		return col_Data;
	}

	static List<String> executeQueryToListString(String sql_Query) throws InterruptedException, SQLException, ClassNotFoundException

	{
		List<String> list =new ArrayList<>();
		if(connection==null){
			connection=CommonMethods.CreateConnection();
		}
		System.out.println(sql_Query);
		try(Statement stmt = connection.createStatement()){
			try(ResultSet rs = stmt.executeQuery(sql_Query)) {
				while (rs.next())
				{
					list.add(rs.getString(1));
				}
			}
			if(list.isEmpty())
			{
				Assert.fail("No data is inserted in Db and MAp is returning null");
			}
			return list;
		}
	}
}





