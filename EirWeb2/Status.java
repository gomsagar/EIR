
package com.eir.report.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

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
		@NamedQuery(name = "findAllStatuss", query = "select myStatus from Status myStatus"),
		@NamedQuery(name = "findStatusById", query = "select myStatus from Status myStatus where myStatus.id = ?1"),
		@NamedQuery(name = "findStatusByPrimaryKey", query = "select myStatus from Status myStatus where myStatus.id = ?1"),
		@NamedQuery(name = "findStatusByStatusDescription", query = "select myStatus from Status myStatus where myStatus.statusDescription = ?1"),
		@NamedQuery(name = "findStatusByStatusDescriptionContaining", query = "select myStatus from Status myStatus where myStatus.statusDescription like ?1") })

@Table(catalog = "eir", name = "status")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "Status")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "status_description", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String statusDescription;

	/**
	 */
	@OneToMany(mappedBy = "status", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.domain.Request> requests;

	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	/**
	 */
	public String getStatusDescription() {
		return this.statusDescription;
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
	public Status() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Status that) {
		setId(that.getId());
		setStatusDescription(that.getStatusDescription());
		setRequests(new java.util.LinkedHashSet<com.eir.report.domain.Request>(that.getRequests()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("statusDescription=[").append(statusDescription).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Status))
			return false;
		Status equalCheck = (Status) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
