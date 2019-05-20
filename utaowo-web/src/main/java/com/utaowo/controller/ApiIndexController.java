package com.utaowo.controller;

import com.utaowo.base.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @AUTHOR WYS
 * @DATE 2019-05-17
 * @VERSION v1.0
 */
@RestController
public class ApiIndexController extends BaseController {


    @PostMapping(value="/api/index")
    public Object test() {
        System.out.println("hello world...");
        return toResponsMsgSuccess("请求成功yyy");
    }
}
