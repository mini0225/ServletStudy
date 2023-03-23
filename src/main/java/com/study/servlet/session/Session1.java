package com.study.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/1")
public class Session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("session1 get요청");
		System.out.println(session.getAttribute("user_name"));
		System.out.println(session.getAttribute("user_phone"));
		System.out.println(session.getAttribute("user_email"));
		System.out.println(session.getAttribute("user_address"));
		System.out.println(session.getAttribute("user_password"));
		//처음 서버 실행시켰을때는 null값으로 찍힌다. post요청 온 이후에 setAttribute되니까
		//post요청보낸 후 재 실행시켰을때는 null값이 아니라 해당 value값이 찍혀잇음.
		//서버상에서 페이지 요청(주소창은 get요청)해도 post보냈던 데이터 찍힘.
		//session 데이터 유지시간 30분 
		//browser 다끄고 작업관리자에도 없앨경우 다시 null값.
		
		request.getRequestDispatcher("/WEB-INF/form1.html").forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("session1 post 요청옴");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();//session에다가 저장
		
		//페이지 상에서 입력한 parameter 들고온다. request.getParameter
		session.setAttribute("user_name", request.getParameter("name"));
		session.setAttribute("user_phone", request.getParameter("phone"));
		session.setAttribute("user_email", request.getParameter("email"));
		session.setAttribute("user_address", request.getParameter("address"));
		session.setAttribute("user_password", request.getParameter("password"));
		
	}

}
