package com.blog.microservices.services;

import com.blog.microservices.domains.Role;
import com.blog.microservices.domains.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private User defaultUser = new User("-1","Default", Role.DEFAULT);

    public User getUserById(String id) {
        return defaultUser;
    }
}
