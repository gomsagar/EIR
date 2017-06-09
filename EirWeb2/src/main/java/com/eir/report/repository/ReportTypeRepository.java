package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.ReportType;

public interface ReportTypeRepository extends JpaRepository<ReportType, Integer>{
	
	ReportType findByreportTypeId(String id);

}
