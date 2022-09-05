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
    @Column(name = "id" )
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                '}';
    }
}
