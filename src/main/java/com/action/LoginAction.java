package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.LoginService;

@Controller
@RequestMapping("/loginAction")
public class LoginAction {
 @Autowired
 LoginService loginService;
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
	    if (username.equals("admin")&& password.equals("admin2015")){
	    	request.getSession().setAttribute("LoginUserId", "99999999");
	    	request.getSession().setAttribute("LoginUserName", "admin");
	    	pw.print("success");
	    }else{
	    	username=username.trim();
	    	String flag=loginService.checkUser(username,password);
	    	if (flag!=null){	    		
	    		request.getSession().setAttribute("LoginUserId", flag);
		    	request.getSession().setAttribute("LoginUserName", username);
		    	pw.print("success");
	    	}
	    	else
	    		pw.print("failed");
	    }
	   pw.flush();
	   pw.close();
	}
	@RequestMapping(value = "/regist.do", method = RequestMethod.POST)
	public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String realname=request.getParameter("realname");
		String school=request.getParameter("school");
		String phonenum=request.getParameter("phonenum");
		String email=request.getParameter("email");
		PrintWriter pw=response.getWriter();
		if (loginService.registUser(username, password, realname, school, phonenum, email))
			pw.print("success");
		else
			pw.print("failed");
		pw.flush();
		pw.close();
	}
}
