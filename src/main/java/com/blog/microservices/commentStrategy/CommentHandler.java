package com.blog.microservices.commentStrategy;

import com.blog.microservices.domains.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CommentHandler {

    private Map<Role,CommentStrategy> strategyMap = new HashMap<>();

    @Autowired
    private ApplicationContext context;

    @PostConstruct
    private void init(){
        strategyMap.put(Role.AUTHOR, context.getBean(AuthorCommentStrategy.class));
        strategyMap.put(Role.REVIEWER, context.getBean(ReviewCommentStrategy.class));
    }

    public CommentStrategy getStrategy(Role role) {
        return strategyMap.getOrDefault(role, context.getBean(DefaultCommentStrategy.class));
    }

}
