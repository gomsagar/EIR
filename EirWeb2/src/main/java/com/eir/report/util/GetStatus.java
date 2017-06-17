package com.eir.report.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.eir.report.entity.Status;
import com.eir.report.repository.StatusRepository;

@Service
public class GetStatus {

	public GetStatus()
	{
		System.out.println("GetStatus constructor called!!!!!!!!!");
	}
	
	@Autowired
	static StatusRepository statusRepository;
	
	public Status getStatusByDescription(String statusDesc)
	{
		if(statusDesc != null && !statusDesc.isEmpty())
		{
			return statusRepository.findBystatusDescription(statusDesc);	
		}
		return null;
	}
	
}
