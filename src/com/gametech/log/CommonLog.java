package com.gametech.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 提供logger的实例
 * 
 * @author pengfei.he
 * 
 */
public class CommonLog {
	public static Logger loginLog = LoggerFactory.getLogger("game");
	public static Logger ERR = LoggerFactory.getLogger("err");
	
}