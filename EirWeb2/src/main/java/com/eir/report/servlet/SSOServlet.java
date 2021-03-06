package com.eir.report.servlet;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.eir.report.constant.Constant;
import com.eir.report.entity.UserDetails;
import com.eir.report.service.EirService;
import com.eir.report.web.service.EwacsData;

@Service
public class SSOServlet extends HttpServlet {
	private static final String CT_REMOTE_USER = "ct-remote-user";
	private static final String FULL_NAME = "fullName";
	private static final String USERS_MEMBER_ID = "users-member-Id";
	EirService eirServise;
	private static final String IP_ADDRESS = "ipAddress"; 
	/*

	private static final String CT_REMOTE_USER = "ct-remote-user";
    private static final String USER_ID = "userId";
    private static final String FULL_NAME = "fullName";
    private static final String BM_ID = "bmId";
    private static final String IP_ADDRESS = "ipAddress";
	private static Log log = LogFactory.getLog(SSOServlet.class);

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SSOConfig ssoConfig = WebApplicationContextUtils.
				getWebApplicationContext(getServletContext()).getBean(
						"ssoConfig", SSOConfig.class);

		SSOConfig ssoConfig1 = WebApplicationContextUtils.
				getWebApplicationContext(getServletContext()).getBean(
						"ssoConfig", SSOConfig.class);
		
		
		String userId = (String) request.getSession().getAttribute(USER_ID);
		if(userId == null || userId.isEmpty()) {
			userId = request.getHeader(CT_REMOTE_USER);
			
			if (ssoConfig.isDev() && StringUtils.isBlank(userId)) {
				userId = request.getParameter(USER_ID);
			}
			try{
                userId = sanitize(userId,ssoConfig.getWhiteCharList());
				setSessionValues(request,ssoConfig, userId);
			}catch(Exception e){
                throw new ServletException("Error setting user data");
			}
		}
		response.sendRedirect(ssoConfig.getRedirectPage());	
	}

	private String sanitize(String input, String whiteCharList) {
        if(input == null ){
            return "";
        }
        log.debug("Sanitzing input");
        return input.replaceAll(whiteCharList,"");
	}

	private void setSessionValues(HttpServletRequest request, SSOConfig ssoConfig, String userId)
			throws QueryUserProductInfoFault, MalformedURLException {
        EwacsData userData = ssoConfig.getEwacsHelper().getDetailsForUser(userId);
        if(userData != null && userData.getBmIdList() != null){
            request.getSession().setAttribute(USER_ID, userId);
            request.getSession().setAttribute(FULL_NAME, userData.getName());
            request.getSession().setAttribute(BM_ID, userData.getBmIdList()) ;
        }
		request.getSession().setAttribute(IP_ADDRESS, request.getRemoteAddr());
	}

*/

	@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
           doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	/*if (userID != null) {
        //UserDetails userDetails = eirService.getUserById(userID);
        //if (userDetails != null) {
		               request.getSession().setAttribute(Constant.USER_ID, userID);
		               response.sendRedirect("ng/index.html");
		        //}
		  }
		  else{
			  response.sendRedirect("ng/error.html");  
		  }*/
		    	
           String userID = request.getParameter("userId");
           System.out.println("=============================================" + userID);
           try {
        	   
        	 /* // RequestDispatcher dispatcher = request.getRequestDispatcher("ng/index.html");
        	   request.getSession().setAttribute(Constant.USER_ID, userID);
        	   response.sendRedirect("ng/index.html");
        	  // dispatcher.forward(request, response);
*/        	   
        	   request.getSession().setAttribute(Constant.USER_ID, userID);
        	   
        	  /* String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
        	   
        	   if(userId == null || userId.isEmpty()) {
       			userId = request.getHeader(CT_REMOTE_USER);
       			
       			if (StringUtils.isBlank(userId)) {
       				userId = request.getParameter(Constant.USER_ID);
       			}
       			try{
       				setSessionValues(request, userId);
       			}catch(Exception e){
                       throw new ServletException("Error setting user data");
       			}*/
        	   
        	   response.sendRedirect("ng/index.html");
         	  	
                  
           } catch (Exception e) {
                  e.printStackTrace();
           }
    }
    
    private void setSessionValues(HttpServletRequest request, String userId) {
        if(userId != null )
        {
        	Integer userID = Integer.parseInt(userId);
        	Integer memberId = eirServise.getUsersMemberId(userID);
            request.getSession().setAttribute(Constant.USER_ID, userID);
            request.getSession().setAttribute(USERS_MEMBER_ID, memberId) ;
        }
		request.getSession().setAttribute(IP_ADDRESS, request.getRemoteAddr());
	}


}
