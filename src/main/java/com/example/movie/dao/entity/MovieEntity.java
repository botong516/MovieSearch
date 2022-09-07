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
    private int isWantToWatch;

    @Column()
    private int islike;

    @Column()
    private String title;

    @Column()
    private String fullTitle;

    @Column()
    private String type;

    @Column()
    private String year;

    @Column()
    private String videoId;

    @Column()
    private String videoTitle;

    @Column()
    private String videoDescription;

    @Column()
    private String thumbnailUrl;

    @Column()
    private String link;

    @Column()
    private String createTime;

    @Column()
    private String updateTime;

}
