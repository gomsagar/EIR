package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.CirRequest;
import com.eir.report.entity.ConsumerRequest;

public interface ConsumerRequetRepository extends JpaRepository<ConsumerRequest, Integer> {
	
	public List<ConsumerRequest> findByConsumerRequestId(Integer requestId);
	
	@Query(value = "select con.REQUEST_ID, s.STATUS_DESCRIPTION from eir.CONSUMER_REQUEST con inner join eir.REQUEST r on r.REQUEST_ID = con.REQUEST_ID "
			+"inner join eir.STATUS s on con.STATUS_ID = s.STATUS_ID where con.REQUEST_ID =:requestID",
			nativeQuery=true)
	public List<Object[]> getConsumerRequestByRequestId(@Param("requestID") Long requestID);
	
	@Query(value = "select con.REQUEST_ID, s.STATUS_DESCRIPTION from eir.CONSUMER_REQUEST con inner join eir.REQUEST r on r.REQUEST_ID = con.REQUEST_ID "
			+"inner join eir.STATUS s on con.STATUS_ID = s.STATUS_ID where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate",
			nativeQuery=true)
	public List<Object[]> getConsumerRequestByDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	@Query(value = "select con.REQUEST_ID, s.STATUS_DESCRIPTION from eir.CONSUMER_REQUEST con inner join eir.REQUEST r on r.REQUEST_ID = con.REQUEST_ID "
			+"inner join eir.STATUS s on con.STATUS_ID = s.STATUS_ID where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate and con.REQUEST_ID =:requestID",
			nativeQuery=true)
	public List<Object[]> getConsumerRequestByDateAndRequestId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("requestID") Long requestID);

	@Query(value = "select conr.XML_OUTPUT_PATH from eir.CONSUMER_REQUEST conr where conr.REQUEST_ID =:requestID", nativeQuery=true)
	public String findByRequest(@Param("requestID")Integer requestID);

}
