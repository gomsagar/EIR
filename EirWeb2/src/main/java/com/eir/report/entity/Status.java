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

@Table(name = "status")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "Status")
@EntityListeners(AuditingEntityListener.class)
public class Status {
	
	@Column(name = "status_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status_seq")
	@SequenceGenerator(
		name="status_seq",
		sequenceName="status_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer statusId;
	
	@Column(name = "status_description", length = 45)
	

	@XmlElement
	String statusDescription;
	
	@Column(name = "create_user_id", length = 45)
	

	@CreatedBy
	String createUserId;
	/**
	 */
	//@OneToMany(mappedBy = "status", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_user_date")
	

	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate ;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	

	@LastModifiedBy
	String updateUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "update_user_date")
	

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public DateTime getCreateUserDate() {
		return createUserDate;
	}

	public void setCreateUserDate(DateTime createUserDate) {
		this.createUserDate = createUserDate;
	}

	public DateTime getUpdateUserDate() {
		return updateUserDate;
	}

	public void setUpdateUserDate(DateTime updateUserDate) {
		this.updateUserDate = updateUserDate;
	}	

}
