
package com.eir.report.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllUserRoles", query = "select myUserRole from UserRole myUserRole"),
		@NamedQuery(name = "findUserRoleByDiscription", query = "select myUserRole from UserRole myUserRole where myUserRole.discription = ?1"),
		@NamedQuery(name = "findUserRoleByDiscriptionContaining", query = "select myUserRole from UserRole myUserRole where myUserRole.discription like ?1"),
		@NamedQuery(name = "findUserRoleByPrimaryKey", query = "select myUserRole from UserRole myUserRole where myUserRole.roleId = ?1"),
		@NamedQuery(name = "findUserRoleByRoleId", query = "select myUserRole from UserRole myUserRole where myUserRole.roleId = ?1") })

@Table(catalog = "eir", name = "user_role")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "UserRole")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class UserRole implements Serializable {
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

	@Column(name = "discription", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String discription;

	/**
	 */
	@OneToMany(mappedBy = "userRole", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.domain.UserDetails> userDetailses;
	/**
	 */
	@OneToMany(mappedBy = "userRole", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.domain.UserRoleAccess> userRoleAccesses;

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
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	/**
	 */
	public String getDiscription() {
		return this.discription;
	}

	/**
	 */
	public void setUserDetailses(Set<UserDetails> userDetailses) {
		this.userDetailses = userDetailses;
	}

	/**
	 */
	public Set<UserDetails> getUserDetailses() {
		if (userDetailses == null) {
			userDetailses = new java.util.LinkedHashSet<com.eir.report.domain.UserDetails>();
		}
		return userDetailses;
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
			userRoleAccesses = new java.util.LinkedHashSet<com.eir.report.domain.UserRoleAccess>();
		}
		return userRoleAccesses;
	}

	/**
	 */
	public UserRole() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UserRole that) {
		setRoleId(that.getRoleId());
		setDiscription(that.getDiscription());
		setUserDetailses(new java.util.LinkedHashSet<com.eir.report.domain.UserDetails>(that.getUserDetailses()));
		setUserRoleAccesses(new java.util.LinkedHashSet<com.eir.report.domain.UserRoleAccess>(that.getUserRoleAccesses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("roleId=[").append(roleId).append("] ");
		buffer.append("discription=[").append(discription).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((roleId == null) ? 0 : roleId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof UserRole))
			return false;
		UserRole equalCheck = (UserRole) obj;
		if ((roleId == null && equalCheck.roleId != null) || (roleId != null && equalCheck.roleId == null))
			return false;
		if (roleId != null && !roleId.equals(equalCheck.roleId))
			return false;
		return true;
	}
}
