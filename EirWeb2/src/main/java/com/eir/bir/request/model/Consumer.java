package com.eir.bir.request.model;

import java.util.Date;

public class Consumer {
	String ernNumber;
	String score;
	String status;
	RelationType relationType;
	AccountType accountType;
	String firstName;
	String middleName;
	String lastName;
	String personPan;
	String drivingLic;
	String aadharhCard;
	String voterId;
	String rationCard;
	String passportNo;
	String homeTelephoneNo;
	String officeTelephoneNo;
	String mobileNo;
	/*Date birthDate;*/
	String maritalStatus;
	Gender gender;
	String personAddrLine1;
	String personAddrLine2;
	String personCity;
	String personState;
	String personPincode;
	AddressType addressType;
	Float amount;
	
public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
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

	public RelationType getRelationType() {
		return relationType;
	}
	public void setRelationType(RelationType relationType) {
		this.relationType = relationType;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
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
	public String getDrivingLic() {
		return drivingLic;
	}
	public void setDrivingLic(String drivingLic) {
		this.drivingLic = drivingLic;
	}
	public String getAadharhCard() {
		return aadharhCard;
	}
	public void setAadharhCard(String aadharhCard) {
		this.aadharhCard = aadharhCard;
	}
	public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	public String getRationCard() {
		return rationCard;
	}
	public void setRationCard(String rationCard) {
		this.rationCard = rationCard;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getHomeTelephoneNo() {
		return homeTelephoneNo;
	}
	public void setHomeTelephoneNo(String homeTelephoneNo) {
		this.homeTelephoneNo = homeTelephoneNo;
	}
	public String getOfficeTelephoneNo() {
		return officeTelephoneNo;
	}
	public void setOfficeTelephoneNo(String officeTelephoneNo) {
		this.officeTelephoneNo = officeTelephoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/*public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}*/
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getPersonAddrLine1() {
		return personAddrLine1;
	}
	public void setPersonAddrLine1(String personAddrLine1) {
		this.personAddrLine1 = personAddrLine1;
	}
	public String getPersonAddrLine2() {
		return personAddrLine2;
	}
	public void setPersonAddrLine2(String personAddrLine2) {
		this.personAddrLine2 = personAddrLine2;
	}
	public String getPersonCity() {
		return personCity;
	}
	public void setPersonCity(String personCity) {
		this.personCity = personCity;
	}
	public String getPersonState() {
		return personState;
	}
	public void setPersonState(String personState) {
		this.personState = personState;
	}
	public String getPersonPincode() {
		return personPincode;
	}
	public void setPersonPincode(String personPincode) {
		this.personPincode = personPincode;
	}
	
	@Override
	public String toString() {
		return "ConsumerList [ernNumber=" + ernNumber + ", score=" + score + ", status=" + status + ", relationType="
				+ relationType + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", personPan=" + personPan + ", drivingLic=" + drivingLic + ", aadharhCard=" + aadharhCard
				+ ", voterId=" + voterId + ", rationCard=" + rationCard + ", passportNo=" + passportNo
				+ ", homeTelephoneNo=" + homeTelephoneNo + ", officeTelephoneNo=" + officeTelephoneNo + ", mobileNo="
				+ mobileNo + ", birthDate=" + ", maritalStatus=" + maritalStatus + ", gender=" + gender
				+ ", personAddrLine1=" + personAddrLine1 + ", personAddrLine2=" + personAddrLine2 + ", personCity="
				+ personCity + ", personState=" + personState + ", personPincode=" + personPincode + ", getErnNumber()="
				+ getErnNumber() + ", getScore()=" + getScore() + ", getStatus()=" + getStatus()
				+ ", getRelationType()=" + getRelationType() + ", getFirstName()=" + getFirstName()
				+ ", getMiddleName()=" + getMiddleName() + ", getLastName()=" + getLastName() + ", getPersonPan()="
				+ getPersonPan() + ", getDrivingLic()=" + getDrivingLic() + ", getAadharhCard()=" + getAadharhCard()
				+ ", getVoterId()=" + getVoterId() + ", getRationCard()=" + getRationCard() + ", getPassportNo()="
				+ getPassportNo() + ", getHomeTelephoneNo()=" + getHomeTelephoneNo() + ", getOfficeTelephoneNo()="
				+ getOfficeTelephoneNo() + ", getMobileNo()=" + getMobileNo() + ", getBirthDate()=" +  ", getMaritalStatus()=" + getMaritalStatus() + ", getGender()=" + getGender()
				+ ", getPersonAddrLine1()=" + getPersonAddrLine1() + ", getPersonAddrLine2()=" + getPersonAddrLine2()
				+ ", getPersonCity()=" + getPersonCity() + ", getPersonState()=" + getPersonState()
				+ ", getPersonPincode()=" + getPersonPincode() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
}
