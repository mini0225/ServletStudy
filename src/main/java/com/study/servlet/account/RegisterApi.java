package com.study.servlet.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.domain.User;
import com.study.repository.UserRepository;
import com.study.service.AccountService;
import com.study.util.DTO;

@WebServlet("/auth/register")
public class RegisterApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						 //웹에서 입력한 애들이 request으로 들어옴 ->필터를 통해 HSR에서 SR로 업케스팅 ->필터에서 method사용을 위해 다운케스팅
		Map<String, String> registerParams = DTO.getParams(request);
		
		AccountService accountService = AccountService.getInstance();
		
		if(accountService.isduplicateUsername(registerParams.get("username"))) {
			System.out.println("아이디가 중복되었습니다.");
			
			request.getRequestDispatcher("/WEB-INF/account/error_username.html").forward(request, response);
			
			return;//끊어주기
		}
		
		System.out.println("가입 가능한 아이디 입니다.");
		User user = User.builder()
				.username(registerParams.get("username"))
				.password(registerParams.get("password"))
				.name(registerParams.get("name"))
				.email(registerParams.get("email"))
				.roles("ROLE_USER, ROLE_ADMIN")
				.build();
		
//		UserRepository.getInstance().saveUser(user);
		
		//회원가입
		accountService.register(user);
		
		//모든User보기
		UserRepository.getInstance().showUserAll();
		
		response.sendRedirect("/login"); //강제로 요청날리겠다
		
	}

}
