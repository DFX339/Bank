package bank.com.service;

import java.io.IOException;
import java.sql.SQLException;

import bank.com.bean.User;
import bank.com.dao.DaoInterface;
import bank.com.dao.MysqlDaoImpl;
import bank.com.factory.DaoFactory;

/**
 * ҵ������
 * 
 * ͨ��������ó־ò����Գ־ò���в���
 * ��ɶԴ� ȡ�ת�ˣ���¼��ע�ᣬ��ѯ���ȹ���
 * 
 * @author DFX
 * @version 2.0 2017/07/28
 * */
public class ServiceImpl {
	private static ServiceImpl instance=null;
	DaoInterface daoImpl;//�����־ò�ӿ������ͱ��������սӿ�ʵ����Ķ�����ɶ����ݵĲ���
	private ServiceImpl(){
		DaoFactory daoFactory=DaoFactory.getInstance();//�õ���������
		
		try {
			daoImpl=daoFactory.getDaoImpl();//ͨ���������󣬵õ��־ò����
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public static synchronized ServiceImpl getInstance(){
		if(instance==null){
			instance=new ServiceImpl();
		}
		return instance;
	}
	
	
	
	//��¼
	public User login(String username ,String password) throws SQLException{
		User user=new User(username,password);
		user.setUsername(username);
		user.setPassword(password);
		return daoImpl.login(user);
		
	}
	
	//ע��
	public boolean regist(String username ,String password,double money) throws SQLException{
		User user=new User(username,password,money);
		user.setUsername(username);
		user.setPassword(password);
		user.setMoney(money);
		return daoImpl.regist(user);
		
	}
	
	//��ѯ���
	public double inqury(String id){
		return daoImpl.inqury(id);
	}
	
	//���
	public double deposit(double money,String id){
		return daoImpl.deposit(money,id);
	}
	
	//ȡ��
	public double withdrawal(double money,String id){
		return daoImpl.withdrawal(money,id);
	}
	
	//ת��
	public double transfer(String ID,double money,String id){
		return daoImpl.transfer(ID, money,id);
	}
	
}
