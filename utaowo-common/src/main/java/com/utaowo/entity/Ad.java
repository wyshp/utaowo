package com.utaowo.entity;

import java.io.Serializable;

/**
 * <p>
 *
 * @AUTHOR WYS
 * @DATE 2019-05-17
 * @VERSION v1.0
 */
public class Ad implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Integer id;

    private Integer adType; // 广告类型(1-轮播图、2-滚动条)

    private String link;  // 链接地址

    private String imgUrl; // 图片地址

    private String content; // 内容

    private Integer status;  // 状态(0-禁用、1-启用)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdType() {
        return adType;
    }

    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
