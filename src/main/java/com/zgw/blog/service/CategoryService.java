package com.zgw.blog.service;

import com.zgw.blog.entity.Category;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/14.
 */
public interface CategoryService {
    //查询所有分类
    List<Category> listCategory();
    /**
     * 获得分类列表
     *
     * @return 分类列表
     */
    List<Category> listCategoryWithCount();
    /**
     * 添加分类
     *
     * @param category 分类
     * @return 分类
     */
    Category insertCategory(Category category);
    /**
     * 删除分类
     *
     * @param id ID
     */
    void deleteCategory(Integer id);
    /**
     * 根据id查询分类信息
     *
     * @param id     ID
     * @return 分类
     */
    Category getCategoryById(Integer id);
    /**
     * 更新分类
     *
     * @param category 分类
     */
    void updateCategory(Category category);


    /**
     * 获得分类总数
     *
     * @return
     */
    Integer countCategory();
}
