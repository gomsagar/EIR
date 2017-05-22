
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
@Table(name = "product_master")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "ProductMaster")
@XmlRootElement(namespace = "eir/com/eir/report/entity")
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

	@Column(name = "discription", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String discription;
	/**
	 */

	@Column(name = "product_code", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String productCode;
	
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
	@OneToMany(mappedBy = "productMaster", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.Request> requests;
	/**
	 */
	@OneToMany(mappedBy = "productMaster", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.MemberProductMapping> memberProductMappings;

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
	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	/**
	 */
	public Set<Request> getRequests() {
		if (requests == null) {
			requests = new java.util.LinkedHashSet<com.eir.report.entity.Request>();
		}
		return requests;
	}

	/**
	 */
	public void setMemberProductMappings(Set<MemberProductMapping> memberProductMappings) {
		this.memberProductMappings = memberProductMappings;
	}
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 */
	public Set<MemberProductMapping> getMemberProductMappings() {
		if (memberProductMappings == null) {
			memberProductMappings = new java.util.LinkedHashSet<com.eir.report.entity.MemberProductMapping>();
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
		setProductCode(that.getProductCode());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setRequests(new java.util.LinkedHashSet<com.eir.report.entity.Request>(that.getRequests()));
		setMemberProductMappings(new java.util.LinkedHashSet<com.eir.report.entity.MemberProductMapping>(that.getMemberProductMappings()));
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
