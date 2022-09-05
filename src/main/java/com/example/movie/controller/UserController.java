package com.example.movie.controller;

import com.example.movie.dao.entity.MovieEntity;
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
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public String Register(@RequestBody UserDto userDto, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.Register();
    }

    @PostMapping("/like")
    public String Like(@RequestBody MovieEntity movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.Like();
    }


    @PostMapping("/favorites")
    public String Favorites(@RequestBody MovieEntity movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.Favorites();
    }
}
