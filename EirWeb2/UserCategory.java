
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
		@NamedQuery(name = "findAllUserCategorys", query = "select myUserCategory from UserCategory myUserCategory"),
		@NamedQuery(name = "findUserCategoryByCreateUserDate", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.createUserDate = ?1"),
		@NamedQuery(name = "findUserCategoryByCreateUserDateAfter", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.createUserDate > ?1"),
		@NamedQuery(name = "findUserCategoryByCreateUserDateBefore", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.createUserDate < ?1"),
		@NamedQuery(name = "findUserCategoryByCreateUserId", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.createUserId = ?1"),
		@NamedQuery(name = "findUserCategoryByCreateUserIdContaining", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.createUserId like ?1"),
		@NamedQuery(name = "findUserCategoryByDiscription", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.discription = ?1"),
		@NamedQuery(name = "findUserCategoryByDiscriptionContaining", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.discription like ?1"),
		@NamedQuery(name = "findUserCategoryByPrimaryKey", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.userCategoryId = ?1"),
		@NamedQuery(name = "findUserCategoryByUpdateUserDate", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.updateUserDate = ?1"),
		@NamedQuery(name = "findUserCategoryByUpdateUserDateAfter", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.updateUserDate > ?1"),
		@NamedQuery(name = "findUserCategoryByUpdateUserDateBefore", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.updateUserDate < ?1"),
		@NamedQuery(name = "findUserCategoryByUpdateUserId", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.updateUserId = ?1"),
		@NamedQuery(name = "findUserCategoryByUpdateUserIdContaining", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.updateUserId like ?1"),
		@NamedQuery(name = "findUserCategoryByUserCategoryId", query = "select myUserCategory from UserCategory myUserCategory where myUserCategory.userCategoryId = ?1") })

@Table(catalog = "eir", name = "user_category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "UserCategory")

public class UserCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "user_category_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer userCategoryId;
	/**
	 */

	@Column(name = "discription", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String discription;
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
	public void setUserCategoryId(Integer userCategoryId) {
		this.userCategoryId = userCategoryId;
	}

	/**
	 */
	public Integer getUserCategoryId() {
		return this.userCategoryId;
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
	public UserCategory() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(UserCategory that) {
		setUserCategoryId(that.getUserCategoryId());
		setDiscription(that.getDiscription());
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

		buffer.append("userCategoryId=[").append(userCategoryId).append("] ");
		buffer.append("discription=[").append(discription).append("] ");
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
		result = (int) (prime * result + ((userCategoryId == null) ? 0 : userCategoryId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof UserCategory))
			return false;
		UserCategory equalCheck = (UserCategory) obj;
		if ((userCategoryId == null && equalCheck.userCategoryId != null) || (userCategoryId != null && equalCheck.userCategoryId == null))
			return false;
		if (userCategoryId != null && !userCategoryId.equals(equalCheck.userCategoryId))
			return false;
		return true;
	}
}
