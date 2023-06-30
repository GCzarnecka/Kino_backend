/**

 The CorsConfiguration class provides configuration for Cross-Origin Resource Sharing (CORS).
 It allows cross-origin requests from any origin and allows all methods and headers.
 */
package com.kino.kino_backend.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {


    /**
     * Creates a WebMvcConfigurer bean to configure CORS settings.
     *
     * @return An implementation of WebMvcConfigurer.
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }
        };
    }
}
