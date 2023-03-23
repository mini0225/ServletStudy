package com.study.servlet.cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/2")
public class Cookie2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("쿠키2");
		//getCookies가 return값이 배열임.
		Cookie[] cookies = request.getCookies(); //response.add 한 애들을 배열로 저장한다.
//		List<Cookie> cookieList = Arrays.asList(cookies);
		
		for(Cookie c : cookies) {
			System.out.println("key : " + c.getName());
			System.out.println("value : " + URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8));
		}
	}

}
