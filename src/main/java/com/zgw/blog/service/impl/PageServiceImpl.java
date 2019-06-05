package com.zgw.blog.service.impl;

import com.zgw.blog.entity.Page;
import com.zgw.blog.mapper.PageMapper;
import com.zgw.blog.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/19.
 */
@Service
public class PageServiceImpl implements PageService {
    @Autowired(required = false)
    private PageMapper pageMapper;
    @Override
    public List<Page> listPage(Integer status) {
        return pageMapper.listPage(status);
    }

    @Override
    public Page getPageByKey(Integer status, String key) {
            return pageMapper.getPageByKey(status, key);
        }

    @Override
    @CachePut(value = "default", key = "'page:'+#page.pageId")
    public void insertPage(Page page) {
        pageMapper.insert(page);
    }

    @Override
    @CacheEvict(value = "default", key = "'page:'+#id")
    public void deletePage(Integer id) {
        pageMapper.deleteById(id);
    }

    @Override
    @Cacheable(value = "default", key = "'page:'+#id")
    public Page getPageById(Integer id) {
        return pageMapper.getPageById(id);
    }

    @Override
    @CacheEvict(value = "default", key = "'page:'+#page.pageId")
    public void updatePage(Page page) {
        pageMapper.update(page);
    }
}

