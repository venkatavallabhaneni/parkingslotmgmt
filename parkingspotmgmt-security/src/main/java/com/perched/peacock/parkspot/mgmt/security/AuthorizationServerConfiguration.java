package com.perched.peacock.parkspot.mgmt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Value("${user.oauth.clientId}")
    private String clientId;
    @Value("${user.oauth.clientSecret}")
    private String clientSecret;
    @Value("${user.oauth.redirectUris}")
    private String redirectUris;
    @Value("${user.oauth.scopes}")
    private String scopes;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient(clientId).secret(passwordEncoder().encode(clientSecret))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials", "implicit")
                .authorities("CLIENT", "USER")
                .scopes(scopes.split(","))
                .redirectUris(redirectUris.split(","))
                .accessTokenValiditySeconds(360)
                .refreshTokenValiditySeconds(240000);
    }
}