package com.pandu.grpc.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class BeanConfig {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
//
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration conf = new RedisStandaloneConfiguration("127.0.0.1", 6379);
//        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().build();
//        JedisConnectionFactory jedis = new JedisConnectionFactory(conf, jedisClientConfiguration);
//        jedis.afterPropertiesSet();
//        return jedis;
//    }
}
