
package com.eir.report.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllErrorMessagess", query = "select myErrorMessages from ErrorMessages myErrorMessages"),
		@NamedQuery(name = "findErrorMessagesByErrorCode", query = "select myErrorMessages from ErrorMessages myErrorMessages where myErrorMessages.errorCode = ?1"),
		@NamedQuery(name = "findErrorMessagesByErrorCodeContaining", query = "select myErrorMessages from ErrorMessages myErrorMessages where myErrorMessages.errorCode like ?1"),
		@NamedQuery(name = "findErrorMessagesByErrorMessagesField", query = "select myErrorMessages from ErrorMessages myErrorMessages where myErrorMessages.errorMessagesField = ?1"),
		@NamedQuery(name = "findErrorMessagesByErrorMessagesFieldContaining", query = "select myErrorMessages from ErrorMessages myErrorMessages where myErrorMessages.errorMessagesField like ?1"),
		@NamedQuery(name = "findErrorMessagesById", query = "select myErrorMessages from ErrorMessages myErrorMessages where myErrorMessages.id = ?1"),
		@NamedQuery(name = "findErrorMessagesByPrimaryKey", query = "select myErrorMessages from ErrorMessages myErrorMessages where myErrorMessages.id = ?1") })

@Table(catalog = "eir", name = "error_messages")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "ErrorMessages")

public class ErrorMessages implements Serializable {
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

	@Column(name = "error_code", length = 45, nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String errorCode;
	/**
	 */

	@Column(name = "error_messages", length = 200, nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String errorMessagesField;

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
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 */
	public String getErrorCode() {
		return this.errorCode;
	}

	/**
	 */
	public void setErrorMessagesField(String errorMessagesField) {
		this.errorMessagesField = errorMessagesField;
	}

	/**
	 */
	public String getErrorMessagesField() {
		return this.errorMessagesField;
	}

	/**
	 */
	public ErrorMessages() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(ErrorMessages that) {
		setId(that.getId());
		setErrorCode(that.getErrorCode());
		setErrorMessagesField(that.getErrorMessagesField());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("errorCode=[").append(errorCode).append("] ");
		buffer.append("errorMessagesField=[").append(errorMessagesField).append("] ");

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
		if (!(obj instanceof ErrorMessages))
			return false;
		ErrorMessages equalCheck = (ErrorMessages) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
