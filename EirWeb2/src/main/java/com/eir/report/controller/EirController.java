package com.eir.report.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eir.report.entity.Address;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.Request;
import com.eir.report.service.EirService;

@Controller
//@RequestMapping("eir")
public class EirController {

	@Autowired
	EirService eirService;

	Logger logger = LoggerFactory.getLogger(EirController.class);

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView helloWorld() {
		logger.debug("EirController - helloWorld: Start");
		//List<BirRequest> retrieveRequest = eirService.retrieveRequest();

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		logger.debug("EirController - helloWorld: End");
		return new ModelAndView("welcome", "message", message );
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView hello() {
		logger.debug("EirController - helloWorld: Start");
		List<BirRequest> retrieveRequest = eirService.retrieveRequest();

		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		logger.debug("EirController - helloWorld: End");
		return new ModelAndView("welcome", "message", message + retrieveRequest);
	}*/
	
	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public ModelAndView addUser() {
		
		Address adr = new Address();
		
		adr.setAddressId(4);
		adr.setAddressLine1("kothrud");
		adr.setAddressLine2("depo");
		adr.setAddressLine3("pune akot");
		adr.setAddressType("temp");
		adr.setCity("Pune 5");
		adr.setPincode("411333");
		
		eirService.saveUser(adr);
		System.out.println("inside new user");
		String message ="Saved";
		return new ModelAndView("NewUser","message", message);// "NewUser";	
	}
	
	/*@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/getAddress", method = RequestMethod.GET, produces="application/json")
	public @ResponseBody JSONArray getAddress() throws JSONException {
		Gson gson = new Gson();
		JSONObject obj = new JSONObject();
		JSONArray jar = new JSONArray();
		Address adr = new Address();
		List<Address> allAddrs = eirService.getAddress();
		adr.setAddressId(3);
		adr.setAddressLine1("pimple");
		adr.setAddressLine2("saudagar");
		adr.setAddressLine3("pune");
		adr.setAddressType("perm");
		adr.setCity("Pune 2");
		adr.setPincode("411000");
		
		allAddrs.add(adr);
		
		String jsonCartList = gson.toJson(allAddrs);
		System.out.println("jsonCartList: " + jsonCartList);
		//ModelAndView view = new ModelAndView("NewUser", "addrsList", allAddrs);
		obj.put("", jsonCartList);
		jar.put(obj);
		System.out.println(obj);
		System.out.println("here == "+jar);
		
		String[] data = {"stringone", "stringtwo"};
		JSONArray json = new JSONArray(Arrays.asList(data));
		
		return json;		
	}*/
	
	@RequestMapping(value = "/returnString", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String returnString() {
		Address adr = new Address();
		adr.setAddressId(3);
		adr.setAddressLine1("pimple");
		adr.setAddressLine2("saudagar");
		adr.setAddressLine3("pune");
		adr.setAddressType("perm");
		adr.setCity("Pune 2");
		adr.setPincode("411000");
		return "hi kishor";
	}
	
	@RequestMapping(value = "/getRequest", method = RequestMethod.POST)
	public @ResponseBody Request update() {
		Request request = new Request();
		request.setRequestId(1);
		request.setAdminHit(1);
		request.setUserHit(1);
		request.setErnNumber("ERN102");
		System.out.println(request.getErnNumber());
		return request;
	}
}
