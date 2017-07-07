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

@Table(name = "consumer_purpose_of_enquiry", schema = "eir")
@EntityListeners(AuditingEntityListener.class)
public class ConsumerPurpose {
	
	@Column(name = "purpose_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="purpose_seq")
	@SequenceGenerator(
		name="purpose_seq",
		sequenceName="eir.purpose_sequence",
		allocationSize=1
	)
	Integer purposeId;
	
	@Column(name = "description", length = 45)
	

	String description;
	
	public Integer getPurposeId() {
		return purposeId;
	}
	public void setPurposeId(Integer purposeId) {
		this.purposeId = purposeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
