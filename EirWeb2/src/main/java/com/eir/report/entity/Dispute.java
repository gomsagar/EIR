package com.eir.report.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "dispute")
@EntityListeners(AuditingEntityListener.class)
public class Dispute implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "dispute_id", nullable = false)	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dispute_seq")
	@SequenceGenerator(
		name="dispute_seq",
		sequenceName="dispute_sequence",
		allocationSize=1
	)
	Integer disputeId;
	
	@Column(name = "description", length = 45)
	String disputeDescription;
	
	@Column(name = "user_id", length = 45)
	Integer userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "request_id", referencedColumnName = "request_id") })
	Request requestId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "status_id", referencedColumnName = "status_id") })
	Status statusId;
	
	@Column(name = "create_user_id", length = 45)
	@CreatedBy
	String createUserId;
	/**
	 */
	
	@Column(name = "create_date")
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
	@Column(name = "update_date")

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;
	
	
	public Integer getDisputeId() {
		return disputeId;
	}
	public void setDisputeId(Integer disputeId) {
		this.disputeId = disputeId;
	}
	public String getDisputeDescription() {
		return disputeDescription;
	}
	public void setDisputeDescription(String disputeDescription) {
		this.disputeDescription = disputeDescription;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Request getRequestId() {
		return requestId;
	}
	public void setRequestId(Request requestId) {
		this.requestId = requestId;
	}
	public Status getStatusId() {
		return statusId;
	}
	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}
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
	
}
