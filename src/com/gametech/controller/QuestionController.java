package com.gametech.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gametech.entity.JsonResult;
import com.gametech.entity.Question;
import com.gametech.entity.ResponseResult;
import com.gametech.manager.QuestionManager;
import com.gametech.utils.HttpUtils;

@Controller
@RequestMapping("question")
public class QuestionController {

	@Autowired
	private QuestionManager questionManager;
	@RequestMapping("getUserQuestion")
	@ResponseBody
	public String getUserQuestion(@RequestParam("page") int nowpage,@RequestParam("rows") int rows){
		ResponseResult result = new ResponseResult();
		int total = questionManager.getUserAllQuestionCount();
		List<Question> listQuestion = questionManager.getUserQuestion(nowpage,rows);
		result.setTotal(total);
		result.setRows(listQuestion);
		return JSON.toJSONString(listQuestion);
	}
	@RequestMapping("/toUserQuestion")
	public String toUserQuestion(){
		return "/jsp/question/userQuestion";
	}
	@RequestMapping("deleteQuestionById")
	@ResponseBody
	public JsonResult deleteQuestionById(@RequestParam("id") int id ,HttpServletRequest request){
		JsonResult result = new JsonResult();
		if(!HttpUtils.isLogin(request)){
			result.setSuccess(false);
			result.setMsg("您未登陆或登陆已过期，请重新登陆！！！");
			return result;
		}
		questionManager.deleteQuestionById(id);
		result.setSuccess(true);
		return result;
	}
}
