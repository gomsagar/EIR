package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.MemberProductMapping;

public interface MemberProductMappingRepository extends JpaRepository<MemberProductMapping, Integer>  {
	
	@Query(value = "select * from eir.member_product_mapping mpm inner join eir.member_user_mapping mum on mpm.member_id = mum.member_id where mum.user_id =:userID",
			nativeQuery=true)
	List<MemberProductMapping> findProductMappingForUserId(@Param("userID") Integer userId);
}
