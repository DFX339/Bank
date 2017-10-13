package com.bank.manager;

import com.bank.model.Money;

/**
 * 定义功能规范的接口
 * @Author DFX
 * @version 1.0 2017/06/15
 * */
public interface ManagerInterface {
	
	public void register(String username,String password);//注册
	public void login(String username,String password);//登录
	public double deposit(double moneyNum);//存款
	public double withdrawals(double moneyNum);//取款
	public double inqury();//查询
	
}
