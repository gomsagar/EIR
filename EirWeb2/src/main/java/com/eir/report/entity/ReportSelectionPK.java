
package com.eir.report.entity;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.*;

/**
 */
public class ReportSelectionPK implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	public ReportSelectionPK() {
	}


	@Column(name = "request_id", nullable = false)
	@Id
	public Integer requestId;

	@Column(name = "product_id", nullable = false)
	@Id
	public Integer productId;

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


}
