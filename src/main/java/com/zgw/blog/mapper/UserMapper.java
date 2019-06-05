package com.zgw.blog.mapper;

import com.zgw.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/13.
 */
@Mapper
public interface UserMapper {
    /**
     * 获得用户列表
     *
     * @return  用户列表
     */
    List<User> listUser() ;


    /**
     * 根据用户名查用户
     *
     * @param name 用户名
     * @return 用户
     */
    User getUserByName(String name) ;



    /**
     * 根据Email查询用户
     *
     * @param email 邮箱
     * @return 用户
     */
    User getUserByEmail(String email) ;



    /**
     * 添加
     *
     * @param user 用户
     * @return 影响行数
     */
    int insert(User user);


    /**
     * 根据ID删除
     *
     * @param userId 用户ID
     * @return 影响行数
     */
    int deleteById(Integer userId);


    /**
     * 根据ID查询
     *
     * @param userId 用户ID
     * @return 用户
     */
    User getUserById(Integer userId);


    /**
     * 更新
     *
     * @param user 用户
     * @return 影响行数
     */
    int update(User user);


    /**
     * 根据用户名或Email获得用户
     *
     * @param str 用户名或Email
     * @return 用户
     */
    User getUserByNameOrEmail(String str) ;

    /**
     * 根据用户名和邮箱查询
     * @param email
     * @param name
     * @return
     */

    User getUserByEmailAndName(@Param(value="email")String email, @Param(value="name")String name);


}
