package com.eir.report.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Cin", "Name" })
public class Response {

	@JsonProperty("Cin")
	private String cin;
	@JsonProperty("Name")
	private String name;

	@JsonProperty("Cin")
	public String getCin() {
		return cin;
	}

	@JsonProperty("Cin")
	public void setCin(String cin) {
		this.cin = cin;
	}

	@JsonProperty("Name")
	public String getName() {
		return name;
	}

	@JsonProperty("Name")
	public void setName(String name) {
		this.name = name;
	}

}
