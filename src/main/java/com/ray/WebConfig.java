package com.ray;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.concurrent.TimeUnit;
//https://www.youtube.com/watch?v=MNgliKze8oI&list=PLsyeobzWxl7rjSO6xX00UWmVhL90i-cOk&index=10
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ray.controller", "com.ray.config", "com.ray.dao", "com.ray.service"})
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        System.out.println("hello, this is from dispatcher resolver");

        return resolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Register resource handler for CSS and JS
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
              //  .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());


    }
}