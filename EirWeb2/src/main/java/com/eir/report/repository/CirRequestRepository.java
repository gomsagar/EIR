package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.CirRequest;
import com.eir.report.entity.UserDetails;

public interface CirRequestRepository extends JpaRepository<CirRequest, Integer> {
	
	@Query(value = "select cr.REQUEST_ID,s.STATUS_DESCRIPTION, cr.WITH_SCORE from CIR_REQUEST cr inner join REQUEST r on r.REQUEST_ID = cr.REQUEST_ID "
			+"inner join STATUS s on cr.STATUS_ID = s.STATUS_ID "
			+ "inner join USER_DETAILS ud on r.USER_ID = ud.USER_ID where r.USER_ID =:userId",
			nativeQuery=true)
	public List<Object[]> getCirRequestByUserId(@Param("userId") Integer userId);

}
