package com;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{
	private FilterConfig config;
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		config=filterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
	      HttpServletResponse res = (HttpServletResponse) response;
	      String request_uri = req.getRequestURI();
	      HttpSession session = req.getSession();
	      ServletContext sessionContext = (ServletContext)session.getServletContext();
    	  String contextPath = sessionContext.getContextPath();
	      String userId = (String)session.getAttribute("LoginUserId");
	     
	      if (userId==null && 
    			  !request_uri.equals(contextPath + "/login.jsp")
    			  && !request_uri.equals(contextPath+"/loginAction/login.do")
    			  && !request_uri.equals(contextPath+"/loginAction/regist.do")){
	    	  res.sendRedirect(contextPath+"/login.jsp");
	    	  return;
	      }
	      chain.doFilter(request, response); 
	}

	public void destroy() {
		// TODO Auto-generated method stub
		config=null;
	}

}
