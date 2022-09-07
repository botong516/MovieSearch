package com.example.movie.dao;

import com.example.movie.dao.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
    MovieEntity findByUserIDAndMovieID(Long userID, String movieID);

    List<MovieEntity> findByUserID(Long userID);
}
