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
	
	@Query(value = "select count(*) from eir.request r where r.user_id =:userID", nativeQuery=true)
	Integer findCountByUserId(@Param("userID") Integer userId);
	
	@Query(value = "select count(*) from eir.request r where r.user_id=:userID and r.status_id=:statusId", nativeQuery=true)
	Integer findCountByUserIdAndStatusId(@Param("userID") Integer userId,@Param("statusId")Integer statusId);

	@Query(value = "(select r.REQUEST_ID from eir.BIR_REQUEST br,eir.REQUEST r where r.REQUEST_ID = br.REQUEST_ID and r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate UNION ALL" 
					+" select r.REQUEST_ID from eir.CIR_REQUEST cr,eir.REQUEST r where r.REQUEST_ID = cr.REQUEST_ID and r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate ORDER BY REQUEST_ID ASC)", nativeQuery=true)
	List<Integer> findRequestByDateAndRequestId(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
