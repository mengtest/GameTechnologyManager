package com.gametech.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.gametech.entity.Blog;
import com.gametech.imanager.IBlogManager;
import com.gametech.iservice.IBlogService;
@Service("blogService")
public class BlogService  implements IBlogService{

	@Autowired
	@Qualifier("blogManager")
	private IBlogManager blogManager;
	public void toEditorBlog(long blogId,HttpServletRequest request) {
		// TODO Auto-generated method stub
		blogManager.toEditorBlog(blogId, request);
	}

	public void toWriteBlog(HttpServletRequest request) {
		// TODO Auto-generated method stub
		blogManager.toWriteBlog(request);
	}

	public void updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		blogManager.updateBlog(blog);
	}

	public Blog getBlogById(long blogId) {
		// TODO Auto-generated method stub
		return blogManager.getBlogById(blogId);
	}

	public void deleteBlogById(long blogid) {
		// TODO Auto-generated method stub
		blogManager.deleteBlogById(blogid);
	}

	public List<Blog> getBlogByName(String name) {
		// TODO Auto-generated method stub
		return blogManager.getBlogByName(name);
	}

	public boolean writeBlog(HttpServletRequest request, Blog blog) {
		// TODO Auto-generated method stub
		return blogManager.writeBlog(request, blog);
	}

	public int getAllBlogCountByType(int type) {
		// TODO Auto-generated method stub
		return blogManager.getAllBlogCountByType(type);
	}

	public List<Blog> getAllBlogByType(int type, int nowpage, int rows) {
		// TODO Auto-generated method stub
		return blogManager.getAllBlogByType(type, nowpage, rows);
	}

}
