package com.bank.test;

import java.util.Scanner;

import com.bank.manager.ManagerImpl;
import com.bank.manager.ManagerInterface;

/**
 * 银行功能测试类
 * 
 * @Author DFX
 * @Version 1.1 2017/06/16
 * 
 * */
public class TestBank {

	public TestBank() {
	}

	/**
	 *主测试方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestBank tb = new TestBank();// 创建TestBank对象，用来对所有方法进行测试
		tb.showFrame1();// 显示菜单
		tb.beforeLogin();// 测试功能方法

	}

	/**
	 * 主菜单显示
	 * 
	 * @param null
	 */
	public void showFrame1() {
		System.out
				.println("*-----------------------请按标号输入您的操作：---------------------*");
		System.out
				.println("*-----------------------欢迎使用银行系统1.1------------------------*");
		System.out
				.println("*                           1.注册                                                                                      *");
		System.out
				.println("*                           2.登录                                                                                      *");
		System.out
				.println("*                           3.退出系统                                                                            *");
		System.out
				.println("*-------------------------******^-^*****--------------------------*");

	}

	/**
	 * 登录后的菜单显示
	 * 
	 * @param null
	 * 
	 * */
	public void showFrame2() {
		System.out
				.println("*-----------------------请按标号输入您的操作：---------------------*");
		System.out
				.println("*-----------------------欢迎使用银行系统1.1------------------------*");
		System.out
				.println("*                           1.存款                                                                                      *");
		System.out
				.println("*                           2.取款                                                                                      *");
		System.out
				.println("*                           3.查看余额                                                                            *");
		System.out
				.println("*                           4.退出系统                                                                            *");
		System.out
				.println("*-------------------------******^-^*****--------------------------*");

	}

	/**
	 * 对银行1.1版本的用户登录前的方法调用
	 * 
	 * @param null
	 * 
	 * */
	public void beforeLogin() {

		ManagerInterface mi = ManagerImpl.getManagerImpl();// 创建ManagerImpl对象来调用ManagerImpl中的方法
		Scanner in = new Scanner(System.in);// 获取键盘输入数据

		while (true) {
			int input = in.nextInt();
			if (input == 1) {
				mi.register("zhangsan", "123");// 调用注册方法
			} else if (input == 2) {
				mi.login("dfx", "123");// 调用登录方法
				if (ManagerImpl.flag) {// 登录成功后才显示功能界面
					showFrame2();// 显示登录后的菜单界面
					afterLogin();// 调用登录后的方法
				} else {
					System.out.println("请重新输入！！！");
				}
			} else if (input == 3) {
				mi.exitSystem();// 调用退出系统方法
			} else {
				System.out.println("您输入的操作有误，请重新输入！！");
			}

		}
	}

	/**
	 * 对银行1.1版本的用户登录之后的方法调用
	 * 
	 * @param null
	 * 
	 * */
	public void afterLogin() {

		ManagerInterface mi = ManagerImpl.getManagerImpl();// 创建ManagerImpl对象来调用ManagerImpl中的方法
		Scanner in = new Scanner(System.in);// 输入流

		while (true) {
			int input = in.nextInt();
			if (input == 1) {
				mi.deposit(1);// 调用存款方法
			} else if (input == 2) {
				mi.withdrawals(1);// 调用取款方法
			} else if (input == 3) {
				mi.inqury();// 调用查看余额方法
			} else if (input == 4) {
				mi.exitSystem();// 调用退出系统
			} else {
				System.out.println("您输入的操作有误，请重新输入！！");
			}

		}
	}

}
