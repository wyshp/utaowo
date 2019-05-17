package com.utaowo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.utaowo.utils.ServerUtils;
import com.utaowo.utils.SpringContextUtil;


/**
 * <p>
 *
 * @author   WYS
 * @date	 2019年5月17日
 * @version  v1.0.0
 */
public class UtaowoContextLoaderListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		//初始化SpringContextUtil的context
		ServletContext context = event.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		SpringContextUtil.setContext(ctx);
		//设置服务器相关路径
		ServerUtils.setRealPath(context.getRealPath(""));

		System.out.println("项目初始化完成...");
	}
}
