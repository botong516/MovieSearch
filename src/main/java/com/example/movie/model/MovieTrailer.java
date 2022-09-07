package com.example.movie.model;

import lombok.Data;

@Data
public class MovieTrailer {
    private String imDbId;
    private String title;
    private String fullTitle;
    private String type;
    private String year;
    private String videoId;
    private String videoTitle;
    private String videoDescription;
    private String thumbnailUrl;
    private String uploadDate;
    private String link;
    private String linkEmbed;
    private String errorMessage;
}
