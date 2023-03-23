package com.study.servlet.form;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/form/1")
public class Form1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("form1 호출!!");
		System.out.println(req.getAttribute("name")); //filter1에서 set한 name을 들고온다.콘솔창 출력
		
//		req.getRequestDispatcher("/WEB-INF/form1.html").forward(req, resp);
		req.getRequestDispatcher("/WEB-INF/name.jsp").forward(req, resp);
	}
}

//req에 저장된 name을 들고와서 호출
//forward : 페이지 호출.