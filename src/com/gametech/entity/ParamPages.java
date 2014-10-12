package com.gametech.entity;

public class ParamPages extends Pages{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5704242017253366849L;
	private long userid;
	//以某个id为参数
	private int someId;
	//某种类型的参数
	private int type;
	
	
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSomeId() {
		return someId;
	}

	public void setSomeId(int someId) {
		this.someId = someId;
	}
	
	
}
