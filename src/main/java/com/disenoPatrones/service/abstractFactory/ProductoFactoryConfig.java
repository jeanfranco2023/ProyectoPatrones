package com.disenoPatrones.service.abstractFactiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductoFactoryConfig {

     @Bean
    public ProductoFactory productoFactory() {
        return new ProductoFactoryImpl();
    }
    
}
