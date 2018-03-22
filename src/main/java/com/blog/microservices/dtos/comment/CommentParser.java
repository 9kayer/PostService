package com.blog.microservices.dtos.comment;

import com.blog.microservices.domains.Comment;
import com.blog.microservices.dtos.Parser;
import org.springframework.stereotype.Component;

@Component("commentParser")
public class CommentParser implements Parser<CommentRequest, CommentRespose, Comment> {

	
	@Override
    public Comment toModel(CommentRequest input) {
    	return new Comment(input.getTitle(),input.getContent(),input.getUser());
    }
	

	 @Override
	 public CommentRespose toDTO(Comment model) {	
	    return new CommentRespose(model.getTitle(),model.getContent(),model.getUser());
	 }
}
