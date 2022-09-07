package com.example.movie.service;

import com.example.movie.model.MovieDetail;
import com.example.movie.model.SearchMovieResp;
import com.example.movie.model.TopMoviesResp;
import com.mysql.cj.protocol.x.Notice;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.example.movie.constant.IMDBConstant.*;

@Service
public class MovieService {

    @Autowired
    public RestTemplate restTemplate;

    public TopMoviesResp Top250Movies() {
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        ResponseEntity<TopMoviesResp> response = restTemplate.exchange(TOP250MOVIES, HttpMethod.GET,
                httpEntity, TopMoviesResp.class);
        return response.getBody();
    }


    public SearchMovieResp Search(String keyword) {
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        String url = SEARCH + keyword;
        ResponseEntity<SearchMovieResp> response = restTemplate.exchange(url, HttpMethod.GET,
                httpEntity, SearchMovieResp.class);
        return response.getBody();
    }

    public TopMoviesResp MostPopular() {
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        ResponseEntity<TopMoviesResp> response = restTemplate.exchange(MOSTPOPULAR, HttpMethod.GET,
                httpEntity, TopMoviesResp.class);
        return response.getBody();
    }


    public MovieDetail MovieDetail() {
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        ResponseEntity<MovieDetail> response = restTemplate.exchange(MOVIEDETAIL, HttpMethod.GET,
                httpEntity, MovieDetail.class);
        return response.getBody();
    }

    @NotNull
    private static HttpEntity<Resource> getResourceHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<Resource> httpEntity = new HttpEntity<>(headers);
        return httpEntity;
    }

}

