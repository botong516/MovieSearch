package com.example.movie.enums;

import lombok.Getter;

@Getter
public enum LikeStatus implements BaseEnum  {
    like(3, "点赞"), unlike(4, "取消点赞");

    private Integer code;
    private String desc;

    LikeStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return code;
    }

}
