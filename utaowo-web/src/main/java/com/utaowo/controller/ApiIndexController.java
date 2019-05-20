package com.utaowo.controller;

import com.utaowo.base.BaseController;
import com.utaowo.entity.Ad;
import com.utaowo.enums.AdTypeEnum;
import com.utaowo.service.IndexService;
import com.utaowo.utils.R;
import java.util.List;
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

    @PostMapping
    public Object test() {
        List<Ad> bannerList = indexService.queryList(AdTypeEnum.BANNER_IMG.key());
        return toResponsSuccess(bannerList);
    }

    /**
     * 忽略Token验证测试
     */
    @GetMapping("notToken")
    public R notToken() {
        return R.ok().put("msg", "无需token也能访问。。。");
    }
}
