package com.blog.microservices.dtos.comment;

import com.blog.microservices.domains.Comment;
import com.blog.microservices.dtos.Parser;
import com.blog.microservices.dtos.user.UserResponse;
import org.springframework.stereotype.Component;

@Component("postCommentParser")
public class PostCommentParser implements Parser<PostCommentRequest,PostCommentResponse,Comment> {

    @Override
    public Comment toModel(PostCommentRequest input) {
        return null;
    }

    @Override
    public PostCommentResponse toDTO(Comment model) {
        return new PostCommentResponse(
                    model.getTitle(),
                    model.getContent(),
                    new UserResponse(
                            model.getUser().getId(),
                            model.getUser().getName(),
                            model.getUser().getRole())
        );
    }
}
