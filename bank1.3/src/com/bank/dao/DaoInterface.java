package com.bank.dao;
/**
 * Dao�㶨�幦�ܹ淶�Ľӿ�
 * @Author DFX
 * @version 1.3 2017/07/18
 * */
public interface DaoInterface {
	
	public void register(String username,String password);//ע��
	public boolean login(String username,String password);//��¼
	public double deposit(double moneyNum);//���
	public double withdrawals(double moneyNum);//ȡ��
	public double inqury();//��ѯ
	public void exitSystem();//�˳�ϵͳ
	public void transfer();//ת��
	
}
