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
	
	@Column(name = "code", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="state_seq")
	@SequenceGenerator(
		name="state_seq",
		sequenceName="state_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer stateCode;
	
	@Column(name = "description", length = 45)
	

	@XmlElement
	String stateDescription;
	
	/*@Column(name = "create_user_id", length = 45)
	

	@CreatedBy
	String createUserId;
	*//**
	 *//*
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_user_date")
	

	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate ;
	*//**
	 *//*

	@Column(name = "update_user_id", length = 45)
	

	@LastModifiedBy
	String updateUserId;
	
	@Column(name = "update_user_date")
	

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;
	
	
	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public DateTime getCreateUserDate() {
		return createUserDate;
	}

	public void setCreateUserDate(DateTime createUserDate) {
		this.createUserDate = createUserDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public DateTime getUpdateUserDate() {
		return updateUserDate;
	}

	public void setUpdateUserDate(DateTime updateUserDate) {
		this.updateUserDate = updateUserDate;
	}
*/
	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateDescription() {
		return stateDescription;
	}

	public void setStateDescription(String stateCodeDescription) {
		this.stateDescription = stateCodeDescription;
	}

}
