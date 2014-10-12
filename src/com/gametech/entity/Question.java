package com.gametech.entity;

import java.sql.Timestamp;

public class Question extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String content;
	private Timestamp createTime;
	//缩略后的内容，保留100-300字
	private String shortTitle;
	//问题分类id
	private int sortId;
	//回答个数
	private int answers;
	//是否已解决 1已解决，-1未解决
	private short isOk;
	//发布问题时，悬赏的积分
	private int xuanshang;
	//验证码
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShortTitle() {
		return shortTitle;
	}
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
	public int getXuanshang() {
		return xuanshang;
	}
	public void setXuanshang(int xuanshang) {
		this.xuanshang = xuanshang;
	}
	public short getIsOk() {
		return isOk;
	}
	public void setIsOk(short isOk) {
		this.isOk = isOk;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getSortId() {
		return sortId;
	}
	public void setSortId(int sortId) {
		this.sortId = sortId;
	}
	public int getAnswers() {
		return answers;
	}
	public void setAnswers(int answers) {
		this.answers = answers;
	}
	
	

}
