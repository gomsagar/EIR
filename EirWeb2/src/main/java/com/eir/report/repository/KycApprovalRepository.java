package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.KycApproval;

public interface KycApprovalRepository extends JpaRepository<KycApproval, Integer> {

}
