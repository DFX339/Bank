package com.bank.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.bank.dao.DaoInterface;

/**
 * 工厂类<单例+同步>
 * 通过反射从properties文件中得到持久层的实现类对象 
 * @Author DFX
 * @Version 1.3 2017/07/18
 * */
public class DaoFactory {
	
	private DaoInterface daoImpl;//定义持久层接口实现类的对象
	
	/*
	 * <饱汉式单例+同步>
	 * 
	 * */
	private static DaoFactory daoFactory=null;
	private DaoFactory(){}
	public synchronized static DaoFactory getInstance(){
		if(daoFactory==null){
			daoFactory=new DaoFactory();
		}
		return daoFactory;
	}
	
	/*
	 * 通过反射得到持久层实现类对象
	 * @Params null
	 * @Return DaoInterface
	 * 
	 * */
	public DaoInterface getObj(){
		Properties prop=new Properties();
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("daoImpl.properties");
			prop.load(fis);
			String className=prop.getProperty("className");//得到反射类全名
			Class c=Class.forName(className);//加载反射类
			Object obj=c.newInstance();//创建反射类对象
			daoImpl=(DaoInterface)obj;//对反射类对象造型为实例接口
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return daoImpl;//返回持久层实现类对象
		
	}
}
