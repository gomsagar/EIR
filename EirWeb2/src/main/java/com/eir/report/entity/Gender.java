package com.eir.report.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Component
@Entity

@Table(name = "gender", schema = "eir")
@EntityListeners(AuditingEntityListener.class)
public class Gender implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "id", nullable = false)
	@Id
	Integer id;

	@Column(name = "description")
	String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
