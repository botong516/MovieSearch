package com.example.movie.controller;

import com.example.movie.dao.entity.MovieEntity;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("")
    public String AddMovie(@RequestBody MovieEntity movie, BindingResult bindingResult) {
        for (ObjectError error : bindingResult.getAllErrors()) {
            return error.getDefaultMessage();
        }
        System.out.println(movie.getName());
        return movieService.AddMovie();
    }

    @GetMapping("/search")
    public Object Search(@RequestParam(defaultValue = "0", name="limit") int limit,
                         @RequestParam(defaultValue = "0", name="offset") int offset) {
        return  movieService.Search(limit,offset);
    }


}

