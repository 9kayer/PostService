package com.blog.microservices.dtos.category;

import com.blog.microservices.domains.Category;
import com.blog.microservices.dtos.Parser;
import org.springframework.stereotype.Component;

@Component("categoryParser")
public class CategoryParser implements Parser<CategoryRequest, CategoryResponse, Category> {

    @Override
    public Category toModel(CategoryRequest input) {
        return new Category(input.getName());
    }

    @Override
    public CategoryResponse toDTO(Category model) {
        return new CategoryResponse(model.getId(),model.getName());
    }
}
