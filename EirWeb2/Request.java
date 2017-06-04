
package com.eir.report.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllRequests", query = "select myRequest from Request myRequest"),
		@NamedQuery(name = "findRequestByAdminHit", query = "select myRequest from Request myRequest where myRequest.adminHit = ?1"),
		@NamedQuery(name = "findRequestByCreateUserDate", query = "select myRequest from Request myRequest where myRequest.createUserDate = ?1"),
		@NamedQuery(name = "findRequestByCreateUserDateAfter", query = "select myRequest from Request myRequest where myRequest.createUserDate > ?1"),
		@NamedQuery(name = "findRequestByCreateUserDateBefore", query = "select myRequest from Request myRequest where myRequest.createUserDate < ?1"),
		@NamedQuery(name = "findRequestByErnNumber", query = "select myRequest from Request myRequest where myRequest.ernNumber = ?1"),
		@NamedQuery(name = "findRequestByErnNumberContaining", query = "select myRequest from Request myRequest where myRequest.ernNumber like ?1"),
		@NamedQuery(name = "findRequestByPrimaryKey", query = "select myRequest from Request myRequest where myRequest.requestId = ?1"),
		@NamedQuery(name = "findRequestByRequestId", query = "select myRequest from Request myRequest where myRequest.requestId = ?1"),
		@NamedQuery(name = "findRequestByScore", query = "select myRequest from Request myRequest where myRequest.score = ?1"),
		@NamedQuery(name = "findRequestByScoreContaining", query = "select myRequest from Request myRequest where myRequest.score like ?1"),
		@NamedQuery(name = "findRequestByType", query = "select myRequest from Request myRequest where myRequest.type = ?1"),
		@NamedQuery(name = "findRequestByTypeContaining", query = "select myRequest from Request myRequest where myRequest.type like ?1"),
		@NamedQuery(name = "findRequestByUpdateUserDate", query = "select myRequest from Request myRequest where myRequest.updateUserDate = ?1"),
		@NamedQuery(name = "findRequestByUpdateUserDateAfter", query = "select myRequest from Request myRequest where myRequest.updateUserDate > ?1"),
		@NamedQuery(name = "findRequestByUpdateUserDateBefore", query = "select myRequest from Request myRequest where myRequest.updateUserDate < ?1"),
		@NamedQuery(name = "findRequestByUpdateUserId", query = "select myRequest from Request myRequest where myRequest.updateUserId = ?1"),
		@NamedQuery(name = "findRequestByUpdateUserIdContaining", query = "select myRequest from Request myRequest where myRequest.updateUserId like ?1"),
		@NamedQuery(name = "findRequestByUserHit", query = "select myRequest from Request myRequest where myRequest.userHit = ?1") })

@Table(catalog = "eir", name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "Request")

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

	@Column(name = "type", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String type;
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

	@Column(name = "ern_number", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String ernNumber;
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
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false) })
	@XmlTransient
	UserDetails userDetails;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "eir_id", referencedColumnName = "eir_id") })
	@XmlTransient
	EntityDetails entityDetails;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Status status;

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
	public void setType(String type) {
		this.type = type;
	}

	/**
	 */
	public String getType() {
		return this.type;
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
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	/**
	 */
	public UserDetails getUserDetails() {
		return userDetails;
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
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 */
	public Status getStatus() {
		return status;
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
		setType(that.getType());
		setScore(that.getScore());
		setUserHit(that.getUserHit());
		setAdminHit(that.getAdminHit());
		setErnNumber(that.getErnNumber());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setUserDetails(that.getUserDetails());
		setEntityDetails(that.getEntityDetails());
		setStatus(that.getStatus());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("requestId=[").append(requestId).append("] ");
		buffer.append("type=[").append(type).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("userHit=[").append(userHit).append("] ");
		buffer.append("adminHit=[").append(adminHit).append("] ");
		buffer.append("ernNumber=[").append(ernNumber).append("] ");
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
