package com.eir.report.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eir.report.entity.ProductMaster;
import com.eir.report.service.EirService;


@Controller
public class EirController {

	@Autowired
	EirService eirService; 
	
	Logger logger = LoggerFactory.getLogger(EirController.class);
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		logger.debug("EirController - helloWorld: Start");
		List<ProductMaster> retrieveRequest = eirService.retrieveRequest();
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		logger.debug("EirController - helloWorld: End");
		return new ModelAndView("welcome", "message", message + retrieveRequest);
	}
}
