package cn.bank.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.bank.dao.BankDao;

/**
 * 工厂类
 * 用来获取dao的实现类
 * 判定实用哪种数据库
 * @author DFX
 * @version 3.0 2017.8.14
 * */
public class DaoFactory {
	
	BankDao bankDao=null;
	
	//单例+同步
	private static DaoFactory instance=null;
	private DaoFactory(){}
	public synchronized static DaoFactory getInstance(){
		if(instance==null){
			instance=new DaoFactory();
		}
		return instance;
	}
	
	public BankDao getDaoImpl(){
		Properties props=new Properties();
		InputStream fis=Thread.currentThread().getContextClassLoader().getResourceAsStream("factory.properties");
		try {
			props.load(fis);
			String className=props.getProperty("className");
			Class c=Class.forName(className);
			bankDao=(BankDao)c.newInstance();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return bankDao;
		
	}

}
