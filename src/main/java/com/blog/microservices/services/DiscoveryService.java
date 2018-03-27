package com.blog.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DiscoveryService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    public Flux<String> serviceAddressFor(String service){
        return Flux.defer(() -> Flux.just(this.discoveryClient.getInstances(service))
                                .flatMap(srv -> Mono.just(loadBalancerClient.choose(service)))
                                .flatMap(serviceInstance -> Mono.just(serviceInstance.getUri().toString())));
    }
}
