package com.sismacontab.inventory.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Arrays;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
            // Caches existentes
            new ConcurrentMapCache("categoryList"),
            new ConcurrentMapCache("subcategoryList"),
            new ConcurrentMapCache("specific1List"),
            new ConcurrentMapCache("specific2List"),
            new ConcurrentMapCache("hierarchyList"),
            // Nuevos caches para atributos de productos
            new ConcurrentMapCache("formasFarmaceuticasActivas"),
            new ConcurrentMapCache("viasAdministracionActivas"),
            new ConcurrentMapCache("poblacionesDianaActivas"),
            new ConcurrentMapCache("tagsActivos")
        ));
        return cacheManager;
    }
}