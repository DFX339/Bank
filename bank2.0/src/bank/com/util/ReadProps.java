package bank.com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取配置文件类
 * 
 * 获取连接数据库的配置文件中的信息
 * 
 * */
public class ReadProps {
	
	static String url;//连接数据库的url
	static String driver;//连接数据的驱动
	static String username;//数据库用户名
	static String password;//数据库登录密码
	
	
	public ReadProps(){
		Properties props=new Properties();//创建properties对象
		InputStream fis=null;//文件输入流对象，用来读取文件
		try {
			fis=Thread.currentThread().getContextClassLoader().getResourceAsStream("mysql.properties");
			props.load(fis);//加载文件
			url=props.getProperty("url");//取出properties文件中url对应的value
			driver=props.getProperty("driver");//取出properties文件中driver对应的value
			username=props.getProperty("username");//取出properties文件中username对应的value
			password=props.getProperty("password");//取出properties文件中url对应的value
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在"+e);
		}
		catch (IOException e1) {
			System.out.println("读取配置文件异常"+e1);
		}
	}

}
