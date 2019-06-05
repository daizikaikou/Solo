package com.zgw.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zgw.blog.entity.User;
import com.zgw.blog.mapper.ArticleMapper;
import com.zgw.blog.mapper.UserMapper;
import com.zgw.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/13.
 */
@Service

public class UserServiceImpl implements UserService{
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public List<User> listUser() {
        List<User> userList = userMapper.listUser();
        for (int i = 0; i < userList.size(); i++) {
            Integer articleCount = articleMapper.countArticleByUser(userList.get(i).getUserId());
            userList.get(i).setArticleCount(articleCount);
        }
        return userList;
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User getUserByEmail(String email) {
        return userMapper.getUserByEmail(email);
    }

    @Override
    @CachePut(value = "default", key = "'user:'+#result.userId")
    public User insertUser(User user) {
        user.setUserRegisterTime(new Date());
        userMapper.insert(user);
        return user;
    }

    @Override
    @CacheEvict(value = "default", key = "'user:'+#id")
    public void deleteUser(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    @Cacheable(value = "default", key = "'user:'+#id")
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    @CacheEvict(value = "default", key = "'user:'+#user.userId")
    public void updateUser(User user) {
        userMapper.update(user);
    }

    @Override
    public User getUserByNameOrEmail(String str) {
        return userMapper.getUserByNameOrEmail(str);
    }

    @Override
    public boolean isExist(String name) {
         /*判断用户名是否已存在*/
            User result =userMapper.getUserByName(name);
            if(StringUtils.isEmpty(result))
                 return false;
            return true;
        }

    @Override
    public User getUserByEmailAndName(String email, String name) {
        return userMapper.getUserByEmailAndName(email,name);
    }
}



