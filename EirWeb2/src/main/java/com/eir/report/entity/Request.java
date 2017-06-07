
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
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
@Table(name = "request")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "Request")
@XmlRootElement(namespace = "eir/com/eir/report/entity")

@EntityListeners(AuditingEntityListener.class)
public class Request implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "request_id", nullable = false)
	

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

		
	@Column(name = "type", length = 45)
	

	@XmlElement
	String type;
	/**
	 */
	
	@Column(name = "ern_number", length = 45)
	

	@XmlElement
	String ernNumber;
	/**
	 */

	@Column(name = "score", length = 45)
	

	@XmlElement
	String score;
	/**
	 */
	
	@Column(name = "status", length = 45)
	

	@XmlElement
	String status;
	/**
	 */

	@Column(name = "user_hit")
	

	@XmlElement
	Integer userHit;
	/**
	 */

	@Column(name = "admin_hit")
	

	@XmlElement
	Integer adminHit;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	

	@CreatedBy
	String createUserId;
	/**
	 */
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

	/**
	 */
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false) })
	@XmlTransient
	UserDetails userDetails;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "eir_id", referencedColumnName = "eir_id") })
	@XmlTransient
	EntityDetails entityDetails;
	/**
	 */
	/* @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Status status;*/
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "product_id", referencedColumnName = "product_id") })
	@XmlTransient
	ProductMaster productMaster;
	/**
	 */
	@OneToMany(mappedBy = "request", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.BirRequest> birRequests;
	/**
	 */
	@OneToOne(mappedBy = "request", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	KycApproval kycApproval;
	/**
	 */
	@OneToMany(mappedBy = "request", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.CirRequest> cirRequets;
	/**
	 */
	@OneToMany(mappedBy = "request", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.ConsumerRequet> consumerRequets;

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
	public void setErnNumber(String ernNumber) {
		this.ernNumber = ernNumber;
	}

	/**
	 */
	public String getErnNumber() {
		return this.ernNumber;
	}

	/**
	 */
	public void setScore(String score) {
		this.score = score;
	}

	/**
	 */
	public String getScore() {
		return this.score;
	}

	/**
	 */
	public void setUserHit(Integer userHit) {
		this.userHit = userHit;
	}

	/**
	 */
	public Integer getUserHit() {
		return this.userHit;
	}

	/**
	 */
	public void setAdminHit(Integer adminHit) {
		this.adminHit = adminHit;
	}

	/**
	 */
	public Integer getAdminHit() {
		return this.adminHit;
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
	public void setEntityDetails(EntityDetails entityDetails) {
		this.entityDetails = entityDetails;
	}

	/**
	 */
	public EntityDetails getEntityDetails() {
		return entityDetails;
	}

	/**
	 */
	public void setProductMaster(ProductMaster productMaster) {
		this.productMaster = productMaster;
	}

	/**
	 */
	public ProductMaster getProductMaster() {
		return productMaster;
	}
	
	/**
	 */
	public void setBirRequests(Set<BirRequest> birRequests) {
		this.birRequests = birRequests;
	}

	/**
	 */
	public Set<BirRequest> getBirRequests() {
		if (birRequests == null) {
			birRequests = new java.util.LinkedHashSet<com.eir.report.entity.BirRequest>();
		}
		return birRequests;
	}

	/**
	 */
	public void setKycApproval(KycApproval kycApproval) {
		this.kycApproval = kycApproval;
	}

	/**
	 */
	public KycApproval getKycApproval() {
		return kycApproval;
	}

	/**
	 */
	public void setCirRequets(Set<CirRequest> cirRequets) {
		this.cirRequets = cirRequets;
	}

	/**
	 */
	public Set<CirRequest> getCirRequets() {
		if (cirRequets == null) {
			cirRequets = new java.util.LinkedHashSet<com.eir.report.entity.CirRequest>();
		}
		return cirRequets;
	}

	/**
	 */
	public void setConsumerRequets(Set<ConsumerRequet> consumerRequets) {
		this.consumerRequets = consumerRequets;
	}

	/**
	 */
	public Set<ConsumerRequet> getConsumerRequets() {
		if (consumerRequets == null) {
			consumerRequets = new java.util.LinkedHashSet<com.eir.report.entity.ConsumerRequet>();
		}
		return consumerRequets;
	}

	/**
	 */
	public Request() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
		
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
}
