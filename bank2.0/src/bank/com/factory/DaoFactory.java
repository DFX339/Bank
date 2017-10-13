package bank.com.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import bank.com.dao.DaoInterface;

/**
 * 工厂类 
 * 通过反射技术 拿到配置文件中的实现类
 *  <单例+同步 保证安全性>
 * @author DFX
 * @version 2.0 2017/07/28
 * */
public class DaoFactory {
	Properties props=new Properties();
	InputStream fis;
	DaoInterface daoImpl;//创建接口类型变量接收配置文件中指定实现类的对象
	private static DaoFactory instance=null;
	private DaoFactory(){
	}
	
	//饱汉式单例+同步
	public synchronized static DaoFactory getInstance(){
		if(instance==null){
			instance=new DaoFactory();
		}
		return instance;
	}
	
	//通过反射读取配置文件信息，得到接口实现类的对象
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
