package com.example.movie.dao.entity;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "movie")
@Data
@EntityListeners(AuditingEntityListener.class)
public class MovieEntity {

    @Id
    @Column(name = "movieId")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(name = "user")
    private String username;

    public String getName() {
        return name;
    }

    public String getUsername() { return username; }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }
}
