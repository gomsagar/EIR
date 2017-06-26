package com.eir.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity

@Table(name = "frequency")
@EntityListeners(AuditingEntityListener.class)
public class Frequency {

	@Column(name = "FREQUENCY_ID", nullable = false)
	@Id
	
	Integer frequencyId;
	
	@Column(name = "FREQUENCY_DESCRIPTION", length = 45)
	String frequencyDescription;

	public Integer getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(Integer frequencyId) {
		this.frequencyId = frequencyId;
	}

	public String getFrequencyDescription() {
		return frequencyDescription;
	}

	public void setFrequencyDescription(String frequencyDescription) {
		this.frequencyDescription = frequencyDescription;
	}
}
