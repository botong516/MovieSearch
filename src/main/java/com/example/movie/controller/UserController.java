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

    @PostMapping("/wanttowatch")
    public String WantToWatch(@RequestBody MovieEntity movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.WantToWatch(movie);
    }

    @PostMapping("/watched")
    public String Watched(@RequestBody MovieEntity movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.Watched(movie);
    }

    @PostMapping("/like")
    public String Like(@RequestBody MovieEntity movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.Like(movie);
    }

    @PostMapping("/unlike")
    public String Unlike(@RequestBody MovieEntity movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.Unlike(movie);
    }
}
