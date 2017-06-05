
package com.eir.report.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "cir_requet")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "CirRequet")

@EntityListeners(AuditingEntityListener.class)
public class CirRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "cir_requet_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cir_seq")
	@SequenceGenerator(
		name="cir_seq",
		sequenceName="cir_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer cirRequetId;
	/**
	 */

	@Column(name = "ern_number", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String ernNumber;
	/**
	 */

	@Column(name = "xml_output", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob

	@XmlElement
	byte[] xmlOutput;
	/**
	 */

	@Column(name = "score", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String score;
	/**
	 */

	@Column(name = "status", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String status;
	/**
	 */

	@Column(name = "bank_Account_No", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer bankAccNo;
	/**
	 */

	@Column(name = "product_field", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String productField;
	/**
	 */

	@Column(name = "purpose", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String purpose;
	/**
	 */

	@Column(name = "amount", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	float amount;
	/**
	 */

	@Column(name = "account_type1", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String accType1;
	/**
	 */

	@Column(name = "client_ref_no", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String clientRefNo;
	/**
	 */

	@Column(name = "account_type2", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String accType2;
	/**
	 */

	@Column(name = "company_pan", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String companyPan;
	/**
	 */

	
	@Column(name = "address_type", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String addrType;
	/**
	 */

	@Column(name = "address_lsine1", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String addrLine1;
	/**
	 */

	@Column(name = "address_line2", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String addrLine2;
	/**
	 */

	@Column(name = "city", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String city;
	/**
	 */

	@Column(name = "state", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String state;
	/**
	 */
	@Column(name = "pincode", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String pinCode;
	/**
	 */
	@Column(name = "telephone_no", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String telephoneNo;
	/**
	 */
	@Column(name = "pan", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String pan;
	/**
	 */
	@Column(name = "cin", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cin;
	/**
	 */
	@Column(name = "tin", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String tin;
	/**
	 */
	@Column(name = "email_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String emailId;
	/**
	 */
	@Column(name = "triggers", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String triggers;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@CreatedBy
	String createUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_user_date")
	@Basic(fetch = FetchType.EAGER)

	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@LastModifiedBy
	String updateUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "update_user_date")
	@Basic(fetch = FetchType.EAGER)

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
	public void setCirRequetId(Integer cirRequetId) {
		this.cirRequetId = cirRequetId;
	}

	/**
	 */
	public Integer getCirRequetId() {
		return this.cirRequetId;
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
	public CirRequest() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(CirRequest that) {
		setCirRequetId(that.getCirRequetId());
		setErnNumber(that.getErnNumber());
		setXmlOutput(that.getXmlOutput());
		setScore(that.getScore());
		setStatus(that.getStatus());
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

		buffer.append("cirRequetId=[").append(cirRequetId).append("] ");
		buffer.append("ernNumber=[").append(ernNumber).append("] ");
		buffer.append("xmlOutput=[").append(xmlOutput).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("status=[").append(status).append("] ");
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
		result = (int) (prime * result + ((cirRequetId == null) ? 0 : cirRequetId.hashCode()));
		return result;
	}
	
	

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof CirRequest))
			return false;
		CirRequest equalCheck = (CirRequest) obj;
		if ((cirRequetId == null && equalCheck.cirRequetId != null) || (cirRequetId != null && equalCheck.cirRequetId == null))
			return false;
		if (cirRequetId != null && !cirRequetId.equals(equalCheck.cirRequetId))
			return false;
		return true;
	}

	public Integer getBankAccNo() {
		return bankAccNo;
	}

	public void setBankAccNo(Integer bankAccNo) {
		this.bankAccNo = bankAccNo;
	}

	public String getProductField() {
		return productField;
	}

	public void setProductField(String productField) {
		this.productField = productField;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getAccType1() {
		return accType1;
	}

	public void setAccType1(String accType1) {
		this.accType1 = accType1;
	}

	public String getClientRefNo() {
		return clientRefNo;
	}

	public void setClientRefNo(String clientRefNo) {
		this.clientRefNo = clientRefNo;
	}

	public String getAccType2() {
		return accType2;
	}

	public void setAccType2(String accType2) {
		this.accType2 = accType2;
	}

	public String getCompanyPan() {
		return companyPan;
	}

	public void setCompanyPan(String companyPan) {
		this.companyPan = companyPan;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getTelephoneNo() {
		return telephoneNo;
	}

	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTin() {
		return tin;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTriggers() {
		return triggers;
	}

	public void setTriggers(String triggers) {
		this.triggers = triggers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
