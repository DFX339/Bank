package bank.com.bean;
/**
 * 用户实体类
 * 包含属性 String username，String password,double money 账户金额
 * 用来验证用户登录和注册功能
 * 完成用户的转账 取款 存款 等操作
 * @Author DFX
 * @version 2.0 207/27
 * */
public class User {
	
	private String ID;
	private String username;//用户名
	private String password;//密码
	private double money;
	
	public User(){}//显示提供无参数的构造方法
	public User(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public User(String username,String password,double money){
		this.username=username;
		this.password=password;
		this.money=money;
	}
	
	public double getMoney(){
		return money;
	}
	public void setMoney(double money){
		this.money=money;
	}
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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
	
	//复写toString()方法
	public String toString(){
		return this.getClass()+"[name"+username+",password"+password+"]";
	}

}
