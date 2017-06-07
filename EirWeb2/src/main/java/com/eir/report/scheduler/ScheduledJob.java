package com.eir.report.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.eir.report.entity.BirRequest;
import com.eir.report.service.BirReportService;

public class ScheduledJob { 
	
	@Autowired
	BirReportService birSchedulerService;
	
	Logger logger = LoggerFactory.getLogger(ScheduledJob.class);
	//Scheduler call repeatedly after every 1 hour
	@Scheduled(cron="* * 1 * * ?")
	public void callServiceMethod()
	{
		logger.info("ScheduledJob callServiceMethod()");
		//execute above query and get required details for the request getXMLResponse(report_token, cin,entityName)	
		/*List<BirRequest> pendingRequestlist = birSchedulerService.getPendingRecord();
		
		logger.debug("getPendingRecord() : "+pendingRequestlist);
		
		if(pendingRequestlist != null && !pendingRequestlist.isEmpty())
		{
			boolean isProcessed = birSchedulerService.getAndProcessBirReport(pendingRequestlist);
			
			logger.debug("getAndProcessBirReport() : "+isProcessed);
		}*/
	
	}
}
