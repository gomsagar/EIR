package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.Dispute;

public interface DisputeRepository extends JpaRepository<Dispute, Integer> {
	
	@Query(value = "select count(*) from eir.dispute d where d.user_id =:userID", nativeQuery=true)
	Integer findDisputeCountByUserId(@Param("userID") Integer userId);
	
	@Query(value = "select count(*) from eir.dispute d where d.user_id=:userID and d.status_id=:statusId", nativeQuery=true)
	Integer findDisputeCountByUserIdAndStatusId(@Param("userID") Integer userId,@Param("statusId")Integer statusId);


}
