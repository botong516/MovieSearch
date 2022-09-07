package com.example.movie.service;

import com.example.movie.dao.MovieRepository;
import com.example.movie.dao.UserRepository;
import com.example.movie.dao.entity.MovieEntity;
import com.example.movie.dao.entity.SysUserEntity;
import com.example.movie.enums.LikeStatus;
import com.example.movie.enums.WatchStatus;
import com.example.movie.model.Favorite;
import com.example.movie.model.MovieReq;
import com.example.movie.model.MovieTrailer;
import com.example.movie.model.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    // If existent username or password inconsistent, return error message
    // If register successed, add row for the user in movie list
    // and go back to log in web page (Not sure how to do)
    public String Register(RegisterDto regiDto) {
        List<SysUserEntity> users = userRepository.findByUsername(regiDto.getName());
        if (users!= null && users.size() > 0) {
            return "username occupied";
        } else {
            if (regiDto.getPassword1() != regiDto.getPassword2()) {
                return "password inconsistent";
            }
        }
        SysUserEntity newUser = new SysUserEntity();
        newUser.setPassword(regiDto.getPassword1());
        newUser.setUsername(regiDto.getName());
        userRepository.save(newUser);
        return "registered success";
    }

    // 调repo存数据库
    // Delete from Watched List
    public String WantToWatch(MovieReq movie) {
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long currentUserID = sysUserEntity.getId();
        if (currentUserID == 0) {
            return null;
        }
        MovieEntity want = movieRepository.findByUserIDAndMovieID(currentUserID, movie.getMovieID());
        if (want == null) {
            want = new MovieEntity();
            want.setUserID(currentUserID);
            want.setMovieID(movie.getMovieID());
            SetMovieEntity(want, movie.getMovieID());
        }
        want.setIsWantToWatch(movie.getWantToWatch().getCode());
        movieRepository.save(want);
        return want.getMovieID();
    }


    // 调repo存数据库
    public String Like(MovieReq movie) {
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long currentUserID = sysUserEntity.getId();
        if (currentUserID == 0) {
            return null;
        }
        MovieEntity like = movieRepository.findByUserIDAndMovieID(currentUserID, movie.getMovieID());
        if (like == null) {
            like = new MovieEntity();
            like.setUserID(currentUserID);
            like.setMovieID(movie.getMovieID());
            SetMovieEntity(like, movie.getMovieID());
        }
        like.setIslike(movie.getLike().getCode());
        movieRepository.save(like);
        return like.getMovieID();
    }


    public void SetMovieEntity(MovieEntity movieEntity, String movieID) {
        MovieTrailer  movieTrailer  = movieService.Trailer(movieID);
        if (movieTrailer == null || movieTrailer.getImDbId() == "") {
            return;
        }
        if (movieTrailer.getTitle() != "") {
            movieEntity.setTitle(movieTrailer.getTitle());
        }
        if (movieTrailer.getFullTitle() != "") {
            movieEntity.setFullTitle(movieTrailer.getFullTitle());
        }
        if (movieTrailer.getType() != "") {
            movieEntity.setType(movieTrailer.getType());
        }
        if (movieTrailer.getYear() != "") {
            movieEntity.setYear(movieTrailer.getYear());
        }
        if (movieTrailer.getVideoDescription() != "") {
            movieEntity.setVideoDescription(movieTrailer.getVideoDescription());
        }
        if (movieTrailer.getVideoTitle() != "") {
            movieEntity.setVideoTitle(movieTrailer.getVideoTitle());
        }
        if (movieTrailer.getThumbnailUrl() != "") {
            movieEntity.setThumbnailUrl(movieTrailer.getThumbnailUrl());
        }
        if (movieTrailer.getLink() != "") {
            movieEntity.setLink(movieTrailer.getLink());
        }
    }


    // 调repo存数据库
    public Favorite Favorite() {
        Favorite favorite = new Favorite();
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long currentUserID = sysUserEntity.getId();
        if (currentUserID == 0) {
            return favorite;
        }
        List<MovieEntity> favorites = movieRepository.findByUserID(currentUserID);
        if (favorites == null || favorites.size() ==0) {
            return favorite;
        }
        List<MovieEntity> likeList = new ArrayList<>();
        List<MovieEntity> wantToList = new ArrayList<>();
        for( MovieEntity movieEntity : favorites) {
            if (movieEntity.getIslike() == LikeStatus.like.getCode()) {
                likeList.add(movieEntity);
            }
            if (movieEntity.getIsWantToWatch() == WatchStatus.wanttowatch.getCode()) {
                wantToList.add(movieEntity);
            }
        }
        favorite.setLikeList(likeList);
        favorite.setWantToList(wantToList);
        return favorite;
    }
}
