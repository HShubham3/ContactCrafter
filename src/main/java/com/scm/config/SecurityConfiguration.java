package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scm.services.impl.SecurityCustomUserDetailsService;

@Configuration
public class SecurityConfiguration {

    // user create and login using java code with in memory service.

    // @Bean
    // InMemoryUserDetailsManager userDetailsManager() {

    // UserDetails user1 = User
    // .withUsername("user1")
    // .password("12345")
    // .build();
    // UserDetails user2 = User
    // .withUsername("user2")
    // .password("12345")
    // .build();

    // return new InMemoryUserDetailsManager(user1, user2);
    // }

    @Autowired
    private SecurityCustomUserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        // need UserService object
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        // need password encoder object
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
