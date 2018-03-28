package com.blog.microservices.commentStrategy;

import com.blog.microservices.domains.Comment;
import com.blog.microservices.domains.Post;
import org.springframework.stereotype.Component;

@Component
public class AuthorCommentStrategy implements CommentStrategy {

    @Override
    public void addComment(Post post, Comment comment) {
        Comment newComment = new Comment("I'm an Author - " + comment.getTitle(), comment.getContent(), comment.getUser());
        post.addComment(newComment);
    }
}
