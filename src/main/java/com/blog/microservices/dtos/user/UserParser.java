package com.blog.microservices.dtos.user;

import com.blog.microservices.domains.User;
import com.blog.microservices.dtos.Parser;
import org.springframework.stereotype.Component;

@Component("userParser")
public class UserParser implements Parser<UserRequest, UserResponse, User> {
   
	    @Override
	    public User toModel(UserRequest input) {
	         return new User(null,input.getName(),input.getRole());
	    }

	    @Override
	    public UserResponse toDTO(User model) {
	         return new UserResponse(model.getId(), model.getName(),model.getRole());
	    }
}
