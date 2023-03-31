package com.study.util;

public class StringBuilderTest {

	public static void main(String[] args) {
		String str = "문자열1";
		
		str += "문자열2";
		
		//replaceAll : 기존 문자열을 다른문자열로 바꿔라.
		
		str = str.replaceAll("문자열2", "문자열3");
		//->문자열1,문자열3 출력
		
		System.out.println(str);
		//각각의 str 에 메모리가 할당되어 있어서 낭비가 발생함.
		//-------------------------------------------------
		
		StringBuilder builder = new StringBuilder(); //비동기
		/*
			stringBuilder는 매개변수로 int capacity가 들어올수 있음
			capacity란....공간(칸(1char = 2byte))...? ex) 16(default, 32 byte) , 32
			append로 추가하되, 16칸을 넘어설 경우 자동으로 16개씩 늘어남, 메모리주소 안변함
			메모리낭비 x, delete 하면 칸을 다시 줄임.
			비동기처리..동기화를 하지않는다
			메모리의 낭비를 줄이기 위해 사용
		*/
		
		StringBuffer buffer = new StringBuffer(); //동기
		/*
			stringBuilder와 동작방식은 같음.
			메모리의 낭비를 줄이기 위해 사용
			스레드 방식에서 사용됨.
			한공간에서 여러작업이 일어날경우 한작업이 끝날때까지 다음작업이 이뤄지지 않는다.
		*/
		
		/*
		 	thread (스레드)
		  	싱글스레드 : 위의 코드가 처리될때까지 뒤 코드가진행이 안됨
		  	멀티스레드 : 조금씩 차례로 전부 다 봄, 먼저끝나는 뒤쪽코드가 있음.
		  	스레드 문제점 : 동기화가필요?
		*/
		
	}

}
