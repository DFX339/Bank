package cn.bank.ssh.service;

import cn.bank.ssh.bean.User;
/**
 * 银行功能定义的接口
 * @author Administrator
 * @version 6.0 2017/9/21
 */
public interface BankService {
	
	public User login(String username,String password);
	public boolean regist(User user);
	public double deposit(int id,double money);
	public double withdrawal(int id,double money);
	public double transfer(int id,double transferMoney,int transferId);
	public double inqury(int id);
}
