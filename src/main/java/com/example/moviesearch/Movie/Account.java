package com.example.moviesearch.Movie;

import java.util.HashSet;

public class Account {
    private final String username;
    private String password;
    private MovieList wantToWatch;
    private MovieList watched;
    private MovieList like;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        this.wantToWatch = new MovieList();
        this.watched = new MovieList();
        this.like = new MovieList();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void addToWantToWatch(Movie movie) {
        this.wantToWatch.add(movie);
    }

    public void addToWatched(Movie movie) {
        this.watched.add(movie);
    }

    public void addToLike(Movie movie) {
        this.like.add(movie);
    }

    public void removeFromWantToWatch(Movie movie) {
        this.wantToWatch.remove(movie);
    }

    public void removeFromWatched(Movie movie) {
        this.watched.remove(movie);
    }

    public void removeFromLike(Movie movie) {
        this.like.remove(movie);
    }

    public int wantToWatchSize() {
        return this.wantToWatch.getSize();
    }

    public int watchedSize() {
        return this.watched.getSize();
    }

    public int likeSize() {
        return this.like.getSize();
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", wantToWatch=" + wantToWatch +
                ", watched=" + watched +
                ", like=" + like +
                '}';
    }
}
