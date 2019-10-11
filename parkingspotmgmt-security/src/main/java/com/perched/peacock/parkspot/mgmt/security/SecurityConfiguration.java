package com.perched.peacock.parkspot.mgmt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${user.oauth.user.username}")
    private String userName;
    @Value("${user.oauth.user.password}")
    private String password;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(userName).password(passwordEncoder.encode(password)).roles("CLIENT", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**").authorizeRequests().antMatchers("/oauth/authorize**", "/login**", "/error**")
                .permitAll().and().authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }
}
