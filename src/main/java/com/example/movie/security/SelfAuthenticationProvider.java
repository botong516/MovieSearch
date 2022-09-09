package com.example.movie.security;

import com.example.movie.service.SysUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SelfAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    SysUserDetailsService sysUserDetailsService;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String account= authentication.getName();
        String password= (String) authentication.getCredentials();
        UserDetails userDetails= sysUserDetailsService.loadUserByUsername(account);
        boolean checkPassword= bCryptPasswordEncoder.matches(password,userDetails.getPassword());
        if(checkPassword){
            throw new BadCredentialsException("密码不正确，请重新登录!");
        }
        return new UsernamePasswordAuthenticationToken(account, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
