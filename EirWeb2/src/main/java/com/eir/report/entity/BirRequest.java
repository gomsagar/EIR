
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@Table(name = "bir_request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "BirRequest")

public class BirRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "bir_request_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer birRequestId;
	/**
	 */

	@Column(name = "entity_name", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String entityName;
	/**
	 */

	@Column(name = "xml_output", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.LAZY)
	@Lob

	@XmlElement
	byte[] xmlOutput;
	
	@Column(name = "score_xml_Output", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.LAZY)
	@Lob

	@XmlElement
	byte[] scoreXMlOutput;
	/**
	 */

	@Column(name = "score", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String score;
	/**
	 */

	@Column(name = "ern_number", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String ernNumber;
	/**
	 */

	@Column(name = "status", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer status;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String createUserId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "create_user_date")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Calendar createUserDate;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String updateUserId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "update_user_date")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Calendar updateUserDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "request_id", referencedColumnName = "request_id") })
	@XmlTransient
	Request request;
	
	@Column(name = "cin_number", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String cinNumber;
	
	@Column(name = "report_token", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String reportToken;
	
	@Column(name = "access_token", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String accessToken;
	
	@Column(name = "company_name", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String companyName;

	/**
	 */
	public void setBirRequestId(Integer birRequestId) {
		this.birRequestId = birRequestId;
	}

	/**
	 */
	public Integer getBirRequestId() {
		return this.birRequestId;
	}

	/**
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 */
	public String getEntityName() {
		return this.entityName;
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
	public void setErnNumber(String ernNumber) {
		this.ernNumber = ernNumber;
	}

	/**
	 */
	public String getErnNumber() {
		return this.ernNumber;
	}

	/**
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 */
	public Integer getStatus() {
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
	public void setCreateUserDate(Calendar createUserDate) {
		this.createUserDate = createUserDate;
	}

	/**
	 */
	public Calendar getCreateUserDate() {
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
	public void setUpdateUserDate(Calendar updateUserDate) {
		this.updateUserDate = updateUserDate;
	}

	/**
	 */
	public Calendar getUpdateUserDate() {
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
	public BirRequest() {
		System.out.println("BirRequest Constructor");
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(BirRequest that) {
		setBirRequestId(that.getBirRequestId());
		setEntityName(that.getEntityName());
		setXmlOutput(that.getXmlOutput());
		setScore(that.getScore());
		setErnNumber(that.getErnNumber());
		setStatus(that.getStatus());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setRequest(that.getRequest());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("birRequestId=[").append(birRequestId).append("] ");
		buffer.append("entityName=[").append(entityName).append("] ");
		buffer.append("xmlOutput=[").append(xmlOutput).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("ernNumber=[").append(ernNumber).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((birRequestId == null) ? 0 : birRequestId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof BirRequest))
			return false;
		BirRequest equalCheck = (BirRequest) obj;
		if ((birRequestId == null && equalCheck.birRequestId != null) || (birRequestId != null && equalCheck.birRequestId == null))
			return false;
		if (birRequestId != null && !birRequestId.equals(equalCheck.birRequestId))
			return false;
		return true;
	}

	public String getCinNumber() {
		return cinNumber;
	}

	public void setCinNumber(String cinNumber) {
		this.cinNumber = cinNumber;
	}

	public String getReportToken() {
		return reportToken;
	}

	public void setReportToken(String reportToken) {
		this.reportToken = reportToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public byte[] getScoreXMlOutput() {
		return scoreXMlOutput;
	}

	public void setScoreXMlOutput(byte[] scoreXMlOutput) {
		this.scoreXMlOutput = scoreXMlOutput;
	}
	
	
	
}
