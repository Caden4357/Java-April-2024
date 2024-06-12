package com.codingdojo.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration // Indicates that this class contains one or more bean methods and may be processed by the Spring container.
public class WebSecurityConfig {
	
	@Autowired UserDetailsService userDetailsService;
    @Autowired // Automatically injects the HandlerMappingIntrospector bean.
    HandlerMappingIntrospector introspector;

	// Add BCrypt Bean
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean // Declares this method as a bean to be managed by the Spring container.
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests( // Configures authorization for HTTP requests.
                auth -> auth.requestMatchers( 
                		// Specifies the request matchers for authorization.
                    new MvcRequestMatcher(introspector, "/"), // Matcher for the root URL.
                    new MvcRequestMatcher(introspector, "/home"), // Matcher for the "/home" URL.
                    new MvcRequestMatcher(introspector, "/news/feed") 
                ).authenticated() // Requires authentication for these URLs.
                .anyRequest().permitAll() // Allows access to all other URLs without authentication.
            )
            .formLogin( // Enables form-based authentication.
                form -> form.loginPage("/login") // Specifies the custom login page URL.
                .defaultSuccessUrl("/home") // Redirects to "/home" after successful login.
                .permitAll() // Allows everyone to access the login page.
            )
            .logout( // Configures logout functionality.
                logout -> logout.permitAll() // Allows everyone to access the logout functionality.
            );
        return http.build(); // Builds the SecurityFilterChain object.
    }
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
      }
}