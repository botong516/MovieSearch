package com.example.movie.controller;

import com.example.movie.model.RegisterDto;
import com.example.movie.model.UserDto;
import com.example.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public String Register(@RequestBody RegisterDto regiDto, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.Register(regiDto);
    }
}
