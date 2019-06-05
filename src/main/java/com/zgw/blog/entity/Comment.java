package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zhaogw&Lss on 2019/4/22.
 */
@Data
public class Comment implements Serializable{

    private static final long serialVersionUID = -5978842136990336491L;
    //评论id
    private Integer commentId;
    //评论父id
    private Integer commentPid;
    //评论昵称
    private String commentPname;
    //评论文章id
    private Integer commentArticleId;
    //评论人名字
    private String commentAuthorName;
    //评论人邮箱
    private String commentAuthorEmail;
    //评论人链接
    private String commentAuthorUrl;
    //评论人头像
    private String commentAuthorAvatar;
    //评论人内容
    private String commentContent;
    //代理人
    private String commentAgent;
    //ip地址
    private String commentIp;
   //创建时间
    private Date commentCreateTime;

    /**
     * 角色(管理员1，访客0)
     */
    private Integer commentRole;

    /**
     * 非数据库字段
     */
    private Article article;











}
