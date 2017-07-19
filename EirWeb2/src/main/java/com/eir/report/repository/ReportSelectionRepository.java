package com.eir.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.ProductMaster;
import com.eir.report.entity.ReportSelection;

public interface ReportSelectionRepository extends JpaRepository<ReportSelection, Integer> {

	/*@Query(value= "select pm from PRODUCT_SELECTION ps inner join PRODUCT_MASTER pm"
			+ " on ps.PRODUCT_ID = pm.PRODUCT_ID and ps.REQUEST_ID=:requestId where ps.REQUEST_ID=:requestId",nativeQuery=true)
	public ProductMaster getRequestByRequestId(@Param("requestId") Integer requestId);*/
	
	List<ReportSelection> findByRequestId(Integer requestId) ;
	
}
