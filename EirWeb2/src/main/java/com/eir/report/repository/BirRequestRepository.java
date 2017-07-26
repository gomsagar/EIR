package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.BirRequest;
import com.eir.report.entity.MemberProductMapping;
import com.eir.report.entity.Status;

import java.util.List;

public interface BirRequestRepository extends JpaRepository<BirRequest, Integer> {

	/*@Modifying
	@Query("update BirRequest z set z.access_token=:fresh_access_token where z.report_token=:report_token and z.cin_number=:cin and z.entity_name=:entityName")
	public void updateAccessToken(@Param("report_token") String report_token,@Param("fresh_access_token") String fresh_access_token,
					@Param("cin") String cin,@Param("entityName") String entityName);

	@Modifying
	@Query("update BirRequest br set br.status=:status , br.updateUserDate=:CURRENT DATE where br.report_token=:report_token and br.cin_number=:cin and br.entity_name=:entityName")
	public void updateRecord(@Param("report_token") String report_token,@Param("cin") String cin,
			@Param("entityName")String entityName,@Param("status") String status);*/

	public List<BirRequest> findByStatus(Status status);
	public List<BirRequest> getByStatus(Integer statusId);
	
	@Query(value = "select br.XML_OUTPUT_PATH from eir.BIR_REQUEST br where br.REQUEST_ID =:requestID",
			nativeQuery=true)
	public String findByRequest(@Param("requestID")Integer requestID);
	
	public BirRequest findByBirRequestId(Integer birRequestId);
	
	@Query(value = "select br.REQUEST_ID,s.STATUS_DESCRIPTION from eir.BIR_REQUEST br inner join eir.REQUEST r on r.REQUEST_ID = br.REQUEST_ID "
			+"inner join eir.STATUS s on br.STATUS_ID = s.STATUS_ID where br.REQUEST_ID =:requestID and r.USER_ID =:userId",
			nativeQuery=true)
	public List<Object[]> getBirRequestByRequestId(@Param("requestID") Long requestID,@Param("userId") Integer userId);
	
	@Query(value = "select br.REQUEST_ID,s.STATUS_DESCRIPTION from eir.BIR_REQUEST br inner join eir.REQUEST r on r.REQUEST_ID = br.REQUEST_ID "
			+"inner join eir.STATUS s on br.STATUS_ID = s.STATUS_ID where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate and r.USER_ID =:userId",
			nativeQuery=true)
	public List<Object[]> getBirRequestByDate(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("userId") Integer userId);
	
	@Query(value = "select br.REQUEST_ID,s.STATUS_DESCRIPTION from eir.BIR_REQUEST br inner join eir.REQUEST r on r.REQUEST_ID = br.REQUEST_ID "
			+"inner join eir.STATUS s on br.STATUS_ID = s.STATUS_ID where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate and br.REQUEST_ID =:requestID and r.USER_ID =:userId",
			nativeQuery=true)
	public List<Object[]> getBirRequestByDateAndRequestId(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("requestID") Long requestID,@Param("userId") Integer userId);

	@Query(value = "select br.REQUEST_ID,s.STATUS_DESCRIPTION from eir.BIR_REQUEST br"
			+ " inner join eir.REQUEST r on r.REQUEST_ID = br.REQUEST_ID inner join eir.STATUS s on br.STATUS_ID = s.STATUS_ID "
			+ "inner join eir.KYC_APPROVAL kyc on r.REQUEST_ID = kyc.request_id where r.REQUEST_ID =:requestID and (kyc.STATUS_ID=11 or kyc.STATUS_ID=5)",
			nativeQuery=true)
	public List<Object[]> getBirRequestByRequestIdForCrmAdmin(@Param("requestID") Long requestID);
	
	@Query(value = "select br.REQUEST_ID,s.STATUS_DESCRIPTION from eir.BIR_REQUEST br"
			+ " inner join eir.REQUEST r on r.REQUEST_ID = br.REQUEST_ID inner join eir.STATUS s on br.STATUS_ID = s.STATUS_ID "
			+ "inner join eir.KYC_APPROVAL kyc on r.REQUEST_ID = kyc.request_id where r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate and (kyc.STATUS_ID=11 or kyc.STATUS_ID=5)",
			nativeQuery=true)
	public List<Object[]> getBirRequestByDateForCrmAdmin(@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	@Query(value = "select br.REQUEST_ID,s.STATUS_DESCRIPTION from eir.BIR_REQUEST br"
			+ " inner join eir.REQUEST r on r.REQUEST_ID = br.REQUEST_ID inner join eir.STATUS s on br.STATUS_ID = s.STATUS_ID "
			+ "inner join eir.KYC_APPROVAL kyc on r.REQUEST_ID = kyc.request_id where r.REQUEST_ID =:requestID and r.CREATE_DATE >= :fromDate and r.CREATE_DATE <= :toDate and (kyc.STATUS_ID=11 or kyc.STATUS_ID=5)",
			nativeQuery=true)
	public List<Object[]> getBirRequestByDateAndRequestIdForCrmAdmin(@Param("fromDate") String fromDate,@Param("toDate") String toDate,@Param("requestID") Long requestID);
}
