package com.pandu.grpc.server.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "test-client", url = "localhost:8080")
public interface TestClient {

    @GetMapping("/test")
    String test(@RequestParam String name);
}
