package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/12.
 */
@Data
public class Article implements Serializable{


    private static final long serialVersionUID = 2141938728634935672L;
    //文章编号
    private Integer articleId;
    //文章用户id
    private Integer articleUserId;
    //文章标题
    private String articleTitle;
    //文章浏览数
    private Integer articleViewCount;
    //文章评论数
    private Integer articleCommentCount;
    //文章心数
    private Integer articleLikeCount;
    //文章创建时间
    private Date articleCreateTime;
    //文章更新时间
    private Date articleUpdateTime;
    //文章是否评论
    private Integer articleIsComment;
    //文章状态
    private Integer articleStatus;
    //文章优先级
    private Integer articleOrder;
   //文章内容
    private String articleContent;

    private User user;

    private List<Tag> tagList;

    private List<Category> categoryList;

}
