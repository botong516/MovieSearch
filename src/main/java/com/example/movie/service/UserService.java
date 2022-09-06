package com.example.movie.service;

import com.example.movie.dao.MovieListsRepository;
import com.example.movie.dao.UserRepository;
import com.example.movie.dao.entity.MovieEntity;
import com.example.movie.dao.entity.MovieListEntity;
import com.example.movie.dao.entity.SysUserEntity;
import com.example.movie.model.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieListsRepository movieListsRepository;

    // If existent username or password inconsistent, return error message
    // If register successed, add row for the user in movie list
    // and go back to log in web page (Not sure how to do)
    public String Register(RegisterDto regiDto) {
        SysUserEntity user = userRepository.findByUsername(regiDto.getName()).get();
        if (user != null) {
            return "username occupied";
        } else {
            if (regiDto.getPassword1() != regiDto.getPassword2()) {
                return "password inconsistent";
            }
        }

        SysUserEntity newUser = new SysUserEntity(regiDto.getName(), regiDto.getPassword1());
        userRepository.save(newUser);

        MovieListEntity movieList = new MovieListEntity();
        movieList.setUserId(newUser.getUserId());
        movieList.setLike(new HashSet<>());
        movieList.setWatched(new HashSet<>());
        movieList.setWatched(new HashSet<>());
        movieListsRepository.save(movieList);

        return "registered";
    }

    // 调repo存数据库
    // Delete from Watched List
    public String WantToWatch(MovieEntity movie) {
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        MovieListEntity wantList = movieListsRepository.findByUserId(sysUserEntity.getUserId());
        wantList.getWantToWatch().add(movie.getId());
        wantList.getWatched().remove(movie.getId());

        return "wanted";
    }

    // 调repo存数据库
    // Delete from WantToWatch List
    public String Watched(MovieEntity movie) {
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        MovieListEntity watchedList = movieListsRepository.findByUserId(sysUserEntity.getUserId());
        watchedList.getWatched().add(movie.getId());
        watchedList.getWantToWatch().remove(movie.getId());

        return "watched";
    }

    // 调repo存数据库
    public String Like(MovieEntity movie) {
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        MovieListEntity likeList = movieListsRepository.findByUserId(sysUserEntity.getUserId());
        likeList.getWatched().add(movie.getId());

        return "liked";
    }

    // Delete from Like list
    public String Unlike(MovieEntity movie) {
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        MovieListEntity likeList = movieListsRepository.findByUserId(sysUserEntity.getUserId());
        likeList.getWatched().remove(movie.getId());

        return "unliked";
    }
}
