package cn.bank.ssh.form;

import org.apache.struts.action.ActionForm;
/**
 * struts中用来收集表单数据的form
 * @author Administrator
 * @version bank5.0 2017/9/17
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
