package com.blog.microservices.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="post")
public class Post {

	@Id
	private String id;
	private String title;
	private String content;
	private List<Category> categories = new ArrayList<>();
	private List<Comment> comments = new ArrayList<>();
	private User user;

	protected Post() {}

	public Post(String title, String content, List<Category> categories, List<Comment> comments, User user) {
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

	public List<Category> getCategories() {
		return categories;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public User getUser() {
		return user;
	}

	public void addCategory(Category category){
		categories.add(category);
	}

	public void deleteCategory(Category category){
		categories.remove(category);
	}

	public void  addComment(Comment comment) {
		this.comments.add(comment);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o){
			return true;
		}
		if (o == null || getClass() != o.getClass()){
			return false;
		}

		Post post = (Post) o;

		return id != null ? id.equals(post.id) : post.id == null;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Post{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", categories=" + categories +
				", comments=" + comments +
				", user=" + user +
				'}';
	}

	public static class PostBuilder {

		private Post post;

		public PostBuilder(){
			post = new Post();
		}

		public PostBuilder id(String id){
			post.id = id;
			return this;
		}

		public PostBuilder title(String title){
			post.title = title;
			return this;
		}

		public PostBuilder content(String content){
			post.content = content;
			return this;
		}

		public PostBuilder categories(List<Category> categories){
			post.categories = categories;
			return this;
		}

		public PostBuilder comments(List<Comment> comments) {
			post.comments = comments;
			return this;
		}

		public PostBuilder user(User user){
			post.user = user;
			return this;
		}

		public Post build(){
			return post;
		}
	}
}
