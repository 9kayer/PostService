package com.blog.microservices.dtos.category;

import com.blog.microservices.dtos.Request;

public class PostCategoryRequest extends Request {

    private String id;

    public PostCategoryRequest() {
    }

    public PostCategoryRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
