package com.gametech.entity;

import java.sql.Timestamp;

public class PayCache {
	private long id;
	private long userid;
	//保存的事件类型的索引id,比如，如果是提问的积分，刚是问题的id
	private long event_id;
	//需要支付的数量
	private int price;
	private Timestamp createTime;
	//完成的状态，0，锁定，1，完成
	private short status;
	//支付的事件类型，见AppConstans
	private short type;
	//备注
	private String remarks;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getEvent_id() {
		return event_id;
	}
	public void setEvent_id(long eventId) {
		event_id = eventId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public short getType() {
		return type;
	}
	public void setType(short type) {
		this.type = type;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
