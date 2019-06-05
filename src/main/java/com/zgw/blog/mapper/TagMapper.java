package com.zgw.blog.mapper;

import com.zgw.blog.entity.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/14.
 */
@Mapper
public interface TagMapper {
    /**
     *
     * 获得标签列表
     *
     * @return 列表
     */
    List<Tag> listTag();

    /**
     * 添加
     * @param tag
     * @return
     */

    int insert(Tag tag);

    /**
     * 根据ID删除
     *
     * @param tagId 标签ID
     * @return 影响行数
     */
    int deleteById(Integer tagId);

    /**
     * 根据ID查询
     *
     * @param tagId 标签ID
     * @return 标签
     */
    Tag getTagById(Integer tagId);

    /**
     * 更新
     * @param tag 标签
     * @return 影响行数
     */
    int update(Tag tag);


    /**
     * 获得标签总数
     *
     * @return 数量
     */
    Integer countTag() ;
}
