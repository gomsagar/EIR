/**
 * 
 */
package com.eir.combo.domains;

/**
  *Setter & Getter methods of Related Directors Domain*
 *
 */
public class RelatedDirectorsDomain 
{
	
	private String name;
	private String relationship;
	private String idType;
	private String idNum;
	private int score;
	private String confScore;
	private String allAccts;
	private String totOutstanding;
	private String noOfActAccts;
	private String noOfActDelinquent;
	private String totSanctioned;
	private String totOutActDelinquent;
	private String creditRating;
	private int riskScore;
	private int modelName;
	
	public int getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(int riskScore) {
		this.riskScore = riskScore;
	}

	public int getModelName() {
		return modelName;
	}

	public void setModelName(int modelName) {
		this.modelName = modelName;
	}	

	public String getConfScore() {
		return confScore;
	}

	public void setConfScore(String confScore) {
		this.confScore = confScore;
	}
	

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getRelationship() 
	{
		return relationship;
	}

	public void setRelationship(String relationship) 
	
	{
		this.relationship = relationship;
	}

	public String getIdType() 
	{
		return idType;
	}

	public void setIdType(String idType) 
	{
		this.idType = idType;
	}

	public String getIdNum()
	{
		return idNum;
	}

	public void setIdNum(String idNum)
	{
		this.idNum = idNum;
	}

	public String getAllAccts()
	{
		return allAccts;
	}

	public void setAllAccts(String allAccts) {
		this.allAccts = allAccts;
		
	}

	public String getTotOutstanding() 
	{
		return totOutstanding;
	}

	public void setTotOutstanding(String totOutstanding) 
	{
		this.totOutstanding = totOutstanding;
	}

	public String getNoOfActAccts() 
	{
		return noOfActAccts;
	}

	public void setNoOfActAccts(String noOfActAccts)
	{
		this.noOfActAccts = noOfActAccts;
	}

	public String getNoOfActDelinquent() 
	{
		return noOfActDelinquent;
	}

	public void setNoOfActDelinquent(String noOfActDelinquent) 
	{
		this.noOfActDelinquent = noOfActDelinquent;
	}

	public String getTotSanctioned()
	{
		return totSanctioned;
	}

	public void setTotSanctioned(String totSanctioned) 
	{
		this.totSanctioned = totSanctioned;
	}

	public String getTotOutActDelinquent() 
	{
		return totOutActDelinquent;
	}

	public void setTotOutActDelinquent(String totOutActDelinquent) 
	{
		this.totOutActDelinquent = totOutActDelinquent;
	}

	public String getCreditRating() 
	{
		return creditRating;
	}

	public void setCreditRating(String creditRating) 
	{
		this.creditRating = creditRating;
	}

	@Override
	public String toString() {
		return "RelatedDirectorsDomain [name=" + name + ", relationship="
				+ relationship + ", idType=" + idType + ", idNum=" + idNum
				+ ", score=" + score + ", confScore=" + confScore
				+ ", allAccts=" + allAccts + ", totOutstanding="
				+ totOutstanding + ", noOfActAccts=" + noOfActAccts
				+ ", noOfActDelinquent=" + noOfActDelinquent
				+ ", totSanctioned=" + totSanctioned + ", totOutActDelinquent="
				+ totOutActDelinquent + ", creditRating=" + creditRating
				+ ", riskScore=" + riskScore + ", modelName=" + modelName + "]";
	}

		
	

}
