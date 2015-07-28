package com.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.TestDao;





@Controller
@RequestMapping("/testAction")
public class TestAction {
	@Autowired
	TestDao testDao;
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
	public void test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().setAttribute("username", "admin");
		PrintWriter pw=response.getWriter();
		//testDao.excuteBySql("insert into t_ticketuser (user_name,if_vip) values ('test',1)");
		pw.print(111111);
		pw.flush();
		pw.close();
	}
}
