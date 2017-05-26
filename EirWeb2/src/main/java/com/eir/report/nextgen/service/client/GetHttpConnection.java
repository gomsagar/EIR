package com.eir.report.nextgen.service.client;

import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GetHttpConnection {

	static Logger logger = LoggerFactory.getLogger(GetHttpConnection.class);
	
	public HttpURLConnection getConn()
	{
		logger.info("GetHttpConnection: getConn() execution Start");
		try
		{
			String viaServer = "http://ind-uat-appl1:8180/nextgen-ind-pds-webservices/endpoint";
			String viaSso = "https://nxg-india-uat.experian.com:443/nextgen-ind-pds-webservices/endpoint";
			
			URL url = new URL(viaServer);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			/*URLConnection urlc = url.openConnection();
	        HttpURLConnection httpc = (HttpURLConnection)urlc;
	        httpc.setRequestMethod("HEAD");*/
		
			conn.setConnectTimeout(15 * 60 * 1000);
			conn.setReadTimeout(60 * 1000);
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty ( "Content-Type", "text/xml; charset=utf-8" );    
			conn.setRequestProperty ( "SOAPAction", "" );
			conn.setRequestProperty ( "ct-remote-user", "smit01" ); // Non-SSO User
			conn.setRequestProperty ( "Authorization", "BASIC c21pdDAxOlNtaXRzKjEyMw==" ); // SSO Based usage for UAT and Production
			Map<String, List<String>> map = null;
			conn.setUseCaches (false);
	        conn.setDefaultUseCaches (false);
	        logger.info("GetHttpConnection: getConn() execution End");
			return conn;
			
		} catch (Exception e) {
			logger.error("GetHttpConnection: getConn() execution start", e);
			//e.printStackTrace();
		}
		logger.info("GetHttpConnection: getConn() execution fail");
		return null;
	}
	
}
