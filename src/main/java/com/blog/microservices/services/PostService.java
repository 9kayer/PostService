package com.blog.microservices.services;

import com.blog.microservices.domains.Comment;
import com.blog.microservices.domains.Post;
import com.blog.microservices.dtos.comment.PostCommentRequest;
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

        final Post.PostBuilder postBuilder = new Post.PostBuilder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent());

        return categoryService.getAllCategoriesById(postRequest.getCategories().stream().map(postCategoryRequest -> postCategoryRequest.getId()).collect(Collectors.toList()))
                .map(categories -> {
                    postBuilder.categories(categories);
                    return categories;
                })
                .flatMap( list -> userService.getUserById(postRequest.getUser().getId()) )
                .map( user -> postBuilder.user(user).build() )
                .flatMap(post -> postRepository.save(post));
    }

    public Mono<Post> update(String id, PostRequest postRequest) {

        final Post.PostBuilder postBuilder = new Post.PostBuilder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent());

        return postRepository.findById(id)
                .flatMap(oldPost -> {
                    postBuilder.comments(oldPost.getComments());
                    return categoryService.getAllCategoriesById(postRequest.getCategories().stream().map(postCategoryRequest -> postCategoryRequest.getId()).collect(Collectors.toList()))
                            .map(categories -> {
                                postBuilder.categories(categories);
                                return categories;
                            })
                            .flatMap( list -> userService.getUserById(postRequest.getUser().getId()) )
                            .map( user -> postBuilder.user(user).build() )
                            .flatMap(post -> postRepository.save(post));
                });
    }

    public Mono<Void> delete(String id) {
        return postRepository.deleteById(id);
    }

    public Mono<Post> addComment(String id, PostCommentRequest commentRequest) {

        return userService.getUserById(commentRequest.getUser().getId())
                .map(user -> new Comment(commentRequest.getTitle(),commentRequest.getContent(), user))
                .flatMap(comment -> postRepository.findById(id)
                                        .map(post -> {
                                            post.addComment(comment);
                                            return post;
                                        })
                ).flatMap(post -> postRepository.save(post));
    }
}
