package com.zgw.blog.mapper;

import com.zgw.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.checkerframework.checker.units.qual.C;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/14.
 */
@Mapper
public interface CategoryMapper {
    /**
     * 获得分类列表
     *
     * @return 列表
     */
    List<Category> listCategory();

    /**
     * 添加
     *
     * @param category 分类
     * @return 影响行数
     */
    int insert(Category category);


    /**
     * 删除分类
     *
     * @param id 文章ID
     */
    int deleteCategory(Integer id);

    /**
     * 根据分类id获得分类信息
     *
     * @param id ID
     * @return 分类
     */
    Category getCategoryById(Integer id);

    /**
     * 更新
     *
     * @param category 分类
     * @return 影响行数
     */
    int update(Category category);


    /**
     * 查询分类总数
     *
     * @return 数量
     */
    Integer countCategory();


}
