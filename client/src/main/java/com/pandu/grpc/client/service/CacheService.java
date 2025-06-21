package com.pandu.grpc.client.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    @Cacheable(value = "greeting", key = "#name")
    public String generateName(String name){
        System.out.println("Generating: " + name);
        return "Hello" + name;
    }
}
