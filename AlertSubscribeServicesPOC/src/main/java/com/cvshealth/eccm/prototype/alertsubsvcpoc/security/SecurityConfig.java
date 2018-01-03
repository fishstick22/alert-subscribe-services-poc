package com.cvshealth.eccm.prototype.alertsubsvcpoc.security;

import com.auth0.spring.security.api.JwtWebSecurityConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
    @Value(value = "${auth0.apiAudience}")
    private String apiAudience;
    @Value(value = "${auth0.issuer}")
    private String issuer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtWebSecurityConfigurer
                .forRS256(apiAudience, issuer)
                .configure(http)
                .cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/login").permitAll()
                .antMatchers(HttpMethod.GET, "/communication/**").permitAll()
                .antMatchers(HttpMethod.GET, "/client/**").hasAuthority("read:client")
//                .antMatchers(HttpMethod.POST, "/photos/**").hasAuthority("create:photos")
//                .antMatchers(HttpMethod.PUT, "/photos/**").hasAuthority("update:photos")
//                .antMatchers(HttpMethod.DELETE, "/photos/**").hasAuthority("delete:photos")
                .anyRequest().authenticated();
                //.anyRequest().permitAll();
    }	
}
