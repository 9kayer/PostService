package com.blog.microservices.domains;

import java.io.Serializable;

public class Comment implements Serializable{

	private String title;
	private String content;
	private User user;

	protected Comment() {}

	public Comment(String title, String content,User user) {
		this.title = title;
		this.content  = content;
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
