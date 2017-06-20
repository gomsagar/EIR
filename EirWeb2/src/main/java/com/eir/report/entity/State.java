package com.eir.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
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
import org.springframework.stereotype.Component;

@Component
@Entity

@Table(name = "STATE_CODE")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "State")

@EntityListeners(AuditingEntityListener.class)
public class State {
	
	@Column(name = "state_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="state_seq")
	@SequenceGenerator(
		name="state_seq",
		sequenceName="state_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer stateId;
	
	@Column(name = "state_description", length = 45)

	@XmlElement
	String stateDescription;
	
	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateCode) {
		this.stateId = stateCode;
	}

	public String getStateCodeDescription() {
		return stateDescription;
	}

	public void setStateCodeDescription(String stateCodeDescription) {
		this.stateDescription = stateCodeDescription;
	}

}
