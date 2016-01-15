package com.its.interceptor;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 
 * @作者: KevinWu
 *
 * @日期:2015年12月15日 上午10:33:41
 *
 * @版本：Xinoman Technologies CO.,LTD.
 */
public class CheckLoginInterceptor implements Interceptor {
	private static final Log log = LogFactory.getLog(CheckLoginInterceptor.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = 3032038231243308736L;

	@Override
	public void destroy() {
		log.info("CheckLogin.destroy()");

	}

	@Override
	public void init() {
		log.info("CheckLogin.init()");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		log.info("CheckLogin.intercept()");
		Map<String, Object> session = ActionContext.getContext().getSession();
		if(session.get("user.username")!=null)
		{
			log.info(session.get("user.username")+"：用户已登录过！");
			return arg0.invoke();
		}		
		return "checkLoginFail";
	}

}
