package com.blog.microservices.domains;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="category")
public class Category {

	@Id
	private String id;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	protected Category() {}

	public Category(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
