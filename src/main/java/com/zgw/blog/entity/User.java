package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zhaogw&Lss on 2019/4/13.
 */
@Data
public class User implements Serializable{
    private static final long serialVersionUID = -4117665428827854455L;
    private Integer userId;

    private String userName;

    private String userPass;
    //昵称
    private String userNickname;
    //邮箱
    private String userEmail;
    //链接
    private String userUrl;
    //图片路径
    private String userAvatar;

    private String userLastLoginIp;
    //创建时间
    private Date userRegisterTime;
    //登录时间
    private Date userLastLoginTime;
    //状态
    private Integer userStatus;

    //用户权限
    private Integer userRole;
    /**
     * 文章数量（不是数据库字段）
     */
    private Integer articleCount;
}
