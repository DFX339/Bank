package cn.bank.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��ȡproperties�����ļ���util��
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
	
	//��̬���飬��ȡ�����ļ��е�������Ϣ
	static{
		Properties props=new Properties();
		InputStream fis=null;
		fis=Thread.currentThread().getContextClassLoader().getResourceAsStream("dao.properties");
		try {
			props.load(fis);//���������ļ�
			driver=props.getProperty("driver");
			url=props.getProperty("url");
			username=props.getProperty("username");
			password=props.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
