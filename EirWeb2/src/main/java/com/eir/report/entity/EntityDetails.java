
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
@Table(name = "entity_details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "EntityDetails")
@XmlRootElement(namespace = "eir/com/eir/report/entity")
@EntityListeners(AuditingEntityListener.class)
public class EntityDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "eir_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="entity_seq")
	@SequenceGenerator(
		name="entity_seq",
		sequenceName="entity_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer eirId;
	/**
	 */

	@Column(name = "member_id")
	

	@XmlElement
	Integer memberId;
	/**
	 */

	@Column(name = "user_id")
	

	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "entity_name", length = 45)
	

	@XmlElement
	String entityName;
	/**
	 */

	@Column(name = "entity_pan", length = 45)
	

	@XmlElement
	String entityPan;
	/**
	 */

	@Column(name = "entity_tan", length = 45)
	

	@XmlElement
	String entityTan;
	/**
	 */

	@Column(name = "entity_cin", length = 45)
	

	@XmlElement
	String entityCin;
	/**
	 */

	@Column(name = "entity_tin", length = 45)
	

	@XmlElement
	String entityTin;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	

	@CreatedBy
	String createUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
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
	//@Temporal(TemporalType.DATE)
	@Column(name = "update_date")
	

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;

	/**
	 */
	@OneToMany(mappedBy = "entityDetails", fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.Request> requests;

	/**
	 */
	public void setEirId(Integer eirId) {
		this.eirId = eirId;
	}

	/**
	 */
	public Integer getEirId() {
		return this.eirId;
	}

	/**
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 */
	public Integer getMemberId() {
		return this.memberId;
	}

	/**
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 */
	public String getEntityName() {
		return this.entityName;
	}

	/**
	 */
	public void setEntityPan(String entityPan) {
		this.entityPan = entityPan;
	}

	/**
	 */
	public String getEntityPan() {
		return this.entityPan;
	}

	/**
	 */
	public void setEntityTan(String entityTan) {
		this.entityTan = entityTan;
	}

	/**
	 */
	public String getEntityTan() {
		return this.entityTan;
	}

	/**
	 */
	public void setEntityCin(String entityCin) {
		this.entityCin = entityCin;
	}

	/**
	 */
	public String getEntityCin() {
		return this.entityCin;
	}

	/**
	 */
	public void setEntityTin(String entityTin) {
		this.entityTin = entityTin;
	}

	/**
	 */
	public String getEntityTin() {
		return this.entityTin;
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
	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

	/**
	 */
	public Set<Request> getRequests() {
		if (requests == null) {
			requests = new java.util.LinkedHashSet<com.eir.report.entity.Request>();
		}
		return requests;
	}

	/**
	 */
	public EntityDetails() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(EntityDetails that) {
		setEirId(that.getEirId());
		setMemberId(that.getMemberId());
		setUserId(that.getUserId());
		setEntityName(that.getEntityName());
		setEntityPan(that.getEntityPan());
		setEntityTan(that.getEntityTan());
		setEntityCin(that.getEntityCin());
		setEntityTin(that.getEntityTin());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
		setRequests(new java.util.LinkedHashSet<com.eir.report.entity.Request>(that.getRequests()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("eirId=[").append(eirId).append("] ");
		buffer.append("memberId=[").append(memberId).append("] ");
		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("entityName=[").append(entityName).append("] ");
		buffer.append("entityPan=[").append(entityPan).append("] ");
		buffer.append("entityTan=[").append(entityTan).append("] ");
		buffer.append("entityCin=[").append(entityCin).append("] ");
		buffer.append("entityTin=[").append(entityTin).append("] ");
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
		result = (int) (prime * result + ((eirId == null) ? 0 : eirId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof EntityDetails))
			return false;
		EntityDetails equalCheck = (EntityDetails) obj;
		if ((eirId == null && equalCheck.eirId != null) || (eirId != null && equalCheck.eirId == null))
			return false;
		if (eirId != null && !eirId.equals(equalCheck.eirId))
			return false;
		return true;
	}
}
