package com.gametech.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gametech.constans.AppConstans;
import com.gametech.utils.GmUtils;
import com.gametech.utils.HttpUtils;

@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("/")
	public String index(){
		return "/jsp/index";
	}
	
	@RequestMapping("/code")
	public void getRegistCode(HttpServletRequest request,HttpServletResponse response){
		try {
			GmUtils.getCode(request, response, AppConstans.CODE_REGIST_CHECK, 4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/checkCode/{code}")
	@ResponseBody
	public Map<String, Integer> checkCode(HttpServletRequest request,@PathVariable("code")String code){
		Map<String, Integer> map = new HashMap<String, Integer>();
		if(HttpUtils.checkCode(request, AppConstans.CODE_REGIST_CHECK, code)){
			map.put("ok", 1);
		} else {
			map.put("ok", 0);
		}
		return map;
	}
}
