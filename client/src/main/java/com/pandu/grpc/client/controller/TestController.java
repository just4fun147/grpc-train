package com.pandu.grpc.client.controller;

import com.pandu.grpc.client.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {
    private CacheService cacheService;

    public TestController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @GetMapping("/test")
    public String test(String name) {
        return cacheService.generateName(name);
    }
}
