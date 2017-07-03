package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.ConsumerRequest;

public interface ConsumerRequetRepository extends JpaRepository<ConsumerRequest, Integer> {
	
	@Query(value = "select con.REQUEST_ID, s.STATUS_DESCRIPTION from CONSUMER_REQUEST con inner join REQUEST r on r.REQUEST_ID = con.REQUEST_ID "
			+"inner join STATUS s on con.STATUS_ID = s.STATUS_ID "
			+ "inner join USER_DETAILS ud on r.USER_ID = ud.USER_ID where r.USER_ID =:userId",
			nativeQuery=true)
	public List<Object[]> getConsumerRequestByUserId(@Param("userId") Integer userId);

}
