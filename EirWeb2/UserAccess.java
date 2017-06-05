
package com.eir.report.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllUserAccesss", query = "select myUserAccess from UserAccess myUserAccess"),
		@NamedQuery(name = "findUserAccessByCategoryId", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.categoryId = ?1"),
		@NamedQuery(name = "findUserAccessByCreateUserDate", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.createUserDate = ?1"),
		@NamedQuery(name = "findUserAccessByCreateUserDateAfter", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.createUserDate > ?1"),
		@NamedQuery(name = "findUserAccessByCreateUserDateBefore", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.createUserDate < ?1"),
		@NamedQuery(name = "findUserAccessByCreateUserId", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.createUserId = ?1"),
		@NamedQuery(name = "findUserAccessByCreateUserIdContaining", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.createUserId like ?1"),
		@NamedQuery(name = "findUserAccessByPrimaryKey", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.userId = ?1"),
		@NamedQuery(name = "findUserAccessByRole1", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role1 = ?1"),
		@NamedQuery(name = "findUserAccessByRole1Containing", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role1 like ?1"),
		@NamedQuery(name = "findUserAccessByRole2", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role2 = ?1"),
		@NamedQuery(name = "findUserAccessByRole2Containing", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role2 like ?1"),
		@NamedQuery(name = "findUserAccessByRole3", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role3 = ?1"),
		@NamedQuery(name = "findUserAccessByRole3Containing", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role3 like ?1"),
		@NamedQuery(name = "findUserAccessByRole4", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role4 = ?1"),
		@NamedQuery(name = "findUserAccessByRole4Containing", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role4 like ?1"),
		@NamedQuery(name = "findUserAccessByRole5", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role5 = ?1"),
		@NamedQuery(name = "findUserAccessByRole5Containing", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.role5 like ?1"),
		@NamedQuery(name = "findUserAccessByUpdateUserDate", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.updateUserDate = ?1"),
		@NamedQuery(name = "findUserAccessByUpdateUserDateAfter", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.updateUserDate > ?1"),
		@NamedQuery(name = "findUserAccessByUpdateUserDateBefore", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.updateUserDate < ?1"),
		@NamedQuery(name = "findUserAccessByUpdateUserId", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.updateUserId = ?1"),
		@NamedQuery(name = "findUserAccessByUpdateUserIdContaining", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.updateUserId like ?1"),
		@NamedQuery(name = "findUserAccessByUserId", query = "select myUserAccess from UserAccess myUserAccess where myUserAccess.userId = ?1") })

@Table(catalog = "eir", name = "user_access")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "UserAccess")

public class UserAccess implements Serializable {
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

	@Column(name = "category_id")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer categoryId;
	/**
	 */

	@Column(name = "role_1", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String role1;
	/**
	 */

	@Column(name = "role_2", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String role2;
	/**
	 */

	@Column(name = "role_3", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String role3;
	/**
	 */

	@Column(name = "role_4", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String role4;
	/**
	 */

	@Column(name = "role_5", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String role5;
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
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 */
	public Integer getCategoryId() {
		return this.categoryId;
	}

	/**
	 */
	public void setRole1(String role1) {
		this.role1 = role1;
	}

	/**
	 */
	public String getRole1() {
		return this.role1;
	}

	/**
	 */
	public void setRole2(String role2) {
		this.role2 = role2;
	}

	/**
	 */
	public String getRole2() {
		return this.role2;
	}

	/**
	 */
	public void setRole3(String role3) {
		this.role3 = role3;
	}

	/**
	 */
	public String getRole3() {
		return this.role3;
	}

	/**
	 */
	public void setRole4(String role4) {
		this.role4 = role4;
	}

	/**
	 */
	public String getRole4() {
		return this.role4;
	}

	/**
	 */
	public void setRole5(String role5) {
		this.role5 = role5;
	}

	/**
	 */
	public String getRole5() {
		return this.role5;
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
	public UserAccess() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UserAccess that) {
		setUserId(that.getUserId());
		setCategoryId(that.getCategoryId());
		setRole1(that.getRole1());
		setRole2(that.getRole2());
		setRole3(that.getRole3());
		setRole4(that.getRole4());
		setRole5(that.getRole5());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("categoryId=[").append(categoryId).append("] ");
		buffer.append("role1=[").append(role1).append("] ");
		buffer.append("role2=[").append(role2).append("] ");
		buffer.append("role3=[").append(role3).append("] ");
		buffer.append("role4=[").append(role4).append("] ");
		buffer.append("role5=[").append(role5).append("] ");
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
		result = (int) (prime * result + ((userId == null) ? 0 : userId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof UserAccess))
			return false;
		UserAccess equalCheck = (UserAccess) obj;
		if ((userId == null && equalCheck.userId != null) || (userId != null && equalCheck.userId == null))
			return false;
		if (userId != null && !userId.equals(equalCheck.userId))
			return false;
		return true;
	}
}
