package cn.bank.ssh.manager;

import cn.bank.ssh.bean.User;

/**
 * ����5.0��ҵ���෽������--�ӿ�
 * @author Administrator
 * @version bank5.0 2017/9/17
 */
public interface BankManagerInterface {
	
	public boolean regist(User user);//ע��
	public User login(String username,String password);//��¼
	public double deposit(int id,double depositMoney);//���
	public double withdrawal(int id,double withdrawalMoney);//ȡ��
	public double transfer(int id,double transferMoney, int transferId);//ת��
	public double find(int id);//��ѯ���
}
