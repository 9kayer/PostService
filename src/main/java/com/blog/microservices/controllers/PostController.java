package com.blog.microservices.controllers;

import com.blog.microservices.dtos.comment.PostCommentRequest;
import com.blog.microservices.dtos.post.PostParser;
import com.blog.microservices.dtos.post.PostRequest;
import com.blog.microservices.dtos.post.PostResponse;
import com.blog.microservices.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${root}")
public class PostController {

    @Autowired
    private PostService postService;

    @Resource(name = "postParser")
    private PostParser postParser;

    @GetMapping
    public Mono<ResponseEntity<Set<PostResponse>>> getPosts() {
        return postService.getPosts()
                    .collectList()
                    .flatMap(list -> Mono.just(ResponseEntity.ok(new HashSet<>( list.stream()
                                                                        .map(post -> postParser.toDTO(post))
                                                                        .collect(Collectors.toList()))))
                    );
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<PostResponse>> getPost(@PathVariable String id) {
        return postService.getPostById(id).map(post -> ResponseEntity.ok(postParser.toDTO(post)));
    }

    @PostMapping
    public Mono<ResponseEntity<PostResponse>> create(@RequestBody PostRequest postRequest) {
        return postService.create(postRequest).map(post -> ResponseEntity.ok(postParser.toDTO(post)));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<PostResponse>> update(@PathVariable String id,@RequestBody PostRequest postRequest) {
        return postService.update(id,postRequest).map(post -> ResponseEntity.ok(postParser.toDTO(post)));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity> delete(@PathVariable String id) {
        return postService.delete(id).map(item -> ResponseEntity.ok(item));
    }

    @PutMapping("/{id}/comment")
    public Mono<ResponseEntity<PostResponse>> addComment(@PathVariable String id, @RequestBody PostCommentRequest commentRequest){
        return postService.addComment(id, commentRequest).map(post -> ResponseEntity.ok(postParser.toDTO(post)));
    }
}
