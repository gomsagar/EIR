
package com.eir.report.entity;

import java.io.Serializable;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
@Table(name = "user_access")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "UserAccess")

@EntityListeners(AuditingEntityListener.class)
public class UserAccess implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "user_id", nullable = false)
	

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
	@SequenceGenerator(
		name="user_seq",
		sequenceName="userId_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer userId;
	/**
	 */

	@Column(name = "category_id")
	

	@XmlElement
	Integer categoryId;
	/**
	 */

	@Column(name = "role_1", length = 45)
	

	@XmlElement
	String role1;
	/**
	 */

	@Column(name = "role_2", length = 45)
	

	@XmlElement
	String role2;
	/**
	 */

	@Column(name = "role_3", length = 45)
	

	@XmlElement
	String role3;
	/**
	 */

	@Column(name = "role_4", length = 45)
	

	@XmlElement
	String role4;
	/**
	 */

	@Column(name = "role_5", length = 45)
	

	@XmlElement
	String role5;
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
	@JoinColumns({ @JoinColumn(name = "category_id", referencedColumnName = "user_category_id" , insertable = false, updatable = false) })
	@XmlTransient
	UserCategory userCategory;

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
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 */
	public Integer getCategoryId() {
		return this.categoryId;
	}

	/**
	 */
	public void setRole1(String role1) {
		this.role1 = role1;
	}

	/**
	 */
	public String getRole1() {
		return this.role1;
	}

	/**
	 */
	public void setRole2(String role2) {
		this.role2 = role2;
	}

	/**
	 */
	public String getRole2() {
		return this.role2;
	}

	/**
	 */
	public void setRole3(String role3) {
		this.role3 = role3;
	}

	/**
	 */
	public String getRole3() {
		return this.role3;
	}

	/**
	 */
	public void setRole4(String role4) {
		this.role4 = role4;
	}

	/**
	 */
	public String getRole4() {
		return this.role4;
	}

	/**
	 */
	public void setRole5(String role5) {
		this.role5 = role5;
	}

	/**
	 */
	public String getRole5() {
		return this.role5;
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
	public void setUserCategory(UserCategory userCategory) {
		this.userCategory = userCategory;
	}

	/**
	 */
	public UserCategory getUserCategory() {
		return userCategory;
	}

	/**
	 */
	public UserAccess() {
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("userId=[").append(userId).append("] ");
		buffer.append("role1=[").append(role1).append("] ");
		buffer.append("role2=[").append(role2).append("] ");
		buffer.append("role3=[").append(role3).append("] ");
		buffer.append("role4=[").append(role4).append("] ");
		buffer.append("role5=[").append(role5).append("] ");
		buffer.append("createUserId=[").append(createUserId).append("] ");
		buffer.append("createUserDate=[").append(createUserDate).append("] ");
		buffer.append("updateUserId=[").append(updateUserId).append("] ");
		buffer.append("updateUserDate=[").append(updateUserDate).append("] ");

		return buffer.toString();
	}
}
