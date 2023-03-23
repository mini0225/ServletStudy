package com.study.servlet.cookie;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/1")
public class Cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("쿠키1");
		
		Cookie cookie = new Cookie("data1","쿠키저장");//무조건 string, 띄어쓰기x
		cookie.setMaxAge(60 * 60); //초단위 저장 60*60 한시간
		
		Cookie cookie2 = new Cookie("data2", URLEncoder.encode("데이터 하나 더 추가", StandardCharsets.UTF_8));
		cookie2.setMaxAge(60 * 60);
		
		//request시 응답을 저장한다.
		response.addCookie(cookie);
		response.addCookie(cookie2);
	}

}

//cookie는 client에 있음. 서버로 cookie저장소 전달(request), 서버가 꺼지더라도 유지가능