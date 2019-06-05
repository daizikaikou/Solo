package com.zgw.blog.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/15.
 */
@Data
public class ArticleParam {
    private Integer articleId;

    private String articleTitle;

    private String articleContent;

    private Integer articleParentCategoryId;

    private Integer articleChildCategoryId;

    private Integer articleOrder;

    private Integer articleStatus;

    private List<Integer> articleTagIds;


}
