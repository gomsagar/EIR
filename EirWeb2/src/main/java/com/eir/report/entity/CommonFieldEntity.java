package com.eir.report.entity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.eir.report.constant.Constant;

@Component
public class CommonFieldEntity implements AuditorAware<String> {
	
	@Override
	public String getCurrentAuditor() {
		System.out.println("getCurrentAuditor()~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		/*ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		session.setAttribute("userId", "EIR_Session");
		System.out.println(session.getAttribute("userId").toString());
		return session.getAttribute("userId").toString();*/
		return Constant.USER_ID;
	}
	
	public void name(HttpServletRequest req) {
		
		System.out.println(" name(HttpServletRequest req)!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(req.getSession().getAttribute("userId"));
		
	}
	
}
