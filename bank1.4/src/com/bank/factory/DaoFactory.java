package com.bank.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.bank.dao.DaoImpl;
import com.bank.dao.DaoInterface;

/**
 * 
 * ������<����+ͬ��>
 * ����ͨ������õ��־ò����
 * 
 * */
public class DaoFactory {
	
	private DaoInterface daoImpl;//����־ò�ӿڶ���
	
	//����+ͬ������֤��ȫ��
	private static DaoFactory daoFactory=null;
	private DaoFactory(){}
	public synchronized static DaoFactory getInstance(){
		if(daoFactory==null){
			daoFactory=new DaoFactory();
		}
		return daoFactory;
	} 
	
	//ͨ������õ�properties�ļ���ָ����ʵ����Ķ���
	public DaoInterface getObj()throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("factory.properties");
		prop.load(fis);
		String className=prop.getProperty("className");
		Class c=Class.forName(className);//���ط�����
		Object obj=c.newInstance();//�õ����������
		daoImpl=(DaoInterface)obj;//����
		
		return daoImpl;
		
	}
	
}
