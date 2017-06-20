package com.eir.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "identification_type")
@EntityListeners(AuditingEntityListener.class)
public class IdentificationType {
	
@Column(name = "identification_id", nullable = false)
	@Id
	Integer identificationId;
	/**
	 */

	@Column(name = "identification_description", length = 45)
	String identificationDescription;
	
	public Integer getIdentificationId() {
		return identificationId;
	}
	public void setIdentificationId(Integer identificationId) {
		this.identificationId = identificationId;
	}
	public String getIdentificationDescription() {
		return identificationDescription;
	}
	public void setIdentificationDescription(String identificationDescription) {
		this.identificationDescription = identificationDescription;
	}
	
}
