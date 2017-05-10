package com.eir.report.listener;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SessionMonitorListener implements HttpSessionListener 
{
	private static final String SESSION_TOKEN = "sessionToken";
	private static Logger log = Logger.getLogger(SessionMonitorListener.class); 
	
	private static int totalActiveSessions = 0;

	public static int getTotalActiveSession() {
		return totalActiveSessions;
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		
		totalActiveSessions++;
		log.info("sessionCreated - add one session into counter");
		String randomNumber = "";
		try{
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			randomNumber = String.valueOf(secureRandom.nextLong());
		}catch(NoSuchAlgorithmException nsae){
			log.info("Exception occured while generating token");
		
		}
		arg0.getSession().setAttribute(SESSION_TOKEN, randomNumber);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		totalActiveSessions--;
		log.info("sessionDestroyed - deduct one session from counter");
	}

}
