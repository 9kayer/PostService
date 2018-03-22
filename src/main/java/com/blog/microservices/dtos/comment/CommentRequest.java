package com.blog.microservices.dtos.comment;

import com.blog.microservices.domains.User;
import com.blog.microservices.dtos.Request;

public class CommentRequest extends Request {

	private String title;
	private String content;
	private User user;

	public CommentRequest() {}
	
	public CommentRequest(String title, String content,User user) {	
		this.title = title;
		this.content = content;
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

	
	



	


}
