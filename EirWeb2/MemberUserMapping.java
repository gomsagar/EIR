
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

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllMemberUserMappings", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping"),
		@NamedQuery(name = "findMemberUserMappingByCreateUserDate", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.createUserDate = ?1"),
		@NamedQuery(name = "findMemberUserMappingByCreateUserDateAfter", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.createUserDate > ?1"),
		@NamedQuery(name = "findMemberUserMappingByCreateUserDateBefore", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.createUserDate < ?1"),
		@NamedQuery(name = "findMemberUserMappingByCreateUserId", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.createUserId = ?1"),
		@NamedQuery(name = "findMemberUserMappingByCreateUserIdContaining", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.createUserId like ?1"),
		@NamedQuery(name = "findMemberUserMappingByName", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.name = ?1"),
		@NamedQuery(name = "findMemberUserMappingByNameContaining", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.name like ?1"),
		@NamedQuery(name = "findMemberUserMappingByPrimaryKey", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.userId = ?1"),
		@NamedQuery(name = "findMemberUserMappingByUpdateUserDate", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.updateUserDate = ?1"),
		@NamedQuery(name = "findMemberUserMappingByUpdateUserDateAfter", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.updateUserDate > ?1"),
		@NamedQuery(name = "findMemberUserMappingByUpdateUserDateBefore", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.updateUserDate < ?1"),
		@NamedQuery(name = "findMemberUserMappingByUpdateUserId", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.updateUserId = ?1"),
		@NamedQuery(name = "findMemberUserMappingByUpdateUserIdContaining", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.updateUserId like ?1"),
		@NamedQuery(name = "findMemberUserMappingByUserId", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.userId = ?1"),
		@NamedQuery(name = "findMemberUserMappingByUserMailId", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.userMailId = ?1"),
		@NamedQuery(name = "findMemberUserMappingByUserMailIdContaining", query = "select myMemberUserMapping from MemberUserMapping myMemberUserMapping where myMemberUserMapping.userMailId like ?1") })

@Table(catalog = "eir", name = "member_user_mapping")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "MemberUserMapping")

public class MemberUserMapping implements Serializable {
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

	@Column(name = "name", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String name;
	/**
	 */

	@Column(name = "user_mail_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String userMailId;
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
	@JoinColumns({ @JoinColumn(name = "member_id", referencedColumnName = "memberid") })
	@XmlTransient
	Member member;

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
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
	}

	/**
	 */
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}

	/**
	 */
	public String getUserMailId() {
		return this.userMailId;
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
	public void setMember(Member member) {
		this.member = member;
	}

	/**
	 */
	public Member getMember() {
		return member;
	}

	/**
	 */
	public MemberUserMapping() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(MemberUserMapping that) {
		setUserId(that.getUserId());
		setName(that.getName());
		setUserMailId(that.getUserMailId());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setMember(that.getMember());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("userMailId=[").append(userMailId).append("] ");
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
		if (!(obj instanceof MemberUserMapping))
			return false;
		MemberUserMapping equalCheck = (MemberUserMapping) obj;
		if ((userId == null && equalCheck.userId != null) || (userId != null && equalCheck.userId == null))
			return false;
		if (userId != null && !userId.equals(equalCheck.userId))
			return false;
		return true;
	}
}
