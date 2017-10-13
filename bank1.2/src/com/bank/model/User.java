package com.bank.model;
/**
 * 用户实体类：用来登录和注册（饱汉式单例设计模式）
 * @Author DFX
 * @version 1.2 2017/06/20
 * */
public class User {
	
	private String username;//用户名
	private String password;//密码
	
	//饱汉式单例设计模式
	private User(){}
	public static User user=null;
	public static User getUser(){
		//增加同步锁，static类型的锁对象为当前静态方法所属类的类名.class
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
