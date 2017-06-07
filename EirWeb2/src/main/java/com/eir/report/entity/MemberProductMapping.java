
package com.eir.report.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 */
@IdClass(com.eir.report.entity.MemberProductMappingPK.class)
@Entity
@Table(name = "member_product_mapping")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "MemberProductMapping")

@EntityListeners(AuditingEntityListener.class)
public class MemberProductMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "member_id", nullable = false)
	

	@Id
	/*@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="memberProdMap_seq")
	@SequenceGenerator(
		name="memberProdMap_seq",
		sequenceName="MemberProductMapping_sequence",
		allocationSize=1
	)*/
	@XmlElement
	Integer memberId;
	
	@Column(name = "product_id", nullable = false)
	
	@Id
	public Integer productId;

	
	@Column(name = "product_code", length = 45)
	
	@XmlElement
	String productCode;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	

	@CreatedBy
	String createUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_user_date")
	

	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate ;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	

	@LastModifiedBy
	String updateUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "update_user_date")
	

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;

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
			@JoinColumn(name = "product_code", referencedColumnName = "product_code", nullable = false, insertable = false, updatable = false) })
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
	public void setCreateUserDate(DateTime createUserDate) {
		this.createUserDate = createUserDate;
	}

	/**
	 */
	public DateTime getCreateUserDate() {
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
	public void setUpdateUserDate(DateTime updateUserDate) {
		this.updateUserDate = updateUserDate;
	}

	/**
	 */
	public DateTime getUpdateUserDate() {
		return this.updateUserDate;
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
	
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
		setProductCode(that.getProductCode());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setProductMaster(that.getProductMaster());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("memberId=[").append(memberId).append("] ");
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
		return true;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
