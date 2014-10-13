package com.gametech.config.jedis;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;

import com.alibaba.fastjson.JSON;
import com.gametech.log.CommonLog;
import com.gametech.utils.StringUtils;


public class JedisUtil {
    protected static Logger log =Logger.getLogger(JedisUtil.class);
    private static Jedis jedisWrite = null;
    private static Jedis jedisRead = null;
   // private static JedisPool pool = null;
	/**
	 * 
	 */
	private JedisUtil() {
	    
	}
	
	public static Jedis getWriteInstance(){
		if(jedisWrite == null){
		 try{
			JedisConfig  config = JedisConfig.getInstance();
			String[] local = config.getMaster().split(",");
			jedisWrite = new Jedis(local[0], Integer.parseInt(local[1]), config.getTimeout());
			jedisWrite.connect();
		 }catch (Exception e) {
			 CommonLog.ERR.info("Redis连接错误");
			 jedisWrite = null;
		}
		}
		return jedisWrite;
	}
	public static Jedis getReadInstance(){
		try{
		if(jedisRead == null){
			JedisConfig config = JedisConfig.getInstance();
			String[] local = config.getSlave().split(",");
			jedisRead = new Jedis(local[0], Integer.parseInt(local[1]), config.getTimeout());
		//		local = config.getMaster().split(",");
		//	jedisRead.slaveof(local[0], Integer.parseInt(local[1]));
		
			jedisRead.connect();
		
			
		}
		}catch (Exception e) {
		  CommonLog.ERR.info("Redis读取错误");
		  jedisRead = null;
		}
		return jedisRead;
	}
	/**
	 * 
	 * <p>Title: getObject</p>
	 * <p>Description: 根据key的值，从Redis中简单的获取一个单独的对象</p>
	 * @param <T>
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static <T> T getObject(String key,Class<T> t){
		Jedis edis = JedisUtil.getReadInstance();
		T obj = null;
		if(edis != null){
			if(edis.isConnected()){
				if(edis.exists(key)){
					obj = JSON.parseObject(edis.get(key), t);
				}
			}
		}
		return obj;
	}
	/**
	 * 
	 * <p>Title: getSring</p>
	 * <p>Description: 从redis中获取一个字符串</p>
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static String getSring(String key){
		Jedis edis = JedisUtil.getWriteInstance();
		if(edis != null){
			 return edis.get(key);
		}
		return null;
	}
	/**
	 * 存储普通的键值
	 * @author guangshuai.wang
	 * @param key
	 * @param value
	 * @return
	 * boolean
	 * @date:2014-9-13
	 */
	public static boolean setString(String key,String value){
		Jedis edis = JedisUtil.getWriteInstance();
		
		if(edis != null && edis.isConnected()){
			edis.set(key, value);
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * <p>Title: setObject</p>
	 * <p>Description: 将对象json化，并存入redis中</p>
	 * @param key
	 * @param obj
	 * @return
	 * @author guangshuai.wang
	 */
	public static boolean setObject(String key,Object obj){
		Jedis edis = JedisUtil.getWriteInstance();
		
		if(edis != null && edis.isConnected()){
			edis.set(key, JSON.toJSONString(obj));
			return true;
		}
		return false;
	}
	/**
	 * 
	 * <p>Title: setHashMap</p>
	 * <p>Description:向redis的map结构中存储一条数据 </p>
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @author guangshuai.wang
	 */
	public static long setHashMapData(String key,String field,String value){
		Jedis edis = JedisUtil.getWriteInstance();
		if(edis != null){
			return edis.hset(key, field, value);
		}
		return 0;
	}
	/**
	 * 
	 * <p>Title: delete</p>
	 * <p>Description: 从Redis中删除一条记录</p>
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static long delete(String key){
		Jedis edis = JedisUtil.getWriteInstance();
		if(edis != null){
			return edis.del(key);
		}
		return 0;
	}
	/**
	 * 
	 * <p>Title: deleteHashMapValue</p>
	 * <p>Description:删除jedis中map结构中的一条value值</p>
	 * @param key
	 * @param field
	 * @return
	 * @author guangshuai.wang
	 */
	public static long deleteOneMapValue(String key,String field){
		Jedis edis = JedisUtil.getWriteInstance();
		if(edis != null){
			return edis.hdel(key, field);
		}
		return -1;
	}
	/**
	 * 
	 * <p>Title: getHashMapValue</p>
	 * <p>Description: 从redis存储的hashmap中获取某个字段的字符串值</p>
	 * @param key
	 * @param field
	 * @return
	 * @author guangshuai.wang
	 */
	public static String getOneMapValue(String key,String field){
		Jedis edis = JedisUtil.getReadInstance();
		String value = null;
		if(edis != null){
			value = edis.hget(key, field);
		}
		return value;
	}
	/**
	 * 
	 * <p>Title: getOneMapValue</p>
	 * <p>Description: 从redis的map存储结构中获取一个对象的值</p>
	 * @param <T>
	 * @param key 唯一主key
	 * @param field map的key
	 * @param t
	 * @return
	 * @author guangshuai.wang
	 */
	public static <T> T getOneMapValue(String key,String field,Class<T> t){
		Jedis edis = JedisUtil.getReadInstance();
		T value = null;
		if(edis != null){
			value = JSON.parseObject(edis.hget(key, field), t);
		}
		return value;
	}
	/**
	 * 
	 * <p>Title: setObjToHash</p>
	 * <p>Description: 把一个对象中的所有字段当作map的key，字段的值为value，存储到reids的map之中</p>
	 * @param obj
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static boolean setObjToHash(Object obj,String key){
		if(obj != null){
			//获取类中所有的字段
			Field[] fields = obj.getClass().getFields();
			for(int i = 0 ;i < fields.length; i++){
				try {
					Method method = obj.getClass().getMethod("get" + StringUtils.firstToUpper(fields[i].getName()));
				    Object value = method.invoke(obj);
				    if(value != null){
				    	JedisUtil.setHashMapData(key, fields[i].getName(), String.valueOf(value));
				    }
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	/**
	 * 
	 * <p>Title: getHmapFields</p>
	 * <p>Description: 获取redis中一个map结构的存储值</p>
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static Map<String, String> getHmapFields(String key){
		Jedis edis = JedisUtil.getReadInstance();
		if(edis != null){
			Map<String, String> map = edis.hgetAll(key);
			return map;
		}
		return null;
	}
	/**
	 * 
	 * <p>Title: isExist</p>
	 * <p>Description:判断一个key是否存储于redis之中 </p>
	 * @param key
	 * @return true 存在，false不存在
	 * @author guangshuai.wang
	 */
	public static boolean isExist(String key){
		Jedis edis = JedisUtil.getReadInstance();
		if(edis != null && edis.exists(key)){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * <p>Title: setObjectListToEdis</p>
	 * <p>Description: 将一个list存储到edis中</p>
	 * @param list
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static int setObjectListToEdis(List< ? extends Object> list,String key){
		Jedis edis = JedisUtil.getWriteInstance();
		if(edis != null){
			for(Object entity : list){
				edis.lpush(key, JSON.toJSONString(entity));
			}
		}
		return 0;
	}
	/**
	 * 
	 * <p>Title: setObjectToEdisList</p>
	 * <p>Description: 将一个对象加入到edis的一个list的头部</p>
	 * @param ObjEntity
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static boolean setObjectToEdisList(Object ObjEntity,String key){
		Jedis edis = JedisUtil.getWriteInstance();
		if(edis != null){
			edis.lpush(key, JSON.toJSONString(ObjEntity));
			return true;
		}
		return false;
	}
	/**
	 * 
	 * <p>Title: getEdisListLength</p>
	 * <p>Description: 获取edis中，list的长度</p>
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static Long getEdisListLength(String key){
		Jedis edis = JedisUtil.getReadInstance();
		if(edis != null){
			return edis.llen(key);
		}
		return 0L;
	}
	/**
	 * 
	 * <p>Title: getListAll</p>
	 * <p>Description:从redis中获取一个list的所有对象的json串</p>
	 * @param key
	 * @return
	 * @author guangshuai.wang
	 */
	public static List<String> getListAll(String key){
		
		List<String> list = new ArrayList<String>();
		Jedis edis = JedisUtil.getReadInstance();
		if(edis != null){
			list = edis.lrange(	key, 0, -1);
		}
		return list;
	}
	/**
	 * 
	 * <p>Title: getObjList</p>
	 * <p>Description: 从redis存储的list中获取一部分数据</p>
	 * @param <T>
	 * @param key				唯一健值
	 * @param start				开始的索引
	 * @param end				结束的索引
	 * @return
	 * @author guangshuai.wang
	 */
	public static List<String> getObjListL(String key,long start,long end){
		List<String> list = new ArrayList<String>();
		Jedis edis = JedisUtil.getReadInstance();
		if(edis != null){
			list = edis.lrange(	key, start, end);
		}
		return list;
	}
	/**
	 * 
	 * <p>Title: deleteFromList</p>
	 * <p>Description:从redis中存储的list列表中删除一个值 </p>
	 * @param key
	 * @param count 		count > 0: 从表头开始向表尾搜索，移除与value相等的元素，数量为count。
	 *						count < 0: 从表尾开始向表头搜索，移除与value相等的元素，数量为count的绝对值。
	 *						count = 0: 移除表中所有与value相等的值。
	 * @param value			要删除的值
	 * @return
	 * @author guangshuai.wang
	 */
	public static long deleteFromList(String key,int count,String value){
		Jedis edis = JedisUtil.getReadInstance();
		if(edis != null){
			return edis.lrem(key, count, value);
		}
		return 0;
	}
	/**
	 * 
	 * <p>Title: setListValue</p>
	 * <p>Description: 将列表key下标为index的元素的值更改为value。</p>
	 * @param key
	 * @param index			要修改的list下标
	 * @param value			新的值
	 * @return
	 * @author guangshuai.wang
	 */
	public static String setListValue(String key,long index,String value){
		Jedis edis = JedisUtil.getReadInstance();
		if(edis != null){
			return edis.lset(key, index, value);
		}
		return null;
	}
	public static void main(String[] args) {
		
		System.out.println("sss:" + JSON.toJSONString(1));
	}
}

