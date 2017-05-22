package com.eir.report.entity;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "report_selection")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "ReportSelection")

public class ReportSelection {
	
	@Column(name = "request_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer requestId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
	@XmlTransient
	ProductMaster productMaster;
	
	@Column(name = "product_request_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String productRequestId;
	
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
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	public ProductMaster getProductMaster() {
		return productMaster;
	}
	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}
	public String getProductRequestId() {
		return productRequestId;
	}
	public void setProductRequestId(String productRequestId) {
		this.productRequestId = productRequestId;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	public Calendar getCreateUserDate() {
		return createUserDate;
	}
	public void setCreateUserDate(Calendar createUserDate) {
		this.createUserDate = createUserDate;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public Calendar getUpdateUserDate() {
		return updateUserDate;
	}
	public void setUpdateUserDate(Calendar updateUserDate) {
		this.updateUserDate = updateUserDate;
	}

}
