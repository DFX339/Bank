package bank.com.dao;

import java.sql.SQLException;

import bank.com.bean.User;

/**
 * 接口
 * 定义对银行业务的操作方法
 * 外加登录和注册
 * 
 * @author DFX
 * @version 2.0 2017/07/27
 * 
 * */
public interface DaoInterface {
	
	public User login(User user) throws SQLException;//登录方法 
	public boolean regist(User user);//注册方法
	public double inqury(String ID);//查询余额 ID：当前账号的ID  return：返回余额
	public double deposit(double money,String id);//存款  money :存款金额  return：返回余额
	public double withdrawal(double money,String id);//取款  money:取款金额	return：返回余额
	public double transfer(String ID,double money,String id);//转账 ID：转账对象，money:转账数目 return：返回余额
	
}
