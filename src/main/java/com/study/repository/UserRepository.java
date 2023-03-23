package com.study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.domain.User;

public class UserRepository {
	
	private static UserRepository instance = null;
	
	private List<User> userList;
	
	private UserRepository() {
		userList = new ArrayList<>();
		
	}
	
	//싱글톤 : 어디서든지 접근가능
	public static UserRepository getInstance() {
		if(instance == null) {
			instance  = new UserRepository();
		}
		return instance;
	}
	
	public void saveUser(User user) {
		
		System.out.println("repository에 사용자 등록");
		userList.add(user);
		
	}
	
	
	//사용자 찾기
	public User findUserByUsername(String username) {
		User user = null;
		
		for(User u : userList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		
		return user;
		//userList안에 있으면 user들고오고 없으면 null
	}
	
	
	//사용자 전체 조회
	public void showUserAll() {
		System.out.println("[등록된 사용자 조회]");

		userList.forEach(user -> {
			System.out.println(user);
		});
	}
	
	

}
