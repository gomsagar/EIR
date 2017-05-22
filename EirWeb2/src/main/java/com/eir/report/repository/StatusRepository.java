package com.eir.report.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.Status;

public interface StatusRepository extends JpaRepository<Status , Integer> {
	
	public Status findBystatusDescription(String statusDescription);
}
