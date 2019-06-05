package com.zgw.blog.service.impl;

import com.zgw.blog.entity.Menu;
import com.zgw.blog.mapper.MenuMapper;
import com.zgw.blog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/24.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired(required = false)
    private MenuMapper menuMapper;

    @Override
    public List<Menu> listMenu() {
        List<Menu> menuList = menuMapper.listMenu();
        return menuList;
    }

    @Override
    @CachePut(value = "default", key = "'menu:'+#menu.menuId")
    public Menu insertMenu(Menu menu) {
        menuMapper.insert(menu);
        return menu;
    }

    @Override
    @CacheEvict(value = "default", key = "'menu:'+#id")
    public void deleteMenu(Integer id) {
        menuMapper.deleteById(id);
    }

    @Override
    @Cacheable(value = "default", key = "'menu:'+#id")
    public Menu getMenuById(Integer id) {
      return menuMapper.getMenuById(id);
    }

    @Override
    @CacheEvict(value = "default", key = "'menu:'+#menu.menuId")
    public void updateMenu(Menu menu) {
        menuMapper.update(menu);
    }
}
