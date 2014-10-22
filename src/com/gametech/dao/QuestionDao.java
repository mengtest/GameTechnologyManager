package com.gametech.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.gametech.entity.Pages;
import com.gametech.entity.Question;

public class QuestionDao extends SqlSessionDaoSupport{

	/**
	 * 获取用户所有的提问
	 * @author guangshuai.wang
	 * 2014-10-16上午12:17:06
	 * @param pages
	 * @return
	 */
	public List<Question> getUserAllQuestion(Pages pages){
		return getSqlSession().selectList("questionmapper.getUserAllQuestion", pages);
	}
	/**
	 * 获取用户提问的总数
	 * @author guangshuai.wang
	 * 2014-10-16上午12:18:07
	 * @return
	 */
	public int getUserAllQuestionCount(){
		return getSqlSession().selectOne("questionmapper.getUserAllQuestionCount");
	}
	/**
	 * 删除一个问题，这里不是真正的删除，而只是改变了一此存储的状态
	 * @author guangshuai.wang
	 * 2014-10-16上午12:29:26
	 * @param id
	 * @return
	 */
	public int deleteOneQuestion(long id){
		return getSqlSession().update("questionmapper.deleteOneQuestion", id);
	}
	
}
