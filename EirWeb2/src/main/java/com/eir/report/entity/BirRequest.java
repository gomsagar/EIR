
package com.eir.report.entity;

import java.io.Serializable;

import javax.persistence.Basic;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
@Table(name = "bir_request", schema = "eir")
@EntityListeners(AuditingEntityListener.class)
public class BirRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "bir_request_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bir_seq")
	@SequenceGenerator(
		name="bir_seq",
		sequenceName="eir.bir_sequence",
		allocationSize=1
	)
	Integer birRequestId;
	/**
	 */

	@Column(name = "entity_name", length = 45)
	String entityName;
	/**
	 */

	/*@Column(name = "xml_output", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.LAZY)
	@Lob
	byte[] xmlOutput;
	
	@Column(name = "score_card_excell", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.LAZY)
	@Lob
	byte[] scoreCardExcell;*/
	/**
	 */

	@Column(name = "score", length = 45)
	String score;
	/**
	 */

	@Column(name = "ern_number", length = 45)
	String ernNumber;
	/**
	 */

	/*@Column(name = "status", length = 45)
	Integer status;*/	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "status_id", referencedColumnName = "status_id") })
	Status status;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	@CreatedBy
	String createUserId;
	/**
	 */
	
	@Column(name = "create_date")
	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate ;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	@LastModifiedBy
	String updateUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;

	/**
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "request_id", referencedColumnName = "request_id") })
	Request request;
	
	@Column(name = "cin_number", length = 45)
	String cinNumber;
	
	@Column(name = "report_token", length = 45)
	String reportToken;
	
	@Column(name = "company_name", length = 45)
	String companyName;
	
	@Column(name = "user_hit", length = 45)
	String userHit;
	
	@Column(name = "admin_hit", length = 45)
	String adminHit;
	
	@Column(name = "xml_output_path", length = 45)
	String xmlOutputPath;
	
	@Column(name = "score_card_excell_output_path", length = 45)
	String scoreCardExcellOutputPath;
	
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
	/*public void setXmlOutput(byte[] xmlOutput) {
		this.xmlOutput = xmlOutput;
	}

	*//**
	 *//*
	public byte[] getXmlOutput() {
		return this.xmlOutput;
	}*/

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
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 */
	public Status getStatus() {
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
	public void setCreateUserDate(DateTime createUserDate) {
		this.createUserDate = DateTime.now();
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
	public BirRequest() {
		System.out.println("BirRequest Constructor");
	}
	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("birRequestId=[").append(birRequestId).append("] ");
		buffer.append("entityName=[").append(entityName).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("ernNumber=[").append(ernNumber).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");

		return buffer.toString();
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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/*public byte[] getScoreCardExcell() {
		return scoreCardExcell;
	}

	public void setScoreCardExcell(byte[] scoreXMlOutput) {
		this.scoreCardExcell = scoreXMlOutput;
	}*/

	public String getUserHit() {
		return userHit;
	}

	public void setUserHit(String userHit) {
		this.userHit = userHit;
	}

	public String getAdminHit() {
		return adminHit;
	}

	public void setAdminHit(String adminHit) {
		this.adminHit = adminHit;
	}

	public String getXmlOutputPath() {
		return xmlOutputPath;
	}

	public void setXmlOutputPath(String xmlOutputPath) {
		this.xmlOutputPath = xmlOutputPath;
	}

	public String getScoreCardExcellOutputPath() {
		return scoreCardExcellOutputPath;
	}

	public void setScoreCardExcellOutputPath(String scoreCardExcellOutputPath) {
		this.scoreCardExcellOutputPath = scoreCardExcellOutputPath;
	}
}
