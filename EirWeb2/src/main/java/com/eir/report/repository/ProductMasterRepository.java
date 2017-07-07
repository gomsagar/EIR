package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eir.report.entity.ProductMaster;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
	
	public ProductMaster findByproductId(Integer productId);
	
	public ProductMaster findByproductCode(String productCode);
	
	@Query(value= "select pm.tat_in_hour from eir.product_master pm inner join eir.product_selection ps on ps.product_id = pm.product_id "
			+ "and ps.product_code=:BIRProductCode and ps.request_id=:requestId",nativeQuery=true)
	public Object[] getBIRProductByRequestId(@Param("requestId") Integer requestId, 
			@Param("BIRProductCode") String birProductCode);

}
