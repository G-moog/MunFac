package com.kingmonkey.munfac.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.kingmonkey.MunFac"})
@EnableJpaRepositories(basePackages = {"com.kingmonkey.munfac"})
public class JPAConfiguration {
}
