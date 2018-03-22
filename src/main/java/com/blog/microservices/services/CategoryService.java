package com.blog.microservices.services;

import com.blog.microservices.domains.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private Category defaultCategory = new Category("default");

    public Category getCategoryById(String id) {
        return defaultCategory;
    }
}
