package cn.bank.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取properties配置文件的util类
 * 
 * @author Administrator
 * @version 3.0 2017/8/14
 *
 */
public class ReadPropUtil {
	
	 static String driver;
	 static String url;
	 static String username;
	 static String password;
	
	public ReadPropUtil(){}
	
	//静态语句块，读取配置文件中的配置信息
	static{
		Properties props=new Properties();
		InputStream fis=null;
		fis=Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
		try {
			props.load(fis);//加载配置文件
			driver=props.getProperty("driver");
			url=props.getProperty("url");
			username=props.getProperty("username");
			password=props.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
