package cn.bank.service;

import cn.bank.bean.UserBean;
import cn.bank.dao.DaoImpl;
import cn.bank.dao.DaoInterface;
import cn.bank.exception.BankException;
/**
 * ҵ�񷽷�������
 * @author Administrator
 * @version 4.0 2017/9/10
 */
public class BankService {
	
	DaoImpl daoImpl=new DaoImpl();
	
	//����+ͬ��
	private static BankService instance=null;
	private BankService(){}
	public static synchronized BankService getInstance(){
		if(instance==null){
			instance=new BankService();
		}
		return instance;
	}
	
	/**
	 * ��¼
	 * @param name �û���
	 * @param password ����
	 * @return ��¼�Ķ���
	 */
	public UserBean login(String name,String password){
		return daoImpl.login(name, password);
	}
	
	/**
	 * ע��
	 * @param user ע�����
	 * @return
	 */
	public  boolean regist(UserBean user){
		System.out.println("�����ð� regist");
		return daoImpl.regist(user);
	}
	
	/**
	 * ���
	 * @param id ��ǰ�����id 
	 * @param depositMoney �����
	 * @return 
	 */
	public  double deposit(int id,String depositMoney){
		String regix="[0-9]{1,6}";//������ʽ�ĸ�ʽΪ ����0-999999
		//����û�����Ĵ����Ϊnull�����׳��쳣
		if(depositMoney==null){throw new BankException("user.deposit.error");}
		
		//��������ݲ�Ϊ0 �Ͷ���������ݽ��и�ʽ�ж�
		if(depositMoney.matches(regix)){
			double numMoney=new Double(depositMoney);
			return daoImpl.deposit(id,numMoney);
		}else{
			//��ʽ������׳��쳣
			throw new BankException("user.deposit.error.num",depositMoney);
		}
	}
	
	/**
	 * ȡ��
	 * @param id ��ǰ�����id 
	 * @param depositMoney �����
	 * @return 
	 */
	public  double withdrawal(int id,String withdrawalMoney){
		String regix="[0-9]{1,6}";//������ʽ�ĸ�ʽΪ ����0-999999
		//����û������ȡ����Ϊnull �����׳��쳣
		if(withdrawalMoney==null){throw new BankException("user.withdrawal.error.num",withdrawalMoney);}
		if(withdrawalMoney.matches(regix)){
			double numMoney=new Double(withdrawalMoney);
			return daoImpl.withdrawal(id,numMoney);
		}else{
			//���û������ȡ�����ʽ����ʱ���׳��쳣
			throw new BankException("user.withdrawal.num.input.error",withdrawalMoney);
		}
	}
	
	/**
	 * ת��
	 * @param id ��ǰ�����id
	 * @param transferMoney ת�˽��
	 * @param transferId ת�˶����id
	 * @return
	 */
	public  double transfer(int id,String transferMoney,String transferId){
		
		if(transferId==null){//�ж��û������ID �Ƿ�Ϊnull�����Ϊnull���׳��쳣
			throw new BankException("user.transfer.objID.error",transferId);
		}
		//�ж��û������ת�˽���Ƿ�Ϊnull��Ϊnull���׳��쳣
		if(transferMoney==null){
			throw new BankException("user.transfer.error");
		}
		
		String regex="[0-9]{1,6}";//����������ʽ��֤����
		if(transferId.matches(regex)){
			
			int id1=new Integer(transferId);
			if(transferMoney.matches(regex)){
				double numMoney=new Double(transferMoney);
				return daoImpl.transfer(id,numMoney,id1);
			}else{
				//ת�˽�����Ͳ�ƥ��ʱ���׳��쳣
				throw new BankException("user.transfer.num.input.error",transferMoney);
			}
		}else{
			//ת��ID���Ͳ�ƥ��ʱ���׳��쳣
			throw new BankException("user.transfer.id.input.error",transferId);
		}
		
		
		
	}
	
	/**
	 * ��ѯ���
	 * @param id ��ǰ�����id
	 * @return
	 */
	public double inqury(int id){
		return daoImpl.inqury(id);
	}
	
}
