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
	@Basic(fetch = FetchType.EAGER)

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cirPurpose_seq")
	@SequenceGenerator(
		name="cirPurpose_seq",
		sequenceName="cirPurpose_sequence",
		allocationSize=1
	)
	Integer cirPurposeId;
	
	@Column(name = "cir_purpose_description", length = 45)
	@Basic(fetch = FetchType.EAGER)

	String cirPurposeDescription;
	
	@Column(name = "create_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@CreatedBy
	String createUserId;
	/**
	 */
	@Column(name = "create_user_date")
	@Basic(fetch = FetchType.EAGER)

	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate ;
	
	@Column(name = "update_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@LastModifiedBy
	String updateUserId;
	/**
	 */
	@Column(name = "update_user_date")
	@Basic(fetch = FetchType.EAGER)

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;
	
	
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
	/**
	 */
}
