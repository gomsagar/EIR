
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "consumer_request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "ConsumerRequet")

@EntityListeners(AuditingEntityListener.class)
public class ConsumerRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "consumer_request_id", nullable = false)
	

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
	String ernNumber;
	/**
	 */
	
	@Column(name = "first_given_name", length = 45)
	

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
	@Column(name = "relation_Type")
	String relationType;
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "relationType_Id", referencedColumnName = "relation_type_id") })
	RelationType relationType;*/
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "accountType_Id", referencedColumnName = "account_type_id") })
	AccountType accountType;*/
	/**
	 */

	@Column(name = "xml_output", columnDefinition = "BLOB")	
	@Lob
	byte[] xmlOutput;
	/**
	 */

	@Column(name = "score", length = 45)
	

	@XmlElement
	String score;
	/**
	 */

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "status_id", referencedColumnName = "status_id") })
	Status statusId;
	/**
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "address_id", referencedColumnName = "address_id") })
	Address addressId;

	@Column(name = "person_pan", length = 45)
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
	String officeTelephoneNo;
	/**
	 */

	@Column(name = "mobile_no", length = 45)
	String mobileNo;
	/**
	 */

	@Column(name = "marital_status", length = 45)
	String maritalStatus;
	/**
	 */

	@Column(name = "gender")
	Integer gender;
	
	
	@Column(name = "amount", length = 45)
	Float amount;
	
	@Column(name = "enquiry_amt_monetary_type", length = 45)
	String enquiryAmtMonetaryType;

	@Column(name = "bureau_member_id", length = 45)
	Integer bureauMemberId;
	
	@Column(name = "enquiry_application_type", length = 45)
	String enquiryApplicationType;
	
	@Column(name = "enquiry_add_on_product", length = 45)
	String enquiryAddOnProduct;
	
	@Column(name = "enquiry_account_type", length = 45)
	String enquiryAccountType;

	@Column(name = "search_type", length = 45)
	String searchType;
	
	@Column(name = "purpose_id", length = 45)
	Integer purposeId;

	@Column(name = "enquiry_amount", length = 45)
	String enquiryAmount;

	@Column(name = "client_enquiry_ref_number", length = 45)
	String clientEnquiryRefNumber;
	
	@Column(name = "frequency_id", length = 45)
	String frequencyId;

	@Column(name = "duration_of_agreement", length = 45)
	String durationOfAgreement;
	
	@Column(name = "purpose_of_inquiry", length = 45)
	Integer purposeOfInquiry;

	@Column(name = "enquiry_credit_purpose", length = 45)
	String enquiryCreditPurpose;

	@Column(name = "language", length = 45)
	String language;
	
	@Column(name = "other_middle_names", length = 45)
	String otherMiddleNames;

	@Column(name = "suffix", length = 45)
	String suffix;

	@Column(name = "application_role", length = 45)
	String applicationRole;
	
	@Column(name = "dateOfBirth", length = 45)
	Date dateOfBirth;

	@Column(name = "india_middle_name3", length = 45)
	String indiaMiddleName3;

	@Column(name = "india_name_title", length = 45)
	String indiaNameTitle;
	
	@Column(name = "alias_name", length = 45)
	String aliasName;
	
	@Column(name = "alias_type", length = 45)
	String aliasType;
	
	@Column(name = "id_number_type", length = 45)
	String idNumberType;
	
	@Column(name = "id_number", length = 45)
	String idNumber;

	@Column(name = "bank_account_number", length = 45)
	String bankAccountNumber;

	@Column(name = "phone_number", length = 45)
	String phoneNumber;
	
	@Column(name = "phone_type", length = 45)
	Date phoneType;

	@Column(name = "web_addr", length = 45)
	String webAddr;

	@Column(name = "occupation_code", length = 45)
	String occupationCode;
	
	@Column(name = "net_montly_income", length = 45)
	String netMontlyIncome;
	
	@Column(name = "occ_years_employed", length = 45)
	String occYearsEmployed;
	
	@Column(name = "occ_months_employed", length = 45)
	String occMonthsEmployed;
	
	@Column(name = "number_of_credit_card_held", length = 45)
	String numberOfCreditCardHeld;

	@Column(name = "monthly_family_expense_amt", length = 45)
	String monthlyFamilyExpenseAmt;

	@Column(name = "number_dependents", length = 45)
	String numberDependents;
	
	@Column(name = "poverty_index", length = 45)
	Date povertyIndex;

	@Column(name = "asset_ownership_indicator", length = 45)
	String assetOwnershipIndicator;
	
	@Column(name = "family_name", length = 45)
	String familyName;


	@Column(name = "product_field", length = 45)
	String productField;

	
	@Column(name = "create_user_id", length = 45)
	@CreatedBy
	String createUserId;
	/**
	 */
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
	@Column(name = "update_date")
	

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "request_id", referencedColumnName = "request_id") })
	Request request;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "cir_request_id", referencedColumnName = "cir_request_id") })
	CirRequest cirRequest;

	
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
	public ConsumerRequest() {
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("consumerRequetId=[").append(consumerRequetId).append("] ");
		buffer.append("xmlOutput=[").append(xmlOutput).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("status=[").append(statusId).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");

		return buffer.toString();
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

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public CirRequest getCirRequest() {
		return cirRequest;
	}

	public void setCirRequest(CirRequest cirRequest) {
		this.cirRequest = cirRequest;
	}

	public String getErnNumber() {
		return ernNumber;
	}

	public void setErnNumber(String ernNumber) {
		this.ernNumber = ernNumber;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getEnquiryAmtMonetaryType() {
		return enquiryAmtMonetaryType;
	}

	public void setEnquiryAmtMonetaryType(String enquiryAmtMonetaryType) {
		this.enquiryAmtMonetaryType = enquiryAmtMonetaryType;
	}

	public Integer getBureauMemberId() {
		return bureauMemberId;
	}

	public void setBureauMemberId(Integer bureauMemberId) {
		this.bureauMemberId = bureauMemberId;
	}

	public String getEnquiryApplicationType() {
		return enquiryApplicationType;
	}

	public void setEnquiryApplicationType(String enquiryApplicationType) {
		this.enquiryApplicationType = enquiryApplicationType;
	}

	public String getEnquiryAccountType() {
		return enquiryAccountType;
	}

	public void setEnquiryAccountType(String enquiryAccountType) {
		this.enquiryAccountType = enquiryAccountType;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public Integer getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(Integer purposeId) {
		this.purposeId = purposeId;
	}

	public String getEnquiryAmount() {
		return enquiryAmount;
	}

	public void setEnquiryAmount(String enquiryAmount) {
		this.enquiryAmount = enquiryAmount;
	}

	public String getClientEnquiryRefNumber() {
		return clientEnquiryRefNumber;
	}

	public void setClientEnquiryRefNumber(String clientEnquiryRefNumber) {
		this.clientEnquiryRefNumber = clientEnquiryRefNumber;
	}

	public String getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(String frequencyId) {
		this.frequencyId = frequencyId;
	}

	public String getDurationOfAgreement() {
		return durationOfAgreement;
	}

	public void setDurationOfAgreement(String durationOfAgreement) {
		this.durationOfAgreement = durationOfAgreement;
	}

	public Integer getPurposeOfInquiry() {
		return purposeOfInquiry;
	}

	public void setPurposeOfInquiry(Integer purposeOfInquiry) {
		this.purposeOfInquiry = purposeOfInquiry;
	}

	public String getEnquiryCreditPurpose() {
		return enquiryCreditPurpose;
	}

	public void setEnquiryCreditPurpose(String enquiryCreditPurpose) {
		this.enquiryCreditPurpose = enquiryCreditPurpose;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getOtherMiddleNames() {
		return otherMiddleNames;
	}

	public void setOtherMiddleNames(String otherMiddleNames) {
		this.otherMiddleNames = otherMiddleNames;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getApplicationRole() {
		return applicationRole;
	}

	public void setApplicationRole(String applicationRole) {
		this.applicationRole = applicationRole;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIndiaMiddleName3() {
		return indiaMiddleName3;
	}

	public void setIndiaMiddleName3(String indiaMiddleName3) {
		this.indiaMiddleName3 = indiaMiddleName3;
	}

	public String getIndiaNameTitle() {
		return indiaNameTitle;
	}

	public void setIndiaNameTitle(String indiaNameTitle) {
		this.indiaNameTitle = indiaNameTitle;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getIdNumberType() {
		return idNumberType;
	}

	public void setIdNumberType(String idNumberType) {
		this.idNumberType = idNumberType;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(String bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(Date phoneType) {
		this.phoneType = phoneType;
	}

	public String getWebAddr() {
		return webAddr;
	}

	public void setWebAddr(String webAddr) {
		this.webAddr = webAddr;
	}

	public String getOccupationCode() {
		return occupationCode;
	}

	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

	public String getNetMontlyIncome() {
		return netMontlyIncome;
	}

	public void setNetMontlyIncome(String netMontlyIncome) {
		this.netMontlyIncome = netMontlyIncome;
	}

	public String getOccYearsEmployed() {
		return occYearsEmployed;
	}

	public void setOccYearsEmployed(String occYearsEmployed) {
		this.occYearsEmployed = occYearsEmployed;
	}

	public String getOccMonthsEmployed() {
		return occMonthsEmployed;
	}

	public void setOccMonthsEmployed(String occMonthsEmployed) {
		this.occMonthsEmployed = occMonthsEmployed;
	}

	public String getNumberOfCreditCardHeld() {
		return numberOfCreditCardHeld;
	}

	public void setNumberOfCreditCardHeld(String numberOfCreditCardHeld) {
		this.numberOfCreditCardHeld = numberOfCreditCardHeld;
	}

	public String getMonthlyFamilyExpenseAmt() {
		return monthlyFamilyExpenseAmt;
	}

	public void setMonthlyFamilyExpenseAmt(String monthlyFamilyExpenseAmt) {
		this.monthlyFamilyExpenseAmt = monthlyFamilyExpenseAmt;
	}

	public String getNumberDependents() {
		return numberDependents;
	}

	public void setNumberDependents(String numberDependents) {
		this.numberDependents = numberDependents;
	}

	public Date getPovertyIndex() {
		return povertyIndex;
	}

	public void setPovertyIndex(Date povertyIndex) {
		this.povertyIndex = povertyIndex;
	}

	public String getAssetOwnershipIndicator() {
		return assetOwnershipIndicator;
	}

	public void setAssetOwnershipIndicator(String assetOwnershipIndicator) {
		this.assetOwnershipIndicator = assetOwnershipIndicator;
	}

	public String getEnquiryAddOnProduct() {
		return enquiryAddOnProduct;
	}

	public void setEnquiryAddOnProduct(String enquiryAddOnProduct) {
		this.enquiryAddOnProduct = enquiryAddOnProduct;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getAliasType() {
		return aliasType;
	}

	public void setAliasType(String aliasType) {
		this.aliasType = aliasType;
	}

	public String getProductField() {
		return productField;
	}

	public void setProductField(String productField) {
		this.productField = productField;
	}
	
	
}
