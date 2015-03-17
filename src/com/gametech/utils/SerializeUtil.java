package com.gametech.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

import com.gametech.entity.ObjEntity;

public class SerializeUtil {

	static Logger log = Logger.getLogger(SerializeUtil.class);
	/**
	 * 
	 * <p>Title: ObjTOSerialize</p>
	 * <p>Description:</p>
	 * @param obj
	 * @return
	 * @author guangshuai.wang
	 */
	public static byte[] ObjTOSerialize(Object obj){
		ObjectOutputStream oos = null;
		ByteArrayOutputStream byteOut = null;
		try{
			byteOut = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(byteOut);
			oos.writeObject(obj);
			byte[] bytes = byteOut.toByteArray();
			return bytes;
		}catch (Exception e) {
			e.printStackTrace();
			
			
		}
		return null;
	}
	/**
	 * 
	 * <p>Title: unSerialize</p>
	 * <p>Description: 对象反序列化</p>
	 * @param bytes
	 * @return
	 * @author guangshuai.wang
	 */
	public static Object unSerialize(byte[] bytes){
		ByteArrayInputStream in = null;
		try{
			in = new ByteArrayInputStream(bytes);
			ObjectInputStream objIn = new ObjectInputStream(in);
			return objIn.readObject();
		}catch (Exception e) {
			log.error("反序列化出错");
		}
		return null;
	}
	public static void main(String[] args) {
		ObjEntity b = new ObjEntity();
		b.setId(9);
		SerializeUtil.ObjTOSerialize(b);
	}
}
