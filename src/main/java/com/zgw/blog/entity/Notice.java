package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Zhaogw&Lss on 2019/4/22.
 */
@Data
public class Notice implements Serializable{

    private static final long serialVersionUID = 6131718202125080771L;
    //公告id
    private Integer noticeId;
    //公告标题
    private String noticeTitle;
    //公告内容
    private String noticeContent;
    //公告创建时间
    private Date noticeCreateTime;
    //公告更新时间
    private Date noticeUpdateTime;
    //公告状态
    private Integer noticeStatus;
    //公告优先级
    private Integer noticeOrder;
}
