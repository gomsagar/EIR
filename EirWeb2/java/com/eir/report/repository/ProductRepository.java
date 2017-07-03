package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.ProductMaster;

public interface ProductRepository extends JpaRepository<ProductMaster, Integer> {
	
	@Query(value= "select pm from PRODUCT_SELECTION ps inner join PRODUCT_MASTER pm on ps.PRODUCT_ID = pm.PRODUCT_ID "
			+ "and ps.PRODUCT_CODE='BIR' and ps.request_id=:requestId;",nativeQuery=true)
	public ProductMaster getRequestByRequestId(@Param("requestId") Integer requestId);

}
