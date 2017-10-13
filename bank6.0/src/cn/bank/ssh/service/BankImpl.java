package cn.bank.ssh.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.bank.ssh.bean.Log;
import cn.bank.ssh.bean.User;
import cn.bank.ssh.exception.BankException;
import cn.bank.ssh.exception.LoginException;
import cn.bank.ssh.exception.RegistException;
/**
 * ���нӿ�ʵ����
 * @author Administrator
 *	@version 6.0 2017/9/21
 */
public class BankImpl implements BankService{
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Resource(name="logImpl")
	private LogImpl logImpl;
	
	/*
	 *��¼�����������־��¼��
	 *ֱ�Ӳ�ѯ���ݿ�����û�к��û���������ƥ��ļ�¼
	 *�еĻ��ͷ��ظü�¼���ɵĶ���
	 *û��ƥ��ļ�¼�Ļ����׳��쳣
	 */
	public User login(String username, String password) {
		List listLogin=null;
		listLogin=hibernateTemplate.find("from User user where user.username=? and user.password=?",
				new Object[]{username,password});
		if(listLogin.size()== 0){
			throw new LoginException("�û��������벻ƥ�䣬����������"+username+":"+password);
		}else{
			try{
				User user = (User) listLogin.get(0);
				return user;
				
			}catch(Exception e){
				throw new LoginException("��¼ʧ��");
			}
		}
	}
	
	/*
	 * ע��
	 * 1.�ж��û�ʹ���Ѿ����ڣ��Ѿ����ھ�ע��ʧ�ܣ�����false
	 * 2.�����ھ����ע�� ���� true
	 */
	public boolean regist(User user) {
		boolean flag=false;
		List listRegister=null;
		listRegister=hibernateTemplate.find("from User user where user.username=? and user.password=?",
				new Object[]{user.getUsername(),user.getPassword()});
		if(listRegister.size()!= 0){
			throw new RegistException("�û����������Ѵ��ڣ�����������"+user.getUsername()+":"+user.getPassword());
		}else{
			try{
				hibernateTemplate.save(user);
				
				/**
				 * ������־�����趨��־��Ϣ���������ݿ�
				 */
				Log log=new Log();
				log.setUserid(user.getId());
				log.setUsername(user.getUsername());
				log.setLogType("Regist Log");
				log.setLogContent(user.getUsername()+"is registing");
				log.setLogTime(new Date());
				
				logImpl.addLog(log);
				flag=true;
			}catch(Exception e){
				throw new RegistException("ע��ʧ��");
			}
		}
		return flag;
	}
	
	/*
	 * ���
	 * ����id�ҵ���ǰ�û������ݿ��м�¼,�õ����
	 * �������ϴ����
	 * ������־����
	 */
	public double deposit(int id, double depositMoney) {
		User user=null;
		user=hibernateTemplate.load(User.class,id);
		double money=user.getMoney();//�õ���ǰ��������
			try{
				money=money+depositMoney;
				user.setMoney(money);
				hibernateTemplate.update(user);
				
				/**
				 * ������־�����趨��־��Ϣ���������ݿ�
				 */
				Log log=new Log();
				log.setUserid(user.getId());
				log.setUsername(user.getUsername());
				log.setLogType("Deposit Log");
				log.setLogContent(user.getUsername()+"is depositing "+depositMoney +" YUAN");
				log.setLogTime(new Date());
				
				logImpl.addLog(log);
				
				return money;
			}catch(Exception e){
				throw new BankException("���ʧ��");
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
		User user=null;
		user=hibernateTemplate.load(User.class,id);
		double money=user.getMoney();
		
		if(money<withdrawalMoney){
			throw new BankException("�˻�����");
		}
			try{
				money=money-withdrawalMoney;
				user.setMoney(money);
				hibernateTemplate.update(user);
				
				/**
				 * ������־�����趨��־��Ϣ���������ݿ�
				 */
				Log log=new Log();
				log.setUserid(user.getId());
				log.setUsername(user.getUsername());
				log.setLogType("withdrawal Log");
				log.setLogContent(user.getUsername()+"is withdrawaling "+withdrawalMoney+" YUAN");
				log.setLogTime(new Date());
				
				logImpl.addLog(log);
				
				return money;
			}catch(Exception e){
				throw new BankException("ȡ��ʧ��");
			}
	}
	
	/*
	 * ת��
	 * 1.�鿴ת���˺��Ƿ���ڣ������ھ��׳��쳣
	 * 2.���ھ�ȡ���Է������ 
	 * 3.ȡ����ǰ�˺ŵ����жϺ�ת�˽��Ĵ�С��С�ھ��׳��쳣
	 * 4.���ھ����ת�ˣ���ǰ�˺Ž���ȥת�˽��Է��˺��������ת�˽��
	 */
	public double transfer(int id, double transferMoney, int transferId) {
		User user=null;
		User objUser=null;
		objUser=hibernateTemplate.get(User.class,transferId);
		
		if(objUser == null){
			throw new BankException("�˺�["+transferId+"]������,����������");
		}
		double objMoney=objUser.getMoney();//��ѯ���Է��������ڴ洢
		
		user=hibernateTemplate.load(User.class, id);//�����ǰ��¼�������Ϣ
		double money=user.getMoney();//�õ���ǰ��������
		
		if(money<transferMoney){
			throw new BankException("�˻�����");
		}
			try{
				//����ǰ����������ٲ��Ҵ������ݿ�
				money=money-transferMoney;
				user.setMoney(money);
				hibernateTemplate.update(user);
				
				//���Է��˺ŵ�Լ���Ӳ��Ҵ������ݿ�
				objMoney = objMoney+transferMoney;
				objUser.setMoney(objMoney);
				hibernateTemplate.update(objUser);
				
				/**
				 * ������־�����趨��־��Ϣ���������ݿ�
				 */
				Log log=new Log();
				log.setUserid(user.getId());
				log.setUsername(user.getUsername());
				log.setLogType("Transfer Log");
				log.setLogContent(user.getUsername()+"is transfering "+transferMoney+" YUAN to" +transferId);
				log.setLogTime(new Date());
				
				logImpl.addLog(log);
				
				return money;
			}catch(Exception e){
				throw new BankException("ת��ʧ��");
			}
	}

	
	/**
	 * ��ѯ���
	 */
	public double inqury(int id) {
		try{
			User user=hibernateTemplate.get(User.class,id);
			System.out.println("ҵ����ѯ���"+user.getMoney());
			return user.getMoney();
		}catch(Exception e){
			throw new BankException("����ѯʧ��");
		}
	}

}
