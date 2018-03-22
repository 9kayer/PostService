package com.blog.microservices.dtos.post;

import com.blog.microservices.domains.Post;
import com.blog.microservices.dtos.Parser;
import com.blog.microservices.dtos.category.PostCategoryParser;
import com.blog.microservices.dtos.comment.PostCommentParser;
import com.blog.microservices.dtos.user.PostUserResponse;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.stream.Collectors;

@Component("postParser")
public class PostParser implements Parser<PostRequest, PostResponse, Post> {

	@Resource(name = "postCategoryParser")
	private PostCategoryParser postCategoryParser;
	@Resource(name = "postCommentParser")
	private PostCommentParser postCommentParser;


	@Override
    public Post toModel(PostRequest input) {
    	throw new UnsupportedOperationException("post parser");
    }

    @Override
    public PostResponse toDTO(Post model) {
    	return new PostResponse(
    			model.getId(),
    			model.getTitle(),
    			model.getContent(),
    			model.getCategories().stream().map(category -> postCategoryParser.toDTO(category)).collect(Collectors.toList()),
    			model.getComments().stream().map(comment -> postCommentParser.toDTO(comment)).collect(Collectors.toList()),
    			new PostUserResponse(model.getUser().getId(),model.getUser().getName(),model.getUser().getRole()));
    }
}
