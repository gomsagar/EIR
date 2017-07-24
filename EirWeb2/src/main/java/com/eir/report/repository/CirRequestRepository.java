package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CirRequest;
import com.eir.report.entity.UserDetails;

public interface CirRequestRepository extends JpaRepository<CirRequest, Integer> {
	
	public CirRequest findByCirRequestId(Integer cirRequestId);
	
	@Query(value = "select cr.REQUEST_ID,s.STATUS_DESCRIPTION, cr.WITH_SCORE from eir.CIR_REQUEST cr inner join eir.REQUEST r on r.REQUEST_ID = cr.REQUEST_ID "
			+"inner join eir.STATUS s on cr.STATUS_ID = s.STATUS_ID where cr.REQUEST_ID =:requestID and r.USER_ID =:userId",
			nativeQuery=true)
	public List<Object[]> getCirRequestByRequestId(@Param("requestID") Long requestID,@Param("userId") Integer userId);
	
	@Query(value = "select cr.REQUEST_ID,s.STATUS_DESCRIPTION, cr.WITH_SCORE from eir.CIR_REQUEST cr inner join eir.REQUEST r on r.REQUEST_ID = cr.REQUEST_ID "
			+"inner join eir.STATUS s on cr.STATUS_ID = s.STATUS_ID where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate and r.USER_ID =:userId",
			nativeQuery=true)
	public List<Object[]> getCirRequestByDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("userId") Integer userId);
	
	@Query(value = "select cr.REQUEST_ID,s.STATUS_DESCRIPTION, cr.WITH_SCORE from eir.CIR_REQUEST cr inner join eir.REQUEST r on r.REQUEST_ID = cr.REQUEST_ID "
			+"inner join eir.STATUS s on cr.STATUS_ID = s.STATUS_ID where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate and cr.REQUEST_ID =:requestID and r.USER_ID =:userId",
			nativeQuery=true)
	public List<Object[]> getCirRequestByDateAndRequestId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("requestID") Long requestID,@Param("userId") Integer userId);

	@Query(value = "select cr.XML_OUTPUT_PATH from eir.CIR_REQUEST cr where cr.REQUEST_ID =:requestID", nativeQuery=true)
	public String findByRequest(@Param("requestID")Integer requestID);
}
