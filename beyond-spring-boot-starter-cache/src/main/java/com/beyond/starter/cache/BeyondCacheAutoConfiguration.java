package com.beyond.starter.cache;

import com.beyond.cache.CacheManager;
import com.beyond.cache.caffeine.CaffeineCacheManger;
import com.beyond.cache.ehcache.EhCacheManager;
import com.beyond.starter.cache.enums.CacheType;
import com.beyond.starter.cache.property.CacheProperties;
import com.beyond.starter.cache.property.CaffeineCacheProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author bin_beyond@outlook.com
 * @since 2022/12/5
 */
@Slf4j
@Configuration
@EnableConfigurationProperties({CacheProperties.class, CaffeineCacheProperties.class})
public class BeyondCacheAutoConfiguration {

    @Bean
    public CacheManager cacheManager(@Qualifier("app.cache-com.beyond.starter.cache.property.CacheProperties") CacheProperties cacheProperties,
                                     final CaffeineCacheProperties caffeineCacheProperties) {
        final CacheType type = cacheProperties.getType();
        log.info("use {} cache", type);
        if (CacheType.CAFFEINE == type) {
            return new CaffeineCacheManger(caffeineCacheProperties);
        }
        if (CacheType.EHCACHE == type) {
            return new EhCacheManager(cacheProperties);
        }
        return null;
    }
}
