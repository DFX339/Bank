package bank.com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ��ȡ�����ļ���
 * 
 * ��ȡ�������ݿ�������ļ��е���Ϣ
 * 
 * */
public class ReadProps {
	
	static String url;//�������ݿ��url
	static String driver;//�������ݵ�����
	static String username;//���ݿ��û���
	static String password;//���ݿ��¼����
	
	
	public ReadProps(){
		Properties props=new Properties();//����properties����
		InputStream fis=null;//�ļ�����������������ȡ�ļ�
		try {
			fis=Thread.currentThread().getContextClassLoader().getResourceAsStream("mysql.properties");
			props.load(fis);//�����ļ�
			url=props.getProperty("url");//ȡ��properties�ļ���url��Ӧ��value
			driver=props.getProperty("driver");//ȡ��properties�ļ���driver��Ӧ��value
			username=props.getProperty("username");//ȡ��properties�ļ���username��Ӧ��value
			password=props.getProperty("password");//ȡ��properties�ļ���url��Ӧ��value
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�������"+e);
		}
		catch (IOException e1) {
			System.out.println("��ȡ�����ļ��쳣"+e1);
		}
	}

}
