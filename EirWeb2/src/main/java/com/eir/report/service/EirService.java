package com.eir.report.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eir.bir.request.model.MultipleRequest;
import com.eir.report.entity.Address;
import com.eir.report.entity.AddressType;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.Request;
import com.eir.report.entity.State;

public interface EirService {

	List<BirRequest> retrieveRequest();
	
	 void saveUser(Address adr);

	List<Address> getAddress();

	List<State> getStateList();

	List<AddressType> getAddressTypeList();

	void uploadKYCDocuments(HttpServletRequest request, HttpServletResponse response);

	void downloadKYCDocuments(HttpServletRequest request, HttpServletResponse response);

	void saveRequestedData(MultipleRequest input, HttpServletRequest request);

	Request createRequest(MultipleRequest input, HttpServletRequest request);
}
