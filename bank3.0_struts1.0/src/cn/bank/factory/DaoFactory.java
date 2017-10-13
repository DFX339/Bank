package cn.bank.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.bank.dao.BankDao;

/**
 * ������
 * ������ȡdao��ʵ����
 * �ж�ʵ���������ݿ�
 * @author DFX
 * @version 3.0 2017.8.14
 * */
public class DaoFactory {
	
	BankDao bankDao=null;
	
	//����+ͬ��
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
