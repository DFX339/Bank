package cn.bank.ssm.dao;

import java.util.List;

import cn.bank.ssm.bean.Admin;
import cn.bank.ssm.bean.Log;
import cn.bank.ssm.bean.User;
/**
 * 银行项目的7.0版本
 * @author Administrator
 *
 */
public interface BankDaoInterface {
	
	public User login(User user);//普通用户登录登录
	public Admin adminLogin(Admin admin);//admin登录登录
	public void regist(User user);//注册
	public void updateMoney(User user);//更新余额
	public User findById(int id);//查看账号是否存在
	public List findAll();//查看所有用户信息
	public void updateTag(User user);//管理员更新用户状态
	public void addLog(Log log);//管理员更新用户状态
	
	
	
	
}
