package com.blog.microservices.dtos.category;

import com.blog.microservices.domains.Category;
import com.blog.microservices.dtos.Parser;
import org.springframework.stereotype.Component;

@Component("postCategoryParser")
public class PostCategoryParser implements Parser<PostCategoryRequest,PostCategoryResponse,Category> {

    @Override
    public Category toModel(PostCategoryRequest input) {
        return null;
    }

    @Override
    public PostCategoryResponse toDTO(Category model) {
        return new PostCategoryResponse(model.getId(), model.getName());
    }
}
