package com.eir.report.listener.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * This class is a session token filter to prevent CSRF attack.
 * In order to prevent forgery, each incoming request is checked
 * for a specific token.
 */
public class SessionTokenFilter implements Filter {

	private static Log log = LogFactory.getLog(SessionTokenFilter.class);
    private static final String REQ_TOKEN = "sessionReqToken";
    private static final String SESS_TOKEN = "sessionToken";
	private static final List<String> PATHS_TO_IGNORE = Arrays.asList("/products/landing.page","/products/ssoLogout.page");

    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("Init() SessionTokenFilter");
	}

    /**
     * Checks request token sent by http request against token assigned
     * during session creation.
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String sessionToken = null;
		String reqToken = null;
		String headerReqToken = null;
		log.info("doFilter:Checking request token");
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession sessionObj = httpServletRequest.getSession();
		String requestPath = httpServletRequest.getServletPath();
        log.debug("Path = " + requestPath);

		if (!PATHS_TO_IGNORE.contains(requestPath)) {
			reqToken = request.getParameter(REQ_TOKEN);

			headerReqToken = httpServletRequest.getHeader(REQ_TOKEN);
			if(reqToken!=null && reqToken.contains("?f=0")){
				reqToken = reqToken.substring(0, reqToken.length()-4);
			}

			if (sessionObj != null) {
				boolean sessionIsnew = sessionObj.isNew();
                log.debug("Session new? = " + sessionIsnew);
				sessionToken = sessionObj.getAttribute(SESS_TOKEN)
						.toString();
                log.debug("Session Token = " + sessionToken);
				if (sessionToken.equals(reqToken) || sessionToken.equals(headerReqToken) || sessionIsnew) {
					chain.doFilter(request, response);
				} else {
					sessionObj.invalidate();
					RequestDispatcher reqDis = request
							.getRequestDispatcher("/error/access-denied.jsp");
					reqDis.forward(request, response);
				}
			}
		} else {
			chain.doFilter(request, response);
		}

	}

	@Override
	public void destroy() {
		log.info("Destroy() SessionTokenFilter");

	}

}
