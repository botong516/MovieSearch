package com.example.movie.service;

import com.example.movie.dao.UserRepository;
import com.example.movie.dao.entity.SysUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SysUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; //user表

    @Override
    public UserDetails loadUserByUsername(String username) throws AuthenticationException {
        SysUserEntity user = userRepository.findFirstByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("login require");
        }
        return user;
    }
}