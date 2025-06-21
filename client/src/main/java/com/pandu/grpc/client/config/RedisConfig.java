package com.pandu.grpc.client.config;

//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@Configuration
public class RedisConfig {

    private RedisCacheConfiguration redisCacheConfiguration;

    public RedisConfig(RedisCacheConfiguration redisCacheConfiguration) {
        this.redisCacheConfiguration = redisCacheConfiguration;
    }

//    @Bean
//    public RedissonClient redisson(){
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://localhost:6379");
//        return Redisson.create(config);
//    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(){
        return builder -> builder.withCacheConfiguration(
                "greeting",
                redisCacheConfiguration
        );
    }
}
