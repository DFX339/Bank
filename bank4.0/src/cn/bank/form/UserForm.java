package cn.bank.form;

import org.apache.struts.action.ActionForm;

/**
 * �����ռ������ݵ�formBean,
 * @author Administrator
 *
 */
public class UserForm extends ActionForm{
	
	private int id;
	private String username;
	private String password;
	private double money;
	
	public UserForm(){}

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
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
