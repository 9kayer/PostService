package com.blog.microservices.dtos.user;

import com.blog.microservices.domains.Role;
import com.blog.microservices.dtos.Request;

public class UserRequest extends Request {

	private String name;
	private Role role;

	public UserRequest() {}

	public UserRequest(String name,Role role) {
		this.name = name;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}


}
