package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.util.DTO;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
class Address{
	private String address1;
	private String address2;
	private String address3;
}

@WebServlet("/api/ajax2")
public class Ajax2Api extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DTO : " + DTO.getParams(request));
		
		System.out.println("Ajax 2로 post요청 옴");
		
		//Map<String, String> requestMap = DTO.getParams(request);
		String jsonData = request.getParameter("jsonData");
		
		System.out.println("json형태 : " + jsonData);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Map<String, Object> addressMap = gson.fromJson(jsonData, Map.class);
		
		Address address = gson.fromJson(jsonData, Address.class);
		
		System.out.println("address객체 : " + address); //get set 가능
		
		System.out.println("Map : " + addressMap );
		
		System.out.println("addressMap get(address1) : "+ addressMap.get("address1"));
		
		
		Address address2 = Address.builder()
				.address1("부산광역시")
				.address2("북구")
				.address3("금곡동")
				.build();
		String responseJson = gson.toJson(address2);
				
		
		
		response.setContentType("text/plain; charset=utf8");
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		PrintWriter out = response.getWriter();
		//out.print(requestMap.get("address1") + " " + requestMap.get("address2") + " " +requestMap.get("address3"));
		out.print(responseJson);
	}

}
