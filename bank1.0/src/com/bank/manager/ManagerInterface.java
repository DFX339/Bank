package com.bank.manager;

import com.bank.model.Money;

/**
 * ���幦�ܹ淶�Ľӿ�
 * @Author DFX
 * @version 1.0 2017/06/15
 * */
public interface ManagerInterface {
	
	public void register(String username,String password);//ע��
	public void login(String username,String password);//��¼
	public double deposit(double moneyNum);//���
	public double withdrawals(double moneyNum);//ȡ��
	public double inqury();//��ѯ
	
}
