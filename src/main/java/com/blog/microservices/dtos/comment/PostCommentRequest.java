package com.blog.microservices.dtos.comment;

import com.blog.microservices.dtos.Request;
import com.blog.microservices.dtos.user.PostUserRequest;

import javax.validation.constraints.NotNull;

public class PostCommentRequest extends Request {

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private PostUserRequest user;

    public PostCommentRequest() {
    }

    public PostCommentRequest(String title, String content, PostUserRequest user) {

        this.title = title;
        this.content = content;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public PostUserRequest getUser() {
        return user;
    }
}
