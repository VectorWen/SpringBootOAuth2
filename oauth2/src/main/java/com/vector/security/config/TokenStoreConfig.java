package com.vector.security.config;

import com.vector.security.store.RedisTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 *
 * 这里切换使用什么方式来存储token信息
 * author: vector.huang
 * date: 2018/09/22 12:31
 */
@Configuration
public class TokenStoreConfig {


//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);

        return new RedisTokenStore(redisConnectionFactory);
    }
}
