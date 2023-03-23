package com.study.servlet.account;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.domain.User;
import com.study.service.AccountService;
import com.study.util.DTO;

@WebServlet("/auth/login")
public class LoginApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		System.out.println("username : " + username);
//		System.out.println("password : " + password);
		
//		Map<String, String> dataMap = new HashMap<>();
//		
//		Set <String> keySet = request.getParameterMap().keySet();
//		keySet.forEach(key ->{
//			dataMap.put(key, request.getParameter(key));
//						
//		});
//		System.out.println("Map : " + dataMap);
		
		
		//parameter를 Map으로 바꿔준다.
		System.out.println(DTO.getParams(request));
		Map<String, String> loginUser = DTO.getParams(request);
		
		AccountService accountService = AccountService.getInstance();
		
		User user = accountService.loadUserByUsername(loginUser.get("username"));
		
		if(user == null) {
			System.out.println("아이디 틀림!");
			//error_login.html  -> script : 사용자 정보를 확인해 주세요. history.back();
			request.getRequestDispatcher("/WEB-INF/account/error_login.html").forward(request, response);
			
			return;
		}
		
		if(!accountService.checkPassword(user, loginUser.get("password"))) {
			System.out.println("비밀번호 틀림!");
			//error_login.html  -> script : 사용자 정보를 확인해 주세요. history.back(); 
			request.getRequestDispatcher("/WEB-INF/account/error_login.html").forward(request, response);
			return;
		}
		
		System.out.println("로그인 성공 : " + user);
		
		//로그인성공!
		HttpSession session = request.getSession();
		session.setAttribute("principal", user); 
		//principal이라는 key값안에 user정보가 value로 들어가 있음. session에 들어가 있다.
		// => session이 유지되는 동안 유저 정보는 유지된다 
		// request.getSession() 이 호출되지 않는이상 이 정보는 유지된다.
		
		
		response.sendRedirect("/mypage");
		
		
		
	}

}
