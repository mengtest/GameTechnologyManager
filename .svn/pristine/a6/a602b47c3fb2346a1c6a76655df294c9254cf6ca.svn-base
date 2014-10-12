package com.gametech.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gametech.utils.HttpUtils;

/**
 * 
 *@Title:国安足球经理（移动）
 *@author guangshuai.wang
 * <p>Description:对session的拦截检测 </p>
 */
public class SessionInterceptor implements HandlerInterceptor{

	//需要拦截的没有登陆不能操作的请求，在dispatcher-servlet.xml中配置
	private List<String> urlCheckList = null;
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String contextPath = request.getContextPath();
		String request_uri = request.getRequestURI();
		//检查是否登陆
		if(urlCheckList != null){
			for(String checkUrl : urlCheckList){
				if(checkUrl == null){
					continue;
				}
				if(request_uri.contains(checkUrl)){
					//未登陆，不能操作，跳转到登陆页面
					if(HttpUtils.getUser(request) == null){
						//跳转到登陆页面
						response.sendRedirect(contextPath);
						
						return false;
					}
				}
			}
		}
		return true;
	}

	public List<String> getUrlCheckList() {
		return urlCheckList;
	}

	public void setUrlCheckList(List<String> urlCheckList) {
		this.urlCheckList = urlCheckList;
	}
	
}
