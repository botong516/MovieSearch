package com.example.movie.dao.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @Lob
    @Column(columnDefinition="TEXT")
    private String videoDescription;

    @Column()
    private String thumbnailUrl;

    @Column()
    private String link;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createTime;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updateTime;

}
