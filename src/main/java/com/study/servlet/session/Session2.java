package com.study.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/2")
public class Session2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("session2 get요청");
		System.out.println(session.getAttribute("user_name"));
		System.out.println(session.getAttribute("user_phone"));
		System.out.println(session.getAttribute("user_email"));
		System.out.println(session.getAttribute("user_address"));
		System.out.println(session.getAttribute("user_password"));
		
		//session에 저장했기 때문에 session1에서 저장하더라도 session2에서 꺼내쓸 수 있음.
		
		request.getRequestDispatcher("/WEB-INF/form1.html").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
