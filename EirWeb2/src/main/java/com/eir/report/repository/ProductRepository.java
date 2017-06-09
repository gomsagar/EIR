package com.eir.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eir.report.entity.ProductMaster;

public interface ProductRepository extends JpaRepository<ProductMaster, Integer> {
	
	public ProductMaster findByproductId(Integer productId);

}
