package cn.bank.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.bank.bean.UserBean;
import cn.bank.exception.BankException;
import cn.bank.util.HibernateFilter;

/**
 * 持久层接口方法实现类
 * @author Administrator
 *
 */
public class DaoImpl implements DaoInterface {
	
	Session session=null;
	
	/**
	 * 注册
	 * 1.查看当前用户名和密码是否已经被注册
	 * 2.已经被注册了就抛出异常
	 * 3.未被注册就直接注册
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
	 * 登录
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
				UserBean userBean=(UserBean) it.next();//取出从数据库中查出来的记录封装成UserBean对象
				return userBean;
			}
		}catch(Exception e){
			session.beginTransaction().rollback();
			throw new BankException("user.login.error");
		}
		return null;
		
	}

	
	/**
	 * 转账
	 * 1.判断对方账户是否存在，不存在就直接抛出异常
	 * 2.存在就取出对方余额
	 * 3.查出当前对象的余额
	 * 4.如果转账金额大于当前对象金额就抛出异常，余额不足
	 * 5.小于就完成转账，将当前用户的money-转账金额，对方用户的money+转账金额。
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
					
					objMoney=objMoney+transferMoney;//对方余额加上转账金额
					objUser.setMoney(objMoney);
					session.update(objUser);
					
					money=money-transferMoney;//当前用户减去转账金额
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
	 * 取款
	 * 1.得到当前账号的余额
	 * 2.比较余额和取款金额的大小
	 * 3.取款金额大于当前余额就抛出异常 余额不足
	 * 4.小于就完成取款，当前账户余额减去取款金额
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
					
				money=money-withdrawalMoney;//当前用户减去取款金额
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
	 * 存款
	 */
	public double deposit(int id, double depositMoney) {
		System.out.println("开始存款");
		session=HibernateFilter.getSession();
		double money=0;
		try{
			session.beginTransaction();
			UserBean user=(UserBean)session.get(UserBean.class,id);
			money=user.getMoney();
			System.out.println("当前余额为："+money);
			money=money+depositMoney;//当前用户加上存款金额
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
	 * 查询余额
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
