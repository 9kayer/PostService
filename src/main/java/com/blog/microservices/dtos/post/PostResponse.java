package com.blog.microservices.dtos.post;

import com.blog.microservices.dtos.Response;
import com.blog.microservices.dtos.category.PostCategoryResponse;
import com.blog.microservices.dtos.comment.PostCommentResponse;
import com.blog.microservices.dtos.user.PostUserResponse;

import java.util.List;

public class PostResponse extends Response {

	private String id;
	private String title;
	private String content;	
	private List<PostCategoryResponse> categories;
	private List<PostCommentResponse> comments;
	private PostUserResponse user;
	
	public PostResponse () {}
	
	public PostResponse(String id, String title, String content, List<PostCategoryResponse> categories, List<PostCommentResponse> comments, PostUserResponse user) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.categories = categories;
		this.comments = comments;
		this.user = user;
	}

	public List<PostCategoryResponse> getCategories() {
		return categories;
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

	public List<PostCommentResponse> getComments() {
		return comments;
	}

	public PostUserResponse getUser() {
		return user;
	}
}
