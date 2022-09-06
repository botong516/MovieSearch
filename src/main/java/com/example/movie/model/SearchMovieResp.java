package com.example.movie.model;

import lombok.Data;

import java.util.List;
@Data
public class SearchMovieResp {
    private String searchType;
    private String expression;
    private List<Movie> results;
    private String errorMessage;
}

