package com.eir.commercial.domains;

import java.util.List;

public class AccountSummary {
 private String nameOfInstitution;
 
 
				/** * Name of Institution :HDFC */
 
 private String TCFAB;/** * Total Credit Facilities - As Borrower */
 private String TCFAG;/** * Total Credit facilities -As Guarentor */
 private String ACF;/** *Active Credit Facilities */
 private String TOAB;/** * Total Outstanding AS Borower*/
 private String TOAG;/** * Total Outstanding AS Guarentor */
 private String LAOP;/** *Latest Account  Open Date */
 private String DCFOBAB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower*/
 private String DCFOBABB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower Balance*/
 private String DCFOBAG;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor*/
 private String DCFOBAGB;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor Balance*/
  
 /** * Name of Institution :PSU */
 private String PSUTCFAB;/** * Total Credit Facilities - As Borrower */
 private String PSUTCFAG;/** * Total Credit facilities -As Guarentor */
 private String PSUACF;/** *Active Credit Facilities */
 private String PSUTOAB;/** * Total Outstanding AS Borower*/
 private String PSUTOAG;/** * Total Outstanding AS Guarentor */
 private String PSULAOP;/** *Latest Account  Open Date */
 private String PSUDCFOBAB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower*/
 private String PSUDCFOBABB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower Balance*/
 private String PSUDCFOBAG;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor*/
 private String PSUDCFOBAGB;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor Balance*/
 
 /** * Name of Institution :PVT */
 private String PVTTCFAB;/** * Total Credit Facilities - As Borrower */
 private String PVTTCFAG;/** * Total Credit facilities -As Guarentor */
 private String PVTACF;/** *Active Credit Facilities */
 private String PVTTOAB;/** * Total Outstanding AS Borower*/
 private String PVTTOAG;/** * Total Outstanding AS Guarentor */
 private String PVTLAOP;/** *Latest Account  Open Date */
 private String PVTDCFOBAB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower*/
 private String PVTDCFOBABB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower Balance*/
 private String PVTDCFOBAG;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor*/
 private String PVTDCFOBAGB;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor Balance*/
 
 /** * Name of Institution :NBFC*/
 private String NBFCTCFAB;/** * Total Credit Facilities - As Borrower */
 private String NBFCTCFAG;/** * Total Credit facilities -As Guarentor */
 private String NBFCACF;/** *Active Credit Facilities */
 private String NBFCTOAB;/** * Total Outstanding AS Borower*/
 private String NBFCTOAG;/** * Total Outstanding AS Guarentor */
 private String NBFCLAOP;/** *Latest Account  Open Date */
 private String NBFCDCFOBAB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower*/
 private String NBFCDCFOBABB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower Balance*/
 private String NBFCDCFOBAG;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor*/
 private String NBFCDCFOBAGB;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor Balance*/
 
 /** * Name of Institution :NST*/
 private String NSTTCFAB;/** * Total Credit Facilities - As Borrower */
 private String NSTTCFAG;/** * Total Credit facilities -As Guarentor */
 private String NSTACF;/** *Active Credit Facilities */
 private String NSTTOAB;/** * Total Outstanding AS Borower*/
 private String NSTTOAG;/** * Total Outstanding AS Guarentor */
 private String NSTLAOP;/** *Latest Account  Open Date */
 private String NSTDCFOBAB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower*/
 private String NSTDCFOBABB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower Balance*/
 private String NSTDCFOBAG;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor*/
 private String NSTDCFOBAGB;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor Balance*/
 
 /** * Name of Institution :GRAND TOTAL*/
 private String GTTCFAB;/** * Total Credit Facilities - As Borrower */
 private String GTTCFAG;/** * Total Credit facilities -As Guarentor */
 private String GTACF;/** *Active Credit Facilities */
 private String GTTOAB;/** * Total Outstanding AS Borower*/
 private String GTTOAG;/** * Total Outstanding AS Guarentor */
 private String GTLAOP;/** *Latest Account  Open Date */
 private String GTDCFOBAB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower*/
 private String GTDCFOBABB;/** *Delinquent Credit Facilitates and Outstanding Balance As Borower Balance*/
 private String GTDCFOBAG;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor*/
 private String GTDCFOBAGB;/** *Delinquent Credit Facilitates and Outstanding Balance As Guarentor Balance*/
 
 private List<FundedList> fundedLists;
 private List<CreditType> types;
 private List<CreditType> others;
 private String creditType;
/**
 * @return the nameOfInstitution
 */
public String getNameOfInstitution() {
	return nameOfInstitution;
}
/**
 * @param nameOfInstitution the nameOfInstitution to set
 */
public void setNameOfInstitution(String nameOfInstitution) {
	this.nameOfInstitution = nameOfInstitution;
}
/**
 * @return the tCFAB
 */
public String getTCFAB() {
	return TCFAB;
}
/**
 * @param tCFAB the tCFAB to set
 */
public void setTCFAB(String tCFAB) {
	TCFAB = tCFAB;
}
/**
 * @return the tCFAG
 */
public String getTCFAG() {
	return TCFAG;
}
/**
 * @param tCFAG the tCFAG to set
 */
public void setTCFAG(String tCFAG) {
	TCFAG = tCFAG;
}
/**
 * @return the aCF
 */
public String getACF() {
	return ACF;
}
/**
 * @param aCF the aCF to set
 */
public void setACF(String aCF) {
	ACF = aCF;
}
/**
 * @return the tOAB
 */
public String getTOAB() {
	return TOAB;
}
/**
 * @param tOAB the tOAB to set
 */
public void setTOAB(String tOAB) {
	TOAB = tOAB;
}
/**
 * @return the tOAG
 */
public String getTOAG() {
	return TOAG;
}
/**
 * @param tOAG the tOAG to set
 */
public void setTOAG(String tOAG) {
	TOAG = tOAG;
}
/**
 * @return the lAOP
 */
public String getLAOP() {
	return LAOP;
}
/**
 * @param lAOP the lAOP to set
 */
public void setLAOP(String lAOP) {
	LAOP = lAOP;
}
/**
 * @return the dCFOBAB
 */
public String getDCFOBAB() {
	return DCFOBAB;
}
/**
 * @param dCFOBAB the dCFOBAB to set
 */
public void setDCFOBAB(String dCFOBAB) {
	DCFOBAB = dCFOBAB;
}
/**
 * @return the dCFOBABB
 */
public String getDCFOBABB() {
	return DCFOBABB;
}
/**
 * @param dCFOBABB the dCFOBABB to set
 */
public void setDCFOBABB(String dCFOBABB) {
	DCFOBABB = dCFOBABB;
}
/**
 * @return the dCFOBAG
 */
public String getDCFOBAG() {
	return DCFOBAG;
}
/**
 * @param dCFOBAG the dCFOBAG to set
 */
public void setDCFOBAG(String dCFOBAG) {
	DCFOBAG = dCFOBAG;
}
/**
 * @return the dCFOBAGB
 */
public String getDCFOBAGB() {
	return DCFOBAGB;
}
/**
 * @param dCFOBAGB the dCFOBAGB to set
 */
public void setDCFOBAGB(String dCFOBAGB) {
	DCFOBAGB = dCFOBAGB;
}
/**
 * @return the pSUTCFAB
 */
public String getPSUTCFAB() {
	return PSUTCFAB;
}
/**
 * @param pSUTCFAB the pSUTCFAB to set
 */
public void setPSUTCFAB(String pSUTCFAB) {
	PSUTCFAB = pSUTCFAB;
}
/**
 * @return the pSUTCFAG
 */
public String getPSUTCFAG() {
	return PSUTCFAG;
}
/**
 * @param pSUTCFAG the pSUTCFAG to set
 */
public void setPSUTCFAG(String pSUTCFAG) {
	PSUTCFAG = pSUTCFAG;
}
/**
 * @return the pSUACF
 */
public String getPSUACF() {
	return PSUACF;
}
/**
 * @param pSUACF the pSUACF to set
 */
public void setPSUACF(String pSUACF) {
	PSUACF = pSUACF;
}
/**
 * @return the pSUTOAB
 */
public String getPSUTOAB() {
	return PSUTOAB;
}
/**
 * @param pSUTOAB the pSUTOAB to set
 */
public void setPSUTOAB(String pSUTOAB) {
	PSUTOAB = pSUTOAB;
}
/**
 * @return the pSUTOAG
 */
public String getPSUTOAG() {
	return PSUTOAG;
}
/**
 * @param pSUTOAG the pSUTOAG to set
 */
public void setPSUTOAG(String pSUTOAG) {
	PSUTOAG = pSUTOAG;
}
/**
 * @return the pSULAOP
 */
public String getPSULAOP() {
	return PSULAOP;
}
/**
 * @param pSULAOP the pSULAOP to set
 */
public void setPSULAOP(String pSULAOP) {
	PSULAOP = pSULAOP;
}
/**
 * @return the pSUDCFOBAB
 */
public String getPSUDCFOBAB() {
	return PSUDCFOBAB;
}
/**
 * @param pSUDCFOBAB the pSUDCFOBAB to set
 */
public void setPSUDCFOBAB(String pSUDCFOBAB) {
	PSUDCFOBAB = pSUDCFOBAB;
}
/**
 * @return the pSUDCFOBABB
 */
public String getPSUDCFOBABB() {
	return PSUDCFOBABB;
}
/**
 * @param pSUDCFOBABB the pSUDCFOBABB to set
 */
public void setPSUDCFOBABB(String pSUDCFOBABB) {
	PSUDCFOBABB = pSUDCFOBABB;
}
/**
 * @return the pSUDCFOBAG
 */
public String getPSUDCFOBAG() {
	return PSUDCFOBAG;
}
/**
 * @param pSUDCFOBAG the pSUDCFOBAG to set
 */
public void setPSUDCFOBAG(String pSUDCFOBAG) {
	PSUDCFOBAG = pSUDCFOBAG;
}
/**
 * @return the pSUDCFOBAGB
 */
public String getPSUDCFOBAGB() {
	return PSUDCFOBAGB;
}
/**
 * @param pSUDCFOBAGB the pSUDCFOBAGB to set
 */
public void setPSUDCFOBAGB(String pSUDCFOBAGB) {
	PSUDCFOBAGB = pSUDCFOBAGB;
}
/**
 * @return the pVTTCFAB
 */
public String getPVTTCFAB() {
	return PVTTCFAB;
}
/**
 * @param pVTTCFAB the pVTTCFAB to set
 */
public void setPVTTCFAB(String pVTTCFAB) {
	PVTTCFAB = pVTTCFAB;
}
/**
 * @return the pVTTCFAG
 */
public String getPVTTCFAG() {
	return PVTTCFAG;
}
/**
 * @param pVTTCFAG the pVTTCFAG to set
 */
public void setPVTTCFAG(String pVTTCFAG) {
	PVTTCFAG = pVTTCFAG;
}
/**
 * @return the pVTACF
 */
public String getPVTACF() {
	return PVTACF;
}
/**
 * @param pVTACF the pVTACF to set
 */
public void setPVTACF(String pVTACF) {
	PVTACF = pVTACF;
}
/**
 * @return the pVTTOAB
 */
public String getPVTTOAB() {
	return PVTTOAB;
}
/**
 * @param pVTTOAB the pVTTOAB to set
 */
public void setPVTTOAB(String pVTTOAB) {
	PVTTOAB = pVTTOAB;
}
/**
 * @return the pVTTOAG
 */
public String getPVTTOAG() {
	return PVTTOAG;
}
/**
 * @param pVTTOAG the pVTTOAG to set
 */
public void setPVTTOAG(String pVTTOAG) {
	PVTTOAG = pVTTOAG;
}
/**
 * @return the pVTLAOP
 */
public String getPVTLAOP() {
	return PVTLAOP;
}
/**
 * @param pVTLAOP the pVTLAOP to set
 */
public void setPVTLAOP(String pVTLAOP) {
	PVTLAOP = pVTLAOP;
}
/**
 * @return the pVTDCFOBAB
 */
public String getPVTDCFOBAB() {
	return PVTDCFOBAB;
}
/**
 * @param pVTDCFOBAB the pVTDCFOBAB to set
 */
public void setPVTDCFOBAB(String pVTDCFOBAB) {
	PVTDCFOBAB = pVTDCFOBAB;
}
/**
 * @return the pVTDCFOBABB
 */
public String getPVTDCFOBABB() {
	return PVTDCFOBABB;
}
/**
 * @param pVTDCFOBABB the pVTDCFOBABB to set
 */
public void setPVTDCFOBABB(String pVTDCFOBABB) {
	PVTDCFOBABB = pVTDCFOBABB;
}
/**
 * @return the pVTDCFOBAG
 */
public String getPVTDCFOBAG() {
	return PVTDCFOBAG;
}
/**
 * @param pVTDCFOBAG the pVTDCFOBAG to set
 */
public void setPVTDCFOBAG(String pVTDCFOBAG) {
	PVTDCFOBAG = pVTDCFOBAG;
}
/**
 * @return the pVTDCFOBAGB
 */
public String getPVTDCFOBAGB() {
	return PVTDCFOBAGB;
}
/**
 * @param pVTDCFOBAGB the pVTDCFOBAGB to set
 */
public void setPVTDCFOBAGB(String pVTDCFOBAGB) {
	PVTDCFOBAGB = pVTDCFOBAGB;
}
/**
 * @return the nBFCTCFAB
 */
public String getNBFCTCFAB() {
	return NBFCTCFAB;
}
/**
 * @param nBFCTCFAB the nBFCTCFAB to set
 */
public void setNBFCTCFAB(String nBFCTCFAB) {
	NBFCTCFAB = nBFCTCFAB;
}
/**
 * @return the nBFCTCFAG
 */
public String getNBFCTCFAG() {
	return NBFCTCFAG;
}
/**
 * @param nBFCTCFAG the nBFCTCFAG to set
 */
public void setNBFCTCFAG(String nBFCTCFAG) {
	NBFCTCFAG = nBFCTCFAG;
}
/**
 * @return the nBFCACF
 */
public String getNBFCACF() {
	return NBFCACF;
}
/**
 * @param nBFCACF the nBFCACF to set
 */
public void setNBFCACF(String nBFCACF) {
	NBFCACF = nBFCACF;
}
/**
 * @return the nBFCTOAB
 */
public String getNBFCTOAB() {
	return NBFCTOAB;
}
/**
 * @param nBFCTOAB the nBFCTOAB to set
 */
public void setNBFCTOAB(String nBFCTOAB) {
	NBFCTOAB = nBFCTOAB;
}
/**
 * @return the nBFCTOAG
 */
public String getNBFCTOAG() {
	return NBFCTOAG;
}
/**
 * @param nBFCTOAG the nBFCTOAG to set
 */
public void setNBFCTOAG(String nBFCTOAG) {
	NBFCTOAG = nBFCTOAG;
}
/**
 * @return the nBFCLAOP
 */
public String getNBFCLAOP() {
	return NBFCLAOP;
}
/**
 * @param nBFCLAOP the nBFCLAOP to set
 */
public void setNBFCLAOP(String nBFCLAOP) {
	NBFCLAOP = nBFCLAOP;
}
/**
 * @return the nBFCDCFOBAB
 */
public String getNBFCDCFOBAB() {
	return NBFCDCFOBAB;
}
/**
 * @param nBFCDCFOBAB the nBFCDCFOBAB to set
 */
public void setNBFCDCFOBAB(String nBFCDCFOBAB) {
	NBFCDCFOBAB = nBFCDCFOBAB;
}
/**
 * @return the nBFCDCFOBABB
 */
public String getNBFCDCFOBABB() {
	return NBFCDCFOBABB;
}
/**
 * @param nBFCDCFOBABB the nBFCDCFOBABB to set
 */
public void setNBFCDCFOBABB(String nBFCDCFOBABB) {
	NBFCDCFOBABB = nBFCDCFOBABB;
}
/**
 * @return the nBFCDCFOBAG
 */
public String getNBFCDCFOBAG() {
	return NBFCDCFOBAG;
}
/**
 * @param nBFCDCFOBAG the nBFCDCFOBAG to set
 */
public void setNBFCDCFOBAG(String nBFCDCFOBAG) {
	NBFCDCFOBAG = nBFCDCFOBAG;
}
/**
 * @return the nBFCDCFOBAGB
 */
public String getNBFCDCFOBAGB() {
	return NBFCDCFOBAGB;
}
/**
 * @param nBFCDCFOBAGB the nBFCDCFOBAGB to set
 */
public void setNBFCDCFOBAGB(String nBFCDCFOBAGB) {
	NBFCDCFOBAGB = nBFCDCFOBAGB;
}
/**
 * @return the nSTTCFAB
 */
public String getNSTTCFAB() {
	return NSTTCFAB;
}
/**
 * @param nSTTCFAB the nSTTCFAB to set
 */
public void setNSTTCFAB(String nSTTCFAB) {
	NSTTCFAB = nSTTCFAB;
}
/**
 * @return the nSTTCFAG
 */
public String getNSTTCFAG() {
	return NSTTCFAG;
}
/**
 * @param nSTTCFAG the nSTTCFAG to set
 */
public void setNSTTCFAG(String nSTTCFAG) {
	NSTTCFAG = nSTTCFAG;
}
/**
 * @return the nSTACF
 */
public String getNSTACF() {
	return NSTACF;
}
/**
 * @param nSTACF the nSTACF to set
 */
public void setNSTACF(String nSTACF) {
	NSTACF = nSTACF;
}
/**
 * @return the nSTTOAB
 */
public String getNSTTOAB() {
	return NSTTOAB;
}
/**
 * @param nSTTOAB the nSTTOAB to set
 */
public void setNSTTOAB(String nSTTOAB) {
	NSTTOAB = nSTTOAB;
}
/**
 * @return the nSTTOAG
 */
public String getNSTTOAG() {
	return NSTTOAG;
}
/**
 * @param nSTTOAG the nSTTOAG to set
 */
public void setNSTTOAG(String nSTTOAG) {
	NSTTOAG = nSTTOAG;
}
/**
 * @return the nSTLAOP
 */
public String getNSTLAOP() {
	return NSTLAOP;
}
/**
 * @param nSTLAOP the nSTLAOP to set
 */
public void setNSTLAOP(String nSTLAOP) {
	NSTLAOP = nSTLAOP;
}
/**
 * @return the nSTDCFOBAB
 */
public String getNSTDCFOBAB() {
	return NSTDCFOBAB;
}
/**
 * @param nSTDCFOBAB the nSTDCFOBAB to set
 */
public void setNSTDCFOBAB(String nSTDCFOBAB) {
	NSTDCFOBAB = nSTDCFOBAB;
}
/**
 * @return the nSTDCFOBABB
 */
public String getNSTDCFOBABB() {
	return NSTDCFOBABB;
}
/**
 * @param nSTDCFOBABB the nSTDCFOBABB to set
 */
public void setNSTDCFOBABB(String nSTDCFOBABB) {
	NSTDCFOBABB = nSTDCFOBABB;
}
/**
 * @return the nSTDCFOBAG
 */
public String getNSTDCFOBAG() {
	return NSTDCFOBAG;
}
/**
 * @param nSTDCFOBAG the nSTDCFOBAG to set
 */
public void setNSTDCFOBAG(String nSTDCFOBAG) {
	NSTDCFOBAG = nSTDCFOBAG;
}
/**
 * @return the nSTDCFOBAGB
 */
public String getNSTDCFOBAGB() {
	return NSTDCFOBAGB;
}
/**
 * @param nSTDCFOBAGB the nSTDCFOBAGB to set
 */
public void setNSTDCFOBAGB(String nSTDCFOBAGB) {
	NSTDCFOBAGB = nSTDCFOBAGB;
}
/**
 * @return the gTTCFAB
 */
public String getGTTCFAB() {
	return GTTCFAB;
}
/**
 * @param gTTCFAB the gTTCFAB to set
 */
public void setGTTCFAB(String gTTCFAB) {
	GTTCFAB = gTTCFAB;
}
/**
 * @return the gTTCFAG
 */
public String getGTTCFAG() {
	return GTTCFAG;
}
/**
 * @param gTTCFAG the gTTCFAG to set
 */
public void setGTTCFAG(String gTTCFAG) {
	GTTCFAG = gTTCFAG;
}
/**
 * @return the gTACF
 */
public String getGTACF() {
	return GTACF;
}
/**
 * @param gTACF the gTACF to set
 */
public void setGTACF(String gTACF) {
	GTACF = gTACF;
}
/**
 * @return the gTTOAB
 */
public String getGTTOAB() {
	return GTTOAB;
}
/**
 * @param gTTOAB the gTTOAB to set
 */
public void setGTTOAB(String gTTOAB) {
	GTTOAB = gTTOAB;
}
/**
 * @return the gTTOAG
 */
public String getGTTOAG() {
	return GTTOAG;
}
/**
 * @param gTTOAG the gTTOAG to set
 */
public void setGTTOAG(String gTTOAG) {
	GTTOAG = gTTOAG;
}
/**
 * @return the gTLAOP
 */
public String getGTLAOP() {
	return GTLAOP;
}
/**
 * @param gTLAOP the gTLAOP to set
 */
public void setGTLAOP(String gTLAOP) {
	GTLAOP = gTLAOP;
}
/**
 * @return the gTDCFOBAB
 */
public String getGTDCFOBAB() {
	return GTDCFOBAB;
}
/**
 * @param gTDCFOBAB the gTDCFOBAB to set
 */
public void setGTDCFOBAB(String gTDCFOBAB) {
	GTDCFOBAB = gTDCFOBAB;
}
/**
 * @return the gTDCFOBABB
 */
public String getGTDCFOBABB() {
	return GTDCFOBABB;
}
/**
 * @param gTDCFOBABB the gTDCFOBABB to set
 */
public void setGTDCFOBABB(String gTDCFOBABB) {
	GTDCFOBABB = gTDCFOBABB;
}
/**
 * @return the gTDCFOBAG
 */
public String getGTDCFOBAG() {
	return GTDCFOBAG;
}
/**
 * @param gTDCFOBAG the gTDCFOBAG to set
 */
public void setGTDCFOBAG(String gTDCFOBAG) {
	GTDCFOBAG = gTDCFOBAG;
}
/**
 * @return the gTDCFOBAGB
 */
public String getGTDCFOBAGB() {
	return GTDCFOBAGB;
}
/**
 * @param gTDCFOBAGB the gTDCFOBAGB to set
 */
public void setGTDCFOBAGB(String gTDCFOBAGB) {
	GTDCFOBAGB = gTDCFOBAGB;
}
/**
 * @return the fundedLists
 */
public List<FundedList> getFundedLists() {
	return fundedLists;
}
/**
 * @param fundedLists the fundedLists to set
 */
public void setFundedLists(List<FundedList> fundedLists) {
	this.fundedLists = fundedLists;
}
/**
 * @return the types
 */
public List<CreditType> getTypes() {
	return types;
}
/**
 * @param types the types to set
 */
public void setTypes(List<CreditType> types) {
	this.types = types;
}
/**
 * @return the others
 */
public List<CreditType> getOthers() {
	return others;
}
/**
 * @param others the others to set
 */
public void setOthers(List<CreditType> others) {
	this.others = others;
}
/**
 * @return the creditType
 */
public String getCreditType() {
	return creditType;
}
/**
 * @param creditType the creditType to set
 */
public void setCreditType(String creditType) {
	this.creditType = creditType;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "AccountSummary [nameOfInstitution=" + nameOfInstitution
			+ ", TCFAB=" + TCFAB + ", TCFAG=" + TCFAG + ", ACF=" + ACF
			+ ", TOAB=" + TOAB + ", TOAG=" + TOAG + ", LAOP=" + LAOP
			+ ", DCFOBAB=" + DCFOBAB + ", DCFOBABB=" + DCFOBABB + ", DCFOBAG="
			+ DCFOBAG + ", DCFOBAGB=" + DCFOBAGB + ", PSUTCFAB=" + PSUTCFAB
			+ ", PSUTCFAG=" + PSUTCFAG + ", PSUACF=" + PSUACF + ", PSUTOAB="
			+ PSUTOAB + ", PSUTOAG=" + PSUTOAG + ", PSULAOP=" + PSULAOP
			+ ", PSUDCFOBAB=" + PSUDCFOBAB + ", PSUDCFOBABB=" + PSUDCFOBABB
			+ ", PSUDCFOBAG=" + PSUDCFOBAG + ", PSUDCFOBAGB=" + PSUDCFOBAGB
			+ ", PVTTCFAB=" + PVTTCFAB + ", PVTTCFAG=" + PVTTCFAG + ", PVTACF="
			+ PVTACF + ", PVTTOAB=" + PVTTOAB + ", PVTTOAG=" + PVTTOAG
			+ ", PVTLAOP=" + PVTLAOP + ", PVTDCFOBAB=" + PVTDCFOBAB
			+ ", PVTDCFOBABB=" + PVTDCFOBABB + ", PVTDCFOBAG=" + PVTDCFOBAG
			+ ", PVTDCFOBAGB=" + PVTDCFOBAGB + ", NBFCTCFAB=" + NBFCTCFAB
			+ ", NBFCTCFAG=" + NBFCTCFAG + ", NBFCACF=" + NBFCACF
			+ ", NBFCTOAB=" + NBFCTOAB + ", NBFCTOAG=" + NBFCTOAG
			+ ", NBFCLAOP=" + NBFCLAOP + ", NBFCDCFOBAB=" + NBFCDCFOBAB
			+ ", NBFCDCFOBABB=" + NBFCDCFOBABB + ", NBFCDCFOBAG=" + NBFCDCFOBAG
			+ ", NBFCDCFOBAGB=" + NBFCDCFOBAGB + ", NSTTCFAB=" + NSTTCFAB
			+ ", NSTTCFAG=" + NSTTCFAG + ", NSTACF=" + NSTACF + ", NSTTOAB="
			+ NSTTOAB + ", NSTTOAG=" + NSTTOAG + ", NSTLAOP=" + NSTLAOP
			+ ", NSTDCFOBAB=" + NSTDCFOBAB + ", NSTDCFOBABB=" + NSTDCFOBABB
			+ ", NSTDCFOBAG=" + NSTDCFOBAG + ", NSTDCFOBAGB=" + NSTDCFOBAGB
			+ ", GTTCFAB=" + GTTCFAB + ", GTTCFAG=" + GTTCFAG + ", GTACF="
			+ GTACF + ", GTTOAB=" + GTTOAB + ", GTTOAG=" + GTTOAG + ", GTLAOP="
			+ GTLAOP + ", GTDCFOBAB=" + GTDCFOBAB + ", GTDCFOBABB="
			+ GTDCFOBABB + ", GTDCFOBAG=" + GTDCFOBAG + ", GTDCFOBAGB="
			+ GTDCFOBAGB + ", fundedLists=" + fundedLists + ", types=" + types
			+ ", others=" + others + ", creditType=" + creditType + "]";
}
  
 
}
