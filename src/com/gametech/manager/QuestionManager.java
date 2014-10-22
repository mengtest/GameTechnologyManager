package com.gametech.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gametech.dao.QuestionDao;
import com.gametech.entity.Pages;
import com.gametech.entity.Question;

public class QuestionManager {

	@Autowired
	private QuestionDao questionDao;
	/**
	 * 获取用户所有的提问
	 * @author guangshuai.wang
	 * 2014-10-16上午12:13:29
	 * @param nowpage			当前页
	 * @param rows				一页显示的数量
	 * @return
	 */
	public List<Question> getUserQuestion(int nowpage,int rows){
		if(nowpage <= 0){
			nowpage = 1;
		}
		Pages pages = new Pages();
		pages.setStart((nowpage - 1) * rows);
		pages.setEnd(rows);
		return questionDao.getUserAllQuestion(pages);
	}
	/**
	 * 获取用户提问的总数
	 * @author guangshuai.wang
	 * 2014-10-16上午12:18:37
	 * @return
	 */
	public int getUserAllQuestionCount(){
		return questionDao.getUserAllQuestionCount();
	}
	/**
	 *  删除一个问题，这里不是真正的删除，而只是改变了一此存储的状态
	 * @author guangshuai.wang
	 * 2014-10-16上午12:30:36
	 * @param id
	 * @return
	 */
	public int deleteQuestionById(long id){
		return questionDao.deleteOneQuestion(id);
	}
	
}
