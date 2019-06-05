package com.zgw.blog.service.impl;

import com.zgw.blog.entity.Link;
import com.zgw.blog.mapper.LinkMapper;
import com.zgw.blog.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Zhaogw&Lss on 2019/4/20.
 */
public class LinkServiceImpl implements LinkService{
    @Autowired
    private LinkMapper linkMapper;
    @Override
    public List<Link> listLink(Integer status) {
        return linkMapper.listLink(status);
    }

    @Override
    @CachePut(value = "default", key = "'link:'+#link.linkId")
    public void insertLink(Link link) {
        linkMapper.insert(link);

    }

    @Override
    @CacheEvict(value = "default", key = "'link:'+#id")
    public void deleteLink(Integer id) {
        linkMapper.deleteById(id);
    }

    @Override
    @Cacheable(value = "default", key = "'link:'+#id")
    public Link getLinkById(Integer id) {
        return linkMapper.getLinkById(id);
    }

    @Override
    @Cacheable(value = "default", key = "'link:'+#id")
    public void updateLink(Link link) {
        linkMapper.update(link);

    }

    @Override
    public Integer countLink(Integer status) {
        return linkMapper.countLink(status);
    }
}
