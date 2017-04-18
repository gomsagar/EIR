package com.eir.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eir.report.entity.ProductMaster;
import com.eir.report.repository.ProductRepository;
import com.eir.report.service.BirReportService;
import com.eir.report.service.EirService;

@Service
public class BirReportServiceImpl implements BirReportService{

	@Autowired
	ProductRepository productRepository;

	
	
}
