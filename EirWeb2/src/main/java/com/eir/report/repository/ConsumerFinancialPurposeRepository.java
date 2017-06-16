package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.ConsumerFinancialPurpose;

public interface ConsumerFinancialPurposeRepository extends JpaRepository<ConsumerFinancialPurpose, Integer> {

	List<ConsumerFinancialPurpose> findBypurposeId(Integer purposeId);
}
