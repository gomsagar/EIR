
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
@IdClass(com.eir.report.domain.UserRoleAccessPK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUserRoleAccesss", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess"),
		@NamedQuery(name = "findUserRoleAccessByAccess", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.access = ?1"),
		@NamedQuery(name = "findUserRoleAccessByAccessContaining", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.access like ?1"),
		@NamedQuery(name = "findUserRoleAccessByCreateUserDate", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.createUserDate = ?1"),
		@NamedQuery(name = "findUserRoleAccessByCreateUserDateAfter", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.createUserDate > ?1"),
		@NamedQuery(name = "findUserRoleAccessByCreateUserDateBefore", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.createUserDate < ?1"),
		@NamedQuery(name = "findUserRoleAccessByCreateUserId", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.createUserId = ?1"),
		@NamedQuery(name = "findUserRoleAccessByCreateUserIdContaining", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.createUserId like ?1"),
		@NamedQuery(name = "findUserRoleAccessByOperationId", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.operationId = ?1"),
		@NamedQuery(name = "findUserRoleAccessByPrimaryKey", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.roleId = ?1 and myUserRoleAccess.operationId = ?2"),
		@NamedQuery(name = "findUserRoleAccessByRoleId", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.roleId = ?1"),
		@NamedQuery(name = "findUserRoleAccessByUpdateUserDate", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.updateUserDate = ?1"),
		@NamedQuery(name = "findUserRoleAccessByUpdateUserDateAfter", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.updateUserDate > ?1"),
		@NamedQuery(name = "findUserRoleAccessByUpdateUserDateBefore", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.updateUserDate < ?1"),
		@NamedQuery(name = "findUserRoleAccessByUpdateUserId", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.updateUserId = ?1"),
		@NamedQuery(name = "findUserRoleAccessByUpdateUserIdContaining", query = "select myUserRoleAccess from UserRoleAccess myUserRoleAccess where myUserRoleAccess.updateUserId like ?1") })

@Table(catalog = "eir", name = "user_role_access")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "UserRoleAccess")

public class UserRoleAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "role_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer roleId;
	/**
	 */

	@Column(name = "operation_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer operationId;
	/**
	 */

	@Column(name = "access", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String access;
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
	@JoinColumns({
			@JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	UserRole userRole;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "operation_id", referencedColumnName = "operation_id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Operations operations;

	/**
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 */
	public Integer getRoleId() {
		return this.roleId;
	}

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
	public void setAccess(String access) {
		this.access = access;
	}

	/**
	 */
	public String getAccess() {
		return this.access;
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
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	/**
	 */
	public UserRole getUserRole() {
		return userRole;
	}

	/**
	 */
	public void setOperations(Operations operations) {
		this.operations = operations;
	}

	/**
	 */
	public Operations getOperations() {
		return operations;
	}

	/**
	 */
	public UserRoleAccess() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UserRoleAccess that) {
		setRoleId(that.getRoleId());
		setOperationId(that.getOperationId());
		setAccess(that.getAccess());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setUserRole(that.getUserRole());
		setOperations(that.getOperations());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("roleId=[").append(roleId).append("] ");
		buffer.append("operationId=[").append(operationId).append("] ");
		buffer.append("access=[").append(access).append("] ");
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
		result = (int) (prime * result + ((roleId == null) ? 0 : roleId.hashCode()));
		result = (int) (prime * result + ((operationId == null) ? 0 : operationId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof UserRoleAccess))
			return false;
		UserRoleAccess equalCheck = (UserRoleAccess) obj;
		if ((roleId == null && equalCheck.roleId != null) || (roleId != null && equalCheck.roleId == null))
			return false;
		if (roleId != null && !roleId.equals(equalCheck.roleId))
			return false;
		if ((operationId == null && equalCheck.operationId != null) || (operationId != null && equalCheck.operationId == null))
			return false;
		if (operationId != null && !operationId.equals(equalCheck.operationId))
			return false;
		return true;
	}
}
