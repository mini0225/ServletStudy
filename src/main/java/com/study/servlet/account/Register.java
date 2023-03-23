package com.study.servlet.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
				// ↓ 주소창에 입력했으니까 get요청, http://localhost:8000/register 입력하니까...
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/account/register.html").forward(request, response);
	}													//↑ form 태그에 post요청임. 가입하기 누르면 registerApi로 감, 가기전에 필터 거치고 감.

}
