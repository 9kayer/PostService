package com.blog.microservices.repositories;

import com.blog.microservices.domains.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PostRepository extends ReactiveCrudRepository<Post, String> {
	
	
}
