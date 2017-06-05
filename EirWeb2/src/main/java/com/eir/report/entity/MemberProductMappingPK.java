
package com.eir.report.entity;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.*;

/**
 */
public class MemberProductMappingPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public MemberProductMappingPK() {
	}

	/**
	 */

	@Column(name = "member_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	public Integer memberId;
	/**
	 */

	@Column(name = "product_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	public Integer productId;

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
		if (!(obj instanceof MemberProductMappingPK))
			return false;
		MemberProductMappingPK equalCheck = (MemberProductMappingPK) obj;
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("MemberProductMappingPK");
		sb.append(" memberId: ").append(getMemberId());
		sb.append(" productId: ").append(getProductId());
		return sb.toString();
	}
}
