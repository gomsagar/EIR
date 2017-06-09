
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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

@Entity
@Table(name = "product_master")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "ProductMaster")
@XmlRootElement(namespace = "eir/com/eir/report/entity")

@EntityListeners(AuditingEntityListener.class)
public class ProductMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "product_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="prodMaster_seq")
	@SequenceGenerator(
		name="prodMaster_seq",
		sequenceName="productMaster_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer productId;
	/**
	 */

	@Column(name = "product_code", length = 45)

	@XmlElement
	String productCode;
	
	@Column(name = "description", length = 45)
	
	@XmlElement
	String description;
	
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
	 
	 
	@Column(name = "tat_in_hour", length = 45)
	

	@XmlElement
	String tatInHour;
 
 
	/*@OneToMany(mappedBy = "productMaster", fetch = FetchType.LAZY)
	java.util.Set<com.eir.report.entity.Request> requests;*/
	/**
	 */
	@OneToMany(mappedBy = "productMaster", fetch = FetchType.LAZY)
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
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 */
	public String getDescription() {
		return this.description;
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
	/*public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}*/

	/**
	 */
	/*public Set<Request> getRequests() {
		if (requests == null) {
			requests = new java.util.LinkedHashSet<com.eir.report.entity.Request>();
		}
		return requests;
	}*/
	
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
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("productId=[").append(productId).append("] ");
		buffer.append("description=[").append(description).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");

		return buffer.toString();
	}	
}
