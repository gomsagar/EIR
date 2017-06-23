package com.eir.commercial.domains;

import java.util.List;

public class MainCreditFacility {
	    
	    private CreditFacilityDetails creditFacilityDetails ;
	    private List<CreditFacilityPaymentHistory> paymentHistory;
	    private List<CreditFacilityGuarentorDetails> guarentorDetailsSec;
	    private List<CreditFacilityBorowerDetails >borowerDetails4;
	    private List<CreditFacilitiesSecuritiesDetails> securitiesDetails5s;
	    private List<CreditFacilityCheckDishonour> checkDishonour6s;
	    private CreditFacilityCreditRatings creditRatings;
	    
	    private boolean derivative;
	    private boolean borrower;
	    private boolean security;
	    private boolean checkDishonour;
	    private boolean creditRating;
	    private String indexVariableCount;
	    
	    
	    
	    
		



		public boolean isDerivative() {
			return derivative;
		}



		public void setDerivative(boolean derivative) {
			this.derivative = derivative;
		}



		/**
		 * @return the paymentHistory
		 */
		public List<CreditFacilityPaymentHistory> getPaymentHistory() {
			return paymentHistory;
		}



		/**
		 * @param paymentHistory the paymentHistory to set
		 */
		public void setPaymentHistory(List<CreditFacilityPaymentHistory> paymentHistory) {
			this.paymentHistory = paymentHistory;
		}



		/**
		 * @return the indexVariableCount
		 */
		public String getIndexVariableCount() {
			return indexVariableCount;
		}



		/**
		 * @param indexVariableCount the indexVariableCount to set
		 */
		public void setIndexVariableCount(String indexVariableCount) {
			this.indexVariableCount = indexVariableCount;
		}



		/**
		 * @return the borrower
		 */
		public boolean isBorrower() {
			return borrower;
		}



		/**
		 * @param borrower the borrower to set
		 */
		public void setBorrower(boolean borrower) {
			this.borrower = borrower;
		}



		/**
		 * @return the security
		 */
		public boolean isSecurity() {
			return security;
		}



		/**
		 * @param security the security to set
		 */
		public void setSecurity(boolean security) {
			this.security = security;
		}



		/**
		 * @return the checkDishonour
		 */
		public boolean isCheckDishonour() {
			return checkDishonour;
		}



		/**
		 * @param checkDishonour the checkDishonour to set
		 */
		public void setCheckDishonour(boolean checkDishonour) {
			this.checkDishonour = checkDishonour;
		}



		/**
		 * @return the creditRating
		 */
		public boolean isCreditRating() {
			return creditRating;
		}



		/**
		 * @param creditRating the creditRating to set
		 */
		public void setCreditRating(boolean creditRating) {
			this.creditRating = creditRating;
		}



		/**
		 * @return the creditFacilityDetails
		 */
		public CreditFacilityDetails getCreditFacilityDetails() {
			return creditFacilityDetails;
		}



		/**
		 * @param creditFacilityDetails the creditFacilityDetails to set
		 */
		public void setCreditFacilityDetails(CreditFacilityDetails creditFacilityDetails) {
			this.creditFacilityDetails = creditFacilityDetails;
		}





		


		/**
		 * @return the guarentorDetailsSec
		 */
		public List<CreditFacilityGuarentorDetails> getGuarentorDetailsSec() {
			return guarentorDetailsSec;
		}



		/**
		 * @param guarentorDetailsSec the guarentorDetailsSec to set
		 */
		public void setGuarentorDetailsSec(List<CreditFacilityGuarentorDetails> guarentorDetailsSec) {
			this.guarentorDetailsSec = guarentorDetailsSec;
		}



		/**
		 * @return the borowerDetails4
		 */
		public List<CreditFacilityBorowerDetails> getBorowerDetails4() {
			return borowerDetails4;
		}



		/**
		 * @param borowerDetails4 the borowerDetails4 to set
		 */
		public void setBorowerDetails4(List<CreditFacilityBorowerDetails> borowerDetails4) {
			this.borowerDetails4 = borowerDetails4;
		}



		/**
		 * @return the securitiesDetails5s
		 */
		public List<CreditFacilitiesSecuritiesDetails> getSecuritiesDetails5s() {
			return securitiesDetails5s;
		}



		/**
		 * @param securitiesDetails5s the securitiesDetails5s to set
		 */
		public void setSecuritiesDetails5s(List<CreditFacilitiesSecuritiesDetails> securitiesDetails5s) {
			this.securitiesDetails5s = securitiesDetails5s;
		}



		/**
		 * @return the checkDishonour6s
		 */
		public List<CreditFacilityCheckDishonour> getCheckDishonour6s() {
			return checkDishonour6s;
		}



		/**
		 * @param checkDishonour6s the checkDishonour6s to set
		 */
		public void setCheckDishonour6s(List<CreditFacilityCheckDishonour> checkDishonour6s) {
			this.checkDishonour6s = checkDishonour6s;
		}





		/**
		 * @return the creditRatings
		 */
		public CreditFacilityCreditRatings getCreditRatings() {
			return creditRatings;
		}



		/**
		 * @param creditRatings the creditRatings to set
		 */
		public void setCreditRatings(CreditFacilityCreditRatings creditRatings) {
			this.creditRatings = creditRatings;
		}



		@Override
		public String toString() {
			return "MainCreditFacility [creditFacilityDetails="
					+ creditFacilityDetails + ", paymentHistory="
					+ paymentHistory + ", guarentorDetailsSec="
					+ guarentorDetailsSec + ", borowerDetails4="
					+ borowerDetails4 + ", securitiesDetails5s="
					+ securitiesDetails5s + ", checkDishonour6s="
					+ checkDishonour6s + ", creditRatings=" + creditRatings
					+ ", derivative=" + derivative + ", borrower=" + borrower
					+ ", security=" + security + ", checkDishonour="
					+ checkDishonour + ", creditRating=" + creditRating
					+ ", indexVariableCount=" + indexVariableCount + "]";
		}



		






}
