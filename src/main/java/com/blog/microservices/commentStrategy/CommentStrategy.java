package com.blog.microservices.commentStrategy;

import com.blog.microservices.domains.Comment;
import com.blog.microservices.domains.Post;

public interface CommentStrategy {

    void addComment(Post post, Comment comment);
}
