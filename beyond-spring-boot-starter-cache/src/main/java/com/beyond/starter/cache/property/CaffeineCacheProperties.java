package com.beyond.starter.cache.property;

import com.beyond.cache.caffeine.CaffeineCacheOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author bin_beyond@outlook.com
 * @since 2022/12/5
 */
@ConfigurationProperties("app.cache.caffeine")
public class CaffeineCacheProperties extends CacheProperties implements CaffeineCacheOptions {

    private int initialCapacity = 100;

    private Duration refreshAfterWrite = Duration.ofSeconds(2);

    @Override
    public int initialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(final int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }

    @Override
    public Duration getRefreshAfterWrite() {
        return refreshAfterWrite;
    }

    public void setRefreshAfterWrite(final Duration refreshAfterWrite) {
        this.refreshAfterWrite = refreshAfterWrite;
    }
}
