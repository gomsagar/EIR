
package com.eir.report.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

/**
 */

@Component
@Entity

@Table(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "Address")

@EntityListeners(AuditingEntityListener.class)
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "address_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="addr_seq")
	@SequenceGenerator(
		name="addr_seq",
		sequenceName="address_sequence",
		allocationSize=1
	)
	@XmlElement
	Integer addressId;
	/**
	 */

	@Column(name = "address_type", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String addressType;
	/**
	 */

	@Column(name = "address_line_1", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String addressLine1;
	/**
	 */

	@Column(name = "address_line_2", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String addressLine2;
	/**
	 */

	@Column(name = "address_line_3", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String addressLine3;
	/**
	 */

	@Column(name = "city", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String city;
	/**
	 */

	@Column(name = "pincode", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String pincode;
	/**
	 */

	@Column(name = "state", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@XmlElement
	String state;
	/**
	 */

	@Column(name = "create_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@CreatedBy
	String createUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "create_user_date")
	@Basic(fetch = FetchType.EAGER)

	@CreatedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime createUserDate ;
	/**
	 */

	@Column(name = "update_user_id", length = 45)
	@Basic(fetch = FetchType.EAGER)

	@LastModifiedBy
	String updateUserId;
	/**
	 */
	//@Temporal(TemporalType.DATE)
	@Column(name = "update_user_date")
	@Basic(fetch = FetchType.EAGER)

	@LastModifiedDate
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	DateTime updateUserDate ;

	/**
	 */
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	/**
	 */
	public Integer getAddressId() {
		return this.addressId;
	}

	/**
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	/**
	 */
	public String getAddressType() {
		return this.addressType;
	}

	/**
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 */
	public String getAddressLine1() {
		return this.addressLine1;
	}

	/**
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 */
	public String getAddressLine2() {
		return this.addressLine2;
	}

	/**
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 */
	public String getAddressLine3() {
		return this.addressLine3;
	}

	/**
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 */
	public String getPincode() {
		return this.pincode;
	}

	/**
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 */
	public String getState() {
		return this.state;
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
	public Address() {
		System.out.println("Address constructor");
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Address that) {
		setAddressId(that.getAddressId());
		setAddressType(that.getAddressType());
		setAddressLine1(that.getAddressLine1());
		setAddressLine2(that.getAddressLine2());
		setAddressLine3(that.getAddressLine3());
		setCity(that.getCity());
		setPincode(that.getPincode());
		setState(that.getState());
		setCreateUserId(that.getCreateUserId());
		setCreateUserDate(that.getCreateUserDate());
		setUpdateUserId(that.getUpdateUserId());
		setUpdateUserDate(that.getUpdateUserDate());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("addressId=[").append(addressId).append("] ");
		buffer.append("addressType=[").append(addressType).append("] ");
		buffer.append("addressLine1=[").append(addressLine1).append("] ");
		buffer.append("addressLine2=[").append(addressLine2).append("] ");
		buffer.append("addressLine3=[").append(addressLine3).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("pincode=[").append(pincode).append("] ");
		buffer.append("state=[").append(state).append("] ");
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
		result = (int) (prime * result + ((addressId == null) ? 0 : addressId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Address))
			return false;
		Address equalCheck = (Address) obj;
		if ((addressId == null && equalCheck.addressId != null) || (addressId != null && equalCheck.addressId == null))
			return false;
		if (addressId != null && !addressId.equals(equalCheck.addressId))
			return false;
		return true;
	}
}
