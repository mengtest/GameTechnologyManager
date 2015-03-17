package com.gametech.iservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gametech.entity.Blog;
public interface IBlogService {
	/**
	 * 编辑文章时，获取文章的信息，并跳转到文章编辑页面。
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午3:56:48
	 * @param blogId
	 */
	public void toEditorBlog(long blogId,HttpServletRequest request);
	/**
	 * 写博客
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午10:58:02
	 * @param request
	 * @return
	 */
	public boolean writeBlog(HttpServletRequest request,Blog blog);
	/**
	 * 获取写文章时的信息，并跳转到写文章的页面
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午3:58:26
	 * @param request
	 */
	public void toWriteBlog(HttpServletRequest request);
	/**更新一篇文章**/
	public void updateBlog(Blog blog);
	/**
	 * 根据文章id获取一篇文章的信息
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午4:07:11
	 * @param blogId
	 * @return
	 */
	public Blog getBlogById(long blogId);
	/**
	 * 删除一篇博客
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午10:06:28
	 * @param blogid
	 */
	public void deleteBlogById(long blogid);
	/**
	 * 根据博客的名字，模糊查询博客。
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午10:09:39
	 * @param name
	 * @return
	 */
	public List<Blog> getBlogByName(String name);
	/**
	 * 根据用户类型，查找此用户的文章个数
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午11:05:23
	 * @param type
	 * @return
	 */
	public int getAllBlogCountByType(int type);
	/**
	 * 根据页数和用户类型获取部分文章
	 *说明:
	 *@author wang guang shuai
	 *2015-3-14下午11:06:50
	 * @param type
	 * @param nowpage
	 * @param rows
	 * @return
	 */
	public List<Blog> getAllBlogByType(int type,int nowpage, int rows);
}
