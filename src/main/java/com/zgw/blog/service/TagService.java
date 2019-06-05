package com.zgw.blog.service;

import com.zgw.blog.entity.Tag;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/14.
 */
public interface TagService {
    /**
     * 获得标签列表
     *
     * @return 标签列表
     */
    List<Tag> listTag();

    /**
     * 获得标签列表
     *
     * @return 标签列表
     */
    List<Tag> listTagWithCount();

    /**
     * 添加标签
     * @param tag
     * @return
     */
    Tag insertTag(Tag tag);

    /**
     * 删除标签
     *
     * @param id 标签iD
     */
    void deleteTag(Integer id);

    /**
     * 根据id获得标签信息
     *
     * @param id 标签ID
     * @return 标签
     */
    Tag getTagById(Integer id);

    /**
     * 修改标签
     * @param tag
     */
    void updateTag(Tag tag);


    /**
     * 获得标签总数
     *
     * @return 数量
     */
    Integer countTag() ;


}
