
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
		@NamedQuery(name = "findAllMembers", query = "select myMember from Member myMember"),
		@NamedQuery(name = "findMemberByMailid", query = "select myMember from Member myMember where myMember.mailid = ?1"),
		@NamedQuery(name = "findMemberByMailidContaining", query = "select myMember from Member myMember where myMember.mailid like ?1"),
		@NamedQuery(name = "findMemberByMemberid", query = "select myMember from Member myMember where myMember.memberid = ?1"),
		@NamedQuery(name = "findMemberByName", query = "select myMember from Member myMember where myMember.name = ?1"),
		@NamedQuery(name = "findMemberByNameContaining", query = "select myMember from Member myMember where myMember.name like ?1"),
		@NamedQuery(name = "findMemberByPrimaryKey", query = "select myMember from Member myMember where myMember.memberid = ?1") })

@Table(catalog = "eir", name = "member")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "entity2/com/eir/report/domain", name = "Member")
@XmlRootElement(namespace = "entity2/com/eir/report/domain")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "memberid", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@XmlElement
	Integer memberid;
	/**
	 */

	@Column(name = "name", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String name;
	/**
	 */

	@Column(name = "mailid", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String mailid;

	/**
	 */
	@OneToMany(mappedBy = "member", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.domain.MemberUserMapping> memberUserMappings;
	/**
	 */
	@OneToMany(mappedBy = "member", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)

	@XmlElement(name = "", namespace = "")
	java.util.Set<com.eir.report.domain.MemberProductMapping> memberProductMappings;

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
			memberUserMappings = new java.util.LinkedHashSet<com.eir.report.domain.MemberUserMapping>();
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
			memberProductMappings = new java.util.LinkedHashSet<com.eir.report.domain.MemberProductMapping>();
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
		setMemberUserMappings(new java.util.LinkedHashSet<com.eir.report.domain.MemberUserMapping>(that.getMemberUserMappings()));
		setMemberProductMappings(new java.util.LinkedHashSet<com.eir.report.domain.MemberProductMapping>(that.getMemberProductMappings()));
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

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((memberid == null) ? 0 : memberid.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Member))
			return false;
		Member equalCheck = (Member) obj;
		if ((memberid == null && equalCheck.memberid != null) || (memberid != null && equalCheck.memberid == null))
			return false;
		if (memberid != null && !memberid.equals(equalCheck.memberid))
			return false;
		return true;
	}
}
