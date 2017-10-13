package cn.bank.ssh.manager;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bank.ssh.bean.Log;
import cn.bank.ssh.bean.User;
import cn.bank.ssh.exception.BankException;
/**
 * ����5.0ҵ��ʵ���࣬ͨ��hibernate��Ϊ�־ò㣬�̳�HibernateDaoSupport
 * ֱ�ӵõ�HibernateTemplate(Session)��������ɾ�Ĳ����
 * @author Administrator
 * @version 5.0 2017/9/17
 */
public class BankManagerImpl extends HibernateDaoSupport implements BankManagerInterface {
	
	//����LogManagerInterface���͵����ԣ������ṩset����������spring������ע�룬�Զ�װ��
	private LogManagerInterface logManager;
	public void setLogManager(LogManagerInterface logManager){
		this.logManager=logManager;
	}

	/*
	 * ע��
	 * 1.�ж��û�ʹ���Ѿ����ڣ��Ѿ����ھ�ע��ʧ�ܣ�����false
	 * 2.�����ھ����ע�� ���� true
	 */
	public boolean regist(User user) {
		boolean flag=false;
		List record=null;
		try{
			record= this.getHibernateTemplate().find("from User user where user.username=? and user.password=?",
					new Object[]{user.getUsername(),user.getPassword()}) ;
		if(record.size() != 0){
			flag=false;
			throw new BankException("user.regist.error.exist",user.getUsername()+"-"+user.getPassword());
		}else{
			
			this.getHibernateTemplate().save(user);
			/**
			 * ����Log����������־
			 * �赽��־��Ϣ������ҵ���LogManagerImpl�ķ��������־�����
			 * ����set���ϣ�����־��ӵ�set������
			 * ��set������ӵ�user������
			 * ������ע����û���Ϣ�������ݿ�
			 * */
			Log log=new Log();
			log.setUserid(user.getId());
			log.setUsername(user.getUsername());
			log.setType("regist log");
			log.setContent(user.getUsername()+" has  finished registing");
			log.setOperateTime(new Date());
			logManager.addLog(log);
			flag=true;
		}
		
		}catch(Exception e){
			throw new BankException("user.regist.error",user.getUsername());
		}
		
		return flag;
	}
	
	/*
	 *��¼�����������־��¼��
	 *ֱ�Ӳ�ѯ���ݿ�����û�к��û���������ƥ��ļ�¼
	 *�еĻ��ͷ��ظü�¼���ɵĶ���
	 *û��ƥ��ļ�¼�Ļ����׳��쳣
	 */
	public User login(String username, String password) {
		List result=null;
		try{
			result= this.getHibernateTemplate().find("from User user where user.username=? and user.password=?",
					new Object[]{username,password}) ;
			System.out.println("��¼���"+username+"--"+result.size());
			if(result.size() != 0){
				User user=new User();
				for(int i=0;i<result.size();i++){
					user.setId(((User) result.get(i)).getId());
					user.setUsername(((User) result.get(i)).getUsername());
					user.setPassword(((User) result.get(i)).getPassword());
					user.setMoney(((User) result.get(i)).getMoney());
				}
				return user;
			}else{
				throw new BankException("user.login.error",username+"-"+password);
			}
		}catch(Exception e){
			throw new BankException("user.login.error",username);
		}
	}
	
	/*
	 * ���
	 * ����id�ҵ���ǰ�û������ݿ��м�¼,�õ����
	 * �������ϴ����
	 * ������־����
	 * 
	 */
	public double deposit(int id, double depositMoney) {
		double money=0;
		try{
			User user= (User) this.getHibernateTemplate().load(User.class,id);
			money=depositMoney+user.getMoney();
			/**
			 * ����Log����������־
			 * �赽��־��Ϣ������ҵ���LogManagerImpl�ķ��������־�����
			 * ����set���ϣ�����־��ӵ�set������
			 * ��set������ӵ�user������
			 * ����������û���Ϣ�������ݿ�
			 * */
			Log log=new Log();
			log.setUserid(id);
			log.setUsername(user.getUsername());
			log.setType("deposit log");
			log.setContent(user.getUsername()+" is depositing"+depositMoney+"YUAN");
			log.setOperateTime(new Date());
			logManager.addLog(log);
			
			
			user.setMoney(money);
			this.getHibernateTemplate().update(user);
			return money;
			
		}catch(Exception e){
			throw new BankException("user.deposit.error");
		}
	}
	
	/*
	 *ȡ��
	 *�Ȳ�ѯ��ǰ���
	 *�ж�����ȡ����Ĵ�С
	 *С�ھ��׳��쳣
	 *���ھ����ȡ�� 
	 */
	public double withdrawal(int id, double withdrawalMoney) {
		double money=0;
		try{
			User user= (User) this.getHibernateTemplate().load(User.class,id);
			
			if(user.getMoney()<withdrawalMoney){
				throw new BankException("user.withdrawal.error.num",withdrawalMoney);
			}else{
				money=user.getMoney()-withdrawalMoney;
				/**
				 * ����Log����������־
				 * �赽��־��Ϣ������ҵ���LogManagerImpl�ķ��������־�����
				 * ����set���ϣ�����־��ӵ�set������
				 * ��set������ӵ�user������
				 * ����������û���Ϣ�������ݿ�
				 * */
				Log log=new Log();
				log.setUserid(id);
				log.setUsername(user.getUsername());
				log.setType("withdrawal log");
				log.setContent(user.getUsername()+" is withdrawalding "+withdrawalMoney+"YUAN");
				log.setOperateTime(new Date());
				logManager.addLog(log);
				
				
				user.setMoney(money);
				this.getHibernateTemplate().update(user);
				return money;
			}	
		}catch(Exception e){
			throw new BankException("user.withdrawal.error");
		}
	}
	
	/**
	 * ת��
	 * 1.�鿴ת���˺��Ƿ���ڣ������ھ��׳��쳣
	 * 2.���ھ�ȡ���Է������ 
	 * 3.ȡ����ǰ�˺ŵ����жϺ�ת�˽��Ĵ�С��С�ھ��׳��쳣
	 * 4.���ھ����ת�ˣ���ǰ�˺Ž���ȥת�˽��Է��˺��������ת�˽��
	 */
	public double transfer(int id, double transferMoney, int transferId) {
		double money=0;
		try{
			//����ʹ��get����Ϊ���ʹ��load������transferId������ʱ��ֱ���׳��쳣������get���ᣬget�����᷵��null
			User objUser= (User) this.getHibernateTemplate().get(User.class,transferId);
			if(objUser == null){
				
				throw new BankException("user.transfer.objID.error",transferId);
			}else{
				User user= (User) this.getHibernateTemplate().load(User.class,id);
				if(user.getMoney()<transferMoney){
					throw new BankException("user.transfer.leftMoney.error",user.getUsername());
				}else{
					
					double 	objMoney=objUser.getMoney()+transferMoney;
					objUser.setMoney(objMoney);
					this.getHibernateTemplate().update(objUser);
					
					money=user.getMoney()-transferMoney;
					/**
					 * ����Log����������־
					 * �赽��־��Ϣ������ҵ���LogManagerImpl�ķ��������־�����
					 * ����set���ϣ�����־��ӵ�set������
					 * ��set������ӵ�user������
					 * ����������û���Ϣ�������ݿ�
					 * */
					Log log=new Log();
					log.setUserid(id);
					log.setUsername(user.getUsername());
					log.setType("transfer log");
					log.setContent(user.getUsername()+" is transfering "
							+transferMoney+"YUAN��" +" to "+objUser.getId()+objUser.getUsername());
					log.setOperateTime(new Date());
					logManager.addLog(log);
					
					user.setMoney(money);
					this.getHibernateTemplate().update(user);
					
					return money;
				}
			}	
		}catch(Exception e){
			throw new BankException("user.transfer.error");
		}
	}

	public double find(int id) {
		try{
			User user=(User)this.getHibernateTemplate().load(User.class,id);
			double money=user.getMoney();
			return money;
		}catch(Exception e){
			throw new BankException("user.inqury.error");
		}
	}

}
