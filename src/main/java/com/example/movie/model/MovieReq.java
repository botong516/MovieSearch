package com.example.movie.model;


import com.example.movie.enums.LikeStatus;
import com.example.movie.enums.WatchStatus;
import lombok.Data;

@Data
public class MovieReq {
    public String movieID;
    public WatchStatus wantToWatch;
    public LikeStatus like;
}
