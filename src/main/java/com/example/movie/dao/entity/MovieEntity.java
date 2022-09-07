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
    @Column()
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column()
    private Long userID;

    @Column()
    private String movieID;

    @Column()
    private String movieName;

    @Column()
    private String movieDesc;

    @Column()
    private int isWantToWatch;

    @Column()
    private int islike;

    @Column()
    private String movieImg;

    @Column()
    private String createTime;

    @Column()
    private String updateTime;

}
