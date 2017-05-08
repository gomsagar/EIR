package com.eir.report.web.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.ws.WebFault;

@SuppressWarnings("serial")
@WebFault(name="NextGenSSOException")
@XmlAccessorType( XmlAccessType.FIELD )
public class NextGenReportServiceException extends Exception
{
	

	
}