package com.study.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/form/1")
public class FormApi1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get 요청옴");
		// 해당 key값을 들고온다, get요청은 주소창에 다뜸
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("phone"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("address"));
		System.out.println(req.getParameter("password"));
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post 요청옴");
		
		//post요청은 한글깨짐...ㅎㅎ
		req.setCharacterEncoding("UTF-8");
		
		System.out.println(req.getParameter("name"));
		System.out.println(req.getParameter("phone"));
		System.out.println(req.getParameter("email"));
		System.out.println(req.getParameter("address"));
		System.out.println(req.getParameter("password"));
		
		//requestBody안에 데이터가 저장되어서 날아온다.
		//encoding이 안되어 있음...
/////////////////////////////////////////////////////////////////////
		//위는 request , 아래는 response
		
		resp.setContentType("text/plain; charset=utf8");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.println("name : "+ req.getParameter("name"));
		out.println("phone : "+ req.getParameter("phone"));
		out.println("email : "+ req.getParameter("email"));
		out.println("address : "+ req.getParameter("address"));
		out.println("password : "+ req.getParameter("password"));
	}

}
