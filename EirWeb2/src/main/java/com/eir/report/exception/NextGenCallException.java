package com.eir.report.exception;

public class NextGenCallException extends Exception
{

	String outputXml;
	int responseCode;
	
	public NextGenCallException(String s)
	{
		super(s);
	}
	
	public NextGenCallException(String s, String outputXML, int responseCode)
	{
		super(s);
		this.outputXml = outputXML;
		this.responseCode = responseCode;
	}
}
