package com.example.movie.dao;

import com.example.movie.dao.entity.MovieListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieListsRepository extends JpaRepository<Long, MovieListEntity> {
    MovieListEntity findByUserId(Long userId);
}
