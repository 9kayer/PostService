package com.blog.microservices.dtos;

public interface Parser<I extends Request, O extends Response, M> {

    M toModel(I input);
    O toDTO(M model);
}
