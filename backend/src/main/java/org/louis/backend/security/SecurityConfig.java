package org.louis.backend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


//    @Value("${app.url}")
//    private String appUrl;


    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(a -> a
                        .requestMatchers("/swagger-ui/**").permitAll()
                        .requestMatchers("/api/secured").authenticated()
                        .requestMatchers("/api/**").permitAll()

                        .anyRequest().permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/api/auth/logout")
                        .logoutSuccessHandler(((request, response, authentication) -> response.setStatus(200))))
                .sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                .oauth2Login(o -> o.defaultSuccessUrl("/login/oauth2/code/github"));
        return http.build();
    }

     */


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {


        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> {
                  //  request.requestMatchers("/swagger-ui/**").permitAll();
                  //  request.requestMatchers("/api/secured").authenticated();
                 //   request.requestMatchers("/api/**").permitAll();
                    request.anyRequest().permitAll();
                })
                .logout(logout -> logout
                        .logoutUrl("/api/user/logout")
                        .logoutSuccessHandler(((request, response, authentication) -> response.setStatus(200))))
                .oauth2Login(o -> {o.defaultSuccessUrl("/login/oauth2/code/github");
                o.defaultSuccessUrl("/", true);})
                .sessionManagement(c -> c.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
                .httpBasic(c ->{
                    c.authenticationEntryPoint(((request, response, authException) -> response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase())));
                    c.init(httpSecurity);
                })
                .build();

    }

    /*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("123")
                        .password("{noop}123")
                        .roles("USER")
                        .build()
        );
    }

     */


    @Bean
    public PasswordEncoder passwordEncoder() {
        return Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
      //  return NoOpPasswordEncoder.getInstance();
    }








}