package com.gametech.entity;

public class BaseEntity extends ObjEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8910465395011865082L;

	public long userid;
	
	public String name;
	

	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
