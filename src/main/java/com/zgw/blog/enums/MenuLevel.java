package com.zgw.blog.enums;

/**
 * Created by Zhaogw&Lss on 2019/4/24.
 */
public enum MenuLevel {
    TOP_MENU(1, "顶部菜单"),
    MAIN_MENU(2, "主体菜单");

    private Integer value;

    private String message;

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

    MenuLevel(Integer value, String message) {
        this.value = value;
        this.message = message;
    }
}
