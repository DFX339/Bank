package cn.bank.dao;

import cn.bank.bean.User;

/**
 * ������Ŀ�Ľӿڷ���
 * @author DFX
 * @version 3.0  2017��8��14
 * */
public interface BankDao {
	
	public  User  login(User user);//��¼
	public  boolean regist(User user);//ע��
	public User transfer(int id,double num,int myId);//ת��
	public User deposite(double num,int id);//���
	public  User inqury(int id);//��ѯ���
	public User withdrawal(double num,int id);//ȡ��
}
