package com.utaowo.controller;

import com.utaowo.base.BaseController;
import com.utaowo.entity.Ad;
import com.utaowo.entity.Video;
import com.utaowo.enums.AdTypeEnum;
import com.utaowo.service.IndexService;
import com.utaowo.service.VideoService;
import com.utaowo.utils.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @AUTHOR WYS
 * @DATE 2019-05-17
 * @VERSION v1.0
 */
@RestController
@RequestMapping("/api/index")
public class ApiIndexController extends BaseController {

    @Autowired
    private IndexService indexService;

    @Autowired
    private VideoService videoService;

    /**
     * 首页轮播图
     */
    @PostMapping(value = "banner")
    public Object index() {
        Map<String, Object> resultObj = new HashMap<String, Object>();

        // 1.首页轮播图
        List<Ad> bannerList = indexService.queryList(AdTypeEnum.BANNER_IMG.key());
        resultObj.put("bannerList", bannerList);

        return toResponsSuccess(resultObj);
    }

    /**
     * 视频列表
     */
    @PostMapping(value = "videoList")
    public Object videoList() {
        Map<String, Object> resultObj = new HashMap<String, Object>();

        List<Video> videoList = videoService.queryVideoList();
        resultObj.put("videoList", videoList);

        return toResponsSuccess(resultObj);
    }

    /**
     * 忽略Token验证测试
     */
    @GetMapping("notToken")
    public R notToken() {
        return R.ok().put("msg", "无需token也能访问。。。");
    }
}
