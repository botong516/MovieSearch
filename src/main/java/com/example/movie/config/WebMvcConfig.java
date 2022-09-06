package com.example.movie.config;

import com.example.movie.enums.CodeToEnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 枚举 转化器工厂类 添加进 Spring Boot 配置
        registry.addConverterFactory(new CodeToEnumConverterFactory());
    }
}