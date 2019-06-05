package com.zgw.blog.mapper;

import com.zgw.blog.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/24.
 */
@Mapper
public interface MenuMapper {
    /**
     * 获得菜单列表
     *
     * @return 列表
     */
    List<Menu> listMenu() ;


    /**
     * 添加
     * @param menu 菜单
     * @return 影响行数
     */
    int insert(Menu menu);


    /**
     * 删除
     *
     * @param menuId 菜单ID
     * @return 影响行数
     */
    int deleteById(Integer menuId);

    /**
     * 根据id查找
     *
     * @param id 菜单ID
     * @return 影响行数
     */
    Menu getMenuById(Integer id);


    /**
     * 更新
     *
     * @param menu 菜单
     * @return 影响行数
     */
    int update(Menu menu);
}
