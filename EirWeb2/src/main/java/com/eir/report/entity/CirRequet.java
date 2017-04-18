
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@Table(catalog = "eir", name = "cir_requet")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "CirRequet")

public class CirRequet implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "cir_requet_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer cirRequetId;
	/**
	 */

	@Column(name = "ern_number", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String ernNumber;
	/**
	 */

	@Column(name = "xml_output", columnDefinition = "BLOB")
	@Basic(fetch = FetchType.EAGER)
	@Lob

	@XmlElement
	byte[] xmlOutput;
	/**
	 */

	@Column(name = "score", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String score;
	/**
	 */

	@Column(name = "status", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String status;
	/**
	 */

	@Column(name = "cir_requetcol", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol;
	/**
	 */

	@Column(name = "cir_requetcol1", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol1;
	/**
	 */

	@Column(name = "cir_requetcol2", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol2;
	/**
	 */

	@Column(name = "cir_requetcol3", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol3;
	/**
	 */

	@Column(name = "cir_requetcol4", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol4;
	/**
	 */

	@Column(name = "cir_requetcol5", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol5;
	/**
	 */

	@Column(name = "cir_requetcol6", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol6;
	/**
	 */

	@Column(name = "cir_requetcol7", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol7;
	/**
	 */

	@Column(name = "cir_requetcol8", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol8;
	/**
	 */

	@Column(name = "cir_requetcol9", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol9;
	/**
	 */

	@Column(name = "cir_requetcol10", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol10;
	/**
	 */

	@Column(name = "cir_requetcol11", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol11;
	/**
	 */

	@Column(name = "cir_requetcol12", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol12;
	/**
	 */

	@Column(name = "cir_requetcol13", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String cirRequetcol13;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "requet_id", referencedColumnName = "request_id") })
	@XmlTransient
	Request request;

	/**
	 */
	public void setCirRequetId(Integer cirRequetId) {
		this.cirRequetId = cirRequetId;
	}

	/**
	 */
	public Integer getCirRequetId() {
		return this.cirRequetId;
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
	public void setXmlOutput(byte[] xmlOutput) {
		this.xmlOutput = xmlOutput;
	}

	/**
	 */
	public byte[] getXmlOutput() {
		return this.xmlOutput;
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
	public void setCirRequetcol(String cirRequetcol) {
		this.cirRequetcol = cirRequetcol;
	}

	/**
	 */
	public String getCirRequetcol() {
		return this.cirRequetcol;
	}

	/**
	 */
	public void setCirRequetcol1(String cirRequetcol1) {
		this.cirRequetcol1 = cirRequetcol1;
	}

	/**
	 */
	public String getCirRequetcol1() {
		return this.cirRequetcol1;
	}

	/**
	 */
	public void setCirRequetcol2(String cirRequetcol2) {
		this.cirRequetcol2 = cirRequetcol2;
	}

	/**
	 */
	public String getCirRequetcol2() {
		return this.cirRequetcol2;
	}

	/**
	 */
	public void setCirRequetcol3(String cirRequetcol3) {
		this.cirRequetcol3 = cirRequetcol3;
	}

	/**
	 */
	public String getCirRequetcol3() {
		return this.cirRequetcol3;
	}

	/**
	 */
	public void setCirRequetcol4(String cirRequetcol4) {
		this.cirRequetcol4 = cirRequetcol4;
	}

	/**
	 */
	public String getCirRequetcol4() {
		return this.cirRequetcol4;
	}

	/**
	 */
	public void setCirRequetcol5(String cirRequetcol5) {
		this.cirRequetcol5 = cirRequetcol5;
	}

	/**
	 */
	public String getCirRequetcol5() {
		return this.cirRequetcol5;
	}

	/**
	 */
	public void setCirRequetcol6(String cirRequetcol6) {
		this.cirRequetcol6 = cirRequetcol6;
	}

	/**
	 */
	public String getCirRequetcol6() {
		return this.cirRequetcol6;
	}

	/**
	 */
	public void setCirRequetcol7(String cirRequetcol7) {
		this.cirRequetcol7 = cirRequetcol7;
	}

	/**
	 */
	public String getCirRequetcol7() {
		return this.cirRequetcol7;
	}

	/**
	 */
	public void setCirRequetcol8(String cirRequetcol8) {
		this.cirRequetcol8 = cirRequetcol8;
	}

	/**
	 */
	public String getCirRequetcol8() {
		return this.cirRequetcol8;
	}

	/**
	 */
	public void setCirRequetcol9(String cirRequetcol9) {
		this.cirRequetcol9 = cirRequetcol9;
	}

	/**
	 */
	public String getCirRequetcol9() {
		return this.cirRequetcol9;
	}

	/**
	 */
	public void setCirRequetcol10(String cirRequetcol10) {
		this.cirRequetcol10 = cirRequetcol10;
	}

	/**
	 */
	public String getCirRequetcol10() {
		return this.cirRequetcol10;
	}

	/**
	 */
	public void setCirRequetcol11(String cirRequetcol11) {
		this.cirRequetcol11 = cirRequetcol11;
	}

	/**
	 */
	public String getCirRequetcol11() {
		return this.cirRequetcol11;
	}

	/**
	 */
	public void setCirRequetcol12(String cirRequetcol12) {
		this.cirRequetcol12 = cirRequetcol12;
	}

	/**
	 */
	public String getCirRequetcol12() {
		return this.cirRequetcol12;
	}

	/**
	 */
	public void setCirRequetcol13(String cirRequetcol13) {
		this.cirRequetcol13 = cirRequetcol13;
	}

	/**
	 */
	public String getCirRequetcol13() {
		return this.cirRequetcol13;
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
	public CirRequet() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(CirRequet that) {
		setCirRequetId(that.getCirRequetId());
		setErnNumber(that.getErnNumber());
		setXmlOutput(that.getXmlOutput());
		setScore(that.getScore());
		setStatus(that.getStatus());
		setCirRequetcol(that.getCirRequetcol());
		setCirRequetcol1(that.getCirRequetcol1());
		setCirRequetcol2(that.getCirRequetcol2());
		setCirRequetcol3(that.getCirRequetcol3());
		setCirRequetcol4(that.getCirRequetcol4());
		setCirRequetcol5(that.getCirRequetcol5());
		setCirRequetcol6(that.getCirRequetcol6());
		setCirRequetcol7(that.getCirRequetcol7());
		setCirRequetcol8(that.getCirRequetcol8());
		setCirRequetcol9(that.getCirRequetcol9());
		setCirRequetcol10(that.getCirRequetcol10());
		setCirRequetcol11(that.getCirRequetcol11());
		setCirRequetcol12(that.getCirRequetcol12());
		setCirRequetcol13(that.getCirRequetcol13());
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

		buffer.append("cirRequetId=[").append(cirRequetId).append("] ");
		buffer.append("ernNumber=[").append(ernNumber).append("] ");
		buffer.append("xmlOutput=[").append(xmlOutput).append("] ");
		buffer.append("score=[").append(score).append("] ");
		buffer.append("status=[").append(status).append("] ");
		buffer.append("cirRequetcol=[").append(cirRequetcol).append("] ");
		buffer.append("cirRequetcol1=[").append(cirRequetcol1).append("] ");
		buffer.append("cirRequetcol2=[").append(cirRequetcol2).append("] ");
		buffer.append("cirRequetcol3=[").append(cirRequetcol3).append("] ");
		buffer.append("cirRequetcol4=[").append(cirRequetcol4).append("] ");
		buffer.append("cirRequetcol5=[").append(cirRequetcol5).append("] ");
		buffer.append("cirRequetcol6=[").append(cirRequetcol6).append("] ");
		buffer.append("cirRequetcol7=[").append(cirRequetcol7).append("] ");
		buffer.append("cirRequetcol8=[").append(cirRequetcol8).append("] ");
		buffer.append("cirRequetcol9=[").append(cirRequetcol9).append("] ");
		buffer.append("cirRequetcol10=[").append(cirRequetcol10).append("] ");
		buffer.append("cirRequetcol11=[").append(cirRequetcol11).append("] ");
		buffer.append("cirRequetcol12=[").append(cirRequetcol12).append("] ");
		buffer.append("cirRequetcol13=[").append(cirRequetcol13).append("] ");
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
		result = (int) (prime * result + ((cirRequetId == null) ? 0 : cirRequetId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof CirRequet))
			return false;
		CirRequet equalCheck = (CirRequet) obj;
		if ((cirRequetId == null && equalCheck.cirRequetId != null) || (cirRequetId != null && equalCheck.cirRequetId == null))
			return false;
		if (cirRequetId != null && !cirRequetId.equals(equalCheck.cirRequetId))
			return false;
		return true;
	}
}
