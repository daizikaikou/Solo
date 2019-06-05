package com.zgw.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Zhaogw&Lss on 2019/4/24.
 */
@Data
public class Options implements Serializable{


    private static final long serialVersionUID = 7472592085744093969L;
    //主要选项id
    public Integer optionId;
    //选项标题
    public String optionSiteTitle;
    //站点描述
    public String optionSiteDescrption;
    //首页描述
    public String optionMetaDescrption;
    //首页关键词
    private String optionMetaKeyword;
    //头像
    private String optionAboutsiteAvatar;
    //昵称
    private String optionAboutsiteTitle;
    //说明内容
    private String optionAboutsiteContent;
    //微信
    private String optionAboutsiteWechat;
    //qq
    private String optionAboutsiteQq;
    //github
    private String optionAboutsiteGithub;
    //weibo
    private String optionAboutsiteWeibo;

    private String optionTongji;
    //状态
    private Integer optionStatus;


}
