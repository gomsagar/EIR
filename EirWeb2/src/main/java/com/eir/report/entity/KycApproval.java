
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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

/**
 */

@Entity

@Table(name = "kyc_approval")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "KycApproval")

@EntityListeners(AuditingEntityListener.class)
public class KycApproval implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "request_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="request_seq")
	@SequenceGenerator(
		name="request_seq",
		sequenceName="request_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer requestId;
	/**
	 */

	@Column(name = "kyc_document", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob

	@XmlElement
	byte[] kycDocument;
	/**
	 */

	@Column(name = "comment", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String comment;
	/**
	 */

	@Column(name = "status", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String status;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@CreatedBy
	String createUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_user_date")
	@Basic(fetch = FetchType.EAGER)

	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate ;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@LastModifiedBy
	String updateUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "update_user_date")
	@Basic(fetch = FetchType.EAGER)

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;

	/**
	 */
	@PrimaryKeyJoinColumn
	@OneToOne(fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	Request request;

	/**
	 */
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	/**
	 */
	public Integer getRequestId() {
		return this.requestId;
	}

	/**
	 */
	public void setKycDocument(byte[] kycDocument) {
		this.kycDocument = kycDocument;
	}

	/**
	 */
	public byte[] getKycDocument() {
		return this.kycDocument;
	}

	/**
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 */
	public String getCreateUserId() {
		return this.createUserId;
	}

	/**
	 */
	public void setCreateUserDate(DateTime createUserDate) {
		this.createUserDate = createUserDate;
	}

	/**
	 */
	public DateTime getCreateUserDate() {
		return this.createUserDate;
	}

	/**
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	/**
	 */
	public String getUpdateUserId() {
		return this.updateUserId;
	}

	/**
	 */
	public void setUpdateUserDate(DateTime updateUserDate) {
		this.updateUserDate = updateUserDate;
	}

	/**
	 */
	public DateTime getUpdateUserDate() {
		return this.updateUserDate;
	}

	/**
	 */
	public void setRequest(Request request) {
		this.request = request;
	}

	/**
	 */
	public Request getRequest() {
		return request;
	}

	/**
	 */
	public KycApproval() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(KycApproval that) {
		setRequestId(that.getRequestId());
		setKycDocument(that.getKycDocument());
		setComment(that.getComment());
		setStatus(that.getStatus());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setRequest(that.getRequest());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("requestId=[").append(requestId).append("] ");
		buffer.append("kycDocument=[").append(kycDocument).append("] ");
		buffer.append("comment=[").append(comment).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((requestId == null) ? 0 : requestId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof KycApproval))
			return false;
		KycApproval equalCheck = (KycApproval) obj;
		if ((requestId == null && equalCheck.requestId != null) || (requestId != null && equalCheck.requestId == null))
			return false;
		if (requestId != null && !requestId.equals(equalCheck.requestId))
			return false;
		return true;
	}
}
