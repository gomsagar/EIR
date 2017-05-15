package com.eir.report.scheduler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.eir.report.service.BirReportService;

public class ScheduledJob {
	
	@Autowired
	BirReportService birSchedulerService;
	
	//Scheduler call repeatedly after every 1 hour
	@Scheduled(cron="* * 1 * * ?")
	public void demoServiceMethod()
	{
		String query = "select entity_name,cin_number,report_token from bir_request where status='PENDING'";
		
		//execute above query and get required details for the request getXMLResponse(report_token, cin,entityName)	
		
		String report_token = null,cin = null ,entityName = null;
		
		birSchedulerService.getXMLResponse(report_token, cin,entityName);
		System.out.println("Method executed at every 5 seconds. Current time is :: "+ new Date());
	}
}
