package com.gametech.entity;

public class Pages extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3038009725689890553L;
	//显示分页的起始位置
	private int start;
	//显示分页的结束位置
	private int end;
	//每页显示的数量
	private int size;
	private int nowPage;
	//总页数
	private int totalPages;
	//不同的请求分页显示不同的url
	private String url;
	/**
	 * 
	 * <p>Title: setPages</p>
	 * <p>Description: 设置页数对象</p>
	 * @param total			总记录数
	 * @param nowpage		当前页数
	 * @param pagesize		每页显示的个数
	 * @author guangshuai.wang
	 */
	public void setPages(int total,int nowpage,int pageSize){
		this.size = pageSize;
		 totalPages = total % pageSize == 0? total / pageSize : total / pageSize + 1;
		 if(nowpage > totalPages){
			 nowpage = 1;
		 }
		 if(nowpage < 1){
			 nowpage = 1;
		 }
		 this.nowPage = nowpage;
		 this.start = (nowpage - 1) * pageSize;
		 //计算结束值，防止越界
		 if((this.start + pageSize) > total){
			 this.end = total -1;
		 } else {
			 this.end = this.start + pageSize -1;
		 }
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
