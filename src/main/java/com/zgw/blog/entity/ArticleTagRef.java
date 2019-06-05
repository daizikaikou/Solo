package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Zhaogw&Lss on 2019/4/14.
 */
@Data
public class ArticleTagRef implements Serializable{


    private static final long serialVersionUID = 5065895627120672926L;
    //文章id
    private Integer articleId;
    //标签id
    private Integer tagId;

    public ArticleTagRef() {
    }

    public ArticleTagRef(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }
}
