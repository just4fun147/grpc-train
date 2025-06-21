package com.pandu.grpc.client.service;

import com.pandu.grpc.GreetingRequest;
import com.pandu.grpc.GreetingResponse;
import com.pandu.grpc.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class GreetingService extends TestServiceGrpc.TestServiceImplBase {

    private CacheService cacheService;

    public GreetingService(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public void greetings(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        GreetingResponse response = GreetingResponse.newBuilder()
                .setMessage(cacheService.generateName(request.getName()))
                .setName(request.getName())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
