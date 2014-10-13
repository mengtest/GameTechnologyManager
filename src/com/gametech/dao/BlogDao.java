package com.gametech.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.gametech.entity.Blog;
import com.gametech.entity.BlogTitle;
import com.gametech.entity.Pages;
import com.gametech.entity.Sort;
@Repository
public class BlogDao extends SqlSessionDaoSupport{

	
	public long createBlog(Blog blog){
		return getSqlSession().insert("blogmapper.createBlog",blog);
	}
	/**
	 * 
	 * <p>Title: getBlogByUserId</p>
	 * <p>Description: 根据userid和页数，分类获取文章</p>
	 * @param page
	 * @return
	 * @author guangshuai.wang
	 */
	public List<Blog> getBlogByUserId(Pages page){
		List<Blog> list = getSqlSession().selectList("blogmapper.getBlogByUserid", page);
		return list;
	}
	/**
	 * 
	 * <p>Title: getBlogByUserId</p>
	 * <p>Description:获取某个用户的所有文章，用于加载到redis之中 </p>
	 * @param userid
	 * @return
	 * @author guangshuai.wang
	 */
	public List<Blog> getBlogByUserId(long userid){
		return getSqlSession().selectList("blogmapper.getAllBlogByUserid",userid);
	}
	public Blog getBlogById(long id){
		return getSqlSession().selectOne("blogmapper.getBlogById", id);
	}
	public void updateBlog(Blog blog){
		getSqlSession().update("blogmapper.updateBlog", blog);
		
	}
	
	public int getMytotalBlog(Blog blog){
		return getSqlSession().selectOne("blogmapper.getMyTotalBlog",blog);
	}
	/**
	 * 
	 * <p>Description:根据文章分类id查询此id下一共有多少文章 </p>
	 * @param type
	 * @return
	 * @author guangshuai.wang
	 */
	public int selectTotalOfBlogClassify(int type){
		return getSqlSession().selectOne("blogmapper.selectTotalOfBlogClassify", type);
	}
	/**
	 * 
	 * <p>Description:查询分类最近发表的文章  </p>
	 * @param pages
	 * @return
	 * @author guangshuai.wang
	 */
	public List<BlogTitle> selectBlogByBlogClassify(Pages pages){
		return getSqlSession().selectList("blogmapper.selectBlogByBlogClassify", pages);
	}
	/**
	 * 查询此自定义分类下的文章
	 * @author guangshuai.wang
	 * @param pages
	 * @return
	 * List<BlogTitle>
	 * @date:2014-8-9
	 */
	public List<BlogTitle> selectBlogBySortId(Pages pages){
		return getSqlSession().selectList("blogmapper.selectBlogBySortId", pages);
	}
	public void updateBlogSort(Sort sort){
		getSqlSession().update("blogmapper.updateBlogSort", sort);
	}
	/**
	 * 根据文章作者的类型来获取此作者下所有的文章，
	 * @author guangshuai.wang
	 * 2014-10-13下午9:51:32
	 * @param type		0，表是是用户的文章，1，是本网站的文章
	 * @return
	 */
	public List<Blog> getAllBlogByType(int type){
		return getSqlSession().selectList("blogmapper.getAllBlogsByType", type);
	}
	/**
	 * 根据文章作者的类型获取此作者下文章的总数，
	 * @author guangshuai.wang
	 * 2014-10-13下午9:53:22
	 * @param type 		0，表是是用户的文章，1，是本网站的文章
	 * @return
	 */
	public int getAllBlogCountByType(int type){
		return getSqlSession().selectOne("blogmapper.getAllBlogCountByType", type);
	}
}
