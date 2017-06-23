package com.eir.commercial.domains;

public class ReportSummary {
	//report sumary 1st part
	private String numOfAllAccounts;
	private String numOfActiveAccounts;
	private String totalCreditProviders;
	private String currentCreditProviders;
	private String standard;
	private String subStandard;
	private String doubtful;
	private String loss;
	private String sma;
	
	
	//* shareWallet part
	private String bureauMember;
	private String pvt;
	private String psu;
	private String nbfc;
	private String frb;
	
	//private String institutionName;
	//Institution Name part
		private String enquiryinstitutionName;
		private String enquiryothers;
		private String total;
		private String monthOne;
		private String monthTwoToThree;
		private String monthFourToSix;
		private String monthSevenToTwelve;
	
		private String monthTwelveToTwentyFour;
		private String monthGreaterThanTwentyFour;
		private String enquiryTotal;
		private String mostRecent;
		//Others part placeholders
		//private String enquiryinstitutionName;
		//private String enquiryothers;
		//private String total;
		private String othersmonthOne;
		private String othersmonthTwoToThree;
		private String othersmonthFourToSix;
		private String othersmonthSevenToTwelve;
		private String othersmonthTwelveToTwentyFour;
		private String othersmonthGreaterThanTwentyFour;
		//private String enquiryTotal;
		private String othersmostRecent;
		private String othersTotal;
		
		private String totalmonthOne;
		private String totalmonthTwoToThree;
		private String totalmonthFourToSix;
		private String totalmonthSevenToTwelve;
		private String totalmonthTwelveToTwentyFour;
		private String totalmonthGreaterThanTwentyFour;
		//private String enquiryTotal;
		private String totalmostRecent;
		private String total_total;
		private boolean disclosure;
		
		/**
		 * @return the disclosure
		 */
		public boolean isDisclosure() {
			return disclosure;
		}
		/**
		 * @param disclosure the disclosure to set
		 */
		public void setDisclosure(boolean disclosure) {
			this.disclosure = disclosure;
		}
		/**
		 * @return the frb
		 */
		public String getFrb() {
			return frb;
		}
		/**
		 * @param frb the frb to set
		 */
		public void setFrb(String frb) {
			this.frb = frb;
		}
		
	/**
		 * @return the othersTotal
		 */
		public String getOthersTotal() {
			return othersTotal;
		}
		/**
		 * @param othersTotal the othersTotal to set
		 */
		public void setOthersTotal(String othersTotal) {
			this.othersTotal = othersTotal;
		}
		/**
		 * @return the total_total
		 */
		public String getTotal_total() {
			return total_total;
		}
		/**
		 * @param total_total the total_total to set
		 */
		public void setTotal_total(String total_total) {
			this.total_total = total_total;
		}
	/**
		 * @return the othersmonthOne
		 */
		public String getOthersmonthOne() {
			return othersmonthOne;
		}
		/**
		 * @param othersmonthOne the othersmonthOne to set
		 */
		public void setOthersmonthOne(String othersmonthOne) {
			this.othersmonthOne = othersmonthOne;
		}
		/**
		 * @return the othersmonthTwoToThree
		 */
		public String getOthersmonthTwoToThree() {
			return othersmonthTwoToThree;
		}
		/**
		 * @param othersmonthTwoToThree the othersmonthTwoToThree to set
		 */
		public void setOthersmonthTwoToThree(String othersmonthTwoToThree) {
			this.othersmonthTwoToThree = othersmonthTwoToThree;
		}
		/**
		 * @return the othersmonthFourToSix
		 */
		public String getOthersmonthFourToSix() {
			return othersmonthFourToSix;
		}
		/**
		 * @param othersmonthFourToSix the othersmonthFourToSix to set
		 */
		public void setOthersmonthFourToSix(String othersmonthFourToSix) {
			this.othersmonthFourToSix = othersmonthFourToSix;
		}
		/**
		 * @return the othersmonthSevenToTwelve
		 */
		public String getOthersmonthSevenToTwelve() {
			return othersmonthSevenToTwelve;
		}
		/**
		 * @param othersmonthSevenToTwelve the othersmonthSevenToTwelve to set
		 */
		public void setOthersmonthSevenToTwelve(String othersmonthSevenToTwelve) {
			this.othersmonthSevenToTwelve = othersmonthSevenToTwelve;
		}
		/**
		 * @return the othersmonthTwelveToTwentyFour
		 */
		public String getOthersmonthTwelveToTwentyFour() {
			return othersmonthTwelveToTwentyFour;
		}
		/**
		 * @param othersmonthTwelveToTwentyFour the othersmonthTwelveToTwentyFour to set
		 */
		public void setOthersmonthTwelveToTwentyFour(String othersmonthTwelveToTwentyFour) {
			this.othersmonthTwelveToTwentyFour = othersmonthTwelveToTwentyFour;
		}
		/**
		 * @return the othersmonthGreaterThanTwentyFour
		 */
		public String getOthersmonthGreaterThanTwentyFour() {
			return othersmonthGreaterThanTwentyFour;
		}
		/**
		 * @param othersmonthGreaterThanTwentyFour the othersmonthGreaterThanTwentyFour to set
		 */
		public void setOthersmonthGreaterThanTwentyFour(String othersmonthGreaterThanTwentyFour) {
			this.othersmonthGreaterThanTwentyFour = othersmonthGreaterThanTwentyFour;
		}
		/**
		 * @return the othersmostRecent
		 */
		public String getOthersmostRecent() {
			return othersmostRecent;
		}
		/**
		 * @param othersmostRecent the othersmostRecent to set
		 */
		public void setOthersmostRecent(String othersmostRecent) {
			this.othersmostRecent = othersmostRecent;
		}
		/**
		 * @return the totalmonthOne
		 */
		public String getTotalmonthOne() {
			return totalmonthOne;
		}
		/**
		 * @param totalmonthOne the totalmonthOne to set
		 */
		public void setTotalmonthOne(String totalmonthOne) {
			this.totalmonthOne = totalmonthOne;
		}
		/**
		 * @return the totalmonthTwoToThree
		 */
		public String getTotalmonthTwoToThree() {
			return totalmonthTwoToThree;
		}
		/**
		 * @param totalmonthTwoToThree the totalmonthTwoToThree to set
		 */
		public void setTotalmonthTwoToThree(String totalmonthTwoToThree) {
			this.totalmonthTwoToThree = totalmonthTwoToThree;
		}
		/**
		 * @return the totalmonthFourToSix
		 */
		public String getTotalmonthFourToSix() {
			return totalmonthFourToSix;
		}
		/**
		 * @param totalmonthFourToSix the totalmonthFourToSix to set
		 */
		public void setTotalmonthFourToSix(String totalmonthFourToSix) {
			this.totalmonthFourToSix = totalmonthFourToSix;
		}
		/**
		 * @return the totalmonthSevenToTwelve
		 */
		public String getTotalmonthSevenToTwelve() {
			return totalmonthSevenToTwelve;
		}
		/**
		 * @param totalmonthSevenToTwelve the totalmonthSevenToTwelve to set
		 */
		public void setTotalmonthSevenToTwelve(String totalmonthSevenToTwelve) {
			this.totalmonthSevenToTwelve = totalmonthSevenToTwelve;
		}
		/**
		 * @return the totalmonthTwelveToTwentyFour
		 */
		public String getTotalmonthTwelveToTwentyFour() {
			return totalmonthTwelveToTwentyFour;
		}
		/**
		 * @param totalmonthTwelveToTwentyFour the totalmonthTwelveToTwentyFour to set
		 */
		public void setTotalmonthTwelveToTwentyFour(String totalmonthTwelveToTwentyFour) {
			this.totalmonthTwelveToTwentyFour = totalmonthTwelveToTwentyFour;
		}
		/**
		 * @return the totalmonthGreaterThanTwentyFour
		 */
		public String getTotalmonthGreaterThanTwentyFour() {
			return totalmonthGreaterThanTwentyFour;
		}
		/**
		 * @param totalmonthGreaterThanTwentyFour the totalmonthGreaterThanTwentyFour to set
		 */
		public void setTotalmonthGreaterThanTwentyFour(String totalmonthGreaterThanTwentyFour) {
			this.totalmonthGreaterThanTwentyFour = totalmonthGreaterThanTwentyFour;
		}
		/**
		 * @return the totalmostRecent
		 */
		public String getTotalmostRecent() {
			return totalmostRecent;
		}
		/**
		 * @param totalmostRecent the totalmostRecent to set
		 */
		public void setTotalmostRecent(String totalmostRecent) {
			this.totalmostRecent = totalmostRecent;
		}
	/**
		 * @return the enquiryinstitutionName
		 */
		public String getEnquiryinstitutionName() {
			return enquiryinstitutionName;
		}
		/**
		 * @param enquiryinstitutionName the enquiryinstitutionName to set
		 */
		public void setEnquiryinstitutionName(String enquiryinstitutionName) {
			this.enquiryinstitutionName = enquiryinstitutionName;
		}
		/**
		 * @return the enquiryothers
		 */
		public String getEnquiryothers() {
			return enquiryothers;
		}
		/**
		 * @param enquiryothers the enquiryothers to set
		 */
		public void setEnquiryothers(String enquiryothers) {
			this.enquiryothers = enquiryothers;
		}
		/**
		 * @return the total
		 */
		public String getTotal() {
			return total;
		}
		/**
		 * @param total the total to set
		 */
		public void setTotal(String total) {
			this.total = total;
		}
		/**
		 * @return the monthOne
		 */
		public String getMonthOne() {
			return monthOne;
		}
		/**
		 * @param monthOne the monthOne to set
		 */
		public void setMonthOne(String monthOne) {
			this.monthOne = monthOne;
		}
		/**
		 * @return the monthTwoToThree
		 */
		public String getMonthTwoToThree() {
			return monthTwoToThree;
		}
		/**
		 * @param monthTwoToThree the monthTwoToThree to set
		 */
		public void setMonthTwoToThree(String monthTwoToThree) {
			this.monthTwoToThree = monthTwoToThree;
		}
		/**
		 * @return the monthFourToSix
		 */
		public String getMonthFourToSix() {
			return monthFourToSix;
		}
		/**
		 * @param monthFourToSix the monthFourToSix to set
		 */
		public void setMonthFourToSix(String monthFourToSix) {
			this.monthFourToSix = monthFourToSix;
		}
		/**
		 * @return the monthSevenToTwelve
		 */
		public String getMonthSevenToTwelve() {
			return monthSevenToTwelve;
		}
		/**
		 * @param monthSevenToTwelve the monthSevenToTwelve to set
		 */
		public void setMonthSevenToTwelve(String monthSevenToTwelve) {
			this.monthSevenToTwelve = monthSevenToTwelve;
		}
		/**
		 * @return the monthTwelveToTwentyFour
		 */
		public String getMonthTwelveToTwentyFour() {
			return monthTwelveToTwentyFour;
		}
		/**
		 * @param monthTwelveToTwentyFour the monthTwelveToTwentyFour to set
		 */
		public void setMonthTwelveToTwentyFour(String monthTwelveToTwentyFour) {
			this.monthTwelveToTwentyFour = monthTwelveToTwentyFour;
		}
		/**
		 * @return the monthGreaterThanTwentyFour
		 */
		public String getMonthGreaterThanTwentyFour() {
			return monthGreaterThanTwentyFour;
		}
		/**
		 * @param monthGreaterThanTwentyFour the monthGreaterThanTwentyFour to set
		 */
		public void setMonthGreaterThanTwentyFour(String monthGreaterThanTwentyFour) {
			this.monthGreaterThanTwentyFour = monthGreaterThanTwentyFour;
		}
		/**
		 * @return the enquiryTotal
		 */
		public String getEnquiryTotal() {
			return enquiryTotal;
		}
		/**
		 * @param enquiryTotal the enquiryTotal to set
		 */
		public void setEnquiryTotal(String enquiryTotal) {
			this.enquiryTotal = enquiryTotal;
		}
		/**
		 * @return the mostRecent
		 */
		public String getMostRecent() {
			return mostRecent;
		}
		/**
		 * @param mostRecent the mostRecent to set
		 */
		public void setMostRecent(String mostRecent) {
			this.mostRecent = mostRecent;
		}
	/**
	 * @return the numOfAllAccounts
	 */
	public String getNumOfAllAccounts() {
		return numOfAllAccounts;
	}
	/**
	 * @param numOfAllAccounts the numOfAllAccounts to set
	 */
	public void setNumOfAllAccounts(String numOfAllAccounts) {
		this.numOfAllAccounts = numOfAllAccounts;
	}
	/**
	 * @return the numOfActiveAccounts
	 */
	public String getNumOfActiveAccounts() {
		return numOfActiveAccounts;
	}
	/**
	 * @param numOfActiveAccounts the numOfActiveAccounts to set
	 */
	public void setNumOfActiveAccounts(String numOfActiveAccounts) {
		this.numOfActiveAccounts = numOfActiveAccounts;
	}
	/**
	 * @return the totalCreditProviders
	 */
	public String getTotalCreditProviders() {
		return totalCreditProviders;
	}
	/**
	 * @param totalCreditProviders the totalCreditProviders to set
	 */
	public void setTotalCreditProviders(String totalCreditProviders) {
		this.totalCreditProviders = totalCreditProviders;
	}
	/**
	 * @return the currentCreditProviders
	 */
	public String getCurrentCreditProviders() {
		return currentCreditProviders;
	}
	/**
	 * @param currentCreditProviders the currentCreditProviders to set
	 */
	public void setCurrentCreditProviders(String currentCreditProviders) {
		this.currentCreditProviders = currentCreditProviders;
	}
	/**
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}
	/**
	 * @param standard the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}
	/**
	 * @return the subStandard
	 */
	public String getSubStandard() {
		return subStandard;
	}
	/**
	 * @param subStandard the subStandard to set
	 */
	public void setSubStandard(String subStandard) {
		this.subStandard = subStandard;
	}
	/**
	 * @return the doubtful
	 */
	public String getDoubtful() {
		return doubtful;
	}
	/**
	 * @param doubtful the doubtful to set
	 */
	public void setDoubtful(String doubtful) {
		this.doubtful = doubtful;
	}
	/**
	 * @return the loss
	 */
	public String getLoss() {
		return loss;
	}
	/**
	 * @param loss the loss to set
	 */
	public void setLoss(String loss) {
		this.loss = loss;
	}
	/**
	 * @return the sma
	 */
	public String getSma() {
		return sma;
	}
	/**
	 * @param sma the sma to set
	 */
	public void setSma(String sma) {
		this.sma = sma;
	}

	/**
	 * @return the pvt
	 */
	public String getPvt() {
		return pvt;
	}
	/**
	 * @param pvt the pvt to set
	 */
	public void setPvt(String pvt) {
		this.pvt = pvt;
	}
	/**
	 * @return the psu
	 */
	public String getPsu() {
		return psu;
	}
	/**
	 * @param psu the psu to set
	 */
	public void setPsu(String psu) {
		this.psu = psu;
	}
	/**
	 * @return the nbfc
	 */
	public String getNbfc() {
		return nbfc;
	}
	/**
	 * @param nbfc the nbfc to set
	 */
	public void setNbfc(String nbfc) {
		this.nbfc = nbfc;
	}

	/**
	 * @return the bureauMember
	 */
	public String getBureauMember() {
		return bureauMember;
	}
	/**
	 * @param bureauMember the bureauMember to set
	 */
	public void setBureauMember(String bureauMember) {
		this.bureauMember = bureauMember;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportSummary [numOfAllAccounts=" + numOfAllAccounts
				+ ", numOfActiveAccounts=" + numOfActiveAccounts
				+ ", totalCreditProviders=" + totalCreditProviders
				+ ", currentCreditProviders=" + currentCreditProviders
				+ ", standard=" + standard + ", subStandard=" + subStandard
				+ ", doubtful=" + doubtful + ", loss=" + loss + ", sma=" + sma
				+ ", bureauMember=" + bureauMember + ", pvt=" + pvt + ", psu="
				+ psu + ", nbfc=" + nbfc + ", frb=" + frb
				+ ", enquiryinstitutionName=" + enquiryinstitutionName
				+ ", enquiryothers=" + enquiryothers + ", total=" + total
				+ ", monthOne=" + monthOne + ", monthTwoToThree="
				+ monthTwoToThree + ", monthFourToSix=" + monthFourToSix
				+ ", monthSevenToTwelve=" + monthSevenToTwelve
				+ ", monthTwelveToTwentyFour=" + monthTwelveToTwentyFour
				+ ", monthGreaterThanTwentyFour=" + monthGreaterThanTwentyFour
				+ ", enquiryTotal=" + enquiryTotal + ", mostRecent="
				+ mostRecent + ", othersmonthOne=" + othersmonthOne
				+ ", othersmonthTwoToThree=" + othersmonthTwoToThree
				+ ", othersmonthFourToSix=" + othersmonthFourToSix
				+ ", othersmonthSevenToTwelve=" + othersmonthSevenToTwelve
				+ ", othersmonthTwelveToTwentyFour="
				+ othersmonthTwelveToTwentyFour
				+ ", othersmonthGreaterThanTwentyFour="
				+ othersmonthGreaterThanTwentyFour + ", othersmostRecent="
				+ othersmostRecent + ", othersTotal=" + othersTotal
				+ ", totalmonthOne=" + totalmonthOne
				+ ", totalmonthTwoToThree=" + totalmonthTwoToThree
				+ ", totalmonthFourToSix=" + totalmonthFourToSix
				+ ", totalmonthSevenToTwelve=" + totalmonthSevenToTwelve
				+ ", totalmonthTwelveToTwentyFour="
				+ totalmonthTwelveToTwentyFour
				+ ", totalmonthGreaterThanTwentyFour="
				+ totalmonthGreaterThanTwentyFour + ", totalmostRecent="
				+ totalmostRecent + ", total_total=" + total_total
				+ ", disclosure=" + disclosure + "]";
	}

}
