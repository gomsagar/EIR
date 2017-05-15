package com.eir.report.entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "StatusCode", "Message", "Response" })
public class CompanyList {

	@JsonProperty("StatusCode")
	private String statusCode;
	@JsonProperty("Message")
	private String message;
	@JsonProperty("Response")
	private List<Response> response = null;

	@JsonProperty("StatusCode")
	public String getStatusCode() {
		return statusCode;
	}

	@JsonProperty("StatusCode")
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@JsonProperty("Message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("Message")
	public void setMessage(String message) {
		this.message = message;
	}

	@JsonProperty("Response")
	public List<Response> getResponse() {
		return response;
	}

	@JsonProperty("Response")
	public void setResponse(List<Response> response) {
		this.response = response;
	}

}
