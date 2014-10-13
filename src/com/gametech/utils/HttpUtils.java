package com.gametech.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

import com.gametech.constans.AppConstans;
import com.gametech.entity.Member;
import com.gametech.entity.User;

public class HttpUtils {

	/**
	 * 
	 * <p>Title: RecordOldPath</p>
	 * <p>Description:当请求登陆时，用于记录访问的地址 ,放到session中，登陆成功后跳转到这个页面</p>
	 * @param request
	 * @author guangshuai.wang
	 */
	public static void RecordOldPath(HttpServletRequest request){
		request.getSession().setAttribute(AppConstans.OLDPATH, request.getRequestURL().toString());
	}
	/**
	 * 
	 * <p>Title: RecordOldPath</p>
	 * <p>Description:当请求登陆时，用于记录访问的地址 ,放到session中，登陆成功后跳转到这个页面</p>
	 * @param path	下次跳转的地址
	 * @param request
	 * @author guangshuai.wang
	 */
	public static void RecordOldPath(String path,HttpServletRequest request){
		request.getSession().setAttribute(AppConstans.OLDPATH, path);
	}
	/**
	 * 
	 * <p>Description:获取登陆前的路径 </p>
	 * @param request
	 * @return
	 * @author guangshuai.wang
	 */
	public static String getOldPath(HttpServletRequest request){
		 Object obj = request.getSession().getAttribute(AppConstans.OLDPATH);
		 if(obj != null){
			 return (String)obj;
		 }
		 return null;
	}
	/**
	 * 
	 * <p>Description: 获取用户的userid</p>
	 * @param request
	 * @return
	 * @author guangshuai.wang
	 */
	public static long getUserId(HttpServletRequest request){
		Object obj = request.getSession().getAttribute(AppConstans.USER);
		if(obj != null){
			Member user = (Member)obj;
			return user.getId();
		}
		return 0;
	}
	/**
	 * 
	 * <p>Description:获取session中的用户类 </p>
	 * @param request
	 * @return
	 * @author guangshuai.wang
	 */
	public static Member getUser(HttpServletRequest request){
		Object obj = request.getSession().getAttribute(AppConstans.USER);
		if(obj != null){
			Member user = (Member)obj;
			return user;
		}
		return null;
	}
	/**
	 * 
	 * <p>Title: getPath</p>
	 * <p>Description:在非http请求的情况下获取web项目的路径 </p>
	 * @return
	 * @author guangshuai.wang
	 */
	public static String getPath(){
		String str = HttpUtils.class.getResource("/").getPath();
		String strsub = "WEB-INF/classes/";
		return str.substring(0, str.length() - strsub.length());
	}
	/**
	 * 根据类型，获取验证码
	 * @author guangshuai.wang
	 * @param request
	 * @param type
	 * @return
	 * String
	 * @date:2014-9-25
	 */
	public static String getCheckCodeFromSession(HttpServletRequest request,String type){
		HttpSession session = request.getSession(false);
		if(session != null){
			Object obj = session.getAttribute(type);
			if(obj != null){
				return (String)obj;
			}
		}
		return null;
	}
	
	public static boolean checkCode(HttpServletRequest request,String type,String code){
		String checkcode = HttpUtils.getCheckCodeFromSession(request, AppConstans.CODE_REGIST_CHECK);
		if(checkcode != null && checkcode.toLowerCase().equals(code.toLowerCase())){
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		HttpUtils.getPath();
	}
}
