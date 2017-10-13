package com.bank.model;
/**
 * �û�ʵ���ࣺ������¼��ע�ᣨ����ʽ�������ģʽ��
 * @Author DFX
 * @version 1.2 2017/06/20
 * */
public class User {
	
	private String username;//�û���
	private String password;//����
	
	//����ʽ�������ģʽ
	private User(){}
	public static User user=null;
	public static User getUser(){
		//����ͬ������static���͵�������Ϊ��ǰ��̬���������������.class
		synchronized(User.class){
		if(user==null){
			user=new User();
		}
		return user;
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
