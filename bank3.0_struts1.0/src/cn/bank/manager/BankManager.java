package cn.bank.manager;

import cn.bank.bean.User;
import cn.bank.dao.BankDao;
import cn.bank.exception.BankException;
import cn.bank.factory.DaoFactory;

/**
 * struts1.0�汾������Ŀ��ҵ����(����+ͬ��)
 * ��ҵ����׳���ʽ�쳣��Ϣ new BankException
 * @author DFX
 * @VERSION 3.0 2017��8��14
 * */
public class BankManager {
	
	private static  BankManager instance=null;
	private BankDao bankDao=null;
	
	private BankManager(){
		DaoFactory daoFactory=DaoFactory.getInstance();
		bankDao=daoFactory.getDaoImpl();//ͨ�����������õ�ʵ����
	}
	
	public synchronized static BankManager getInstance(){
		if(instance==null){
			instance=new BankManager();
		}
		return instance;
	}
	
	/**
	 * ��¼
	 * @param user
	 * @return
	 */
	public User login(String username, String password){
		User user=User.getInstance();
		user.setUsername(username);
		user.setPassword(password);
		user=bankDao.login(user);
		return user;
	}
	
	/**
	 * ע��
	 * @param user
	 * @return
	 */
	public boolean regist(User user){
		boolean flag=bankDao.regist(user);
		return flag;
	}
	
	/**
	 * ���
	 * @param num
	 * @return user
	 */
	public User deposit(String num,int id){
		String regix="[0-9]{1,6}";//�������ʽ�ĸ�ʽΪ ����0-999999
		//����û�����Ĵ����Ϊnull�����׳��쳣
		if(num==null){throw new BankException("user.deposit.error");}
		
		//��������ݲ�Ϊ0 �Ͷ���������ݽ��и�ʽ�ж�
		if(num.matches(regix)){
			double numMoney=new Double(num);
			return bankDao.deposite(numMoney,id);
		}else{
			//��ʽ������׳��쳣
			throw new BankException("user.deposit.error.num",num);
		}
	}
	
	/**
	 * ȡ��
	 * @param id,num
	 * @return user
	 */
	public User withdrawal(String num,int id){
		String regix="[0-9]{1,6}";//�������ʽ�ĸ�ʽΪ ����0-999999
		//����û������ȡ����Ϊnull �����׳��쳣
		if(num==null){throw new BankException("user.withdrawal.error.num",num);}
		if(num.matches(regix)){
			double numMoney=new Double(num);
			return bankDao.withdrawal(numMoney,id);
		}else{
			//���û������ȡ�����ʽ����ʱ���׳��쳣
			throw new BankException("user.withdrawal.num.input.error",num);
		}
	}
	
	/**
	 * ת��
	 * @param id,num
	 * @return user
	 */
	public User transfer(String id,String num,int myId){
		
		User user=User.getInstance();
		if(id==null){//�ж��û������ID �Ƿ�Ϊnull�����Ϊnull���׳��쳣
			throw new BankException("user.transfer.objID.error",id);
		}
		//�ж��û������ת�˽���Ƿ�Ϊnull��Ϊnull���׳��쳣
		if(num==null){
			throw new BankException("user.transfer.error");
		}
		
		String regix="[0-9]{1,6}";//�����������ʽ��֤����
		if(id.matches(regix)){
			
			int id1=new Integer(id);
			if(num.matches(regix)){
				double numMoney=new Double(num);
				user = bankDao.transfer(id1,numMoney,myId);
			}else{
				//ת�˽�����Ͳ�ƥ��ʱ���׳��쳣
				throw new BankException("user.transfer.num.input.error",num);
			}
		}else{
			//ת��ID���Ͳ�ƥ��ʱ���׳��쳣
			throw new BankException("user.transfer.id.input.error",id);
		}
		return user;
	}
	
	/**
	 * ��ѯ���
	 * @param 
	 * @return user
	 */
	public User inqury(int id){
		return bankDao.inqury(id);
	}
	
	
}