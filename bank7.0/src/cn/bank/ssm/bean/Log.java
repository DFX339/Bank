package cn.bank.ssm.bean;

import java.util.Date;

/**
 * 日志类
 * @author Administrator
 *
 */
public class Log {
	
	private int id;//日志主id 
	private String logType;//日志类型
	private String logContent;//日志内容
	private Date operateTime;//日志创建时间
	private int userid;
	

	public Log(){}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	
	
	
}
