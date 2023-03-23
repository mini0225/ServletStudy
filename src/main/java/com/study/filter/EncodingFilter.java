package com.study.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;


	public void destroy() {}
		
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		System.out.println("encodingfilter - 필터2 실행됨.");
		//servletRequest에는 get method가 없음 다운캐스팅필요
		HttpServletRequest hsr = (HttpServletRequest) request;
		
		if(hsr.getMethod().equalsIgnoreCase("POST")) {
							// ↑ 대소문자 구분없이 비교하겟다.
			request.setCharacterEncoding(StandardCharsets.UTF_8.name());
		}
		//if 조건문 post요청이면 인코딩해라, post요청은 UTF-8지원x 
		
		System.out.println("encodingfilter - 입력받은 Method : " + hsr.getMethod());
		
		
		chain.doFilter(request, response);
		//↑ servlet임. chain 이전 : 전처리  / 이후 : 후처리
	}

	
	public void init(FilterConfig fConfig) throws ServletException {}

}
