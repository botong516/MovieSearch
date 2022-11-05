package com.example.movie.controller;

import com.example.movie.dao.entity.SysUserEntity;
import com.example.movie.model.RegisterDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "api/v1/")
public class IndexController {

    @GetMapping("hello") // 声明get接口
    public Object SayHello(){
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "CurrentUserID:" + sysUserEntity.getId();
    }

    @GetMapping("userInfo")
    public Object GetUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if  (principal == null ) {
            return  "";
        }
        if (principal instanceof String) {
            return principal;
        }
        SysUserEntity sysUserEntity = (SysUserEntity) principal;
        if  (sysUserEntity == null) {
            return  "";
        }
        return sysUserEntity.getUsername();
    }
}
