package com.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ticketBuy")
public class TicketBuyAction {
	@RequestMapping(value = "/showTicket.do", method = RequestMethod.POST)
	public void showTicket(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		JSONObject ret = new JSONObject();
		ret.put("total", 1);
		JSONArray rows = new JSONArray();
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("firstname", "111");
		temp.put("lastname", "222");
		temp.put("phone", "333");
		temp.put("email","<a href=\"http://www.baidu.com\">444</a>");
		rows.add(temp);
		ret.put("rows", rows);
		
		PrintWriter pw = response.getWriter();

		pw.print(ret);

		pw.flush();

		pw.close();
	}
}
