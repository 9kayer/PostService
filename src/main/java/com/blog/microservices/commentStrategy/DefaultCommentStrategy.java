package com.blog.microservices.commentStrategy;

import com.blog.microservices.domains.Comment;
import com.blog.microservices.domains.Post;
import org.springframework.stereotype.Component;

@Component
public class DefaultCommentStrategy implements CommentStrategy{

    @Override
    public void addComment(Post post, Comment comment) {
        post.addComment(new Comment("I'm Different, u Biatches! - " + comment.getTitle(), comment.getContent(), comment.getUser()));
    }
}
