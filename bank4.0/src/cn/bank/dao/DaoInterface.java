package cn.bank.dao;

import cn.bank.bean.UserBean;

/**
 * ������Ŀ4.0�Ľӿڷ�������
 * @author Administrator
 *
 */
public interface DaoInterface {
	
	public UserBean login(String name,String password);
	public boolean regist(UserBean user);
	public double deposit(int id,double depositMoney);
	public double withdrawal(int id,double withdrawalMoney);
	public double transfer(int id,double transferMoney,int transferId);
	public double inqury(int id);
}
