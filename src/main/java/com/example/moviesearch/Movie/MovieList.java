package com.example.moviesearch.Movie;

import java.util.HashSet;

public class MovieList {
    private HashSet<Movie> movieList;
    private int size;

    public MovieList() {
        this.movieList = new HashSet<>();
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public void add(Movie movie) {
        if (movieList.add(movie)) {
            size++;
        }
    }

    public void remove(Movie movie) {
        if (movieList.remove(movie)) {
            size--;
        }
    }
}
