package com.gametech.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import com.gametech.entity.Blog;

/**
 * 
 * @author guangshuai.wang
 * <p>Description:做反射时，可能用到的方法 </p>
 */
public class ReflectUtils {

	/**
	 * 
	 * <p>Title: getter</p>
	 * <p>Description: </p>
	 * @param obj 操作的对象
	 * @param att 方法名（不带get，只有成员变量名）
	 * @author guangshuai.wang
	 */
	public static Object getter(Object obj,String att){
		Object result = null;
		try{
			Method method = obj.getClass().getMethod("get" + StringUtils.firstToUpper(att));
			result = method.invoke(obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	/**
	 * 用反射调用set方法给对象实例赋值
	 * <p>Title: setter</p>
	 * <p>Description: </p>
	 * @param obj 要操作的对象
	 * @param att 要操作的对象的成员变量
	 * @param value 要赋的值
	 * @param argumentType 成员变量类型,注意int.class和Integer.class的区别，这是两个不同的类型
	 * @author guangshuai.wang
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws NumberFormatException 
	 */
	public static void setter(Object obj,String att,Object value,Class<?> argumentType) throws SecurityException, NoSuchMethodException, NumberFormatException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		
			Method method = obj.getClass().getMethod("set" + StringUtils.firstToUpper(att), argumentType);
			if(int.class.getCanonicalName().equals(argumentType.getCanonicalName())){
				method.invoke(obj, Integer.parseInt((String)value));
			} else if(String.class.getCanonicalName().equals(argumentType.getCanonicalName())){
				method.invoke(obj, (String)value);
			}
			
	}
	/**
	 * 
	 * <p>Title: setValueToObj</p>
	 * <p>Description: 从Redis的map集合中，获取类对象的值。</p>
	 * @param obj
	 * @param map
	 * @author guangshuai.wang
	 */
	public static void setValueToObj(Object obj,Map<String, String> map){
		Field[] fields = obj.getClass().getFields();
		for(int i = 0; i < fields.length; i++){
			String value = map.get(fields[i].getName());
			if(value != null){
				//ReflectUtils.setter(obj, fields[i].getName(), value, fields[i].getType());
			}
		}
	}
	public static void main(String[] args) {
		
	}
}
