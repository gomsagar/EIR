package com.eir.bir.request.model;


public class ConsumerList {
	String ernNumber;
	String score;
	String status;
	String relationType;
	String firstName;
	String middleName;
	String lastName;
	String personPan;
	
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

	@Override
	public String toString() {
		return "ConsumerList [ernNumber=" + ernNumber + ", score=" + score + ", status=" + status + "]";
	}
	public String getRelationType() {
		return relationType;
	}
	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPersonPan() {
		return personPan;
	}
	public void setPersonPan(String personPan) {
		this.personPan = personPan;
	}
}
