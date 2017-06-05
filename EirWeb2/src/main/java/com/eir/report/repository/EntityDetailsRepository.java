package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.EntityDetails;

public interface EntityDetailsRepository extends JpaRepository<EntityDetails, Integer> {
	
	public EntityDetails findByEntityCin(final String entityCin);

}