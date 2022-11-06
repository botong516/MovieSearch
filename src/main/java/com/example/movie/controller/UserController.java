package com.example.movie.controller;

import com.example.movie.dao.entity.MovieEntity;
import com.example.movie.model.Favorite;
import com.example.movie.model.MovieReq;
import com.example.movie.model.UserDto;
import com.example.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/wanttowatch")
    public String WantToWatch(@RequestBody MovieReq movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.WantToWatch(movie);
    }

    @PostMapping("/like")
    public String Like(@RequestBody MovieReq movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        return userService.Like(movie);
    }

    @GetMapping("/favorite")
    public Favorite favorite() {
        return userService.Favorite();
    }

}
