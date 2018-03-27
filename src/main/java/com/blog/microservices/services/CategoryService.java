package com.blog.microservices.services;

import com.blog.microservices.domains.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private DiscoveryService discoveryService;

    @Value("CategoryService")
    private String serviceName;

    @Autowired
    private WebClient webClient;

    public Mono<Category> getCategoryById(String id) {

        return discoveryService.serviceAddressFor(serviceName).next()
                .flatMap(address -> Mono.just(webClient.mutate().baseUrl(address + "/category/" + id).build().get()))
                .map(WebClient.RequestHeadersSpec::retrieve)
                .flatMap(eq -> eq.bodyToMono(Category.class));
    }

    public Mono<List<Category>> getAllCategoriesById(List<String> idList) {

        final List<Category> categories = new ArrayList<>();
        Mono<List<Category>> mono = Mono.empty();

        for (String id : idList){
            mono = getCategoryById(id).map(category -> {
                categories.add(category);
                return categories;
            });
        }

        return mono;
    }
}
