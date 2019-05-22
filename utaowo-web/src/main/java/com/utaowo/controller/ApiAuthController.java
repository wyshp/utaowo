package com.utaowo.controller;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.StringUtils;
import com.utaowo.base.BaseController;
import com.utaowo.entity.FullUserInfo;
import com.utaowo.entity.User;
import com.utaowo.entity.UserInfo;
import com.utaowo.service.TokenService;
import com.utaowo.service.UserService;
import com.utaowo.util.ApiUserUtils;
import com.utaowo.utils.CharUtil;
import com.utaowo.utils.CommonUtil;
import com.utaowo.utils.HttpUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * @AUTHOR WYS
 * @DATE 2019-05-22
 * @VERSION v1.0
 */
@RestController
@RequestMapping("/api/auth")
public class ApiAuthController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("login_by_weixin")
    public Object loginByWeixin() {
        JSONObject jsonParam = this.getJsonRequest();
        FullUserInfo fullUserInfo = null;
        String code = "";
        if (!StringUtils.isNullOrEmpty(jsonParam.getString("code"))) {
            code = jsonParam.getString("code");
        }
        if (null != jsonParam.get("userInfo")) {
            fullUserInfo = jsonParam.getObject("userInfo", FullUserInfo.class);
        }
        if (null == fullUserInfo) {
            return toResponsFail("登录失败");
        }

        Map<String, Object> resultObj = new HashMap<String, Object>();
        //
        UserInfo userInfo = fullUserInfo.getUserInfo();

        //获取openid
        String requestUrl = ApiUserUtils.getWebAccess(code);//通过自定义工具类组合出小程序需要的登录凭证 code
        logger.info("》》》组合token为：" + requestUrl);
        JSONObject sessionData = HttpUtil.httpsRequest(requestUrl, "GET", null);
        if (null == sessionData || StringUtils.isNullOrEmpty(sessionData.getString("openid"))) {
            return toResponsFail("登录失败");
        }

        //验证用户信息完整性
        String sha1 = CommonUtil.getSha1(fullUserInfo.getRawData() + sessionData.getString("session_key"));
        if (org.apache.commons.lang3.StringUtils.isNotBlank(fullUserInfo.getSignature()) && !fullUserInfo.getSignature().equals(sha1)) {
            return toResponsFail("登录失败");
        }

        Date nowTime = new Date();
        User user = userService.queryByOpenId(sessionData.getString("openid"));
        if(null == user){
            user = new User();
            user.setUserName("微信用户" + CharUtil.getRandomString(12));
            user.setPassword(sessionData.getString("openid"));
            user.setRegisterTime(nowTime);
            user.setRegisterIp(this.getClientIp());
            user.setLastLoginIp(user.getRegisterIp());
            user.setLastLoginTime(user.getRegisterTime());
            user.setWeixinOpenid(sessionData.getString("openid"));
            user.setAvatar(userInfo.getAvatarUrl());
            user.setGender(userInfo.getGender()); // //性别 0：未知、1：男、2：女
            user.setNickName(userInfo.getNickName());
            userService.save(user);
        }else {
            user.setLastLoginIp(this.getClientIp());
            user.setLastLoginTime(nowTime);
            userService.update(user);
        }

        Map<String, Object> tokenMap = tokenService.createToken(user.getUserId());

        String token = MapUtils.getString(tokenMap, "token");

        if (null == userInfo || StringUtils.isNullOrEmpty(token)) {
            return toResponsFail("登录失败");
        }

        resultObj.put("token", token);
        resultObj.put("userInfo", userInfo);
        resultObj.put("userId", user.getUserId());
        return toResponsSuccess(resultObj);
    }
}
