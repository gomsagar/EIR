package com.eir.bir.request.model;


public class ConsumerList {
	String ernNumber;
	String score;
	String status;
	String cirRequetcol;
	
	public String getErnNumber() {
		return ernNumber;
	}
	public void setErnNumber(String ernNumber) {
		this.ernNumber = ernNumber;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCirRequetcol() {
		return cirRequetcol;
	}
	public void setCirRequetcol(String cirRequetcol) {
		this.cirRequetcol = cirRequetcol;
	}
	@Override
	public String toString() {
		return "ConsumerList [ernNumber=" + ernNumber + ", score=" + score + ", status=" + status + ", cirRequetcol="
				+ cirRequetcol + "]";
	}
}
