
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@Table(catalog = "eir", name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "Request")
@XmlRootElement(namespace = "eir/com/eir/report/entity")
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "request_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer requestId;
	/**
	 */

	@Column(name = "ern_number", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String ernNumber;
	/**
	 */

	@Column(name = "score", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String score;
	/**
	 */

	@Column(name = "user_hit")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer userHit;
	/**
	 */

	@Column(name = "admin_hit")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer adminHit;
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
	@JoinColumns({ @JoinColumn(name = "eir_id", referencedColumnName = "eir_id") })
	@XmlTransient
	EntityDetails entityDetails;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
	@XmlTransient
	ProductMaster productMaster;
	/**
	 */
	@OneToMany(mappedBy = "request", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.BirRequest> birRequests;
	/**
	 */
	@OneToOne(mappedBy = "request", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	KycApproval kycApproval;
	/**
	 */
	@OneToMany(mappedBy = "request", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.CirRequet> cirRequets;
	/**
	 */
	@OneToMany(mappedBy = "request", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.ConsumerRequet> consumerRequets;

	/**
	 */
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	/**
	 */
	public Integer getRequestId() {
		return this.requestId;
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
	public void setUserHit(Integer userHit) {
		this.userHit = userHit;
	}

	/**
	 */
	public Integer getUserHit() {
		return this.userHit;
	}

	/**
	 */
	public void setAdminHit(Integer adminHit) {
		this.adminHit = adminHit;
	}

	/**
	 */
	public Integer getAdminHit() {
		return this.adminHit;
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
	public void setEntityDetails(EntityDetails entityDetails) {
		this.entityDetails = entityDetails;
	}

	/**
	 */
	public EntityDetails getEntityDetails() {
		return entityDetails;
	}

	/**
	 */
	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}

	/**
	 */
	public ProductMaster getProductMaster() {
		return productMaster;
	}

	/**
	 */
	public void setBirRequests(Set<BirRequest> birRequests) {
		this.birRequests = birRequests;
	}

	/**
	 */
	public Set<BirRequest> getBirRequests() {
		if (birRequests == null) {
			birRequests = new java.util.LinkedHashSet<com.eir.report.entity.BirRequest>();
		}
		return birRequests;
	}

	/**
	 */
	public void setKycApproval(KycApproval kycApproval) {
		this.kycApproval = kycApproval;
	}

	/**
	 */
	public KycApproval getKycApproval() {
		return kycApproval;
	}

	/**
	 */
	public void setCirRequets(Set<CirRequet> cirRequets) {
		this.cirRequets = cirRequets;
	}

	/**
	 */
	public Set<CirRequet> getCirRequets() {
		if (cirRequets == null) {
			cirRequets = new java.util.LinkedHashSet<com.eir.report.entity.CirRequet>();
		}
		return cirRequets;
	}

	/**
	 */
	public void setConsumerRequets(Set<ConsumerRequet> consumerRequets) {
		this.consumerRequets = consumerRequets;
	}

	/**
	 */
	public Set<ConsumerRequet> getConsumerRequets() {
		if (consumerRequets == null) {
			consumerRequets = new java.util.LinkedHashSet<com.eir.report.entity.ConsumerRequet>();
		}
		return consumerRequets;
	}

	/**
	 */
	public Request() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Request that) {
		setRequestId(that.getRequestId());
		setErnNumber(that.getErnNumber());
		setScore(that.getScore());
		setUserHit(that.getUserHit());
		setAdminHit(that.getAdminHit());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setEntityDetails(that.getEntityDetails());
		setProductMaster(that.getProductMaster());
		setBirRequests(new java.util.LinkedHashSet<com.eir.report.entity.BirRequest>(that.getBirRequests()));
		setKycApproval(that.getKycApproval());
		setCirRequets(new java.util.LinkedHashSet<com.eir.report.entity.CirRequet>(that.getCirRequets()));
		setConsumerRequets(new java.util.LinkedHashSet<com.eir.report.entity.ConsumerRequet>(that.getConsumerRequets()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("requestId=[").append(requestId).append("] ");
		buffer.append("ernNumber=[").append(ernNumber).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("userHit=[").append(userHit).append("] ");
		buffer.append("adminHit=[").append(adminHit).append("] ");
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
		result = (int) (prime * result + ((requestId == null) ? 0 : requestId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Request))
			return false;
		Request equalCheck = (Request) obj;
		if ((requestId == null && equalCheck.requestId != null) || (requestId != null && equalCheck.requestId == null))
			return false;
		if (requestId != null && !requestId.equals(equalCheck.requestId))
			return false;
		return true;
	}
}
