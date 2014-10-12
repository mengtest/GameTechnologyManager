package com.gametech.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.gametech.entity.Member;

public class MemberDao extends SqlSessionDaoSupport{
	
	public Member getMemberByName(String name){
		return  getSqlSession().selectOne("membermapper.selectMemberByName", name);
	}
	public void deleteMemberById(int id){
		getSqlSession().delete("membermapper.deleteMemberById", id);
	}
	public void insertMember(Member member){
		getSqlSession().insert("membermapper.insertMember", member);
	}
}
