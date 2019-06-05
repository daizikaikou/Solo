package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Zhaogw&Lss on 2019/4/13.
 */
@Data
public class Category implements Serializable{

    private static final long serialVersionUID = -791596063364191494L;
    //分类id
    private Integer categoryId;
    //一级分类pid=0，二级分类pid=其父节点id
    private Integer categoryPid;
    //分类名称
    private String categoryName;
    //分类描述
    private String categoryDescription;
    //分类排序
    private Integer categoryOrder;
    //分类图标
    private String categoryIcon;

    /**
     * 文章数量(非数据库字段)
     */
    private Integer articleCount;

    public Category(Integer categoryId, Integer categoryPid, String categoryName, String categoryDescription, Integer categoryOrder, String categoryIcon, Integer articleCount) {
        this.categoryId = categoryId;
        this.categoryPid = categoryPid;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryOrder = categoryOrder;
        this.categoryIcon = categoryIcon;
        this.articleCount = articleCount;
    }

    public Category(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(Integer categoryId) {
        this.categoryId = categoryId;
    }
    /**
     * 未分类
     *
     * @return 分类
     */
    public static Category Default() {
        return new Category(100000000, "未分类");
    }
}
