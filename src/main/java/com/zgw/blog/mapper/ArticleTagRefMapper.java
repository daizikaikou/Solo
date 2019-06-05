package com.zgw.blog.mapper;

import com.zgw.blog.entity.Article;
import com.zgw.blog.entity.ArticleTagRef;
import com.zgw.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/14.
 */
@Mapper
public interface ArticleTagRefMapper {
    /**
     * 根据文章获得标签列表
     * @param articleId 文章ID
     * @return 标签列表
     */
   List<Tag> listTagByArticleId(Integer articleId);
     /**
     * 根据文章ID删除记录
     * @param articleId 文章ID
     * @return 影响行数
     */
    int deleteByArticleId(Integer articleId);
    /**
     * 添加文章和分类关联记录
     * @param record 关联对象
     * @return 影响行数
     */
    int insert(ArticleTagRef record);


    /**
     * 根据标签ID统计文章数
     * @param tagId 标签ID
     * @return 文章数量
     */
    int countArticleByTagId(Integer tagId);


    /**
     * 根据标签ID删除记录
     * @param tagId 标签ID
     * @return 影响行数
     */
    int deleteByTagId(Integer tagId);
}
