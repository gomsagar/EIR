//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.21 at 07:58:31 PM IST 
//


package com.eir.model.bir;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for CompanyReportType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CompanyReportType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyProfile" type="{}CompanyProfileType"/>
 *         &lt;element name="PrincipalProductOrServices" type="{}PrincipalProductOrServicesType"/>
 *         &lt;element name="ShareCapital" type="{}ShareCapitalType"/>
 *         &lt;element name="ShareHoldingPattern" type="{}ShareHoldingPatternType"/>
 *         &lt;element name="KeyManagerialPersons" type="{}KeyManagerialPersonsType"/>
 *         &lt;element name="Charges" type="{}ChargesType"/>
 *         &lt;element name="Auditors" type="{}AuditorsType"/>
 *         &lt;element name="BalanceSheet" type="{}BalanceSheetType"/>
 *         &lt;element name="ProfitAndLoss" type="{}ProfitAndLossType"/>
 *         &lt;element name="CashFlowDirect" type="{}CashFlowDirectType"/>
 *         &lt;element name="CashFlowInDirect" type="{}CashFlowInDirectType"/>
 *         &lt;element name="IntangibleAssets" type="{}IntangibleAssetsType"/>
 *         &lt;element name="OtherCurrentLiabilites" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AllotmentOfNewEquity" type="{}AllotmentOfNewEquityType"/>
 *         &lt;element name="Lawsuits" type="{}LawsuitsType"/>
 *         &lt;element name="Shareholders" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CompanyReportType", propOrder = {
    "companyProfile",
    "principalProductOrServices",
    "shareCapital",
    "shareHoldingPattern",
    "keyManagerialPersons",
    "charges",
    "auditors",
    "balanceSheet",
    "profitAndLoss",
    "cashFlowDirect",
    "cashFlowInDirect",
    "intangibleAssets",
    "otherCurrentLiabilites",
    "allotmentOfNewEquity",
    "lawsuits",
    "shareholders",
    "finacialRatios",
    "companyStructure"
})
@XmlRootElement(name = "CompanyReport")
public class CompanyReportType {

    @XmlElement(name = "CompanyProfile", required = false)
    protected CompanyProfileType companyProfile;
    @XmlElement(name = "PrincipalProductOrServices", required = false)
    protected PrincipalProductOrServicesType principalProductOrServices;
/*    @XmlElement(name = "ProductOrService", required = false)
    protected ProductOrServiceType productOrServices;*/
    @XmlElement(name = "ShareCapital", required = false)
    protected ShareCapitalType shareCapital;
    @XmlElement(name = "ShareHoldingPattern", required = false)
    protected ShareHoldingPatternType shareHoldingPattern;
    @XmlElement(name = "KeyManagerialPersons", required = false)
    protected KeyManagerialPersonsType keyManagerialPersons;
    @XmlElement(name = "Charges", required = false)
    protected ChargesType charges;
    @XmlElement(name = "Auditors", required = false)
    protected AuditorsType auditors;
    @XmlElement(name = "BalanceSheet", required = false)
    protected BalanceSheetType balanceSheet;
    @XmlElement(name = "ProfitAndLoss", required = false)
    protected ProfitAndLossType profitAndLoss;
    @XmlElement(name = "CashFlowDirect", required = false)
    protected CashFlowDirectType cashFlowDirect;
    @XmlElement(name = "CashFlowInDirect", required = false)
    protected CashFlowInDirectType cashFlowInDirect;
    @XmlElement(name = "TangibleAssets", required = false)
    protected IntangibleAssetsType intangibleAssets;
    @XmlElement(name = "OtherCurrentLiabilites", required = false)
    protected String otherCurrentLiabilites;
    @XmlElement(name = "AllotmentOfNewEquity", required = false)
    protected AllotmentOfNewEquityType allotmentOfNewEquity;
    @XmlElement(name = "Lawsuits", required = false)
    protected LawsuitsType lawsuits;
    @XmlElement(name = "Shareholders", required = false)
    protected ShareHolders shareholders;
    @XmlElement(name = "CompanyStructure", required = false)
    protected CompanyStructure companyStructure;
	@XmlElement(name = "FinacialRatios", required =  false)
    protected List<FinancialRatios> finacialRatios;

/*    public ProductOrServiceType getProductOrServices() {
		return productOrServices;
	}

	public void setProductOrServices(ProductOrServiceType productOrServices) {
		this.productOrServices = productOrServices;
	}*/

	public CompanyStructure getCompanyStructure() {
		return companyStructure;
	}

	public void setCompanyStructure(CompanyStructure companyStructure) {
		this.companyStructure = companyStructure;
	}


    public List<FinancialRatios> getFinacialRatios() {
        if (finacialRatios == null) {
            finacialRatios = new ArrayList<FinancialRatios>();
        }
        return this.finacialRatios;
    }
    
/*    @XmlElement(name = "SnapshotType", required = false)
    protected List<SnapshotType> snapshotType;

    public List<SnapshotType> getSnapshotType() {
        if (snapshotType == null) {
            snapshotType = new ArrayList<SnapshotType>();
        }
        return this.snapshotType;
    }
    public void setSnapshot(List<SnapshotType> snapshot){
    	this.snapshotType = snapshot;
    }*/
    /**
     * Gets the value of the companyProfile property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyProfileType }
     *     
     */
    public CompanyProfileType getCompanyProfile() {
        return companyProfile;
    }

    /**
     * Sets the value of the companyProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyProfileType }
     *     
     */
    public void setCompanyProfile(CompanyProfileType value) {
        this.companyProfile = value;
    }

    /**
     * Gets the value of the principalProductOrServices property.
     * 
     * @return
     *     possible object is
     *     {@link PrincipalProductOrServicesType }
     *     
     */
    public PrincipalProductOrServicesType getPrincipalProductOrServices() {
        return principalProductOrServices;
    }

    /**
     * Sets the value of the principalProductOrServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrincipalProductOrServicesType }
     *     
     */
    public void setPrincipalProductOrServices(PrincipalProductOrServicesType value) {
        this.principalProductOrServices = value;
    }

    /**
     * Gets the value of the shareCapital property.
     * 
     * @return
     *     possible object is
     *     {@link ShareCapitalType }
     *     
     */
    public ShareCapitalType getShareCapital() {
        return shareCapital;
    }

    /**
     * Sets the value of the shareCapital property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShareCapitalType }
     *     
     */
    public void setShareCapital(ShareCapitalType value) {
        this.shareCapital = value;
    }

    /**
     * Gets the value of the shareHoldingPattern property.
     * 
     * @return
     *     possible object is
     *     {@link ShareHoldingPatternType }
     *     
     */
    public ShareHoldingPatternType getShareHoldingPattern() {
        return shareHoldingPattern;
    }

    /**
     * Sets the value of the shareHoldingPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShareHoldingPatternType }
     *     
     */
    public void setShareHoldingPattern(ShareHoldingPatternType value) {
        this.shareHoldingPattern = value;
    }

    /**
     * Gets the value of the keyManagerialPersons property.
     * 
     * @return
     *     possible object is
     *     {@link KeyManagerialPersonsType }
     *     
     */
    public KeyManagerialPersonsType getKeyManagerialPersons() {
        return keyManagerialPersons;
    }

    /**
     * Sets the value of the keyManagerialPersons property.
     * 
     * @param value
     *     allowed object is
     *     {@link KeyManagerialPersonsType }
     *     
     */
    public void setKeyManagerialPersons(KeyManagerialPersonsType value) {
        this.keyManagerialPersons = value;
    }

    /**
     * Gets the value of the charges property.
     * 
     * @return
     *     possible object is
     *     {@link ChargesType }
     *     
     */
    public ChargesType getCharges() {
        return charges;
    }

    /**
     * Sets the value of the charges property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargesType }
     *     
     */
    public void setCharges(ChargesType value) {
        this.charges = value;
    }

    /**
     * Gets the value of the auditors property.
     * 
     * @return
     *     possible object is
     *     {@link AuditorsType }
     *     
     */
    public AuditorsType getAuditors() {
        return auditors;
    }

    /**
     * Sets the value of the auditors property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditorsType }
     *     
     */
    public void setAuditors(AuditorsType value) {
        this.auditors = value;
    }

    /**
     * Gets the value of the balanceSheet property.
     * 
     * @return
     *     possible object is
     *     {@link BalanceSheetType }
     *     
     */
    public BalanceSheetType getBalanceSheet() {
        return balanceSheet;
    }

    /**
     * Sets the value of the balanceSheet property.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSheetType }
     *     
     */
    public void setBalanceSheet(BalanceSheetType value) {
        this.balanceSheet = value;
    }

    /**
     * Gets the value of the profitAndLoss property.
     * 
     * @return
     *     possible object is
     *     {@link ProfitAndLossType }
     *     
     */
    public ProfitAndLossType getProfitAndLoss() {
        return profitAndLoss;
    }

    /**
     * Sets the value of the profitAndLoss property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfitAndLossType }
     *     
     */
    public void setProfitAndLoss(ProfitAndLossType value) {
        this.profitAndLoss = value;
    }

    /**
     * Gets the value of the cashFlowDirect property.
     * 
     * @return
     *     possible object is
     *     {@link CashFlowDirectType }
     *     
     */
    public CashFlowDirectType getCashFlowDirect() {
        return cashFlowDirect;
    }

    /**
     * Sets the value of the cashFlowDirect property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashFlowDirectType }
     *     
     */
    public void setCashFlowDirect(CashFlowDirectType value) {
        this.cashFlowDirect = value;
    }

    /**
     * Gets the value of the cashFlowInDirect property.
     * 
     * @return
     *     possible object is
     *     {@link CashFlowInDirectType }
     *     
     */
    public CashFlowInDirectType getCashFlowInDirect() {
        return cashFlowInDirect;
    }

    /**
     * Sets the value of the cashFlowInDirect property.
     * 
     * @param value
     *     allowed object is
     *     {@link CashFlowInDirectType }
     *     
     */
    public void setCashFlowInDirect(CashFlowInDirectType value) {
        this.cashFlowInDirect = value;
    }

    /**
     * Gets the value of the intangibleAssets property.
     * 
     * @return
     *     possible object is
     *     {@link IntangibleAssetsType }
     *     
     */
    public IntangibleAssetsType getIntangibleAssets() {
        return intangibleAssets;
    }

    /**
     * Sets the value of the intangibleAssets property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntangibleAssetsType }
     *     
     */
    public void setIntangibleAssets(IntangibleAssetsType value) {
        this.intangibleAssets = value;
    }

    /**
     * Gets the value of the otherCurrentLiabilites property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOtherCurrentLiabilites() {
        return otherCurrentLiabilites;
    }

    /**
     * Sets the value of the otherCurrentLiabilites property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOtherCurrentLiabilites(String value) {
        this.otherCurrentLiabilites = value;
    }

    /**
     * Gets the value of the allotmentOfNewEquity property.
     * 
     * @return
     *     possible object is
     *     {@link AllotmentOfNewEquityType }
     *     
     */
    public AllotmentOfNewEquityType getAllotmentOfNewEquity() {
        return allotmentOfNewEquity;
    }

    /**
     * Sets the value of the allotmentOfNewEquity property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllotmentOfNewEquityType }
     *     
     */
    public void setAllotmentOfNewEquity(AllotmentOfNewEquityType value) {
        this.allotmentOfNewEquity = value;
    }

    /**
     * Gets the value of the lawsuits property.
     * 
     * @return
     *     possible object is
     *     {@link LawsuitsType }
     *     
     */
    public LawsuitsType getLawsuits() {
        return lawsuits;
    }

    /**
     * Sets the value of the lawsuits property.
     * 
     * @param value
     *     allowed object is
     *     {@link LawsuitsType }
     *     
     */
    public void setLawsuits(LawsuitsType value) {
        this.lawsuits = value;
    }

    /**
     * Gets the value of the shareholders property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public ShareHolders getShareholders() {
        return shareholders;
    }

    /**
     * Sets the value of the shareholders property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShareholders(ShareHolders value) {
        this.shareholders = value;
    }

}
