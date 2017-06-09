package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.AddressType;

public interface AddressTypeRepository extends JpaRepository<AddressType, Integer> {
	
	AddressType findByAddressTypeId(Integer id);

}
