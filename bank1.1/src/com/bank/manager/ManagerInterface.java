package com.bank.manager;

/**
 * ���幦�ܹ淶�Ľӿ�
 * @Author DFX
 * @version 1.1 2017/06/16
 * */
public interface ManagerInterface {
	
	public void register(String username,String password);//ע��
	public boolean login(String username,String password);//��¼
	public double deposit(double moneyNum);//���
	public double withdrawals(double moneyNum);//ȡ��
	public double inqury();//��ѯ
	public void exitSystem();//�˳�ϵͳ
	
	
}