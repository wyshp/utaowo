package com.utaowo.base;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

/**
 * <p>
 *
 * @AUTHOR WYS
 * @DATE 2019-05-17
 * @VERSION v1.0
 */
public class BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 获取request对象
     */
    @Autowired
    protected HttpServletRequest request;
    /**
     * 获取response对象
     */
    @Autowired
    protected HttpServletResponse response;

    /**
     * initBinder 初始化绑定 <br>
     * 这里处理了3种类型<br>
     * 1、字符串自动 trim 去掉前后空格 <br>
     * 2、java.util.Date 转换为 "yyyy-MM-dd HH:mm:ss" 格式<br>
     * 3、java.sql.Date 转换为 "yyyy-MM-dd" 格式<br>
     * 4、java.util.Timestamps 时间转换
     *
     * @param binder
     * @param request
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        // 字符串自动Trim
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }

    /**
     * 获取请求方IP
     *
     * @return 客户端Ip
     */
    public String getClientIp() {
        String xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            return "8.8.8.8";
        }
        return xff;
    }

    public Map<String, Object> toResponsObject(int requestCode, String msg, Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errCode", requestCode);
        obj.put("errMsg", msg);
        if (data != null) {
            obj.put("data", data);
        }
        return obj;
    }

    public Map<String, Object> toResponsMsgSuccess(String msg) {
        return toResponsObject(0, msg, "");
    }

    public Map<String, Object> toResponsSuccess(Object data) {
        Map<String, Object> rp = toResponsObject(0, "执行成功", data);
        return rp;
    }

    public Map<String, Object> toResponsFail(String msg) {
        return toResponsObject(1, msg, null);
    }


}
