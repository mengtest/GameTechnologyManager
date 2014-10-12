package com.gametech.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.gametech.constans.AppConstans;
import com.gametech.dao.MemberDao;
import com.gametech.entity.Member;
import com.gametech.utils.HttpUtils;

public class MemberManager {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private MemberDao memberDao;
	/**
	 * 后台登陆
	 * @return  0 成功，1 用户不存在，2，密码或帐号错误,3 验证码错误
	 */
	public int login(Member member){
		if(!HttpUtils.checkCode(request, AppConstans.CODE_REGIST_CHECK, member.getCode())){
			return 3;
		}
		Member oldMember = memberDao.getMemberByName(member.getName());
		if(oldMember == null){
			return 1;
		} 
		if(member.getPassword().equals(oldMember.getPassword())){
			request.getSession(false).setAttribute(AppConstans.USER, oldMember);
			return 0;
		} else {
			return 2;
		}
		
	}
	
}
