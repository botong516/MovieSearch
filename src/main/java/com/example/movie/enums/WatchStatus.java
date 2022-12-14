package com.example.movie.enums;

import lombok.Getter;

@Getter
public enum WatchStatus implements BaseEnum {
    wanttowatch(1, "想看"), watched(2, "看过");

    private Integer code;
    private String desc;

    WatchStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}

