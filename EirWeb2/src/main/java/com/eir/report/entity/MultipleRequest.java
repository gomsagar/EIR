package com.eir.report.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"birRequest",
"cirRequest"
})

public class MultipleRequest {
	

@JsonProperty("birRequest")
private BirRequest birRequest;
@JsonProperty("cirRequest")
private CirRequest cirRequest;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("birRequest")
public BirRequest getBirRequest() {
return birRequest;
}

@JsonProperty("birRequest")
public void setBirRequest(BirRequest birRequest) {
this.birRequest = birRequest;
}

@JsonProperty("cirRequest")
public CirRequest getCirRequest() {
return cirRequest;
}

@JsonProperty("cirRequest")
public void setCirRequest(CirRequest cirRequest) {
this.cirRequest = cirRequest;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}


}
