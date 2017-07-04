package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.CirRequest;
import com.eir.report.entity.UserDetails;

public interface CirRequestRepository extends JpaRepository<CirRequest, Integer> {
	
	@Query(value = "select cr.REQUEST_ID,s.STATUS_DESCRIPTION, cr.WITH_SCORE from CIR_REQUEST cr inner join REQUEST r on r.REQUEST_ID = cr.REQUEST_ID "
			+"inner join STATUS s on cr.STATUS_ID = s.STATUS_ID where cr.REQUEST_ID =:requestID",
			nativeQuery=true)
	public List<Object[]> getCirRequestByRequestId(@Param("requestID") Integer requestID);
	
	@Query(value = "select cr.REQUEST_ID,s.STATUS_DESCRIPTION, cr.WITH_SCORE from CIR_REQUEST cr inner join REQUEST r on r.REQUEST_ID = cr.REQUEST_ID "
			+"inner join STATUS s on cr.STATUS_ID = s.STATUS_ID where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate",
			nativeQuery=true)
	public List<Object[]> getCirRequestByDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	@Query(value = "select cr.REQUEST_ID,s.STATUS_DESCRIPTION, cr.WITH_SCORE from CIR_REQUEST cr inner join REQUEST r on r.REQUEST_ID = cr.REQUEST_ID "
			+"inner join STATUS s on cr.STATUS_ID = s.STATUS_ID where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate and cr.REQUEST_ID =:requestID",
			nativeQuery=true)
	public List<Object[]> getCirRequestByDateAndRequestId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("requestID") Integer requestID);

}
