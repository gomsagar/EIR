package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.ProductMaster;

public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {
	
	public ProductMaster findByproductId(Integer productId);
	
	public ProductMaster findByproductCode(String productCode);

}
