package com.blog.microservices.services;

import com.blog.microservices.domains.Post;
import com.blog.microservices.dtos.post.PostRequest;
import com.blog.microservices.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    public Flux<Post> getPosts() {
        return postRepository.findAll();
    }

    public Mono<Post> getPostById(String id) {
        return postRepository.findById(id);
}

    public Mono<Post> create(PostRequest postRequest) {

        Post post = new Post.PostBuilder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .categories(postRequest.getCategories()
                        .stream()
                        .map(categoryIdRequest -> categoryService.getCategoryById(categoryIdRequest.getId()))
                        .collect(Collectors.toList()))
                .user(userService.getUserById(postRequest.getUser().getId()))
                .build();

        return postRepository.save(post);

    }

    public Mono<Post> update(String id, PostRequest postRequest) {

        Post post = new Post.PostBuilder()
                .id(postRequest.getId())
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .categories(postRequest.getCategories()
                        .stream()
                        .map(categoryIdRequest -> categoryService.getCategoryById(categoryIdRequest.getId()))
                        .collect(Collectors.toList()))
                .user(userService.getUserById(postRequest.getUser().getId()))
                .build();

        return postRepository.save(post);
    }

    public Mono<Void> delete(String id) {
        return postRepository.deleteById(id);
    }
}
