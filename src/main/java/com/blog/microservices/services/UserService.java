package com.blog.microservices.services;

import com.blog.microservices.domains.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    private DiscoveryService discoveryService;

    @Autowired
    private WebClient webClient;

    @Value("UserService")
    private String serviceName;

    public Mono<User> getUserById(String id) {

        return discoveryService.serviceAddressFor(serviceName).next()
                .flatMap(address -> Mono.just(webClient.mutate().baseUrl(address + "/user/" + id).build().get()) )
                .map(WebClient.RequestHeadersSpec::retrieve)
                .flatMap(eq -> eq.bodyToMono(User.class));
    }
}
