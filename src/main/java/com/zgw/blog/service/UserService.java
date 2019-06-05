package com.zgw.blog.service;

import com.zgw.blog.entity.User;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/13.
 */
public interface UserService {
    /**
     * 获得用户列表
     *
     * @return 用户列表
     */
    List<User> listUser();


    /**
     * 根据用户名查询用户
     *
     * @param name 用户名
     * @return 用户
     */
    User getUserByName(String name);


    /**
     * 根据邮箱查询用户
     *
     * @param email Email
     * @return 用户
     */
    User getUserByEmail(String email);


    /**
     * 添加用户
     *
     * @param user 用户
     * @return 用户
     */
    User insertUser(User user);


    /**
     * 删除用户
     *
     * @param id 用户ID
     */
    void deleteUser(Integer id);


    /**
     * 根据id查询用户信息
     *
     * @param id 用户ID
     * @return 用户
     */
    User getUserById(Integer id);



    /**
     * 修改用户信息
     *
     * @param user 用户
     */
    void updateUser(User user);


    /**
     * 根据用户名和邮箱查询用户
     *
     * @param str 用户名或Email
     * @return 用户
     */
    User getUserByNameOrEmail(String str);



    boolean isExist(String name);


    User getUserByEmailAndName(String email,String name);


}
