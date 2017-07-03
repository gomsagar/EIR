/**
 * 
 */
package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.MemberProductMapping;
import com.eir.report.entity.Request;
import com.eir.report.entity.UserDetails;

/**
 * @author C17485A
 *
 */
public interface RequestRepository extends JpaRepository<Request, Integer> {

	List<Request> findByUserDetails(UserDetails userDetails);
	
	Request findByRequestId(Integer requestId) ;
	
	@Query(value = "select count(*) from request r where r.user_id =:userID", nativeQuery=true)
	Integer findCountByUserId(@Param("userID") Integer userId);
	
	@Query(value = "select count(*) from request r where r.user_id=:userID and r.status_id=:statusId", nativeQuery=true)
	Integer findCountByUserIdAndStatusId(@Param("userID") Integer userId,@Param("statusId")Integer statusId);

}
