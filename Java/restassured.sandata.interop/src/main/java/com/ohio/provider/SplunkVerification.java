package com.ohio.provider;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class SplunkVerification {

	public void URLCOnnection() throws Exception {
	URL url = new URL("http://mnt-spl-sp01.sandata.com:8000/en-US/app/search/search?q=search%20EVV_Batch_Req.20170928.134604.180794021.txt&display.page.search.mode=smart&dispatch.sample_ratio=1&earliest=&latest=&sid=1506586851.6278580")  ;
	URLConnection conn = url.openConnection();
	conn.connect();
	}
	
	
public static void main(String args[]) {
	SplunkVerification SV = new SplunkVerification();
	try {
		SV.URLCOnnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Connection established");
}
	}

