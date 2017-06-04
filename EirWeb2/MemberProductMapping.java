
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
@IdClass(com.eir.report.domain.MemberProductMappingPK.class)
@Entity
@NamedQueries({
		@NamedQuery(name = "findAllMemberProductMappings", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping"),
		@NamedQuery(name = "findMemberProductMappingByCreateUserDate", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.createUserDate = ?1"),
		@NamedQuery(name = "findMemberProductMappingByCreateUserDateAfter", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.createUserDate > ?1"),
		@NamedQuery(name = "findMemberProductMappingByCreateUserDateBefore", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.createUserDate < ?1"),
		@NamedQuery(name = "findMemberProductMappingByCreateUserId", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.createUserId = ?1"),
		@NamedQuery(name = "findMemberProductMappingByCreateUserIdContaining", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.createUserId like ?1"),
		@NamedQuery(name = "findMemberProductMappingByMemberId", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.memberId = ?1"),
		@NamedQuery(name = "findMemberProductMappingByPrimaryKey", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.memberId = ?1 and myMemberProductMapping.productId = ?2"),
		@NamedQuery(name = "findMemberProductMappingByProductId", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.productId = ?1"),
		@NamedQuery(name = "findMemberProductMappingByUpdateUserDate", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.updateUserDate = ?1"),
		@NamedQuery(name = "findMemberProductMappingByUpdateUserDateAfter", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.updateUserDate > ?1"),
		@NamedQuery(name = "findMemberProductMappingByUpdateUserDateBefore", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.updateUserDate < ?1"),
		@NamedQuery(name = "findMemberProductMappingByUpdateUserId", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.updateUserId = ?1"),
		@NamedQuery(name = "findMemberProductMappingByUpdateUserIdContaining", query = "select myMemberProductMapping from MemberProductMapping myMemberProductMapping where myMemberProductMapping.updateUserId like ?1") })

@Table(catalog = "eir", name = "member_product_mapping")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "MemberProductMapping")

public class MemberProductMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "member_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer memberId;
	/**
	 */

	@Column(name = "product_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer productId;
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
			@JoinColumn(name = "member_id", referencedColumnName = "memberid", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	Member member;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false) })
	@XmlTransient
	ProductMaster productMaster;

	/**
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 */
	public Integer getMemberId() {
		return this.memberId;
	}

	/**
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 */
	public Integer getProductId() {
		return this.productId;
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
	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}

	/**
	 */
	public ProductMaster getProductMaster() {
		return productMaster;
	}

	/**
	 */
	public MemberProductMapping() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(MemberProductMapping that) {
		setMemberId(that.getMemberId());
		setProductId(that.getProductId());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setMember(that.getMember());
		setProductMaster(that.getProductMaster());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("memberId=[").append(memberId).append("] ");
		buffer.append("productId=[").append(productId).append("] ");
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
		result = (int) (prime * result + ((memberId == null) ? 0 : memberId.hashCode()));
		result = (int) (prime * result + ((productId == null) ? 0 : productId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof MemberProductMapping))
			return false;
		MemberProductMapping equalCheck = (MemberProductMapping) obj;
		if ((memberId == null && equalCheck.memberId != null) || (memberId != null && equalCheck.memberId == null))
			return false;
		if (memberId != null && !memberId.equals(equalCheck.memberId))
			return false;
		if ((productId == null && equalCheck.productId != null) || (productId != null && equalCheck.productId == null))
			return false;
		if (productId != null && !productId.equals(equalCheck.productId))
			return false;
		return true;
	}
}
