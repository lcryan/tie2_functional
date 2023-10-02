package com.example.tie2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
/*    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
    }*/

    // sets up pw encoder //
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // ------ To implement authorisation here ------- -//
 /*   @Bean
    protected SecurityFilterChain filter(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .httpBasic().disable()
                .cors().and()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/info").hasRole("USER")
                .requestMatchers("/users/**").hasAnyRole("ADMIN", "USER")
                .requestMatchers("/admins").hasAuthority("ROLE_ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/users/{id}").hasRole("ADMIN")
                .requestMatchers("/authenticate").permitAll()

                .anyRequest().denyAll()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }*/
}


