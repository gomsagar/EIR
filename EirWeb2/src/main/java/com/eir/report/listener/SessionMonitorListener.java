package com.eir.report.listener;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eir.report.controller.EirController;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SessionMonitorListener implements HttpSessionListener 
{
	private static final String SESSION_TOKEN = "sessionToken";
	//private static Logger log = Logger.getLogger(SessionMonitorListener.class); 

	Logger logger = LoggerFactory.getLogger(EirController.class);
	private static int totalActiveSessions = 0;

	public static int getTotalActiveSession() {
		return totalActiveSessions;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		totalActiveSessions++;
		logger.info("sessionCreated - add one session into counter");
		System.out.println("sessionCreated - add one session into counter");
		String randomNumber = "";
		try{
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			randomNumber = String.valueOf(secureRandom.nextLong());
		}catch(NoSuchAlgorithmException nsae){
			logger.info("Exception occured while generating token");
		
		}
		arg0.getSession().setAttribute(SESSION_TOKEN, randomNumber);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		totalActiveSessions--;
		System.out.println("sessionDestroyed - deduct one session from counter");
		logger.info("sessionDestroyed - deduct one session from counter");
	}

}
