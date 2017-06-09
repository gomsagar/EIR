
package com.eir.report.entity;

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
@Table(catalog = "eir", name = "error_messages")

public class ErrorMessages implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	

	@Id
	Integer id;
	/**
	 */

	@Column(name = "error_code", length = 45, nullable = false)
	

	String errorCode;
	/**
	 */

	@Column(name = "error_messages", length = 200, nullable = false)
	

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
}
