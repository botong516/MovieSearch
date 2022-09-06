package com.example.movie.service;

import com.example.movie.model.SearchMovieResp;
import com.mysql.cj.protocol.x.Notice;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class MovieService {

    public Object Search(String keyword) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://imdb-api.com/en/API/SearchMovie/k_8kmyy76b/"+keyword).
                build().encode();
        URI uri = uriComponents.toUri();
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");
        headers.add("user-agent", "Application");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String url1 = "http://imdb-api.com/en/API/SearchMovie/k_8kmyy76b/12";
        String productFound = restTemplate.exchange(url1, HttpMethod.GET, entity, String.class).getBody();

        ResponseEntity<String> result = restTemplate.getForEntity(url1,String.class);



//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url("http://127.0.0.1:8080/hello")
//                .method("GET", null)
//                .build();
//        try {
//            Response response = client.newCall(request).execute();
//            System.out.println(response.body().toString());
//        } catch (Exception e) {
//
//        }
        return "movies";
    }


    public Object MeiliSearch(String keyword) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString("http://imdb-api.com/en/API/SearchMovie/k_8kmyy76b/"+keyword).
                build().encode();
        URI uri = uriComponents.toUri();
        RestTemplate restTemplate = new RestTemplate();

        String url1 = "http://imdb-api.com/en/API/SearchMovie/k_8kmyy76b/";
        return "movies";
    }
}

