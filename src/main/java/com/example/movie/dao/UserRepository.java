package com.example.movie.dao;

import com.example.movie.dao.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<SysUserEntity, Long> {
    SysUserEntity getByUsername(String username);
    List<SysUserEntity> findByUsername(String username);
}
