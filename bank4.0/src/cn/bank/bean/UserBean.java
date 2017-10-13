package cn.bank.bean;
/**
 * 用户的表单bean，一对一
 * @author Administrator
 *
 */
public class UserBean {
	
	private int id;
	private String username;
	private String password;
	private double money;
	

	public UserBean(){}

	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
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
	
}
