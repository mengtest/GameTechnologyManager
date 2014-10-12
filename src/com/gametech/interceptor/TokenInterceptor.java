package com.gametech.interceptor;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gametech.entity.User;
import com.gametech.utils.HttpUtils;


public class TokenInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse reponse,Object handler){
		if(handler instanceof HandlerMethod){
			User user = HttpUtils.getUser(request);
			if(user != null){
				HandlerMethod handlerMethod = (HandlerMethod)handler;
				Method method = handlerMethod.getMethod();
				Token token = method.getAnnotation(Token.class);
				if(token != null){
					boolean needToken = token.NeedToken();
					if(needToken){
						request.getSession(false).setAttribute("token", System.currentTimeMillis());
					}
					boolean removeToken = token.RemoveToken();
					if(removeToken){
						if(this.isRepeatSubmit(request)){
							//重复提交了，在这里发出提示
							try {
								request.setAttribute("msg", "请的提交正在处理中，请不要重复提交。一会就好。");
								reponse.sendRedirect(request.getContextPath() + "/blog/error");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return false;
						}
						request.getSession(false).removeAttribute("token");
					}
				}
			}
			
		}
		return true;
	}
	private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("token");
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter("token");
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
}
