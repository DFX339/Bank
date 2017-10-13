package cn.bank.ssm.bean;
/**
 * 管理员
 * @author Administrator
 * @version 7.0 2017/9/28
 */
public class Admin {
	
	private int aid;//管理员的id，主标识
	private String username;//管理员登录名
	private String password;//管理员密码

	public Admin(){}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
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
