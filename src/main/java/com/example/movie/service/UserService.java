package com.example.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String Register() {
        return "like";
    }

    public String Like() {
        return "like";
    }

    public String Favorites() {
        return "favorites";
    }
}
