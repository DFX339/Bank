package cn.bank.ssh.bean;

import java.util.Date;

/**
 * 日志实体类
 * @author Administrator
 *
 */
public class Log {
	
	private int id;
	private int userid;
	private String username;
	private String logType;
	private String logContent;
	private Date logTime;
	

	public Log(){}

	public Date getLogTime() {
		return logTime;
	}
	
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	
	
}
