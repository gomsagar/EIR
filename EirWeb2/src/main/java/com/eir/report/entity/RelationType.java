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

@Table(name = "relation_type")
@EntityListeners(AuditingEntityListener.class)
public class RelationType {
	
	@Column(name = "relation_type_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="relationType_seq")
	@SequenceGenerator(
		name="relationType_seq",
		sequenceName="relationType_sequence",
		allocationSize=1
	)
	String relationTypeId;
	
	@Column(name = "relation_type_description", length = 45)
	

	String relationTypeDescription;
	
		
	public String getRelationTypeId() {
		return relationTypeId;
	}
	public void setRelationTypeId(String relationTypeId) {
		this.relationTypeId = relationTypeId;
	}
	public String getRelationTypeDescription() {
		return relationTypeDescription;
	}
	public void setRelationTypeDescription(String relationTypeDescription) {
		this.relationTypeDescription = relationTypeDescription;
	}
	
}
