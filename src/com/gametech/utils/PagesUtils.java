package com.gametech.utils;

import com.gametech.entity.Pages;

public class PagesUtils {
	
	public static void setPages(Pages pagesObj,String url){
		int page = pagesObj.getNowPage();
		if(page < 5){
			pagesObj.setEnd(10);
			pagesObj.setStart(1);
		} else {
			pagesObj.setEnd(page + 4);
			pagesObj.setStart(page - 5);
		}
		if(pagesObj.getTotalPages() < 10){
			pagesObj.setStart(1);
			pagesObj.setEnd(pagesObj.getTotalPages());
		}
		pagesObj.setUrl(url);
	}

}
