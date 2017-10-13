package com.bank.manager;

import java.util.Scanner;

import com.bank.model.Money;
import com.bank.utils.AccountOverException;
import com.bank.utils.InvalidDepositException;

/**
 * �ӿڵ�ʵ����(�������ģʽ)
 * @Author DFX
 * @version 1.0 2017/06/15
 * */
public class ManagerImpl implements ManagerInterface {
	
	Money money=Money.getMoneyBean();//����Money����
	
	//�������ģʽ
	private static ManagerImpl managerImpl=null;
	public static ManagerImpl getManagerImpl(){
		if(managerImpl==null){
			managerImpl=new ManagerImpl();
		}
		return managerImpl;
	}
	
	//�޲ι��췽��
	public ManagerImpl(){}
	
	Scanner in=new Scanner(System.in);//��ȡ������������
	String inputStr=null;
	
	/*
	 * ������ʵ��
	 * @param: inputNum :����Ľ����
	 * @return:
	 * */
	@Override
	public double deposit(double inputNum) {
		System.out.println("���������");
		inputNum=in.nextDouble();
			try {
				if(inputNum<=0){
					throw new InvalidDepositException("�����С�ڵ���0������");
				}else{
					System.out.println("������Ĵ����Ϊ��"+inputNum);
					
					inputNum+=money.getMoney();
					System.out.println("�����ϵ��ܽ��Ϊ��"+inputNum);
					money.setMoney(inputNum);
				}
			} catch (InvalidDepositException e) {
				System.out.println(e.getMessage());
			}
			return inputNum;
	}

	/*
	 * ȡ�����ʵ��
	 * @param: outputNum :ȡ���Ľ����
	 * @return:
	 * */
	@Override
	public double withdrawals(double outputNum) {
		System.out.println("������ȡ���");
		outputNum=in.nextDouble();
		try {
			if((money.getMoney()-outputNum)<=0){
				throw new AccountOverException("���㣬����ȡ�����");
			}else{
				System.out.println("�������ȡ����Ϊ��"+outputNum);
				outputNum=money.getMoney()-outputNum;
				System.out.println("���Ŀ������Ϊ��"+outputNum);
				money.setMoney(outputNum);
			}
		} catch (AccountOverException e) {
			System.out.println(e.getMessage());
		}
		return outputNum;
	}
	
	/*
	 * ��ѯ������ʵ��
	 * @param: null
	 * @return:
	 * */
	@Override
	public double inqury() {
		System.out.println("�������Ϊ��"+money.getMoney());
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
