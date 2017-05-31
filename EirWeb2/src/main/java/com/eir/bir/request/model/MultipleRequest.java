package com.eir.bir.request.model;

import java.util.List;


public class MultipleRequest {
	

private BirRequest bir;
private CirRequest cir;

List<ConsumerList> consumer = null;


public List<ConsumerList> getConsumer() {
	return consumer;
}

public void setConsumer(List<ConsumerList> consumer) {
	this.consumer = consumer;
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

}
