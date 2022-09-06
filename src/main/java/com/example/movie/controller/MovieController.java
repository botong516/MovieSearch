package com.example.movie.controller;

import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

//    @PostMapping("")
//    public String AddMovie(@RequestBody MovieEntity movie, BindingResult bindingResult) {
//        for (ObjectError error : bindingResult.getAllErrors()) {
//            return error.getDefaultMessage();
//        }
//        System.out.println(movie.getName());
//        return movieService.AddMovie();
//    }

    @GetMapping("/search")
    public Object Search(String keyword) {
        return  movieService.Search(keyword);
    }

    @GetMapping("/meilisearch")
    public Object Meilisearch(String keyword) {
        return  movieService.Search(keyword);
    }
}

