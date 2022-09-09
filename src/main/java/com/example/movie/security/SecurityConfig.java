package com.example.movie.security;

import com.example.movie.service.SysUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SysUserDetailsService sysUserDetailsService;

    @Autowired
    AuthenticationEnryPoint authenticationEnryPoint;    //未登录

    @Autowired
    AuthenticationSuccess authenticationSuccess;    //登录成功

    @Autowired
    AuthenticationFailure authenticationFailure;    //登录失败

    @Autowired
    SelfAuthenticationProvider selfAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(sysUserDetailsService)
//                .passwordEncoder(passwordEncoder());
        auth.authenticationProvider(selfAuthenticationProvider);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/api/v1/**").authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login").permitAll()
//                .and().csrf().disable()
//                .cors();

        http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers("/api/v1/**").authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login").permitAll()
                .successHandler(authenticationSuccess)
                .failureHandler(authenticationFailure)
                .and()
                .logout()
                .permitAll()
                .and().exceptionHandling()
                .authenticationEntryPoint(authenticationEnryPoint)
                .and()
                .sessionManagement()
        ;
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:8000", "http://localhost:8000"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST"));
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return source;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }

}
