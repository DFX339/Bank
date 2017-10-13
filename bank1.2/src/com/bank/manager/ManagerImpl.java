package com.bank.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.bank.dao.DaoImpl;
import com.bank.model.Money;
import com.bank.model.User;
import com.bank.utils.AccountOverException;
import com.bank.utils.InvalidDepositException;
import com.bank.utils.MD5;
import com.bank.utils.TransferException;

/**
 * 接口的实现类(饱汉式单例设计模式)
 * 实现的主要方法：登录系统，注册用户， 查询余额，转账，存款，取款，退出系统
 * @Author DFX
 * @version 1.2 2017/06/20
 * */
public class ManagerImpl implements ManagerInterface {
	
	
	// 单例设计模式
	private static ManagerImpl managerImpl = null;

	public static ManagerImpl getManagerImpl() {
		//增加同步锁，static类型的锁对象为当前静态方法所属类的类名.class
		synchronized(ManagerImpl.class){
		if (managerImpl == null) {
			managerImpl = new ManagerImpl();
		}
		return managerImpl;
		}
	}

	// 无参构造方法
	public ManagerImpl() {}

	DaoImpl daoImpl=DaoImpl.getDaoImpl();//得到DaoImpl对象，用来调用DaoImpl中的方法
	
	/*
	 * 调用DaoImpl的transfer方法
	 * 
	 * @param: inputNum :存入的金额数
	 * 
	 * @return:
	 */
	public void transfer(){
		daoImpl.transfer();
	}
		
	
	/*
	 * 调用DaoImpl中的存款方法
	 * 
	 * @param: inputNum :存入的金额数
	 * 
	 * @return:
	 */
	@Override
	public double deposit(double inputNum)  {
			return daoImpl.deposit(inputNum);
	}
	

	/*
	 * 调用DaoImpl中取款方法
	 * 
	 * @param: outputNum :取出的金额数
	 * 
	 * @return:
	 */
	@Override
	public double withdrawals(double outputNum) {
		return daoImpl.withdrawals(outputNum);
	}

	/*
	 * 调用DaoImpl中查询余额方法
	 * 
	 * @param: null
	 * 
	 * @return:
	 */
	@Override
	public double inqury() {
		return daoImpl.inqury();
	}

	/*
	 * 调用DaoImpl层的用户登录方法
	 * 
	 * @param: username 用户名 password 密码
	 * 
	 * @return: void
	 */
	@Override
	public boolean login(String username, String password) {
		return daoImpl.login(username, password);
	}

	/*
	 * 调用DaoImpl中的用户注册方法
	 * 
	 * @param: username 用户名 password 密码
	 * 
	 * @return: void
	 */
	@Override
	public void register(String username, String password) {
		daoImpl.register(username, password);
	}

	/**
	 * 退出系统
	 * 
	 * @param null
	 * @return void
	 * */
	@Override
	public void exitSystem() {
		daoImpl.exitSystem();
	}
	
}
