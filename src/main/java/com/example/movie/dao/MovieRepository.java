package com.example.movie.dao;

import com.example.movie.dao.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {

}
