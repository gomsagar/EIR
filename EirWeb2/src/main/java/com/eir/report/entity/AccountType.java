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

@Table(name = "account_type", schema = "eir")
@EntityListeners(AuditingEntityListener.class)
public class AccountType {
	
	@Column(name = "account_type_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="accntType_seq")
	@SequenceGenerator(
		name="accntType_seq",
		sequenceName="eir.accntType_sequence",
		allocationSize=1
	)
	Integer accntTypeId;
	
	@Column(name = "account_type_description", length = 45)
	

	String accntTypeDescription;

		
	public Integer getAccntTypeId() {
		return accntTypeId;
	}
	public void setAccntTypeId(Integer accntTypeId) {
		this.accntTypeId = accntTypeId;
	}
	public String getAccntTypeDescription() {
		return accntTypeDescription;
	}
	public void setAccntTypeDescription(String accntTypeDescription) {
		this.accntTypeDescription = accntTypeDescription;
	}
	
}
