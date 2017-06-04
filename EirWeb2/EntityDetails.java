
package com.eir.report.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllEntityDetailss", query = "select myEntityDetails from EntityDetails myEntityDetails"),
		@NamedQuery(name = "findEntityDetailsByCreateUserDate", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.createUserDate = ?1"),
		@NamedQuery(name = "findEntityDetailsByCreateUserDateAfter", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.createUserDate > ?1"),
		@NamedQuery(name = "findEntityDetailsByCreateUserDateBefore", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.createUserDate < ?1"),
		@NamedQuery(name = "findEntityDetailsByCreateUserId", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.createUserId = ?1"),
		@NamedQuery(name = "findEntityDetailsByCreateUserIdContaining", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.createUserId like ?1"),
		@NamedQuery(name = "findEntityDetailsByEirId", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.eirId = ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityCin", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityCin = ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityCinContaining", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityCin like ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityName", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityName = ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityNameContaining", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityName like ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityPan", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityPan = ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityPanContaining", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityPan like ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityTan", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityTan = ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityTanContaining", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityTan like ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityTin", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityTin = ?1"),
		@NamedQuery(name = "findEntityDetailsByEntityTinContaining", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.entityTin like ?1"),
		@NamedQuery(name = "findEntityDetailsByMemberId", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.memberId = ?1"),
		@NamedQuery(name = "findEntityDetailsByPrimaryKey", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.eirId = ?1"),
		@NamedQuery(name = "findEntityDetailsByUpdateUserDate", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.updateUserDate = ?1"),
		@NamedQuery(name = "findEntityDetailsByUpdateUserDateAfter", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.updateUserDate > ?1"),
		@NamedQuery(name = "findEntityDetailsByUpdateUserDateBefore", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.updateUserDate < ?1"),
		@NamedQuery(name = "findEntityDetailsByUpdateUserId", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.updateUserId = ?1"),
		@NamedQuery(name = "findEntityDetailsByUpdateUserIdContaining", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.updateUserId like ?1"),
		@NamedQuery(name = "findEntityDetailsByUserId", query = "select myEntityDetails from EntityDetails myEntityDetails where myEntityDetails.userId = ?1") })

@Table(catalog = "eir", name = "entity_details")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "EntityDetails")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class EntityDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "eir_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer eirId;
	/**
	 */

	@Column(name = "member_id")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer memberId;
	/**
	 */

	@Column(name = "user_id")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "entity_name", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String entityName;
	/**
	 */

	@Column(name = "entity_pan", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String entityPan;
	/**
	 */

	@Column(name = "entity_tan", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String entityTan;
	/**
	 */

	@Column(name = "entity_cin", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String entityCin;
	/**
	 */

	@Column(name = "entity_tin", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String entityTin;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String createUserId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "create_user_date")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Calendar createUserDate;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String updateUserId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "update_user_date")
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	Calendar updateUserDate;

	/**
	 */
	@OneToMany(mappedBy = "entityDetails", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.domain.Request> requests;

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
	public void setCreateUserDate(Calendar createUserDate) {
		this.createUserDate = createUserDate;
	}

	/**
	 */
	public Calendar getCreateUserDate() {
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
	public void setUpdateUserDate(Calendar updateUserDate) {
		this.updateUserDate = updateUserDate;
	}

	/**
	 */
	public Calendar getUpdateUserDate() {
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
			requests = new java.util.LinkedHashSet<com.eir.report.domain.Request>();
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
		setRequests(new java.util.LinkedHashSet<com.eir.report.domain.Request>(that.getRequests()));
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
