package cn.bank.ssh.manager;

import cn.bank.ssh.bean.Log;
/**
 * 银行5.0的业务类日志定义--接口
 * @author Administrator
 * @version bank5.0 2017/9/17
 */
public interface LogManagerInterface {
	
	//添加日志信息
	public void addLog(Log log);
}
