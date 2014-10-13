package com.gametech.excel.model;

public class Classify extends ExcelBase {
	//id
	public int id;
	//分类id
	public int templateId;
	//分类名字
	public String name;
	
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
	
}