package com.gametech.excel.model;

public class Jifen extends ExcelBase {
	//id
	public int id;
	//发放积分事件id
	public int templateId;
	//事件名
	public String name;
	//奖励的积分
	public int jifen;
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setTemplateId(int templateId){
		this.templateId = templateId;
	}
	public int getTemplateId(){
		return templateId;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setJifen(int jifen){
		this.jifen = jifen;
	}
	public int getJifen(){
		return jifen;
	}
	
}