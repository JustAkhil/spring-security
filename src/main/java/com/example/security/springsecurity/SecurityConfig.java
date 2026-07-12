package com.example.security.springsecurity;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // admin ko sirf admin access karega aur user ko user /admin is end point /** mean any end point contain admin

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity.authorizeHttpRequests(authorizeRequest ->
                authorizeRequest.requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
                        .anyRequest().authenticated());
        httpSecurity.httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    // this  userDetailService interface is use to load the user data
    // noop tells spring not hash or encrypt the password store it in plain text

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("user1")
                .password("{noop}user1")
                .roles("USER")
                .build();

        UserDetails user2 = User.withUsername("user2")
                .password("{noop}user2")
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1, user2, admin);
    }
}
