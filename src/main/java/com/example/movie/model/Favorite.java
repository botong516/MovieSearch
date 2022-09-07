package com.example.movie.model;

import com.example.movie.dao.entity.MovieEntity;
import lombok.Data;

import java.util.List;
@Data
public class Favorite {
    private List<MovieEntity> likeList;
    private List<MovieEntity> wantToList;
}
