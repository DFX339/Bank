package bank.com.test;

import java.sql.SQLException;

import bank.com.bean.User;
import bank.com.service.ServiceImpl;

/**
 * ����ҵ������Ĳ�����
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
	

	//ת��
	public void transfer(){
		double money=si.transfer("1",50,"2");
		System.out.println(money+"ת��");
	}
	
	//��ѯ���
	public void inqury(){
		double money=si.inqury("1");
		System.out.println(money+"���");
	}
	//ȡ��
	public void withdrawal(){
		double money=si.withdrawal(50,"1");
		System.out.println(money+"ȡ��");
	}
	
	//���
	public void deposit(){
		double money=si.deposit(100,"1");
		System.out.println(money+"���");
	}
	
	//��¼
	public void login() throws SQLException{
		User flag=si.login("С��ʹ", "123");
		System.out.println(flag+"��¼");
	}
	
	//ע��
	public void regist() throws SQLException{
		boolean flag=si.regist("С��ʹ", "123",123);
		System.out.println(flag+"ע��");
	}
	
	

}
