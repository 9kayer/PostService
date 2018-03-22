package com.blog.microservices.dtos.post;

import com.blog.microservices.dtos.Request;
import com.blog.microservices.dtos.category.PostCategoryRequest;
import com.blog.microservices.dtos.comment.PostCommentRequest;
import com.blog.microservices.dtos.user.PostUserRequest;

import java.util.List;

public class PostRequest extends Request {

	private String id;
	private String title;
	private String content;	
	private List<PostCategoryRequest> categories;
	private List<PostCommentRequest> comments;
	private PostUserRequest user;
	
	public PostRequest() {}

	public PostRequest(String id, String title, String content, List<PostCategoryRequest> categories, List<PostCommentRequest> comments, PostUserRequest user) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.categories = categories;
		this.comments = comments;
		this.user = user;
	}
	
	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public List<PostCategoryRequest> getCategories() {
		return categories;
	}

	public List<PostCommentRequest> getComments() {
		return comments;
	}

	public PostUserRequest getUser() {
		return user;
	}
}
