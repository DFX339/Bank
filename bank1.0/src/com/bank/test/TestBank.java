package com.bank.test;

import java.util.Scanner;

import com.bank.manager.ManagerImpl;
import com.bank.manager.ManagerInterface;

/**
 * 银行功能测试类
 * @Author DFX
 * @Version 1.0 2017/06/15
 * 
 * */
public class TestBank {
	
	public TestBank(){}
	
	/**
	 *主测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		TestBank tb=new TestBank();//创建TestBank对象，对所有方法进行测试
		tb.showFrame();//显示菜单
		tb.testBank();//测试功能方法
		
		
	}
	
	/**
	 * 退出系统
	 * @param null
	 */
	public static void exits(){
		System.out.println("谢谢您的使用！6^-^6");
		System.exit(1);
	}
	
	
	/**
	 * 菜单显示
	 * @param null
	 */
	public void showFrame(){
		System.out.println("*-----------------------请按标号输入您的操作：---------------------*");
		System.out.println("*-----------------------欢迎使用银行系统1.0------------------------*");
		System.out.println("*                           1.存款                                                                                      *");
		System.out.println("*                           2.取款                                                                                      *");
		System.out.println("*                           3.查看余额                                                                            *");
		System.out.println("*                           4.退出系统                                                                            *");
		System.out.println("*-------------------------******^-^*****--------------------------*");
		
	}
	
	
	/**
	 * 对银行1.0版本的代码方法调用
	 * @param null
	 * 
	 * */
	public void testBank(){
		
		ManagerInterface mi=ManagerImpl.getManagerImpl();//创建ManagerImpl对象来调用ManagerImpl中的方法
		Scanner in=new Scanner(System.in);//输入流

		while(true){
			int input=in.nextInt();
			if(input==1){
				mi.deposit(1);//调用存款方法
			}else if(input==2){
				mi.withdrawals(1);//调用取款方法
			}else if(input==3){
				mi.inqury();//调用查看余额方法
			}else if(input==4){
				TestBank.exits();//退出系统
			}else{
			System.out.println("您输入的操作有误，请重新输入！！");
		}
		
	 }
 }
	

}
