package com.eir.report.service;

import java.util.List;

import com.eir.report.entity.Address;
import com.eir.report.entity.BirRequest;

public interface EirService {

	List<BirRequest> retrieveRequest();
	
	 void saveUser(Address adr);

	List<Address> getAddress();
}
