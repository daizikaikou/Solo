package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Zhaogw&Lss on 2019/4/24.
 */
@Data
public class Menu implements Serializable {


    private static final long serialVersionUID = 6447763087514031665L;
    //菜单id
    private Integer menuId;
    //菜单名称
    private String menuName;
    //菜单链接
    private String menuUrl;
    //菜单类型
    private Integer menuLevel;
    //菜单图标
    private String menuIcon;
    //菜单级别
    private Integer menuOrder;

}
