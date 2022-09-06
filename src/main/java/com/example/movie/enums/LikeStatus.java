package com.example.movie.enums;

import lombok.Getter;

@Getter
public enum LikeStatus implements BaseEnum  {
    like(1, "点赞"), unlike(2, "取消点赞");

    private Integer code;
    private String desc;

    LikeStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
