package io.lab.springdatalab.security;

import io.lab.springdatalab.security.JwtFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/api/product/**").permitAll()
                .antMatchers("/api/order/**").permitAll()
                .antMatchers("/api/customer/**").hasAnyRole("CUSTOMER","ADMIN")
                .antMatchers("/api/admin/**").hasRole("ADMIN")
                .and()
                .addFilter(new JwtFilter(authenticationManager()));


    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/getToken");
    }
}
