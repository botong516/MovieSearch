package com.example.movie.service;

import com.example.movie.model.MovieDetail;
import com.example.movie.model.MovieTrailer;
import com.example.movie.model.SearchMovieResp;
import com.example.movie.model.TopMoviesResp;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static com.example.movie.constant.IMDBConstant.*;

@Service
public class MovieService {
    @Autowired
    public RestTemplate restTemplate;

    private TopMoviesResp topMoviesResp;

    public TopMoviesResp Top250Movies() {
        if (topMoviesResp != null) {
            return topMoviesResp;
        }
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        ResponseEntity<TopMoviesResp> response = restTemplate.exchange(TOP250MOVIES, HttpMethod.GET,
                httpEntity, TopMoviesResp.class);
        TopMoviesResp resp = response.getBody();
        if (resp != null && resp.getItems() != null && resp.getItems().size() > 0)
            topMoviesResp = response.getBody();
        return topMoviesResp;
    }

    private HashMap<String, SearchMovieResp> topMoviesRespMap = new HashMap<>();
    public SearchMovieResp Search(String keyword) {
        if (topMoviesRespMap.get(keyword) != null) {
            return topMoviesRespMap.get(keyword);
        }
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        String url = SEARCH + keyword;
        ResponseEntity<SearchMovieResp> response = restTemplate.exchange(url, HttpMethod.GET,
                httpEntity, SearchMovieResp.class);
        SearchMovieResp resp = response.getBody();
        if (resp != null && resp.getResults() != null && resp.getResults().size() > 0)
            topMoviesRespMap.put(keyword, response.getBody());
        return response.getBody();
    }

    public TopMoviesResp MostPopular() {
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        ResponseEntity<TopMoviesResp> response = restTemplate.exchange(MOSTPOPULAR, HttpMethod.GET,
                httpEntity, TopMoviesResp.class);
        return response.getBody();
    }


    private HashMap<String, MovieDetail> movieDetailMap = new HashMap<>();

    public MovieDetail MovieDetail(String id) {
        if (movieDetailMap.get(id) != null) {
            return movieDetailMap.get(id);
        }
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        String url = MOVIEDETAIL + id;
        ResponseEntity<MovieDetail> response = restTemplate.exchange(url, HttpMethod.GET,
                httpEntity, MovieDetail.class);
        MovieDetail resp = response.getBody();
        if (resp != null && resp.getId() != "")
            movieDetailMap.put(id, response.getBody());
        return response.getBody();
    }


    private HashMap<String, MovieTrailer> movieTrailerMap = new HashMap<>();

    public MovieTrailer Trailer(String id) {
        if (movieTrailerMap.get(id) != null) {
            return movieTrailerMap.get(id);
        }
        HttpEntity<Resource> httpEntity = getResourceHttpEntity();
        String url = TRAILER + id;
        ResponseEntity<MovieTrailer> response = restTemplate.exchange(url, HttpMethod.GET,
                httpEntity, MovieTrailer.class);
        MovieTrailer resp = response.getBody();
        if (resp != null && resp.getImDbId() != "")
            movieTrailerMap.put(id, response.getBody());
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

