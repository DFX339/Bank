package com.bank.manager;

/**
 * 定义功能规范的接口
 * @Author DFX
 * @version 1.2 2017/06/20
 * */
public interface ManagerInterface {
	
	public void register(String username,String password);//注册
	public boolean login(String username,String password);//登录
	public double deposit(double moneyNum);//存款
	public double withdrawals(double moneyNum);//取款
	public double inqury();//查询
	public void exitSystem();//退出系统
	public void transfer();//转账
	
	
}
