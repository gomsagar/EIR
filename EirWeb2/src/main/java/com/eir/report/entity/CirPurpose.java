package com.eir.report.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Component
@Entity

@Table(name = "cir_purpose")
@EntityListeners(AuditingEntityListener.class)

public class CirPurpose {
	
	@Column(name = "cir_purpose_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="cirPurpose_seq")
	@SequenceGenerator(
		name="cirPurpose_seq",
		sequenceName="cirPurpose_sequence",
		allocationSize=1
	)
	Integer cirPurposeId;
	
	@Column(name = "cir_purpose_description", length = 45)
	

	String cirPurposeDescription;
	
	public Integer getCirPurposeId() {
		return cirPurposeId;
	}
	public void setCirPurposeId(Integer cirPurposeId) {
		this.cirPurposeId = cirPurposeId;
	}
	public String getCirPurposeDescription() {
		return cirPurposeDescription;
	}
	public void setCirPurposeDescription(String cirPurposeDescription) {
		this.cirPurposeDescription = cirPurposeDescription;
	}
}
