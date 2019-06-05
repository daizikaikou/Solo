package com.zgw.blog.mapper;

import com.zgw.blog.entity.Options;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheEvict;

/**
 * Created by Zhaogw&Lss on 2019/4/24.
 */
@Mapper
public interface OptionsMapper {

    /**
     * 获得记录
     *
     * @return 系统信息
     */
    Options getOptions();


    /**
     * 添加
     * @param options 系统设置
     * @return 影响行数
     */
    int insert(Options options);


    /**
     * 更新
     *
     * @param options 系统信息
     * @return 影响行数
     */
    int update(Options options);


}
