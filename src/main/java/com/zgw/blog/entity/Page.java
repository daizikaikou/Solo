package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zhaogw&Lss on 2019/4/19.
 */
@Data
public class Page implements Serializable{
    private static final long serialVersionUID = -864172678641566523L;
    //页面id
    private Integer pageId;
    //页面url
    private String pageKey;
    //标题
    private String pageTitle;
    //内容
    private String pageContent;
    //创建时间
    private Date pageCreateTime;
    //更新时间
    private Date pageUpdateTime;
    //浏览量
    private Integer pageViewCount;
    //评论数
    private Integer pageCommentCount;
    //状态
    private Integer pageStatus;

}
