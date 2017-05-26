package com.eir.report.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eir.report.entity.Address;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.State;
import com.eir.report.repository.AddressRepository;
import com.eir.report.repository.BirRequestRepository;
import com.eir.report.repository.StateRepository;
import com.eir.report.service.EirService;

@Service
public class EirServiceImpl implements EirService{

	@Autowired
	BirRequestRepository birRequestRepository;
	
	@Autowired
	AddressRepository addrRepository;
	
	@Autowired
	StateRepository stateRepository;

	@Override
	public List<BirRequest> retrieveRequest() {
		return birRequestRepository.findAll();
		//return null;
	}

	public void saveUser(Address adr) {
		
		 addrRepository.save(adr);
	}

	@Override
	public List<Address> getAddress() {
		return addrRepository.findAll();
	}

	@Override
	public List<State> getStateList() {
		
		return stateRepository.findAll();
	}
	
}
