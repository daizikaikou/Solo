package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zhaogw&Lss on 2019/4/20.
 */
@Data
public class Link implements Serializable {

    private static final long serialVersionUID = -4316096192278867007L;
    //链接id
    private Integer linkId;
    //链接地址
    private String linkUrl;
    //链接名称
    private String linkName;
    //链接图
    private String linkImage;
    //链接描述
    private String linkDescription;
    //所有者别名
    private String linkOwnerNickname;
    //链接联系方式
    private String linkOwnerContact;

    private Date linkUpdateTime;

    private Date linkCreateTime;
    //优先级
    private Integer linkOrder;
    //状态
    private Integer linkStatus;


}
