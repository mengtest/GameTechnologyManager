package com.gametech.entity;

import java.util.Date;

public class BlogTitle extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6960246627842720531L;
	public String title;
	//摘要
	public String shortContent;
	public Date createTime;
	//阅读次数
	public long readTimes;
	//文章的状态 0 正常，-1，删除
	private int status;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public long getReadTimes() {
		return readTimes;
	}
	public void setReadTimes(long readTimes) {
		this.readTimes = readTimes;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShortContent() {
		return shortContent;
	}
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}
	
	
}
