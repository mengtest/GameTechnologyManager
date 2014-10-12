package com.gametech.entity;

import java.util.Date;

public class Blog extends BlogTitle{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7540468495953122058L;
	
	public String content;
	public Date createTime;
	//个人自定义分类id
	public int sortId;
	//文章分类id
	public int classifyId;
	public String tag;
	//是否原创
	public int yuanchuang = 0;
	
	
	public int getYuanchuang() {
		return yuanchuang;
	}
	public void setYuanchuang(int yuanchuang) {
		this.yuanchuang = yuanchuang;
	}
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(int classifyId) {
		this.classifyId = classifyId;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
}
