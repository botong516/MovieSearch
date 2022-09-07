package com.example.movie.controller;

import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/top250")
    @ResponseBody
    public Object Top250Movies() {
        return  movieService.Top250Movies();
    }

    @GetMapping("/search")
    @ResponseBody
    public Object Search(String keyword) {
        return  movieService.Search(keyword);
    }

    @GetMapping("/mostpopular")
    @ResponseBody
    public Object MostPopular() {
        return  movieService.MostPopular();
    }


    @GetMapping("/{id}")
    @ResponseBody
    public Object MovieDetail(@PathVariable(name = "id") String id) {
        return movieService.MovieDetail(id);
    }
}

