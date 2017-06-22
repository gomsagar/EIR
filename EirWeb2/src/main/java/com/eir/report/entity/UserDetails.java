
package com.eir.report.entity;

import java.io.Serializable;

import java.lang.StringBuilder;
import java.util.Set;

import javax.xml.bind.annotation.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="userDetails_seq")
	@SequenceGenerator(
		name="userDetails_seq",
		sequenceName="userDetails_sequence",
		allocationSize=1
	)
	Integer userId;

	
	/**
	 */
	@Column(name = "user_name", length = 45)
	@XmlElement
	String userName;

	
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

	@Column(name = "address_id")
	

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
	
	
	@Column(name = "create_user_id", length = 45)
	@CreatedBy
	String createUserId;

	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createDate ;

	
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
	DateTime updateDate ;
	
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 */
	public Integer getUserId() {
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public DateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(DateTime createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public DateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(DateTime updateDate) {
		this.updateDate = updateDate;
	}
}
