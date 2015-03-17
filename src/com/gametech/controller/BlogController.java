package com.gametech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gametech.entity.Blog;
import com.gametech.entity.JsonResult;
import com.gametech.entity.ResponseResult;
import com.gametech.excel.TemplateService;
import com.gametech.excel.model.Classify;
import com.gametech.iservice.IBlogService;
import com.gametech.utils.HttpUtils;

@Controller
@RequestMapping("/blog")
public class BlogController {
   @Autowired
   private TemplateService templateService;
  @Autowired
  @Qualifier("blogService")
  private IBlogService blogService;
   
	@RequestMapping("toWrite")
	public String toWriteBlog(HttpServletRequest request){
		request.setAttribute("classify", templateService.getAll(Classify.class)
				.values());
		request.setAttribute("blog", new Blog());
		return "/jsp/blog/writeBlog";
	}
	/**
	 * 发布文章
	 * @param blog
	 * @param request
	 * @return
	 */
	@RequestMapping("publish")
	public String publishBlog(@ModelAttribute("Blog") Blog blog,HttpServletRequest request){
		if(blog.getId() == 0){
			blogService.writeBlog(request, blog);
		} else {
			blogService.updateBlog(blog);
		}
		return "redirect:getOneBlog/" + blog.getId();
	}
	@RequestMapping("/getOneBlog/{id}")
	public String getOneBlogById(@PathVariable("id") long id,HttpServletRequest request){
		Blog blog = blogService.getBlogById(id);
		request.setAttribute("blog", blog);
		return "/jsp/blog/blog";
	}
	@RequestMapping("/toAllBlogs")
	public String toAllBlogs(){
		return "/jsp/blog/allBlog";
	}
	@RequestMapping("/toUserAllBlogs")
	public String toUserAllBlogs(){
		return "/jsp/blog/userAllBlog";
	}
	@RequestMapping("/deleteBlogById")
	@ResponseBody
	public JsonResult deleteBlogById(@RequestParam("id") long id,HttpServletRequest request){
		
		JsonResult result = new JsonResult();
		result.setSuccess(true);
		if(!HttpUtils.isLogin(request)){
			result.setSuccess(false);
			result.setMsg("您未登陆或登陆已过期，请重新登陆！！");
			return result;
		} 
		blogService.deleteBlogById(id);
		return result;
	}
	/**
	 * 获取文章
	 * @author guangshuai.wang
	 * 2014-10-14上午12:10:40
	 * @param type						0 玩家发表的文章；1 系统后台发表的文章
	 * @param request
	 * @param nowpage 			当前页，这个是jquery-easyui自动提交的能参数，参数名必须为page
	 * @param rows				每页显示的记录数，这个是jquery-easyui自动提交的参数，参数名必须为rows
	 * @return
	 */
	@RequestMapping("/getAllBlogs/{type}")
	@ResponseBody
	public String getAllBlogs(@PathVariable("type")int type,@RequestParam("page") int nowpage,@RequestParam("rows") int rows){
		int totalBlogs = blogService.getAllBlogCountByType(type);
		List<Blog> blogList = blogService.getAllBlogByType(type,nowpage,rows);
		ResponseResult result = new ResponseResult();
		result.setTotal(totalBlogs);
		result.setRows(blogList);
		return JSON.toJSONString(result);
	}
	@RequestMapping("toEditor/{blogid}")
	public String toEditorBlog(@PathVariable("blogid") long blogid,HttpServletRequest request){
		blogService.toEditorBlog(blogid, request);
		return "/jsp/blog/writeBlog";
	}
}
