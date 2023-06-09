/**

 Configuration class for security settings and filters.
 */
package com.kino.kino_backend.Configuration;

import jakarta.servlet.Filter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfiguration {

    /**
     * Configures the security filter chain for the HTTP requests.
     *
     * @param http the HttpSecurity object used for configuring security
     * @return the configured SecurityFilterChain object
     * @throws Exception if an exception occurs during configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                .csrf()
                .disable()
                .authorizeHttpRequests()
//                        .requestMatchers(request -> request.getServletPath().startsWith("/api/"))
                        .requestMatchers("/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated()
                        .and()
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .authenticationProvider(authenticationProvider)
                        .addFilterBefore(
                                jwtAuthFilter,
                                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    private final AuthenticationProvider authenticationProvider;

    private final  JWTAuthenticationFilter jwtAuthFilter;
}
