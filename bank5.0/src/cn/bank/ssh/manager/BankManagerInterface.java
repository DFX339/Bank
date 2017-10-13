package cn.bank.ssh.manager;

import cn.bank.ssh.bean.User;

/**
 * 银行5.0的业务类方法定义--接口
 * @author Administrator
 * @version bank5.0 2017/9/17
 */
public interface BankManagerInterface {
	
	public boolean regist(User user);//注册
	public User login(String username,String password);//登录
	public double deposit(int id,double depositMoney);//存款
	public double withdrawal(int id,double withdrawalMoney);//取款
	public double transfer(int id,double transferMoney, int transferId);//转账
	public double find(int id);//查询余额
}
