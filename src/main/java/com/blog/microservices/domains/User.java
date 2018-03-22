package com.blog.microservices.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection="user")
public class User  implements Serializable{

	@Id
	private String id;
	private String name;
	private Role role;

	protected User() {}

	public User(String id, String name,Role role) {
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

	public void setId(String id) {
		this.id = id;
	}





}
