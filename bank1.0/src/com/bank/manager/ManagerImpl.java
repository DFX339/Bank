package com.bank.manager;

import java.util.Scanner;

import com.bank.model.Money;
import com.bank.utils.AccountOverException;
import com.bank.utils.InvalidDepositException;

/**
 * 接口的实现类(单例设计模式)
 * @Author DFX
 * @version 1.0 2017/06/15
 * */
public class ManagerImpl implements ManagerInterface {
	
	Money money=Money.getMoneyBean();//创建Money对象
	
	//单例设计模式
	private static ManagerImpl managerImpl=null;
	public static ManagerImpl getManagerImpl(){
		if(managerImpl==null){
			managerImpl=new ManagerImpl();
		}
		return managerImpl;
	}
	
	//无参构造方法
	public ManagerImpl(){}
	
	Scanner in=new Scanner(System.in);//获取键盘输入数据
	String inputStr=null;
	
	/*
	 * 存款方法的实现
	 * @param: inputNum :存入的金额数
	 * @return:
	 * */
	@Override
	public double deposit(double inputNum) {
		System.out.println("请输入存款金额：");
		inputNum=in.nextDouble();
			try {
				if(inputNum<=0){
					throw new InvalidDepositException("存款金额小于等于0！！！");
				}else{
					System.out.println("您输入的存款金额为："+inputNum);
					
					inputNum+=money.getMoney();
					System.out.println("您卡上的总金额为："+inputNum);
					money.setMoney(inputNum);
				}
			} catch (InvalidDepositException e) {
				System.out.println(e.getMessage());
			}
			return inputNum;
	}

	/*
	 * 取款方法的实现
	 * @param: outputNum :取出的金额数
	 * @return:
	 * */
	@Override
	public double withdrawals(double outputNum) {
		System.out.println("请输入取款金额：");
		outputNum=in.nextDouble();
		try {
			if((money.getMoney()-outputNum)<=0){
				throw new AccountOverException("余额不足，不能取款！！！");
			}else{
				System.out.println("您输入的取款金额为："+outputNum);
				outputNum=money.getMoney()-outputNum;
				System.out.println("您的卡上余额为："+outputNum);
				money.setMoney(outputNum);
			}
		} catch (AccountOverException e) {
			System.out.println(e.getMessage());
		}
		return outputNum;
	}
	
	/*
	 * 查询余额方法的实现
	 * @param: null
	 * @return:
	 * */
	@Override
	public double inqury() {
		System.out.println("您的余额为："+money.getMoney());
		return money.getMoney();
	}

	@Override
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	

}
