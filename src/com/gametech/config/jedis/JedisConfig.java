package com.gametech.config.jedis;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @author guangshuai.wang
 * <p>Description:</p>
 */
public class JedisConfig {

	
	private int maxactive;
	private int maxidle;
	private int maxwait;
	private int timeout;
	private boolean testonborrow = true;
	private boolean testonreturn = true;
	private String master;
	private String slave;
	
	private int retry_num;
	private static JedisConfig jedisConfig= new JedisConfig();
	static {
		InputStream configInput = null;
		SAXReader reader = new SAXReader();
		try{
			String path  = "com/gametech/config/jedis/jedis_config.xml";
			configInput = JedisConfig.getInstance().getClass().getClassLoader().getResourceAsStream(path);
			Document doc = reader.read(configInput);
			Element root = doc.getRootElement();
			Element jedis = root.element("jedis");
			jedisConfig.setMaxactive(Integer.parseInt(jedis.attributeValue("maxactive")));
			jedisConfig.setMaxidle(Integer.parseInt(jedis.attributeValue("maxidle")));
			jedisConfig.setMaxwait(Integer.parseInt(jedis.attributeValue("maxwait")));
			jedisConfig.setRetry_num(Integer.parseInt(jedis.attributeValue("retry_num")));
			jedisConfig.setTimeout(Integer.parseInt(jedis.attributeValue("timeout")));
			Element server = root.element("master");
			jedisConfig.setMaster(server.attributeValue("ip") + "," + server.attributeValue("port"));
			Element slave = root.element("slave");
			jedisConfig.setSlave(slave.attributeValue("ip") + "," + slave.attributeValue("port"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	private JedisConfig(){
		
	}
	
	public static JedisConfig getInstance(){
		return jedisConfig;
	}
	
	
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getMaxactive() {
		return maxactive;
	}
	public void setMaxactive(int maxactive) {
		this.maxactive = maxactive;
	}
	public int getMaxidle() {
		return maxidle;
	}
	public void setMaxidle(int maxidle) {
		this.maxidle = maxidle;
	}
	public int getMaxwait() {
		return maxwait;
	}
	public void setMaxwait(int maxwait) {
		this.maxwait = maxwait;
	}
	public boolean isTestonborrow() {
		return testonborrow;
	}
	public void setTestonborrow(boolean testonborrow) {
		this.testonborrow = testonborrow;
	}
	public boolean isTestonreturn() {
		return testonreturn;
	}
	public void setTestonreturn(boolean testonreturn) {
		this.testonreturn = testonreturn;
	}
	
	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getSlave() {
		return slave;
	}

	public void setSlave(String slave) {
		this.slave = slave;
	}

	public int getRetry_num() {
		return retry_num;
	}
	public void setRetry_num(int retryNum) {
		retry_num = retryNum;
	}
	
	public static void main(String[] args) {
		JedisConfig config = JedisConfig.getInstance();
		System.out.println(config.getMaxactive());
	}
}
