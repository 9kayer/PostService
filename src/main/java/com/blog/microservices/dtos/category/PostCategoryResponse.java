package com.blog.microservices.dtos.category;

import com.blog.microservices.dtos.Response;

public class PostCategoryResponse extends Response {

    private String id;
    private String name;

    protected PostCategoryResponse() {}

    public PostCategoryResponse(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
