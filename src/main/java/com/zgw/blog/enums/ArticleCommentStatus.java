package com.zgw.blog.enums;

/**
 * Created by Zhaogw&Lss on 2019/4/16.
 */
public enum ArticleCommentStatus {
    AllOW(1,"允许"),
    NOT_AllOW(0,"不允许");

    private Integer value;

    private String message;

    ArticleCommentStatus(Integer value, String message) {
        this.value = value;
        this.message = message;
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}
