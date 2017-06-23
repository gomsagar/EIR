

// main domain :All domain is linked up one singel domain.so only one refrence variable is used

package com.eir.commercial.domains;


import java.util.List;

public class CommercialReportDetails {

	private VMReportHeader reportHeader;
	private Score score;
	private CurrentApplication application;
	private CompanyDetails companyDetails;
	//private LocationDetails details;
	private List<LocationDetails> locationDetails;
	private AccountSummary accountSummary;
	private ReportSummary reportSummary;
	private List<RelationshipDetails>relationshipDetails;
	private List<SuitFiledDetails> suitFiledDetails;
	
	private List<CreditFacilityDetailsAsGuarentor>facilityDetailsAsGuarentor;
	private List<EnquiryDetails> enquiryDetails;
    private List<MainCreditFacility> creditFacilities;
   
   //private boolean relationshipentity;
   private String currency;
   private int year;
   private boolean disclosure;
   private ReportCir cir;
   private SalesInvoice invoice;
   private String reportIdentifier;
   
   
   
   
   
   
   /**
 * @return the reportIdentifier
 */
public String getReportIdentifier() {
	return reportIdentifier;
}
/**
 * @param reportIdentifier the reportIdentifier to set
 */
public void setReportIdentifier(String reportIdentifier) {
	this.reportIdentifier = reportIdentifier;
}
public ReportCir getCir() {
	return cir;
}
public void setCir(ReportCir cir) {
	this.cir = cir;
}
public SalesInvoice getInvoice() {
	return invoice;
}
public void setInvoice(SalesInvoice invoice) {
	this.invoice = invoice;
}
public boolean isDisclosure() {
	return disclosure;
}
public void setDisclosure(boolean disclosure) {
	this.disclosure = disclosure;
}
/**
 * @return the year
 */
public int getYear() {
	return year;
}
/**
 * @param year the year to set
 */
public void setYear(int year) {
	this.year = year;
}
private boolean matchFound ;
   
   
/**
 * @return the currency
 */


public boolean isMatchFound() {
	return matchFound;
}
public void setMatchFound(boolean matchFound) {
	this.matchFound = matchFound;
}
/**
 * @return the currency
 */
public String getCurrency() {
	return currency;
}
/**
 * @param currency the currency to set
 */
public void setCurrency(String currency) {
	this.currency = currency;
}

/**
 * @return the score
 */
public Score getScore() {
	return score;
}
/**
 * @param score the score to set
 */
public void setScore(Score score) {
	this.score = score;
}
/**
 * @return the application
 */
public CurrentApplication getApplication() {
	return application;
}
/**
 * @param application the application to set
 */
public void setApplication(CurrentApplication application) {
	this.application = application;
}
/**
 * @return the companyDetails
 */
public CompanyDetails getCompanyDetails() {
	return companyDetails;
}
/**
 * @param companyDetails the companyDetails to set
 */
public void setCompanyDetails(CompanyDetails companyDetails) {
	this.companyDetails = companyDetails;
}
/**
 * @return the locationDetails
 */
public List<LocationDetails> getLocationDetails() {
	return locationDetails;
}
/**
 * @param locationDetails the locationDetails to set
 */
public void setLocationDetails(List<LocationDetails> locationDetails) {
	this.locationDetails = locationDetails;
}
/**
 * @return the accountSummary
 */
public AccountSummary getAccountSummary() {
	return accountSummary;
}
/**
 * @param accountSummary the accountSummary to set
 */
public void setAccountSummary(AccountSummary accountSummary) {
	this.accountSummary = accountSummary;
}
/**
 * @return the reportSummary
 */
public ReportSummary getReportSummary() {
	return reportSummary;
}
/**
 * @param reportSummary the reportSummary to set
 */
public void setReportSummary(ReportSummary reportSummary) {
	this.reportSummary = reportSummary;
}
/**
 * @return the relationshipDetails
 */


/**
 * @return the suitFiledDetails
 */
public List<SuitFiledDetails> getSuitFiledDetails() {
	return suitFiledDetails;
}
/**
 * @return the relationshipDetails
 */
public List<RelationshipDetails> getRelationshipDetails() {
	return relationshipDetails;
}
/**
 * @param relationshipDetails the relationshipDetails to set
 */
public void setRelationshipDetails(List<RelationshipDetails> relationshipDetails) {
	this.relationshipDetails = relationshipDetails;
}
/**
 * @param suitFiledDetails the suitFiledDetails to set
 */
public void setSuitFiledDetails(List<SuitFiledDetails> suitFiledDetails) {
	this.suitFiledDetails = suitFiledDetails;
}

/**
 * @return the facilityDetailsAsGuarentor
 */
public List<CreditFacilityDetailsAsGuarentor> getFacilityDetailsAsGuarentor() {
	return facilityDetailsAsGuarentor;
}
/**
 * @param facilityDetailsAsGuarentor the facilityDetailsAsGuarentor to set
 */
public void setFacilityDetailsAsGuarentor(List<CreditFacilityDetailsAsGuarentor> facilityDetailsAsGuarentor) {
	this.facilityDetailsAsGuarentor = facilityDetailsAsGuarentor;
}
/**
 
 * @return the creditFacilities
 */
public List<MainCreditFacility> getCreditFacilities() {
	return creditFacilities;
}
/**
 * @return the enquiryDetails
 */
public List<EnquiryDetails> getEnquiryDetails() {
	return enquiryDetails;
}
/**
 * @param enquiryDetails the enquiryDetails to set
 */
public void setEnquiryDetails(List<EnquiryDetails> enquiryDetails) {
	this.enquiryDetails = enquiryDetails;
}
/**
 * @param creditFacilities the creditFacilities to set
 */
public void setCreditFacilities(List<MainCreditFacility> creditFacilities) {
	this.creditFacilities = creditFacilities;
}
/**
 * @return the reportHeader
 */
public VMReportHeader getReportHeader() {
	return reportHeader;
}
/**
 * @param reportHeader the reportHeader to set
 */
public void setReportHeader(VMReportHeader reportHeader) {
	this.reportHeader = reportHeader;
}
	



	/*public LocationDetails getDetails() {
		return details;
	}

	public void setDetails(LocationDetails details) {
		this.details = details;
	}*/
}
