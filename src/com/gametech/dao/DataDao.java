package com.gametech.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * 
 * 数据库持久化操作
 * 
 * @author wang guang shuai 2014-12-19 5:42:09
 */
public class DataDao extends SqlSessionDaoSupport{
	/**
	 * 插入数据
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午4:23:49
	 * @param methodName
	 * @param obj
	 * @return
	 */
	public  int insertData(String methodName, Object obj) {
		int result = getSqlSession().insert(methodName, obj);
		return result;
	}

	public  Object getList(String methodName, Object obj) {
		return getSqlSession().selectList(methodName, obj);
	}

	public  Object getOne(String methodName, Object obj) {
		return getSqlSession().selectOne(methodName, obj);

	}

	public  int update(String methodName, Object obj) {
		return getSqlSession().update(methodName, obj);
	}

	public  int deleteData(String methodName, Object obj) {
		return getSqlSession().delete(methodName, obj);
	}
}
