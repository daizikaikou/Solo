package com.zgw.blog.service;

import com.zgw.blog.entity.Link;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/20.
 */
public interface LinkService {
    /**
     * 获得链接列表
     *
     * @param status 状态
     * @return 链接列表
     */
    List<Link> listLink(Integer status);


    /**
     * 添加链接
     *
     * @param link 链接
     */
    void insertLink(Link link);


    /**
     * 删除链接
     *
     * @param id 链接ID
     */
    void deleteLink(Integer id);

    /**
     * 根据id查询链接
     *
     * @param id 链接ID
     * @return 链接
     */
    Link getLinkById(Integer id);


    /**
     * 更新链接
     *
     * @param link 链接
     */
    void updateLink(Link link);

    /**
     * 统计链接总数
     * @param status
     * @return
     */

    Integer countLink(Integer status);
}
