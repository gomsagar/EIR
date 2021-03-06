
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
@Table(name = "user_category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "UserCategory")
@XmlRootElement(namespace = "eir/com/eir/report/entity")
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
	@OneToMany(mappedBy = "userCategory", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.UserAccess> userAccesses;

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
	public void setUserAccesses(Set<UserAccess> userAccesses) {
		this.userAccesses = userAccesses;
	}

	/**
	 */
	public Set<UserAccess> getUserAccesses() {
		if (userAccesses == null) {
			userAccesses = new java.util.LinkedHashSet<com.eir.report.entity.UserAccess>();
		}
		return userAccesses;
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
		setUserAccesses(new java.util.LinkedHashSet<com.eir.report.entity.UserAccess>(that.getUserAccesses()));
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
