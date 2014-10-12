package com.gametech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gametech.entity.Member;
import com.gametech.manager.MemberManager;

@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired
	private MemberManager memberManager;
	/**
	 * 登陆
	 * @return
	 */
	@RequestMapping("login")
	public String login(@ModelAttribute("member") Member member){
		int result = memberManager.login(member);
		//登陆成功
		if(result == 0){
			return "/jsp/member/main";
		}
		return "redirect:/";
		
	}
	@RequestMapping("checkMember")
	@ResponseBody
	public String checkMember(@ModelAttribute("member")Member member){
		int result = memberManager.login(member);
		return String.valueOf(result);
	}
}
