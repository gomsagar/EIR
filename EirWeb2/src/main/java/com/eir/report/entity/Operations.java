
package com.eir.report.entity;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.LinkedHashSet;
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
		@NamedQuery(name = "findAllOperationss", query = "select myOperations from Operations myOperations"),
		@NamedQuery(name = "findOperationsByCreateDate", query = "select myOperations from Operations myOperations where myOperations.createDate = ?1"),
		@NamedQuery(name = "findOperationsByCreateDateAfter", query = "select myOperations from Operations myOperations where myOperations.createDate > ?1"),
		@NamedQuery(name = "findOperationsByCreateDateBefore", query = "select myOperations from Operations myOperations where myOperations.createDate < ?1"),
		@NamedQuery(name = "findOperationsByCreateUserId", query = "select myOperations from Operations myOperations where myOperations.createUserId = ?1"),
		@NamedQuery(name = "findOperationsByCreateUserIdContaining", query = "select myOperations from Operations myOperations where myOperations.createUserId like ?1"),
		@NamedQuery(name = "findOperationsByOperationDescription", query = "select myOperations from Operations myOperations where myOperations.operationDescription = ?1"),
		@NamedQuery(name = "findOperationsByOperationDescriptionContaining", query = "select myOperations from Operations myOperations where myOperations.operationDescription like ?1"),
		@NamedQuery(name = "findOperationsByOperationId", query = "select myOperations from Operations myOperations where myOperations.operationId = ?1"),
		@NamedQuery(name = "findOperationsByOperationscol", query = "select myOperations from Operations myOperations where myOperations.operationscol = ?1"),
		@NamedQuery(name = "findOperationsByOperationscolContaining", query = "select myOperations from Operations myOperations where myOperations.operationscol like ?1"),
		@NamedQuery(name = "findOperationsByPrimaryKey", query = "select myOperations from Operations myOperations where myOperations.operationId = ?1"),
		@NamedQuery(name = "findOperationsByUpdateDate", query = "select myOperations from Operations myOperations where myOperations.updateDate = ?1"),
		@NamedQuery(name = "findOperationsByUpdateDateAfter", query = "select myOperations from Operations myOperations where myOperations.updateDate > ?1"),
		@NamedQuery(name = "findOperationsByUpdateDateBefore", query = "select myOperations from Operations myOperations where myOperations.updateDate < ?1"),
		@NamedQuery(name = "findOperationsByUpdateUserId", query = "select myOperations from Operations myOperations where myOperations.updateUserId = ?1"),
		@NamedQuery(name = "findOperationsByUpdateUserIdContaining", query = "select myOperations from Operations myOperations where myOperations.updateUserId like ?1") })

@Table(catalog = "eir", name = "operations")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "Operations")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class Operations implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "operation_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer operationId;
	/**
	 */

	@Column(name = "operation_description", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String operationDescription;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String createUserId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Calendar createDate;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String updateUserId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Calendar updateDate;
	/**
	 */

	@Column(name = "operationscol", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String operationscol;

	/**
	 */
	@OneToMany(mappedBy = "operations", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.UserRoleAccess> userRoleAccesses;

	/**
	 */
	public void setOperationId(Integer operationId) {
		this.operationId = operationId;
	}

	/**
	 */
	public Integer getOperationId() {
		return this.operationId;
	}

	/**
	 */
	public void setOperationDescription(String operationDescription) {
		this.operationDescription = operationDescription;
	}

	/**
	 */
	public String getOperationDescription() {
		return this.operationDescription;
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
	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	/**
	 */
	public Calendar getCreateDate() {
		return this.createDate;
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
	public void setUpdateDate(Calendar updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 */
	public Calendar getUpdateDate() {
		return this.updateDate;
	}

	/**
	 */
	public void setOperationscol(String operationscol) {
		this.operationscol = operationscol;
	}

	/**
	 */
	public String getOperationscol() {
		return this.operationscol;
	}

	/**
	 */
	public void setUserRoleAccesses(Set<UserRoleAccess> userRoleAccesses) {
		this.userRoleAccesses = userRoleAccesses;
	}

	/**
	 */
	public Set<UserRoleAccess> getUserRoleAccesses() {
		if (userRoleAccesses == null) {
			userRoleAccesses = new java.util.LinkedHashSet<com.eir.report.entity.UserRoleAccess>();
		}
		return userRoleAccesses;
	}

	/**
	 */
	public Operations() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Operations that) {
		setOperationId(that.getOperationId());
		setOperationDescription(that.getOperationDescription());
		setCreateUserId(that.getCreateUserId());
		setCreateDate(that.getCreateDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateDate(that.getUpdateDate());
		setOperationscol(that.getOperationscol());
		setUserRoleAccesses(new java.util.LinkedHashSet<com.eir.report.entity.UserRoleAccess>(that.getUserRoleAccesses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("operationId=[").append(operationId).append("] ");
		buffer.append("operationDescription=[").append(operationDescription).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createDate=[").append(createDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateDate=[").append(updateDate).append("] ");
		buffer.append("operationscol=[").append(operationscol).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((operationId == null) ? 0 : operationId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Operations))
			return false;
		Operations equalCheck = (Operations) obj;
		if ((operationId == null && equalCheck.operationId != null) || (operationId != null && equalCheck.operationId == null))
			return false;
		if (operationId != null && !operationId.equals(equalCheck.operationId))
			return false;
		return true;
	}
}
