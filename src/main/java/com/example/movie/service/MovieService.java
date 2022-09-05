package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class MovieService {
    public String AddMovie() {
        return "success";
    }

    // TODO Search IMDb’s API
    public Object Search(int limit, int offset) {
        Map<String, Object> params= new HashMap<>();
        params.put("limit", limit);
        params.put("offset", offset);
        return params;
    }

}

