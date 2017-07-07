
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.persistence.*;

/**
 */

@Entity
@Table(name = "member", schema = "eir")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "memberid", nullable = false)
	

	@Id
	@XmlElement
	Integer memberid;
	/**
	 */

	@Column(name = "name", length = 45)
	

	@XmlElement
	String name;
	/**
	 */

	@Column(name = "mailid", length = 45)
	

	@XmlElement
	String mailid;
	
    @Column(name = "MEMBER_TYPE", length = 45)
	String memberType;

	/**
	 */
	@OneToMany(mappedBy = "member", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.MemberUserMapping> memberUserMappings;
	/**
	 */
	@OneToMany(mappedBy = "member", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.entity.MemberProductMapping> memberProductMappings;

	/**
	 */
	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	/**
	 */
	public Integer getMemberid() {
		return this.memberid;
	}

	/**
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
	}

	/**
	 */
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	/**
	 */
	public String getMailid() {
		return this.mailid;
	}

	/**
	 */
	public void setMemberUserMappings(Set<MemberUserMapping> memberUserMappings) {
		this.memberUserMappings = memberUserMappings;
	}

	/**
	 */
	public Set<MemberUserMapping> getMemberUserMappings() {
		if (memberUserMappings == null) {
			memberUserMappings = new java.util.LinkedHashSet<com.eir.report.entity.MemberUserMapping>();
		}
		return memberUserMappings;
	}

	/**
	 */
	public void setMemberProductMappings(Set<MemberProductMapping> memberProductMappings) {
		this.memberProductMappings = memberProductMappings;
	}

	/**
	 */
	public Set<MemberProductMapping> getMemberProductMappings() {
		if (memberProductMappings == null) {
			memberProductMappings = new java.util.LinkedHashSet<com.eir.report.entity.MemberProductMapping>();
		}
		return memberProductMappings;
	}

	/**
	 */
	public Member() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Member that) {
		setMemberid(that.getMemberid());
		setName(that.getName());
		setMailid(that.getMailid());
		setMemberUserMappings(new java.util.LinkedHashSet<com.eir.report.entity.MemberUserMapping>(that.getMemberUserMappings()));
		setMemberProductMappings(new java.util.LinkedHashSet<com.eir.report.entity.MemberProductMapping>(that.getMemberProductMappings()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("memberid=[").append(memberid).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("mailid=[").append(mailid).append("] ");

		return buffer.toString();
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
}
