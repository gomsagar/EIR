
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
@Table(name = "cir_request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "CirRequet")

@EntityListeners(AuditingEntityListener.class)
public class CirRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "cir_request_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="cir_seq")
	@SequenceGenerator(
		name="cir_seq",
		sequenceName="cir_sequence",
		allocationSize=1
	)
	Integer cirRequestId;

	/**
	 */

	@Column(name = "xml_output", columnDefinition = "BLOB")
	
	@Lob
	byte[] xmlOutput;
	/**
	 */

	@Column(name = "score", length = 45)
	String score;
	/**
	 */

	/*@Column(name = "status", length = 45)
	String status;*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "status_id", referencedColumnName = "status_id") })
	Status status;
	/**
	 */

	/*@Column(name = "bank_Account_No", length = 45)
	

	@XmlElement
	Integer bankAccNo;*/
	/**
	 */

	@Column(name = "product_field", length = 45)
	String productField;
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "product_field_id", referencedColumnName = "report_type_id") })
	ReportType productField;
	 */

	@Column(name = "cir_purpose_id")
	Integer purposeId;
	
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "cir_purpose_id", referencedColumnName = "cir_purpose_id") })
	CirPurpose purpose;
	 */

	@Column(name = "enquiry_amount")
	String enquiryAmount;
		
	
	@Column(name = "company_pan", length = 45)
	String companyPan;
	/**
	 */
	@Column(name = "user_hit", length = 45)
	String userHit;
	
	@Column(name = "admin_hit", length = 45)
	String adminHit;
	
	@Column(name = "enquiry_amt_monetary_type", length = 45)
	String enquiryAmntMomentaryType;
	
	@Column(name = "enquiry_application_type", length = 45)
	String enquiryApplctnType;
	
	@Column(name = "enquiry_account_type", length = 45)
	String enquiryAccntType;
	
	@Column(name = "search_type", length = 45)
	String searchType;
	
	@Column(name = "frequency", length = 45)
	String frequency;
	
	@Column(name = "durationof_agrement", length = 45)
	String durationOfAgrement;
	
	@Column(name = "language", length = 45)
	String language;
	
	@Column(name = "enquiry_add_on_product", length = 45)
	String enquiryAddProduct;
	
	@Column(name = "bus_name", length = 45)
	String busName;
	
	@Column(name = "phone_number", length = 45)
	String phoneNumber;
	
	@Column(name = "phone_type", length = 45)
	String phoneType;
	
	@Column(name = "phone_number_extension", length = 45)
	String phoneNumberExtn;
	
	@Column(name = "experian_encrypted_bin", length = 45)
	String experianEncrypted;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "address_id", referencedColumnName = "address_id") })
	Address addressId;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "address_type_id", referencedColumnName = "address_type_id") })
	AddressType addrType;
	 */
	/**
	 */
	@Column(name = "telephone_no", length = 45)
	String telephoneNo;
	/**
	 */
	@Column(name = "pan", length = 45)
	String pan;
	/**
	 */
	@Column(name = "cin", length = 45)
	String cin;
	/**
	 */
	@Column(name = "tin", length = 45)
	String tin;
	/**
	 */
	@Column(name = "email_id", length = 45)
	String emailId;
	/**
	 */
	@Column(name = "triggers", length = 45)
	String triggers;
	/**
	 */

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
	@JoinColumns({ @JoinColumn(name = "request_id", referencedColumnName = "request_id") })
	@XmlTransient
	Request request;

	/**
	 */
	public void setCirRequetId(Integer cirRequetId) {
		this.cirRequestId = cirRequetId;
	}

	/**
	 */
	public Integer getCirRequetId() {
		return this.cirRequestId;
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
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 */
	public Status getStatus() {
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
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("cirRequetId=[").append(cirRequestId).append("] ");
		buffer.append("xmlOutput=[").append(xmlOutput).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");

		return buffer.toString();
	}

	
	public String getProductField() {
		return productField;
	}

	public void setProductField(String productField) {
		this.productField = productField;
	}

	public Integer getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(Integer purpose) {
		this.purposeId = purpose;
	}

	public String getEnquiryAmount() {
		return enquiryAmount;
	}

	public void setEnquiryAmount(String enquiryAmount) {
		this.enquiryAmount = enquiryAmount;
	}

	public String getUserHit() {
		return userHit;
	}

	public void setUserHit(String userHit) {
		this.userHit = userHit;
	}

	public String getAdminHit() {
		return adminHit;
	}

	public void setAdminHit(String adminHit) {
		this.adminHit = adminHit;
	}

	public String getEnquiryAmntMomentaryType() {
		return enquiryAmntMomentaryType;
	}

	public void setEnquiryAmntMomentaryType(String enquiryAmntMomentaryType) {
		this.enquiryAmntMomentaryType = enquiryAmntMomentaryType;
	}

	public String getEnquiryApplctnType() {
		return enquiryApplctnType;
	}

	public void setEnquiryApplctnType(String enquiryApplctnType) {
		this.enquiryApplctnType = enquiryApplctnType;
	}

	public String getEnquiryAccntType() {
		return enquiryAccntType;
	}

	public void setEnquiryAccntType(String enquiryAccntType) {
		this.enquiryAccntType = enquiryAccntType;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getDurationOfAgrement() {
		return durationOfAgrement;
	}

	public void setDurationOfAgrement(String durationOfAgrement) {
		this.durationOfAgrement = durationOfAgrement;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getEnquiryAddProduct() {
		return enquiryAddProduct;
	}

	public void setEnquiryAddProduct(String enquiryAddProduct) {
		this.enquiryAddProduct = enquiryAddProduct;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumberExtn() {
		return phoneNumberExtn;
	}

	public void setPhoneNumberExtn(String phoneNumberExtn) {
		this.phoneNumberExtn = phoneNumberExtn;
	}

	public String getExperianEncrypted() {
		return experianEncrypted;
	}

	public void setExperianEncrypted(String experianEncrypted) {
		this.experianEncrypted = experianEncrypted;
	}

	public String getCompanyPan() {
		return companyPan;
	}

	public void setCompanyPan(String companyPan) {
		this.companyPan = companyPan;
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
	
	public Integer getCirRequestId() {
		return cirRequestId;
	}

	public void setCirRequestId(Integer cirRequestId) {
		this.cirRequestId = cirRequestId;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}
}
