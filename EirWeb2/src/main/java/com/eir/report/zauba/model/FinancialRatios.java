package com.eir.report.zauba.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinacialRatios", propOrder = {
    "solvencyRatios",
    "leverageRatios",
    "effeciencyRatios",
    "profitabilityRatios"
})
public class FinancialRatios 
{
    @XmlElement(name = "SolvencyRatios", required = false)
    protected SolvencyRatios solvencyRatios;
    @XmlElement(name = "LeverageRatios", required = false)
    protected LeverageRatios leverageRatios;
    @XmlElement(name = "EffeciencyRatios", required = false)
    protected EffeciencyRatios effeciencyRatios;
    @XmlElement(name = "ProfitabilityRatios", required = false)
    protected ProfitabilityRatios profitabilityRatios;
    @XmlAttribute(name = "AsOf")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar asOf;

    /**
     * Gets the value of the solvencyRatios property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyReport.FinacialRatios.SolvencyRatios }
     *     
     */
    public SolvencyRatios getSolvencyRatios() {
        return solvencyRatios;
    }

    /**
     * Sets the value of the solvencyRatios property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyReport.FinacialRatios.SolvencyRatios }
     *     
     */
    public void setSolvencyRatios(SolvencyRatios value) {
        this.solvencyRatios = value;
    }

    /**
     * Gets the value of the leverageRatios property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyReport.FinacialRatios.LeverageRatios }
     *     
     */
    public LeverageRatios getLeverageRatios() {
        return leverageRatios;
    }

    /**
     * Sets the value of the leverageRatios property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyReport.FinacialRatios.LeverageRatios }
     *     
     */
    public void setLeverageRatios(LeverageRatios value) {
        this.leverageRatios = value;
    }

    /**
     * Gets the value of the effeciencyRatios property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyReport.FinacialRatios.EffeciencyRatios }
     *     
     */
    public EffeciencyRatios getEffeciencyRatios() {
        return effeciencyRatios;
    }

    /**
     * Sets the value of the effeciencyRatios property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyReport.FinacialRatios.EffeciencyRatios }
     *     
     */
    public void setEffeciencyRatios(EffeciencyRatios value) {
        this.effeciencyRatios = value;
    }

    /**
     * Gets the value of the profitabilityRatios property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyReport.FinacialRatios.ProfitabilityRatios }
     *     
     */
    public ProfitabilityRatios getProfitabilityRatios() {
        return profitabilityRatios;
    }

    /**
     * Sets the value of the profitabilityRatios property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyReport.FinacialRatios.ProfitabilityRatios }
     *     
     */
    public void setProfitabilityRatios(ProfitabilityRatios value) {
        this.profitabilityRatios = value;
    }

    /**
     * Gets the value of the asOf property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAsOf() {
        return asOf;
    }

    /**
     * Sets the value of the asOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAsOf(XMLGregorianCalendar value) {
        this.asOf = value;
    }

}
