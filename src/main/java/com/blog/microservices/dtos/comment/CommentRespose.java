package com.blog.microservices.dtos.comment;

import com.blog.microservices.domains.User;
import com.blog.microservices.dtos.Response;

public class CommentRespose extends Response {

	 private String title;
	 private String content;
	 private User user;
	
	 
	 public CommentRespose() {} 
	 
	 public CommentRespose(String title, String content, User user) {
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
		
	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
