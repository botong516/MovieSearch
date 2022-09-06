package com.example.movie.controller;

import com.example.movie.dao.entity.SysUserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class IndexController {

    @GetMapping("/hello")
    public Object SayHello(){
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "CurrentUserID:" + sysUserEntity.getUserId();
    }

}
