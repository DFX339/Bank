package bank.com.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import bank.com.dao.DaoInterface;

/**
 * ������ 
 * ͨ�����似�� �õ������ļ��е�ʵ����
 *  <����+ͬ�� ��֤��ȫ��>
 * @author DFX
 * @version 2.0 2017/07/28
 * */
public class DaoFactory {
	Properties props=new Properties();
	InputStream fis;
	DaoInterface daoImpl;//�����ӿ����ͱ������������ļ���ָ��ʵ����Ķ���
	private static DaoFactory instance=null;
	private DaoFactory(){
	}
	
	//����ʽ����+ͬ��
	public synchronized static DaoFactory getInstance(){
		if(instance==null){
			instance=new DaoFactory();
		}
		return instance;
	}
	
	//ͨ�������ȡ�����ļ���Ϣ���õ��ӿ�ʵ����Ķ���
	public DaoInterface getDaoImpl() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
			fis= Thread.currentThread().getContextClassLoader().getResourceAsStream("/daoImpl.properties");
			props.load(fis);
			String name=props.getProperty("className");
			Class c=Class.forName(name);
			Object obj=c.newInstance();
			daoImpl=(DaoInterface)obj;
			return daoImpl;
	}
	
}
