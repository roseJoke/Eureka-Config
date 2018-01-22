package com.kuliao.eurek.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {
    @Bean
    Logger.Level feignLoggerLevel(){          //实现日志配置  当然也可以用配置类实现
        return Logger.Level.FULL;
    }
}
