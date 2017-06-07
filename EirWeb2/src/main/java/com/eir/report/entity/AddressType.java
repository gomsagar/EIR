package com.eir.report.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

@Component
@Entity

@Table(name = "address_type")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "eir/com/eir/report/entity", name = "AddressType")

@EntityListeners(AuditingEntityListener.class)
public class AddressType {
	
	@Column(name = "id", nullable = false)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="addrType_seq")
	@SequenceGenerator(
		name="addrType_seq",
		sequenceName="addressType_sequence",
		allocationSize=1
	)
	@XmlElement
	String addressTypeId;
	
	@Column(name = "description", length = 45)
	

	@XmlElement
	String addressTypeDescription;
	
	
	public String getAddressTypeId() {
		return addressTypeId;
	}
	public void setAddressTypeId(String addressTypeId) {
		this.addressTypeId = addressTypeId;
	}
	public String getAddressTypeDescription() {
		return addressTypeDescription;
	}
	public void setAddressTypeDescription(String addressTypeDescription) {
		this.addressTypeDescription = addressTypeDescription;
	}
}
