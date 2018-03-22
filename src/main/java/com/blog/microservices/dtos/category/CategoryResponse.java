package com.blog.microservices.dtos.category;

import com.blog.microservices.dtos.Response;

public class CategoryResponse extends Response {

    private String id;
    private String name;

    public CategoryResponse() {}

    public CategoryResponse(String id, String name) {
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
