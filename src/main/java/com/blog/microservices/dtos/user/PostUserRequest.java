package com.blog.microservices.dtos.user;

import com.blog.microservices.dtos.Request;

import javax.validation.constraints.NotNull;

public class PostUserRequest extends Request {

    @NotNull
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
