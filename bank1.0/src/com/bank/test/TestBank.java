package com.bank.test;

import java.util.Scanner;

import com.bank.manager.ManagerImpl;
import com.bank.manager.ManagerInterface;

/**
 * ���й��ܲ�����
 * @Author DFX
 * @Version 1.0 2017/06/15
 * 
 * */
public class TestBank {
	
	public TestBank(){}
	
	/**
	 *�����Է���
	 * @param args
	 */
	public static void main(String[] args) {
		TestBank tb=new TestBank();//����TestBank���󣬶����з������в���
		tb.showFrame();//��ʾ�˵�
		tb.testBank();//���Թ��ܷ���
		
		
	}
	
	/**
	 * �˳�ϵͳ
	 * @param null
	 */
	public static void exits(){
		System.out.println("лл����ʹ�ã�6^-^6");
		System.exit(1);
	}
	
	
	/**
	 * �˵���ʾ
	 * @param null
	 */
	public void showFrame(){
		System.out.println("*-----------------------�밴����������Ĳ�����---------------------*");
		System.out.println("*-----------------------��ӭʹ������ϵͳ1.0------------------------*");
		System.out.println("*                           1.���                                                                                      *");
		System.out.println("*                           2.ȡ��                                                                                      *");
		System.out.println("*                           3.�鿴���                                                                            *");
		System.out.println("*                           4.�˳�ϵͳ                                                                            *");
		System.out.println("*-------------------------******^-^*****--------------------------*");
		
	}
	
	
	/**
	 * ������1.0�汾�Ĵ��뷽������
	 * @param null
	 * 
	 * */
	public void testBank(){
		
		ManagerInterface mi=ManagerImpl.getManagerImpl();//����ManagerImpl����������ManagerImpl�еķ���
		Scanner in=new Scanner(System.in);//������

		while(true){
			int input=in.nextInt();
			if(input==1){
				mi.deposit(1);//���ô���
			}else if(input==2){
				mi.withdrawals(1);//����ȡ���
			}else if(input==3){
				mi.inqury();//���ò鿴����
			}else if(input==4){
				TestBank.exits();//�˳�ϵͳ
			}else{
			System.out.println("������Ĳ����������������룡��");
		}
		
	 }
 }
	

}
