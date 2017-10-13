package com.bank.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.bank.dao.DaoImpl;
import com.bank.dao.DaoInterface;

/**
 * 
 * 工厂类<单例+同步>
 * 用于通过反射得到持久层对象
 * 
 * */
public class DaoFactory {
	
	private DaoInterface daoImpl;//定义持久层接口对象
	
	//单例+同步，保证安全性
	private static DaoFactory daoFactory=null;
	private DaoFactory(){}
	public synchronized static DaoFactory getInstance(){
		if(daoFactory==null){
			daoFactory=new DaoFactory();
		}
		return daoFactory;
	} 
	
	//通过反射得到properties文件中指定的实现类的对象
	public DaoInterface getObj()throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("factory.properties");
		prop.load(fis);
		String className=prop.getProperty("className");
		Class c=Class.forName(className);//加载反射类
		Object obj=c.newInstance();//得到反射类对象
		daoImpl=(DaoInterface)obj;//造型
		
		return daoImpl;
		
	}
	
}
