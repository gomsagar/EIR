/**
 * 
 */
package com.eir.combo.domains;

import java.util.List;

import com.eir.commercial.domains.CompanyDetails;

/**
 *Setter & Getter methods of All Domains*	
 */
public class ComboSummaryDomain 
{
	private CompanyInfoDomain cmpInfo;
	private CompanyDetails companyDetails;
	private IdentifiersDomain idDomain;
	private List<RelatedDirectorsDomain> dirDomain;
	private String ern;
	private String enqRef;
	private String memName;
	private String reportDate;
	private String currency;
	
	private int scoreCom;
	private double scoreCons;
	private int delphiChck;
	
	public int getDelphiChck() {
		return delphiChck;
	}
	public void setDelphiChck(int delphiChck) {
		this.delphiChck = delphiChck;
	}
	
	public int getScoreCom() {
		return scoreCom;
	}
	public void setScoreCom(int scoreCom) {
		this.scoreCom = scoreCom;
	}
	public double getScoreCons() {
		return scoreCons;
	}
	public void setScoreCons(double scoreCons) {
		this.scoreCons = scoreCons;
	}
	public CompanyDetails getCompanyDetails() {
		return companyDetails;
	}
	public void setCompanyDetails(CompanyDetails companyDetails) {
		this.companyDetails = companyDetails;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getReportDate()
	{
		return reportDate;
	}
	public void setReportDate(String reportDate) 
	{
		this.reportDate = reportDate;
	}
	public String getErn() 
	{
		return ern;
	}
	public void setErn(String ern) 
	{
		this.ern = ern;
	}
	public String getEnqRef()
	{
		return enqRef;
	}
	public void setEnqRef(String enqRef)
	{
		this.enqRef = enqRef;
	}
	public String getMemName()
	{
		return memName;
	}
	public void setMemName(String memName) 
	{
		this.memName = memName;
	}
	public CompanyInfoDomain getCmpInfo()
	{
		return cmpInfo;
	}
	public void setCmpInfo(CompanyInfoDomain cmpInfo) 
	{
		this.cmpInfo = cmpInfo;
	}
	public IdentifiersDomain getIdDomain() 
	{
		return idDomain;
	}
	public void setIdDomain(IdentifiersDomain idDomain) 
	{
		this.idDomain = idDomain;
	}
	public List<RelatedDirectorsDomain> getDirDomain() 
	{
		return dirDomain;
	}
	public void setDirDomain(List<RelatedDirectorsDomain> list) 
	{
		this.dirDomain = list;
	}
	@Override
	public String toString() {
		return "ComboSummaryDomain [cmpInfo=" + cmpInfo + ", companyDetails="
				+ companyDetails + ", idDomain=" + idDomain + ", dirDomain="
				+ dirDomain + ", ern=" + ern + ", enqRef=" + enqRef
				+ ", memName=" + memName + ", reportDate=" + reportDate
				+ ", currency=" + currency + ", scoreCom=" + scoreCom
				+ ", scoreCons=" + scoreCons + ", delphiChck=" + delphiChck
				+ "]";
	}

	
}
