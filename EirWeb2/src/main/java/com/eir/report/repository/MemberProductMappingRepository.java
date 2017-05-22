package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.BirRequest;
import com.eir.report.entity.MemberProductMapping;

public interface MemberProductMappingRepository extends JpaRepository<MemberProductMapping, Integer>  {

}
