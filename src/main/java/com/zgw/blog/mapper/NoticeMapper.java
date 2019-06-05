package com.zgw.blog.mapper;

import com.zgw.blog.entity.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/22.
 */
@Mapper
public interface NoticeMapper {
    /**
     * 获得公告列表
     *
     * @param status 状态
     * @return 公告列表
     */
    List<Notice> listNotice(@Param(value = "status") Integer status);


    /**
     * 添加
     *
     * @param notice 公告
     * @return 影响行数
     */
    int insert(Notice notice);

    /**
     * 根据ID删除
     *
     * @param noticeId 公告ID
     * @return 影响行数
     */
    int deleteById(Integer noticeId);


    /**
     * 根据ID查询
     *
     * @param noticeId 公告ID
     * @return 公告
     */
    Notice getNoticeById(Integer noticeId);


    /**
     * 获得公告列表
     *
     * @param notice 公告
     * @return 影响行数
     */
    int update(Notice notice);
}
