package org.louis.backend.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager () {
        UserDetails john = User.builder()
                .username("rob")
                .password("1234")
                .roles("Employee")
                .build();

        return new InMemoryUserDetailsManager(john);
    }
}

