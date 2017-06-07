
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@Table(name = "operations")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "Operations")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class Operations implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "operation_id", nullable = false)
	

	@Id
	@XmlElement
	Integer operationId;
	/**
	 */

	@Column(name = "operation_description", length = 45, nullable = false)
	

	@XmlElement
	String operationDescription;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	

	@XmlElement
	String createUserId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	

	@XmlElement
	Calendar createDate;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	

	@XmlElement
	String updateUserId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	

	@XmlElement
	Calendar updateDate;
	/**
	 */

	@Column(name = "operationscol", length = 45)
	

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
