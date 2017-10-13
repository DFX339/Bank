package cn.bank.ssh.bean;

import java.util.Date;
/**
 * hibernate用来建表的bean  日志类 
 * @author Administrator
 * @version bank5.0 2017/9/17
 */
public class Log {
	
	private int id;
	private int userid;
	private String username;
	private String type;
	private String content;
	private Date operateTime;
	
	public Log(){}
	
	

	public int getUserid() {
		return userid;
	}



	public void setUserid(int userid) {
		this.userid = userid;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	
	
}
