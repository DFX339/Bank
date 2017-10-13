package cn.bank.ssh.bean;

import java.util.Set;
/**
 * hibernate用来建表的bean  用户类
 * @author Administrator
 * @version bank5.0 2017/9/17
 */
public class User {
	
	private int id;
	private String username;
	private String password;
	private double Money;
	
	public User(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getMoney() {
		return Money;
	}

	public void setMoney(double money) {
		Money = money;
	}

	
	
}
