package com.example.movie.model;

import lombok.Data;

import java.util.List;

@Data
public class TopMoviesResp {
    private List<Item> items;
    private String errorMessage;
}

@Data
class Item {
    private String id;
    private String rank;
    private String fullTitle;
    private String image;
    private String year;
    private String crew;
    private String imDbRating;
    private String imDbRatingCount;
}


