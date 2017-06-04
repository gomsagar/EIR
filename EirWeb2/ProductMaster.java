
package com.eir.report.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
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
		@NamedQuery(name = "findAllProductMasters", query = "select myProductMaster from ProductMaster myProductMaster"),
		@NamedQuery(name = "findProductMasterByCreateUserDate", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.createUserDate = ?1"),
		@NamedQuery(name = "findProductMasterByCreateUserDateAfter", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.createUserDate > ?1"),
		@NamedQuery(name = "findProductMasterByCreateUserDateBefore", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.createUserDate < ?1"),
		@NamedQuery(name = "findProductMasterByCreateUserId", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.createUserId = ?1"),
		@NamedQuery(name = "findProductMasterByCreateUserIdContaining", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.createUserId like ?1"),
		@NamedQuery(name = "findProductMasterByDiscription", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.discription = ?1"),
		@NamedQuery(name = "findProductMasterByDiscriptionContaining", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.discription like ?1"),
		@NamedQuery(name = "findProductMasterByPrimaryKey", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.productId = ?1"),
		@NamedQuery(name = "findProductMasterByProductId", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.productId = ?1"),
		@NamedQuery(name = "findProductMasterByTatInHour", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.tatInHour = ?1"),
		@NamedQuery(name = "findProductMasterByTatInHourContaining", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.tatInHour like ?1"),
		@NamedQuery(name = "findProductMasterByUpdateUserDate", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.updateUserDate = ?1"),
		@NamedQuery(name = "findProductMasterByUpdateUserDateAfter", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.updateUserDate > ?1"),
		@NamedQuery(name = "findProductMasterByUpdateUserDateBefore", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.updateUserDate < ?1"),
		@NamedQuery(name = "findProductMasterByUpdateUserId", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.updateUserId = ?1"),
		@NamedQuery(name = "findProductMasterByUpdateUserIdContaining", query = "select myProductMaster from ProductMaster myProductMaster where myProductMaster.updateUserId like ?1") })

@Table(catalog = "eir", name = "product_master")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "ProductMaster")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class ProductMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "product_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer productId;
	/**
	 */

	@Column(name = "discription", length = 45, nullable = false)
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

	@Column(name = "tat_in_hour", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String tatInHour;

	/**
	 */
	@OneToMany(mappedBy = "productMaster", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.domain.MemberProductMapping> memberProductMappings;

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
	public void setTatInHour(String tatInHour) {
		this.tatInHour = tatInHour;
	}

	/**
	 */
	public String getTatInHour() {
		return this.tatInHour;
	}

	/**
	 */
	public void setMemberProductMappings(Set<MemberProductMapping> memberProductMappings) {
		this.memberProductMappings = memberProductMappings;
	}

	/**
	 */
	public Set<MemberProductMapping> getMemberProductMappings() {
		if (memberProductMappings == null) {
			memberProductMappings = new java.util.LinkedHashSet<com.eir.report.domain.MemberProductMapping>();
		}
		return memberProductMappings;
	}

	/**
	 */
	public ProductMaster() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(ProductMaster that) {
		setProductId(that.getProductId());
		setDiscription(that.getDiscription());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setTatInHour(that.getTatInHour());
		setMemberProductMappings(new java.util.LinkedHashSet<com.eir.report.domain.MemberProductMapping>(that.getMemberProductMappings()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("productId=[").append(productId).append("] ");
		buffer.append("discription=[").append(discription).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");
		buffer.append("tatInHour=[").append(tatInHour).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((productId == null) ? 0 : productId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof ProductMaster))
			return false;
		ProductMaster equalCheck = (ProductMaster) obj;
		if ((productId == null && equalCheck.productId != null) || (productId != null && equalCheck.productId == null))
			return false;
		if (productId != null && !productId.equals(equalCheck.productId))
			return false;
		return true;
	}
}
