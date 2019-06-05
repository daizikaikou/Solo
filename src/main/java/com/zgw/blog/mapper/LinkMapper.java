package com.zgw.blog.mapper;

import com.zgw.blog.entity.Link;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/20.
 */
@Mapper
public interface LinkMapper {
    /**
     * 获得链接列表
     *
     * @param status 状态
     * @return  列表
     */
    List<Link> listLink(@Param(value = "status") Integer status);


    /**
     * 添加
     *
     * @param link 链接
     * @return 影响行数
     */
    int insert(Link link);


    /**
     * 删除
     * @param linkId 链接ID
     * @return 影响行数
     */
    int deleteById(Integer linkId);

    /**
     * 根据ID查询
     *
     * @param linkId 链接ID
     * @return 影响行数
     */
    Link getLinkById(Integer linkId);

    /**
     * 更新
     *
     * @param link 链接ID
     * @return 影响行数
     */
    int update(Link link);


    /**
     * 获得链接总数
     *
     * @param status 状态
     * @return 数量
     */
    Integer countLink(@Param(value = "status") Integer status);


}
