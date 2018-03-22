package com.blog.microservices.dtos.user;

import com.blog.microservices.domains.Role;
import com.blog.microservices.dtos.Response;

public class UserResponse extends Response {

	private String id;
	private String name;
	private Role role;

	public UserResponse() {}

	public UserResponse(String id, String name, Role role) {
		this.id = id;
		this.name = name;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Role getRole() {
		return role;
	}



	    
	    
}
