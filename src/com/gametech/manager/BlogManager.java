package com.gametech.manager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gametech.config.jedis.JedisUtil;
import com.gametech.constans.JedisConstans;
import com.gametech.constans.StringLengthConstans;
import com.gametech.dao.BlogDao;
import com.gametech.entity.Blog;
import com.gametech.entity.Pages;

@Service
public class BlogManager {
	@Autowired
	private BlogDao blogDao;
	/**
	 * 
	 * <p>Title: writeBlog</p>
	 * <p>Description: 写文章
	 * </p>
	 * @param blog
	 * @return
	 * @author guangshuai.wang
	 */
	public boolean writeBlog(Blog blog,long userid){
		if(blog != null){
			if(blog.getTitle() == null || blog.getContent() == null || blog.getClassifyId() == 0 || blog.getShortContent() == null){
				return false;
			}
			if(blog.getTitle().length() > StringLengthConstans.TITLE_LENGTH){
				return false;
			}
			if(blog.getShortContent().length() > StringLengthConstans.SHORT_CONTENT_LENGTH){
				String subStr = blog.getShortContent().substring(0, StringLengthConstans.SHORT_CONTENT_LENGTH);
				blog.setShortContent(subStr);
			}
			
			blog.setUserid(userid);
			blog.setCreateTime(new Date());
			blog.setType(1);
			//保存文章
			blogDao.createBlog(blog);
		}
		
		return false;
	}
	/**
	 * 
	 * <p>Description:验证并修理文章内容 </p>
	 * @param blog
	 * @author guangshuai.wang
	 */
	public String checkBlog(Blog blog){
		if(blog.getTitle() == null || blog.getTitle().equals("") || blog.getClassifyId() == -1 || blog.getContent() == null || blog.getContent().equals("")){
			return "forward:error";
		}
		if(blog.getTitle().length() > 200){
			blog.setTitle(blog.getTitle().substring(0, 200));
		}
		if(blog.getContent().length() > 50000){
			blog.setContent(blog.getContent().substring(0, 50000));
		}
		return null;
	}
	/**
	 * 根据文章id获取一篇文章
	 * @author guangshuai.wang
	 * 2014-10-12下午9:49:59
	 * @param id
	 * @return
	 */
	public Blog getBlogById(long id){
		Blog blog = blogDao.getBlogById(id);
		
		return blog;
	}
	/**
	 * 获取一往篇文章的阅读次数
	 * @author guangshuai.wang
	 * @param blogId
	 * @return
	 * long
	 * @date:2014-9-14
	 */
	public long getBlogReadTimes(long blogId){
		String value = JedisUtil.getSring(JedisConstans.READ_TEMIS + blogId);
		if(value != null){
			return Long.parseLong(value);
		}
		return 0;
	}
	/**
	 * 根据文章作者的类型来获取此作者下所有的文章，
	 * @author guangshuai.wang
	 * 2014-10-13下午9:51:32
	 * @param type		0，表是是用户的文章，1，是本网站的文章
	 * @return
	 */
	public List<Blog> getAllBlogByType(int type,int page,int rows){
		Pages pages = new Pages();
		pages.setUserid(type);
		if(page <=0){
			page = 1;
		}
		pages.setStart((page -1 ) * rows);
		pages.setEnd(rows);
		List<Blog> list = blogDao.getAllBlogByType(pages);
		
		return list;
	}
	
	/**
	 * 根据文章作者的类型获取此作者下文章的总数，
	 * @author guangshuai.wang
	 * 2014-10-13下午9:53:22
	 * @param type 		0，表是是用户的文章，1，是本网站的文章
	 * @return
	 */
	public int getAllBlogCountByType(int type){
		return blogDao.getAllBlogCountByType(type);
	}
	/**
	 * 根据文章id
	 * @author guangshuai.wang
	 * 2014-10-15下午11:05:14
	 * @param id
	 * @param type
	 * @return
	 */
	public int deleteBlogById(long id){
		
		return blogDao.deleteBlogById(id);
	}
}
