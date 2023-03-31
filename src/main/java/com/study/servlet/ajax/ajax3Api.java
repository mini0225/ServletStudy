package com.study.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@WebServlet("/api/ajax3")
public class ajax3Api extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Ajax 3로 post요청 옴");
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String jsonData = request.getParameter("data");
		Map<String, Object> dataMap = gson.fromJson(jsonData, Map.class);
//		List<String> phoneNumbers = new ArrayList<>();
//		
//		dataMap.forEach((key,value) ->{
//			//value가뭔지 확인 필요, 뭔지도 모르고 다운캐스팅 할순 없음
//			if(value.getClass() == String.class) {
//				//String이면 넣어라
//				phoneNumbers.add((String)value);
//			}
//		});
		
//		response.setContentType("text/plain; charset=utf8");
		response.setContentType("application/json; charset=utf8");
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		PrintWriter out = response.getWriter();
			
		StringBuilder stringBuilder = new StringBuilder(); //문자열을 합쳐주는 용도
		
		dataMap.forEach((key, value) -> {
			stringBuilder.append(value); //apend : 문자열을 더한다.
			stringBuilder.append("-");
		});
		//여기서 010-8968-3970- 이니까 마지막-를 지워준다.
		
		stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
		//index에서 index를 지워준다 length는 14이니까 마지막꺼를 지우기 위해서 (14-1, 14) 이된다.
		
		JsonObject jsonObject = new JsonObject();
		//jsonObject.addProperty("response", jsonData);
		jsonObject.addProperty("responseData", stringBuilder.toString());
		
//		string으로 변환해서 출력
//		out.print(stringBuilder.toString());
		out.print(jsonObject.toString());
		
	}

}
