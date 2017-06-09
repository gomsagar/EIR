
package com.eir.report.entity;

import java.io.Serializable;

import java.lang.StringBuilder;
import java.util.Set;

import javax.persistence.Id;
import javax.xml.bind.annotation.*;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "UserDetails")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class UserDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "user_id", nullable = false)
	

	@Id
	@XmlElement
	String userId;
	/**
	 */
	@Column(name = "password", length = 45)
	

	@XmlElement
	String password;
	
	@Column(name = "first_name", length = 45)
	

	@XmlElement
	String firstName;
	/**
	 */

	@Column(name = "last_name", length = 45)
	

	@XmlElement
	String lastName;
	/**
	 */

	@Column(name = "mail_id", length = 45)
	

	@XmlElement
	String mailId;
	/**
	 */

	@Column(name = "address")
	

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
	/*@OneToMany(mappedBy = "userDetails", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.Request> requests;
*/
	/**
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 */
	public String getUserId() {
		return this.userId;
	}

public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
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
	 *//*
	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	*//**
	 *//*
	public Set<Request> getRequests() {
		if (requests == null) {
			requests = new java.util.LinkedHashSet<com.eir.report.entity.Request>();
		}
		return requests;
	}
*/
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
		//setRequests(new java.util.LinkedHashSet<com.eir.report.entity.Request>(that.getRequests()));
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
