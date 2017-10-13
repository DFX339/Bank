package bank.com.dao;

import java.sql.SQLException;

import bank.com.bean.User;

/**
 * �ӿ�
 * ���������ҵ��Ĳ�������
 * ��ӵ�¼��ע��
 * 
 * @author DFX
 * @version 2.0 2017/07/27
 * 
 * */
public interface DaoInterface {
	
	public User login(User user) throws SQLException;//��¼���� 
	public boolean regist(User user);//ע�᷽��
	public double inqury(String ID);//��ѯ��� ID����ǰ�˺ŵ�ID  return���������
	public double deposit(double money,String id);//���  money :�����  return���������
	public double withdrawal(double money,String id);//ȡ��  money:ȡ����	return���������
	public double transfer(String ID,double money,String id);//ת�� ID��ת�˶���money:ת����Ŀ return���������
	
}
