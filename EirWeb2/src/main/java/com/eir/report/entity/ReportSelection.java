package com.eir.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@IdClass(com.eir.report.entity.ReportSelectionPK.class)
@Entity
@Table(name = "product_selection", schema = "eir")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "ReportSelection")

@EntityListeners(AuditingEntityListener.class)
public class ReportSelection {
	
	@Column(name = "request_id", nullable = false)
	@Id
	public Integer requestId;

	@Column(name = "product_id", nullable = false)
	@Id
	public Integer productId;

	@Column(name = "product_code", length = 45)
	@XmlElement
	String productCode;
	
	@Column(name = "create_user_id", length = 45)
	@CreatedBy
	String createUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_date")
	

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
	@Column(name = "update_date")
	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;
	
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public DateTime getCreateUserDate() {
		return createUserDate;
	}
	public void setCreateUserDate(DateTime createUserDate) {
		this.createUserDate = createUserDate;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public DateTime getUpdateUserDate() {
		return updateUserDate;
	}
	public void setUpdateUserDate(DateTime updateUserDate) {
		this.updateUserDate = updateUserDate;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

}
