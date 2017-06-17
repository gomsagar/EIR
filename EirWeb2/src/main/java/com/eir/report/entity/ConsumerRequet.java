
package com.eir.report.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 */

@Entity
@Table(name = "consumer_requet")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "ConsumerRequet")

@EntityListeners(AuditingEntityListener.class)
public class ConsumerRequet implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "consumer_requet_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="consumer_seq")
	@SequenceGenerator(
		name="consumer_seq",
		sequenceName="consumerReq_seq",
		allocationSize=1
	)
	@XmlElement
	Integer consumerRequetId;
	/**
	 */

	@Column(name = "ern_number", length = 45)
	

	@XmlElement
	String ernNumber;
	/**
	 */
	
	@Column(name = "first_name", length = 45)
	

	@XmlElement
	String firstName;
	

	@Column(name = "middle_name", length = 45)
	

	@XmlElement
	String middleName;
	/**
	 */
	@Column(name = "last_name", length = 45)
	

	@XmlElement
	String lastName;
	/**
	 */
	@Column(name = "relation_Type", length = 45)
	

	@XmlElement
	String relationType;
	/**
	 */

	@Column(name = "xml_output", columnDefinition = "BLOB")
	
	@Lob

	@XmlElement
	byte[] xmlOutput;
	/**
	 */

	@Column(name = "score", length = 45)
	

	@XmlElement
	String score;
	/**
	 */

	@Column(name = "status", length = 45)
	

	@XmlElement
	String status;
	/**
	 */

	@Column(name = "cir_requetcol", length = 45)
	

	@XmlElement
	String cirRequetcol;
	/**
	 */

	@Column(name = "person_pan", length = 45)
	

	@XmlElement
	String personPan;
	/**
	 */

	@Column(name = "driving_lic", length = 45)
	

	@XmlElement
	String drivingLic;
	/**
	 */

	@Column(name = "aadhar_card", length = 45)
	

	@XmlElement
	String aadharCard;
	/**
	 */

	@Column(name = "voter_id", length = 45)
	

	@XmlElement
	String voterId;
	/**
	 */

	@Column(name = "ration_card", length = 45)
	

	@XmlElement
	String rationCard;
	/**
	 */

	@Column(name = "passport_no", length = 45)
	

	@XmlElement
	String passportNo;
	/**
	 */

	@Column(name = "homeTelephone_no", length = 45)
	

	@XmlElement
	String homeTelephoneNo;
	/**
	 */

	@Column(name = "officeTelephone_no", length = 45)
	

	@XmlElement
	String officeTelephoneNo;
	/**
	 */

	@Column(name = "mobile_no", length = 45)
	

	@XmlElement
	String mobileNo;
	/**
	 */

	@Column(name = "birth_Date", length = 45)
	

	@XmlElement
	String birthDate;
	/**
	 */

	@Column(name = "marital_status", length = 45)
	

	@XmlElement
	String maritalStatus;
	/**
	 */

	@Column(name = "gender", length = 45)
	

	@XmlElement
	String gender;
	/**
	 */

	@Column(name = "personAddr_line1", length = 45)
	

	@XmlElement
	String personAddrLine1;
	/**
	 */
	@Column(name = "personAddr_line2", length = 45)
	

	@XmlElement
	String personAddrLine2;
	/**
	 */
	@Column(name = "person_city", length = 45)
	

	@XmlElement
	String personCity;
	/**
	 */
	@Column(name = "person_state", length = 45)
	

	@XmlElement
	String personState;
	/**
	 */
	@Column(name = "person_pincode", length = 45)
	

	@XmlElement
	String personPincode;
	

	@Column(name = "create_user_id", length = 45)
	

	@CreatedBy
	String createUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	

	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	

	@LastModifiedBy
	String updateUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "requet_id", referencedColumnName = "request_id") })
	@XmlTransient
	Request request;

	/**
	 */
	public void setConsumerRequetId(Integer consumerRequetId) {
		this.consumerRequetId = consumerRequetId;
	}

	/**
	 */
	public Integer getConsumerRequetId() {
		return this.consumerRequetId;
	}

	/**
	 */
	public void setErnNumber(String ernNumber) {
		this.ernNumber = ernNumber;
	}

	/**
	 */
	public String getErnNumber() {
		return this.ernNumber;
	}

	/**
	 */
	public void setXmlOutput(byte[] xmlOutput) {
		this.xmlOutput = xmlOutput;
	}

	/**
	 */
	public byte[] getXmlOutput() {
		return this.xmlOutput;
	}

	/**
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 */
	public String getScore() {
		return this.score;
	}

	/**
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 */
	public void setCirRequetcol(String cirRequetcol) {
		this.cirRequetcol = cirRequetcol;
	}

	/**
	 */
	public String getCirRequetcol() {
		return this.cirRequetcol;
	}

	

	/**
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 */
	public String getCreateUserId() {
		return this.createUserId;
	}

	/**
	 */
	public void setCreateUserDate(DateTime createUserDate) {
		this.createUserDate = createUserDate;
	}

	/**
	 */
	public DateTime getCreateUserDate() {
		return this.createUserDate;
	}

	/**
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 */
	public String getUpdateUserId() {
		return this.updateUserId;
	}

	/**
	 */
	public void setUpdateUserDate(DateTime updateUserDate) {
		this.updateUserDate = updateUserDate;
	}

	/**
	 */
	public DateTime getUpdateUserDate() {
		return this.updateUserDate;
	}

	/**
	 */
	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 */
	public ConsumerRequet() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(ConsumerRequet that) {
		setConsumerRequetId(that.getConsumerRequetId());
		setErnNumber(that.getErnNumber());
		setXmlOutput(that.getXmlOutput());
		setScore(that.getScore());
		setStatus(that.getStatus());
		setCirRequetcol(that.getCirRequetcol());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setRequest(that.getRequest());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("consumerRequetId=[").append(consumerRequetId).append("] ");
		buffer.append("ernNumber=[").append(ernNumber).append("] ");
		buffer.append("xmlOutput=[").append(xmlOutput).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("cirRequetcol=[").append(cirRequetcol).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((consumerRequetId == null) ? 0 : consumerRequetId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof ConsumerRequet))
			return false;
		ConsumerRequet equalCheck = (ConsumerRequet) obj;
		if ((consumerRequetId == null && equalCheck.consumerRequetId != null) || (consumerRequetId != null && equalCheck.consumerRequetId == null))
			return false;
		if (consumerRequetId != null && !consumerRequetId.equals(equalCheck.consumerRequetId))
			return false;
		return true;
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

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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
}
