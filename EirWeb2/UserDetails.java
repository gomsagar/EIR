
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
		@NamedQuery(name = "findAllUserDetailss", query = "select myUserDetails from UserDetails myUserDetails"),
		@NamedQuery(name = "findUserDetailsByAddress", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.address = ?1"),
		@NamedQuery(name = "findUserDetailsByFirstName", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.firstName = ?1"),
		@NamedQuery(name = "findUserDetailsByFirstNameContaining", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.firstName like ?1"),
		@NamedQuery(name = "findUserDetailsByLastName", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.lastName = ?1"),
		@NamedQuery(name = "findUserDetailsByLastNameContaining", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.lastName like ?1"),
		@NamedQuery(name = "findUserDetailsByMailId", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.mailId = ?1"),
		@NamedQuery(name = "findUserDetailsByMailIdContaining", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.mailId like ?1"),
		@NamedQuery(name = "findUserDetailsByPrimaryKey", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.userId = ?1"),
		@NamedQuery(name = "findUserDetailsByUserId", query = "select myUserDetails from UserDetails myUserDetails where myUserDetails.userId = ?1") })

@Table(catalog = "eir", name = "user_details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "UserDetails")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "user_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "first_name", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String firstName;
	/**
	 */

	@Column(name = "last_name", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String lastName;
	/**
	 */

	@Column(name = "mail_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String mailId;
	/**
	 */

	@Column(name = "address")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer address;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false) })
	@XmlTransient
	UserRole userRole;
	/**
	 */
	@OneToMany(mappedBy = "userDetails", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.domain.Request> requests;

	/**
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 */
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	/**
	 */
	public String getMailId() {
		return this.mailId;
	}

	/**
	 */
	public void setAddress(Integer address) {
		this.address = address;
	}

	/**
	 */
	public Integer getAddress() {
		return this.address;
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
	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	/**
	 */
	public Set<Request> getRequests() {
		if (requests == null) {
			requests = new java.util.LinkedHashSet<com.eir.report.domain.Request>();
		}
		return requests;
	}

	/**
	 */
	public UserDetails() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UserDetails that) {
		setUserId(that.getUserId());
		setFirstName(that.getFirstName());
		setLastName(that.getLastName());
		setMailId(that.getMailId());
		setAddress(that.getAddress());
		setUserRole(that.getUserRole());
		setRequests(new java.util.LinkedHashSet<com.eir.report.domain.Request>(that.getRequests()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("firstName=[").append(firstName).append("] ");
		buffer.append("lastName=[").append(lastName).append("] ");
		buffer.append("mailId=[").append(mailId).append("] ");
		buffer.append("address=[").append(address).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((userId == null) ? 0 : userId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof UserDetails))
			return false;
		UserDetails equalCheck = (UserDetails) obj;
		if ((userId == null && equalCheck.userId != null) || (userId != null && equalCheck.userId == null))
			return false;
		if (userId != null && !userId.equals(equalCheck.userId))
			return false;
		return true;
	}
}
