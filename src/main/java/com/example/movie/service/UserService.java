package com.example.movie.service;

import com.example.movie.dao.MovieRepository;
import com.example.movie.dao.UserRepository;
import com.example.movie.dao.entity.MovieEntity;
import com.example.movie.dao.entity.SysUserEntity;
import com.example.movie.model.MovieReq;
import com.example.movie.model.RegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

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
        MovieEntity want = movieRepository.findByUserIDAndMovieID(currentUserID, movie.getMovieID());
        if (want == null) {
            want = new MovieEntity();
            want.setUserID(currentUserID);
            want.setMovieID(movie.getMovieID());
        }
        want.setIsWantToWatch(movie.getWantToWatch().getCode());
        movieRepository.save(want);
        return want.getMovieID();
    }


    // 调repo存数据库
    public String Like(MovieReq movie) {
        SysUserEntity sysUserEntity = (SysUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long currentUserID = sysUserEntity.getId();
        MovieEntity like = movieRepository.findByUserIDAndMovieID(sysUserEntity.getId(), movie.getMovieID());
        if (like == null) {
            like = new MovieEntity();
            like.setUserID(currentUserID);
            like.setMovieID(movie.getMovieID());
        }
        like.setIsLike(movie.getLike().getCode());
        movieRepository.save(like);
        return like.getMovieID();
    }

}
