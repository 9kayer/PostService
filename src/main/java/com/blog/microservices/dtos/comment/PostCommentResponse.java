package com.blog.microservices.dtos.comment;

import com.blog.microservices.dtos.Response;
import com.blog.microservices.dtos.user.UserResponse;

public class PostCommentResponse extends Response {

    private String title;
    private String content;
    private UserResponse user;

    public PostCommentResponse() {}

    public PostCommentResponse(String title, String content,UserResponse user) {
        this.title = title;
        this.content  = content;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public UserResponse getUser() {
        return user;
    }
}
