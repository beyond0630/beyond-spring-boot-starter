package com.beyond.starter.cache.property;

import com.beyond.cache.CacheOptions;
import com.beyond.starter.cache.enums.CacheType;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;

/**
 * @author bin_beyond@outlook.com
 * @since 2022/12/5
 */
@ConfigurationProperties("app.cache")
public class CacheProperties implements CacheOptions {

    private CacheType type;
    private int maxCapacity = 10000;

    private Duration expiration = Duration.ofHours(2);


    public CacheType getType() {
        return type;
    }

    public void setType(final CacheType type) {
        this.type = type;
    }

    @Override
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(final int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public Duration getExpiration() {
        return expiration;
    }

    public void setExpiration(final Duration expiration) {
        this.expiration = expiration;
    }

}
