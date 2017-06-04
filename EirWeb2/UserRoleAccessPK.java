
package com.eir.report.domain;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.*;

/**
 */
public class UserRoleAccessPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public UserRoleAccessPK() {
	}

	/**
	 */

	@Column(name = "role_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	public Integer roleId;
	/**
	 */

	@Column(name = "operation_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	public Integer operationId;

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
		if (!(obj instanceof UserRoleAccessPK))
			return false;
		UserRoleAccessPK equalCheck = (UserRoleAccessPK) obj;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("UserRoleAccessPK");
		sb.append(" roleId: ").append(getRoleId());
		sb.append(" operationId: ").append(getOperationId());
		return sb.toString();
	}
}
