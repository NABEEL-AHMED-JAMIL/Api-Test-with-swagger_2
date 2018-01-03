package com.example.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author by Nabeel on 10/18/2017.
 */
/**************************************************************************
 * @class CachingConfig that help to perform operation on rest api's class as Caching data
 *
 * @Bean cacheManager() : @class CacheManager
 * @Bean cacheMangerFactory() : @class EhCacheManagerFactoryBean
 *
 *
 **************************************************************************/
@EnableJpaRepositories(basePackages = "com.example.demo.repository")
@Configuration
@EnableCaching
public class CachingConfig {


    /************************************************************************************************
     * A property group for {@link CachingConfig } checking the {@link CacheManager }
     *
     * @return {@link CacheManager } for {@link CachingConfig } configuration
     *
     *************************************************************************************************/
    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(cacheMangerFactory().getObject());
    }

    /************************************************************************************************
     * A property group for {@link CachingConfig } checking the {@link EhCacheManagerFactoryBean }
     *
     * @return {@link EhCacheManagerFactoryBean } for {@link CachingConfig } configuration
     *
     *************************************************************************************************/
    @Bean
    public EhCacheManagerFactoryBean cacheMangerFactory() {
        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        bean.setShared(true);
        return bean;
    }
}
