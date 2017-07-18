package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberUserMappingRepository extends JpaRepository<com.eir.report.entity.MemberUserMapping, Integer> 
{
	@Query(value="select member_id from member_user_mapping where user_id =:userId", nativeQuery=true)
	Integer getUsersMemberId(@Param("userId") Integer userId);
}
