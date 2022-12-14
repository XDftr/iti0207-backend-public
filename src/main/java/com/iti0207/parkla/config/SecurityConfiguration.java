package com.iti0207.parkla.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    public final static String AUTHORIZATION_HEADER = "Authorization";

    private final TokenProvider tokenProvider;

    public SecurityConfiguration(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        JWTFilter customFilter = new JWTFilter(this.tokenProvider);
        return http
                .authorizeRequests()
                .antMatchers("/api/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

