package com.bank.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.bank.dao.DaoInterface;

/**
 * ������<����+ͬ��>
 * ͨ�������properties�ļ��еõ��־ò��ʵ������� 
 * @Author DFX
 * @Version 1.3 2017/07/18
 * */
public class DaoFactory {
	
	private DaoInterface daoImpl;//����־ò�ӿ�ʵ����Ķ���
	
	/*
	 * <����ʽ����+ͬ��>
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
	 * ͨ������õ��־ò�ʵ�������
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
			String className=prop.getProperty("className");//�õ�������ȫ��
			Class c=Class.forName(className);//���ط�����
			Object obj=c.newInstance();//�������������
			daoImpl=(DaoInterface)obj;//�Է������������Ϊʵ���ӿ�
			
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
		return daoImpl;//���س־ò�ʵ�������
		
	}
}
