package com.pandu.grpc.server.controller;

import com.pandu.grpc.GreetingResponse;
import com.pandu.grpc.server.rest.TestClient;
import com.pandu.grpc.server.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class GreetingController {
    private final GreetingService greetingService;
    private final TestClient testClient;
    public GreetingController(GreetingService greetingService, TestClient testClient) {
        this.greetingService = greetingService;
        this.testClient = testClient;
    }

    @GetMapping
    public String greeting(String name) {
        return greetingService.getGreetingService(name).getMessage();
    }

    @GetMapping("/feign")
    public String feign(String name) {
        return testClient.test(name);
    }
}
