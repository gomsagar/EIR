package com.eir.report.listener.filter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * This is a filter to prevent cross site scripting.
 * We wrap request to <class>XSSRequestWrapper</class>.
 * The wrapper overrides accessors to return only sanitized values
 * for request parameters and headers.
 */
public class XSSPreventionFilter implements Filter{
	
	private static Log log = LogFactory.getLog(XSSPreventionFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("XSSPreventionFilter: init()");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		XSSRequestWrapper wrapper = new XSSRequestWrapper((HttpServletRequest)request);
		chain.doFilter(wrapper,response);
	}

	@Override
	public void destroy() {
		log.info("XSSPreventionFilter: destroy()");
		
	}
}