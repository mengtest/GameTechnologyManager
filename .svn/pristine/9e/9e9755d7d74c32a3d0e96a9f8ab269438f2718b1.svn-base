package com.gametech.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 
	 * <p>Title: isNumber</p>
	 * <p>Description:判断字符串是否为整数 </p>
	 * @param str
	 * @return
	 * @author guangshuai.wang
	 */
	public static boolean isNumber(String str){
		for(int i = 0; i < str.length(); ++i){
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
	/**
	 * 
	 * <p>Title: getClassType</p>
	 * <p>Description: 判断并返回基本类型</p>
	 * @param str
	 * @return
	 * @author guangshuai.wang
	 */
	public static Class<?> getClassType(String str){
		if(StringUtils.isNumber(str)){
			return int.class;
		} else {
			return String.class;
		}
	}
	/**
	 * 
	 * <p>Title: firstToUpper</p>
	 * <p>Description:把字符串转化为首字母大写的字符串 </p>
	 * @param str
	 * @return
	 * @author guangshuai.wang
	 */
	public static String firstToUpper(String str){
		return str.replaceFirst(str.substring(0, 1), str.substring(0,1).toUpperCase());
	}
	public static String getClassNameByFilename(String name){
		String str = "";
		if(name != null){
			str = name.substring(0, name.indexOf("."));
			str = StringUtils.firstToUpper(str);
		}
		return str;
	}
	/**
	 * 把字符串中，<img src >的图片去掉
	 * @author guangshuai.wang
	 * @return
	 * String
	 * @date:2014-9-21
	 */
	public static String replaceImg(String sourceStr){
		 // 获取img标签正则  
	    String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
	    String copyStr = sourceStr;
	    Matcher match = Pattern.compile(IMGURL_REG).matcher(sourceStr);
	    String result = "";
	    while(match.find()){
	    	result = match.group();
	    	copyStr = copyStr.replace(result,"");
	    }
	    return copyStr;
	}
	public static void main(String[] args) {
		String str = "<p><img src='/ueditor/jsp/upload/image/20140921/1411309931285038336.jpg' title='1411309931285038336.jpg' alt='IMG_20140921_1938422.jpg'/>aaaaaaaaaaaaaaaaaaaaaaaa</p>";
		System.out.println(StringUtils.replaceImg(str));
	}
}
