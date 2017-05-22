package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eir.report.entity.BirRequest;
import com.eir.report.entity.MemberProductMapping;

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

	public List<BirRequest> getByStatus(Integer statusId);

}
