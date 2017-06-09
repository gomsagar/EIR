package com.eir.bir.request.model;

import java.util.List;

import com.eir.report.entity.Request;

public class MultipleRequest {
	
private BirRequest bir;
private CirRequest cir;

List<Consumer> consumerList = null;
private boolean isBIRActive;
private boolean isCIRActive;
private boolean isComboActive;
//private Request requestObj;


public List<Consumer> getConsumerList() {
	return consumerList;
}

public void setConsumerList(List<Consumer> consumerList) {
	this.consumerList = consumerList;
}

public BirRequest getBir() {
	return bir;
}

public void setBir(BirRequest bir) {
	this.bir = bir;
}

public CirRequest getCir() {
	return cir;
}

public void setCir(CirRequest cir) {
	this.cir = cir;
}



public boolean getIsCIRActive() {
	return isCIRActive;
}

public void setIsCIRActive(boolean isCIRActive) {
	this.isCIRActive = isCIRActive;
}

public boolean getIsComboActive() {
	return isComboActive;
}

public void setIsComboActive(boolean isComboActive) {
	this.isComboActive = isComboActive;
}

public boolean getIsBIRActive() {
	return isBIRActive;
}

public void setIsBIRActive(boolean isBIRActive) {
	this.isBIRActive = isBIRActive;
}

/*public Request getRequestObj() {
	return requestObj;
}

public void setRequestObj(Request requestObj) {
	this.requestObj = requestObj;
}
*/
public void setBIRActive(boolean isBIRActive) {
	this.isBIRActive = isBIRActive;
}

public void setCIRActive(boolean isCIRActive) {
	this.isCIRActive = isCIRActive;
}

public void setComboActive(boolean isComboActive) {
	this.isComboActive = isComboActive;
}

}
