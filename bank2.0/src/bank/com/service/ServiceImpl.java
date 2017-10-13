package bank.com.service;

import java.io.IOException;
import java.sql.SQLException;

import bank.com.bean.User;
import bank.com.dao.DaoInterface;
import bank.com.dao.MysqlDaoImpl;
import bank.com.factory.DaoFactory;

/**
 * 业务层操作
 * 
 * 通过工厂获得持久层对象对持久层进行操作
 * 完成对存款， 取款，转账，登录，注册，查询余额等功能
 * 
 * @author DFX
 * @version 2.0 2017/07/28
 * */
public class ServiceImpl {
	private static ServiceImpl instance=null;
	DaoInterface daoImpl;//创建持久层接口引用型变量，接收接口实现类的对象，完成对数据的操作
	private ServiceImpl(){
		DaoFactory daoFactory=DaoFactory.getInstance();//得到工厂对象
		
		try {
			daoImpl=daoFactory.getDaoImpl();//通过工厂对象，得到持久层对象
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
	
	
	
	//登录
	public User login(String username ,String password) throws SQLException{
		User user=new User(username,password);
		user.setUsername(username);
		user.setPassword(password);
		return daoImpl.login(user);
		
	}
	
	//注册
	public boolean regist(String username ,String password,double money) throws SQLException{
		User user=new User(username,password,money);
		user.setUsername(username);
		user.setPassword(password);
		user.setMoney(money);
		return daoImpl.regist(user);
		
	}
	
	//查询余额
	public double inqury(String id){
		return daoImpl.inqury(id);
	}
	
	//存款
	public double deposit(double money,String id){
		return daoImpl.deposit(money,id);
	}
	
	//取款
	public double withdrawal(double money,String id){
		return daoImpl.withdrawal(money,id);
	}
	
	//转账
	public double transfer(String ID,double money,String id){
		return daoImpl.transfer(ID, money,id);
	}
	
}
