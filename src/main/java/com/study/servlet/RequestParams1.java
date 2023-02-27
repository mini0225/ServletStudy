package com.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;

//import 정리 단축키 control + shift + o

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req/1")
public class RequestParams1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println(req.getLocalPort());
		System.out.println(req.getMethod());
		System.out.println(req.getRequestURI());
		System.out.println(req.getQueryString());
		// 주소창 ? 기준으로 뒤쪽은 queryString key=value
		
		String test = req.getParameter("test");
		String name = req.getParameter("name");
		
//		System.out.println(req.getParameter("test"));
//		System.out.println(req.getParameter("name"));
//		get요청에서만 사용, 주소창에 요청하는건 다 get요청
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain; charset=utf8");
		
		resp.getWriter().print("test" + test);
		resp.getWriter().print("name" + name);
		
		
//		request는 utf8 사용.
//		response는 set해줘야함.
		
	
		
	}
	

}
