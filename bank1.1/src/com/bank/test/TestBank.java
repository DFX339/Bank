package com.bank.test;

import java.util.Scanner;

import com.bank.manager.ManagerImpl;
import com.bank.manager.ManagerInterface;

/**
 * ���й��ܲ�����
 * 
 * @Author DFX
 * @Version 1.1 2017/06/16
 * 
 * */
public class TestBank {

	public TestBank() {
	}

	/**
	 *�����Է���
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestBank tb = new TestBank();// ����TestBank�������������з������в���
		tb.showFrame1();// ��ʾ�˵�
		tb.beforeLogin();// ���Թ��ܷ���

	}

	/**
	 * ���˵���ʾ
	 * 
	 * @param null
	 */
	public void showFrame1() {
		System.out
				.println("*-----------------------�밴����������Ĳ�����---------------------*");
		System.out
				.println("*-----------------------��ӭʹ������ϵͳ1.1------------------------*");
		System.out
				.println("*                           1.ע��                                                                                      *");
		System.out
				.println("*                           2.��¼                                                                                      *");
		System.out
				.println("*                           3.�˳�ϵͳ                                                                            *");
		System.out
				.println("*-------------------------******^-^*****--------------------------*");

	}

	/**
	 * ��¼��Ĳ˵���ʾ
	 * 
	 * @param null
	 * 
	 * */
	public void showFrame2() {
		System.out
				.println("*-----------------------�밴����������Ĳ�����---------------------*");
		System.out
				.println("*-----------------------��ӭʹ������ϵͳ1.1------------------------*");
		System.out
				.println("*                           1.���                                                                                      *");
		System.out
				.println("*                           2.ȡ��                                                                                      *");
		System.out
				.println("*                           3.�鿴���                                                                            *");
		System.out
				.println("*                           4.�˳�ϵͳ                                                                            *");
		System.out
				.println("*-------------------------******^-^*****--------------------------*");

	}

	/**
	 * ������1.1�汾���û���¼ǰ�ķ�������
	 * 
	 * @param null
	 * 
	 * */
	public void beforeLogin() {

		ManagerInterface mi = ManagerImpl.getManagerImpl();// ����ManagerImpl����������ManagerImpl�еķ���
		Scanner in = new Scanner(System.in);// ��ȡ������������

		while (true) {
			int input = in.nextInt();
			if (input == 1) {
				mi.register("zhangsan", "123");// ����ע�᷽��
			} else if (input == 2) {
				mi.login("dfx", "123");// ���õ�¼����
				if (ManagerImpl.flag) {// ��¼�ɹ������ʾ���ܽ���
					showFrame2();// ��ʾ��¼��Ĳ˵�����
					afterLogin();// ���õ�¼��ķ���
				} else {
					System.out.println("���������룡����");
				}
			} else if (input == 3) {
				mi.exitSystem();// �����˳�ϵͳ����
			} else {
				System.out.println("������Ĳ����������������룡��");
			}

		}
	}

	/**
	 * ������1.1�汾���û���¼֮��ķ�������
	 * 
	 * @param null
	 * 
	 * */
	public void afterLogin() {

		ManagerInterface mi = ManagerImpl.getManagerImpl();// ����ManagerImpl����������ManagerImpl�еķ���
		Scanner in = new Scanner(System.in);// ������

		while (true) {
			int input = in.nextInt();
			if (input == 1) {
				mi.deposit(1);// ���ô���
			} else if (input == 2) {
				mi.withdrawals(1);// ����ȡ���
			} else if (input == 3) {
				mi.inqury();// ���ò鿴����
			} else if (input == 4) {
				mi.exitSystem();// �����˳�ϵͳ
			} else {
				System.out.println("������Ĳ����������������룡��");
			}

		}
	}

}
