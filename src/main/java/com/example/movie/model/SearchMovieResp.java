package com.example.movie.model;

import lombok.Data;

import java.util.List;
@Data
public class SearchMovieResp {
    private String searchType;
    private String expression;
    private List<SearchMovieItem> results;
    private String errorMessage;
}

@Data
class SearchMovieItem {
    private String id;
    private String resultType;
    private String image;
    private String title;
    private String description;
}
