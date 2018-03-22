package com.blog.microservices.dtos.category;

import com.blog.microservices.dtos.Request;

public class CategoryRequest extends Request {

    private String name;

    public CategoryRequest() {}

    public CategoryRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
