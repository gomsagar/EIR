package com.eir.report.nextgen.service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:nextgen.properties")
public class NextgenConfig {

	@Value("${nextgen.service.url.viasso}")
	String nextGenUrl;
	
	@Value("${nextgen.connection.timeout}")
	Integer connTimeOut;
	
	@Value("${nextgen.read.timout}")
	Integer readTimeOut;

	public String getNextGenUrl() {
		return nextGenUrl;
	}

	public void setNextGenUrl(String nextGenUrl) {
		this.nextGenUrl = nextGenUrl;
	}

	public Integer getConnTimeOut() {
		return connTimeOut;
	}

	public void setConnTimeOut(Integer connTimeOut) {
		this.connTimeOut = connTimeOut;
	}

	public Integer getReadTimeOut() {
		return readTimeOut;
	}

	public void setReadTimeOut(Integer readTimeOut) {
		this.readTimeOut = readTimeOut;
	}
}
