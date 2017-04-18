package com.eir.report.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.eir.report.service.EirService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContextTest.xml"})
@WebAppConfiguration
public class EirControllerTest {
	
	@Autowired
	EirService eirService;
	
    @Autowired
    private WebApplicationContext wac;
    
    /*@InjectMocks
    private EirController eirController;
*/
    @Autowired
    private EirController eirController;
    
    private MockMvc mockMvc;

    @Before
    public void setup() {
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(eirController).build();
    }

    @Test
    public void testGetSignupForm() throws Exception {
    	System.out.println("testGetSignupForm");
        this.mockMvc.perform(get("/welcome")).andExpect(status().isOk());


    }

}
