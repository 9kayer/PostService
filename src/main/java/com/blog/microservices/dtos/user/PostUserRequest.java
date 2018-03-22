package com.blog.microservices.dtos.user;

import com.blog.microservices.dtos.Request;

public class PostUserRequest extends Request {

    private String id;

    public PostUserRequest() {
    }

    public PostUserRequest(String id) {

        this.id = id;
    }

    public String getId() {
        return id;
    }
}
