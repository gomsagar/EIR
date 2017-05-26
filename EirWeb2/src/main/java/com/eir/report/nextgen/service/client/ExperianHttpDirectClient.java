package com.eir.report.nextgen.service.client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eir.report.exception.NextGenCallException;

public class ExperianHttpDirectClient {
	
	Logger logger = LoggerFactory.getLogger(ExperianHttpDirectClient.class);
	
	public NextGenResponseWrapper getNextgenReport(String xml) throws IOException, NextGenCallException 
	{
		logger.debug("ExperianHttpDirectClient: getProductReport() execution Start"); 
		NextGenResponseWrapper nextGenResponseWrapper = new NextGenResponseWrapper();
		
		try {
			//get httpurlconnection object 
			GetHttpConnection getHttpConnection = new GetHttpConnection();
			HttpURLConnection conn = getHttpConnection.getConn();
			conn.connect();
			
			OutputStreamWriter writer = new OutputStreamWriter( conn.getOutputStream() );
			writer.write(xml);
			writer.flush();
			writer.close();
			
			logger.debug("Experian Web Service Connectivity Started.....");
			int responseCode = conn.getResponseCode();
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			String acknowlegement = "";

			while ((line = rd.readLine()) != null) {

				if ("".equals(acknowlegement)) {
					acknowlegement = line;
				} else {
					acknowlegement += line;
				}
			}

			rd.close();
			conn.disconnect();
			
			nextGenResponseWrapper.setResponse(acknowlegement);
			nextGenResponseWrapper.setResponseCode(responseCode);
			
			return nextGenResponseWrapper;
		} catch (Exception e) {
			logger.error("ExperianHttpDirectClient: getProductReport() - exception occured while unmarshlling response", e);
			nextGenResponseWrapper.setResponse("nextgen call fail");
			nextGenResponseWrapper.setResponseCode(404);
			return null;
		}
		
		/*// HTTP RESPONSE CODE 200=OK
		if (responseCode == 200 ) 
		{
			try
			{
				SOAPMessage message = MessageFactory.newInstance().createMessage(null, conn.getInputStream());
				Unmarshaller unmarshaller = JAXBContext.newInstance(ResponseInfo.class).createUnmarshaller();
				
				ResponseInfo responseInfo = (ResponseInfo)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());	
				conn.disconnect();
				return responseInfo;
			}
			catch (Exception e)
			{
				logger.error("ExperianHttpDirectClient: callNextgen() - exception occured while unmarshlling response", e);
				conn.disconnect();
				throw new NextGenCallException("Error occured on unmarshlling");
			}
			
		} else {// nextgen connection error
			System.out.println("conn.getResponseCode()  - " + responseCode );
			throw new NextGenCallException("", acknowlegement, responseCode);
		}*/
	}
	
	
	public NextGenResponseWrapper getConsumerReport(String xml) throws IOException, NextGenCallException
	{
		logger.debug("ExperianHttpDirectClient: getConsumerReport() execution Start"); 
		NextGenResponseWrapper nextGenResponseWrapper = new NextGenResponseWrapper();
		
		try {
			//get httpurlconnection object 
			GetHttpConnection getHttpConnection = new GetHttpConnection();
			HttpURLConnection conn = getHttpConnection.getConn();
			conn.connect();
			
			OutputStreamWriter writer = new OutputStreamWriter( conn.getOutputStream() );
			writer.write(xml);
			writer.flush();
			writer.close();
			
			logger.debug("Experian Web Service Connectivity Started.....");
			int responseCode = conn.getResponseCode();
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			String acknowlegement = "";

			while ((line = rd.readLine()) != null) {

				if ("".equals(acknowlegement)) {
					acknowlegement = line;
				} else {
					acknowlegement += line;
				}
			}

			rd.close();
			conn.disconnect();
			
			nextGenResponseWrapper.setResponse(acknowlegement);
			nextGenResponseWrapper.setResponseCode(responseCode);
			
			return nextGenResponseWrapper;
		} catch (Exception e) {
			logger.error("ExperianHttpDirectClient: getConsumerReport() - exception occured while unmarshlling response", e);
			nextGenResponseWrapper.setResponse("nextgen call fail");
			nextGenResponseWrapper.setResponseCode(404);
			return null;
		}
	}
	
	
}
