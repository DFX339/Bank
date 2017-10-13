package bank.com.test;

import java.sql.SQLException;

import bank.com.bean.User;
import bank.com.service.ServiceImpl;

/**
 * 银行业务操作的测试类
 * 
 * @author DFX
 * @VERSION 2.0 2017/7/28
 * 
 * */
public class TestBank {

	ServiceImpl  si=ServiceImpl.getInstance();	public static void main(String[] args) throws SQLException {
		TestBank tb=new TestBank();
//		tb.regist();
		tb.login();
		tb.inqury();
//		tb.deposit();
//		tb.withdrawal();
		tb.transfer();
	}
	

	//转账
	public void transfer(){
		double money=si.transfer("1",50,"2");
		System.out.println(money+"转账");
	}
	
	//查询余额
	public void inqury(){
		double money=si.inqury("1");
		System.out.println(money+"余额");
	}
	//取款
	public void withdrawal(){
		double money=si.withdrawal(50,"1");
		System.out.println(money+"取款");
	}
	
	//存款
	public void deposit(){
		double money=si.deposit(100,"1");
		System.out.println(money+"存款");
	}
	
	//登录
	public void login() throws SQLException{
		User flag=si.login("小天使", "123");
		System.out.println(flag+"登录");
	}
	
	//注册
	public void regist() throws SQLException{
		boolean flag=si.regist("小天使", "123",123);
		System.out.println(flag+"注册");
	}
	
	

}
