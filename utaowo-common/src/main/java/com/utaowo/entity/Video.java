package com.utaowo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * @AUTHOR WYS
 * @DATE 2019-05-22
 * @VERSION v1.0
 */
public class Video implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    private String videoTitle; // 视频名称

    private String videoUrl;// 视频地址

    private String videoCategory;// 视频分类(java、python、other)

    private String videoImg; // 视频封面

    private String videoAuthor; // 视频发布者

    private Integer videoSeq; // 视频顺序

    private Integer playCount; // 观看人数

    private String desc; // 视频描述

    private Integer status;  // 状态(0-禁用、1-启用)

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoCategory() {
        return videoCategory;
    }

    public void setVideoCategory(String videoCategory) {
        this.videoCategory = videoCategory;
    }

    public String getVideoImg() {
        return videoImg;
    }

    public void setVideoImg(String videoImg) {
        this.videoImg = videoImg;
    }

    public String getVideoAuthor() {
        return videoAuthor;
    }

    public void setVideoAuthor(String videoAuthor) {
        this.videoAuthor = videoAuthor;
    }

    public Integer getVideoSeq() {
        return videoSeq;
    }

    public void setVideoSeq(Integer videoSeq) {
        this.videoSeq = videoSeq;
    }

    public Integer getPlayCount() {
        return playCount;
    }

    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
