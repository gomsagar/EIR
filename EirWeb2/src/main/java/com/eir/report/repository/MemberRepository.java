package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	@Query(value = "select m.* from eir.member m inner join eir.MEMBER_USER_MAPPING mu on m.MEMBERID = mu.MEMBER_ID"
			+ " where mu.USER_ID=:userId",nativeQuery=true)
	public Member getUserType(@Param("userId") Integer userId);

}
