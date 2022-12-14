package com.example.movie.enums;

import lombok.Getter;

@Getter
public enum WatchStatus implements BaseEnum {
    wanttowatch(1, "ζ³η"), watched(2, "ηθΏ");

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

