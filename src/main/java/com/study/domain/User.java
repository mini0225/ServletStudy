package com.study.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
	
	private String username;
	private String password;
	private String name;
	private String email;
	//권한에 관한것 22.12.05 (01:49:29)
	private String roles;  //ROLE_USER , ROLE_MANAGER, ROLE_ADMIN 으로 roles 들어감
	
}
