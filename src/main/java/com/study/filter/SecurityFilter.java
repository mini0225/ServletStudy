package com.study.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.domain.User;

@WebFilter("/*")
public class SecurityFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;
	
	public void destroy() {}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String requestURI = req.getRequestURI();
		String antMatchers1 = "/mypage, /mypage/password";
		String antMatchers2 = "/login, /register";
		String logoutURI = "/logout";
		String adminPage = "/admin";
		
		System.out.println("securityfilter - securityFilter");
		System.out.println(requestURI);  //<-요청주소
		
		if(antMatchers1.contains(requestURI) && !authorization(req.getSession())) { 
			///mypage, /mypage/password 이 요청이 들어왔을때 && 인증이 안되어 있으면 if문 실행
			System.out.println("securityfilter - 로그인필요");
			resp.sendRedirect("/login");
			return;
			//filter에서 걸러서 login으로 보내준다.
		}
		
		if(antMatchers2.contains(requestURI) && authorization(req.getSession())) {
			//둘다 true인경우 
			System.out.println("securityfilter - 로그인 후");
			resp.sendRedirect("/mypage");
			return;
		}
		
		if(logoutURI.equalsIgnoreCase(requestURI)) {
			req.getSession().invalidate(); //<-session 강제로 죽이기 = 로그인정보 날리기
			System.out.println("securityfilter - 로그아웃함");
			resp.sendRedirect("/login");
		}
		if(requestURI.contains(adminPage) && !hasRole(req.getSession(), "ADMIN")) {
			resp.sendError(403, "Forbidden, 권한이 없습니다.");
			return;
		}
		
			
			
		chain.doFilter(request, response);
	}

	private boolean authorization(HttpSession session) {
		User principalUser = (User) session.getAttribute("principal"); 
		//principal이라는 key값 안에 user정보가 들어가있으면 login되어 있는 상태
		System.out.println("principalUser : " + principalUser);
		return principalUser !=null;
	}
	private boolean hasRole(HttpSession session, String role) {
		
		AtomicBoolean result = new AtomicBoolean(false);
		
		if(authorization(session)) {
			//로그인 유무확인.
			User principalUser = (User) session.getAttribute("principal");
			
			String[] roleArray = principalUser.getRoles().replaceAll(" ", "").split(",");
			List<String> roleList = Arrays.asList(roleArray);
			
			roleList.forEach(r -> { //role = r
				if(r.startsWith("ROLE_") && r.contains(role)) {
					result.set(true);
				}//Atomic을 붙여줘 람다식의 조건문에서 접근가능할수 있게 한다.
			});
			
		}
				
		return result.get();
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
