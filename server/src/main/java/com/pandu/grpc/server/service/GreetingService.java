package com.pandu.grpc.server.service;

import com.pandu.grpc.GreetingRequest;
import com.pandu.grpc.GreetingResponse;
import com.pandu.grpc.TestServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @GrpcClient("testService")
    private TestServiceGrpc.TestServiceBlockingStub testStub;

    public GreetingResponse getGreetingService(String name) {
        GreetingRequest request = GreetingRequest.newBuilder().setName(name).build();
        return testStub.greetings(request);
    }
}
