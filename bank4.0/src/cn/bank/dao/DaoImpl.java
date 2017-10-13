package cn.bank.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.bank.bean.UserBean;
import cn.bank.exception.BankException;
import cn.bank.util.HibernateFilter;

/**
 * �־ò�ӿڷ���ʵ����
 * @author Administrator
 *
 */
public class DaoImpl implements DaoInterface {
	
	Session session=null;
	
	/**
	 * ע��
	 * 1.�鿴��ǰ�û����������Ƿ��Ѿ���ע��
	 * 2.�Ѿ���ע���˾��׳��쳣
	 * 3.δ��ע���ֱ��ע��
	 */
	public boolean regist(UserBean user) {
		boolean flag=false;
		session=HibernateFilter.getSession();
		session.beginTransaction();
		try{
			System.out.println("regist:"+user.getUsername());
			List list=session.createQuery("from UserBean user where" +
					" user.username like ? and user.password like ?")
					.setParameter(0,user.getUsername())
					.setParameter(1,user.getPassword())
					.list();
			if(list.size()>0){
				throw new BankException("user.regist.error.exist",user.getUsername());
			}
			session.save(user);
			session.getTransaction().commit();
			flag = true;
		}catch(Exception e){
			session.beginTransaction().rollback();
			throw new BankException("user.regist.error");
		}
		
		return flag;
	}

	/**
	 * ��¼
	 */
	public UserBean login(String name, String password) {
		try{
			session=HibernateFilter.getSession();
			session.beginTransaction();
			List list=session.createQuery("from UserBean user where" +
					" user.username like ? and user.password like ?")
					.setParameter(0,name)
					.setParameter(1,password)
					.list();
			if(list.size()<0){
				throw new BankException("user.login.error",name+password);
			}
			Iterator it=list.iterator();
			while(it.hasNext()){
				UserBean userBean=(UserBean) it.next();//ȡ�������ݿ��в�����ļ�¼��װ��UserBean����
				return userBean;
			}
		}catch(Exception e){
			session.beginTransaction().rollback();
			throw new BankException("user.login.error");
		}
		return null;
		
	}

	
	/**
	 * ת��
	 * 1.�ж϶Է��˻��Ƿ���ڣ������ھ�ֱ���׳��쳣
	 * 2.���ھ�ȡ���Է����
	 * 3.�����ǰ��������
	 * 4.���ת�˽����ڵ�ǰ��������׳��쳣������
	 * 5.С�ھ����ת�ˣ�����ǰ�û���money-ת�˽��Է��û���money+ת�˽�
	 */
	public double transfer(int id, double transferMoney, int transferId) {
		session=HibernateFilter.getSession();
		double money=0;
		try{
			session.beginTransaction();
			UserBean objUser=(UserBean)session.get(UserBean.class,transferId);
			if(objUser==null){
				throw new BankException("user.transfer.objID.error",transferId+"");
			}else{
				double objMoney=objUser.getMoney();
				
				UserBean user=(UserBean)session.get(UserBean.class,id);
				money=user.getMoney();
				
				if(transferMoney>money){
					throw new BankException("user.transfer.leftMoney.error",transferMoney+"");
				}else{
					
					objMoney=objMoney+transferMoney;//�Է�������ת�˽��
					objUser.setMoney(objMoney);
					session.update(objUser);
					
					money=money-transferMoney;//��ǰ�û���ȥת�˽��
					user.setMoney(money);
					session.update(user);
					session.beginTransaction().commit();
				}
			}
			
		}catch(Exception e ){
			session.beginTransaction().rollback();
			throw new BankException("user.transfer.error");
		}
		return money;
	}
	
	/**
	 * ȡ��
	 * 1.�õ���ǰ�˺ŵ����
	 * 2.�Ƚ�����ȡ����Ĵ�С
	 * 3.ȡ������ڵ�ǰ�����׳��쳣 ����
	 * 4.С�ھ����ȡ���ǰ�˻�����ȥȡ����
	 */
	public double withdrawal(int id, double withdrawalMoney) {
		session=HibernateFilter.getSession();
		double money=0;
		try{
			session.beginTransaction();
			UserBean user=(UserBean)session.get(UserBean.class,id);
			money=user.getMoney();
			if(withdrawalMoney>money){
				throw new BankException("user.withdrawal.error.num",withdrawalMoney+"");
			}else{
					
				money=money-withdrawalMoney;//��ǰ�û���ȥȡ����
				user.setMoney(money);
				session.update(user);
				session.beginTransaction().commit();
			}
			
		}catch(Exception e ){
			session.beginTransaction().rollback();
			throw new BankException("user.withdrawal.error");
		}
		return money;
	}
	
	/**
	 * ���
	 */
	public double deposit(int id, double depositMoney) {
		System.out.println("��ʼ���");
		session=HibernateFilter.getSession();
		double money=0;
		try{
			session.beginTransaction();
			UserBean user=(UserBean)session.get(UserBean.class,id);
			money=user.getMoney();
			System.out.println("��ǰ���Ϊ��"+money);
			money=money+depositMoney;//��ǰ�û����ϴ����
			user.setMoney(money);
			session.update(user);
			session.beginTransaction().commit();
			
		}catch(Exception e ){
			session.beginTransaction().rollback();
			throw new BankException("user.deposit.error");
		}
		return money;
	}

	/**
	 * ��ѯ���
	 */
	public double inqury(int id) {
		
		session=HibernateFilter.getSession();
		double money=0;
		try{
			session.beginTransaction();
			UserBean user=(UserBean)session.get(UserBean.class,id);
			money=user.getMoney();
			session.beginTransaction().commit();
		}catch(Exception e ){
			session.beginTransaction().rollback();
			throw new BankException("user.inqury.error");
		}
		return money;
	}
}
