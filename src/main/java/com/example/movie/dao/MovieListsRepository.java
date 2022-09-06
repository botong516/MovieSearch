package com.example.movie.dao;

import com.example.movie.dao.entity.MovieEntity;
import com.example.movie.dao.entity.MovieListEntity;
import com.example.movie.dao.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

@Repository
public interface MovieListsRepository extends JpaRepository<SysUserEntity, HashSet> {
    MovieListEntity findByUserId(Long userId);
}
