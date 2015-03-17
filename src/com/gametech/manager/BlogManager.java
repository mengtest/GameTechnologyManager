package com.gametech.manager;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gametech.config.jedis.JedisUtil;
import com.gametech.constans.JedisConstans;
import com.gametech.constans.MyBatisConstants;
import com.gametech.constans.StringLengthConstans;
import com.gametech.dao.BlogDao;
import com.gametech.dao.DataDao;
import com.gametech.entity.Blog;
import com.gametech.entity.Member;
import com.gametech.entity.Pages;
import com.gametech.excel.TemplateService;
import com.gametech.excel.model.Classify;
import com.gametech.imanager.IBlogManager;
import com.gametech.utils.HttpUtils;

@Service("blogManager")
public class BlogManager implements IBlogManager {
	@Autowired
	private BlogDao blogDao;
	@Autowired
	private DataDao dataDao;
	@Autowired
	private TemplateService templateService;

	/**
	 * 
	 * <p>
	 * Title: writeBlog
	 * </p>
	 * <p>
	 * Description: 写文章
	 * </p>
	 * 
	 * @param blog
	 * @return
	 * @author guangshuai.wang
	 */
	public boolean writeBlog(HttpServletRequest request, Blog blog) {
		Member member = HttpUtils.getUser(request);
		if (member == null || blog == null) {
			return false;
		}
		blog.setName(member.getName());
		if (this.checkBlog(blog)) {
			blog.setUserid(member.getId());
			blog.setCreateTime(new Date());
			blog.setType(1);
			// 保存文章
			blogDao.createBlog(blog);
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * <p>
	 * Description:验证并修理文章内容
	 * </p>
	 * 
	 * @param blog
	 * @author guangshuai.wang
	 */
	public boolean checkBlog(Blog blog) {
		if (blog.getTitle() == null || blog.getTitle().equals("")) {
			return false;
		}
		if (blog.getShortContent() == null || blog.getShortContent().equals("")) {
			return false;
		}
		if (blog.getContent() == null || blog.getContent().equals("")) {
			return false;
		}
		if (blog.getClassifyId() <= 0) {
			return false;
		}
		if (blog.getTitle().length() > StringLengthConstans.TITLE_LENGTH) {
			blog.setTitle(blog.getTitle().substring(0,
					StringLengthConstans.TITLE_LENGTH));
		}
		String shortContemt = blog.getShortContent();
		if (shortContemt.length() > StringLengthConstans.SHORT_CONTENT_LENGTH) {
			blog.setShortContent(shortContemt.substring(0,
					StringLengthConstans.SHORT_CONTENT_LENGTH));
		}
		if (blog.getContent().length() > StringLengthConstans.BLOG_CONTENT_LENGTH) {
			blog.setContent(blog.getContent().substring(0,
					StringLengthConstans.BLOG_CONTENT_LENGTH));
		}
		return true;
	}

	/**
	 * 根据文章id获取一篇文章
	 * 
	 * @author guangshuai.wang 2014-10-12下午9:49:59
	 * @param id
	 * @return
	 */
	public Blog getBlogById(long id) {
		Blog blog = blogDao.getBlogById(id);
		return blog;
	}

	/**
	 * 获取一往篇文章的阅读次数
	 * 
	 * @author guangshuai.wang
	 * @param blogId
	 * @return long
	 * @date:2014-9-14
	 */
	public long getBlogReadTimes(long blogId) {
		String value = JedisUtil.getSring(JedisConstans.READ_TEMIS + blogId);
		if (value != null) {
			return Long.parseLong(value);
		}
		return 0;
	}

	/**
	 * 根据文章作者的类型来获取此作者下所有的文章，
	 * 
	 * @author guangshuai.wang 2014-10-13下午9:51:32
	 * @param type
	 *            0，表是是用户的文章，1，是本网站的文章
	 * @return
	 */
	public List<Blog> getAllBlogByType(int type, int page, int rows) {
		Pages pages = new Pages();
		pages.setUserid(type);
		if (page <= 0) {
			page = 1;
		}
		pages.setStart((page - 1) * rows);
		pages.setEnd(rows);
		List<Blog> list = blogDao.getAllBlogByType(pages);

		return list;
	}

	/**
	 * 根据文章作者的类型获取此作者下文章的总数，
	 * 
	 * @author guangshuai.wang 2014-10-13下午9:53:22
	 * @param type
	 *            0，表是是用户的文章，1，是本网站的文章
	 * @return
	 */
	public int getAllBlogCountByType(int type) {
		return blogDao.getAllBlogCountByType(type);
	}

	/**
	 * 根据文章id
	 * 
	 * @author guangshuai.wang 2014-10-15下午11:05:14
	 * @param id
	 * @param type
	 * @return
	 */
	public void deleteBlogById(long id) {
		blogDao.deleteBlogById(id);
	}

	public void toEditorBlog(long blogId, HttpServletRequest request) {
		// TODO Auto-generated method stub
		Blog blog = this.getBlogById(blogId);
		if (blog != null) {
			request.setAttribute("classify",
					templateService.getAll(Classify.class).values());
			request.setAttribute("blog", blog);
		}
	}

	public void toWriteBlog(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("classify", templateService.getAll(Classify.class)
				.values());
		request.setAttribute("blog", new Blog());
	}

	public void updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		this.checkBlog(blog);
		dataDao.update(MyBatisConstants.UPDATE_BLOG, blog);
	}

	public List<Blog> getBlogByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
