package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Zhaogw&Lss on 2019/4/13.
 */
@Data
public class Tag implements Serializable{

    private static final long serialVersionUID = 2977141363081532766L;
    //标签id
    private Integer tagId;
    //标签名
    private String tagName;
    //描述
    private String tagDescription;

    /**
     * 文章数量(不是数据库字段)
     */
    private Integer articleCount;

    public Tag() {
    }

    public Tag(Integer tagId) {
        this.tagId = tagId;
    }

    public Tag(Integer tagId, String tagName, String tagDescription, Integer articleCount) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.tagDescription = tagDescription;
        this.articleCount = articleCount;
    }
}
