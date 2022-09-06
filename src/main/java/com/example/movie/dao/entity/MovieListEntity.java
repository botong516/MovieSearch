package com.example.movie.dao.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "movieList")
@Data
@EntityListeners(AuditingEntityListener.class)
public class MovieListEntity {
    @Id
    @Column(name = "userId")
    private Long userId;

    @Lob
    @Column(name = "like")
    private Set<Long> like;

    @Lob
    @Column(name = "wantToWatch")
    private Set<Long> wantToWatch;

    @Lob
    @Column(name = "watched")
    private Set<Long> watched;

    public Long getUserId() {
        return userId;
    }

    public Set<Long> getLike() {
        return like;
    }

    public Set<Long> getWantToWatch() {
        return wantToWatch;
    }

    public Set<Long> getWatched() {
        return watched;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setLike(Set<Long> like) {
        this.like = like;
    }

    public void setWantToWatch(Set<Long> wantToWatch) {
        this.wantToWatch = wantToWatch;
    }

    public void setWatched(Set<Long> watched) {
        this.watched = watched;
    }
}
