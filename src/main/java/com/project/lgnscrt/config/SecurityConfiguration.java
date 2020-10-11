package com.project.lgnscrt.config;

import com.project.lgnscrt.security.VerifyTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("viewer")
                .password("viewer")
                .roles("VIEWER")
                .and()
                .withUser("administrator")
                .password("administrator")
                .roles("ADMINISTRATOR");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        "/api/sensor-list",
                        "/api/sensor",
                        "/api/save-sensor",
                        "/api/delete-sensor",
                        "/api/update-sensor")
                .hasRole("ADMINISTRATOR")
                .antMatchers("/api/sensor-list","/api/sensor")
                .hasAnyRole("VIEWER","ADMINISTRATOR")

                .antMatchers(HttpMethod.DELETE,"/api/delete-sensor/**").hasRole("ADMINISTRATOR")
                .antMatchers(HttpMethod.POST,"/api/**").hasRole("ADMINISTRATOR")
                .antMatchers("/api/login").hasAnyRole("VIEWER","ADMINISTRATOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/api/login")
                .and()
                .logout()
                .logoutUrl("/api/logout")
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}