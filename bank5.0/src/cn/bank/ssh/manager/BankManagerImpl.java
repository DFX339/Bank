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
 * 银行5.0业务实现类，通过hibernate作为持久层，继承HibernateDaoSupport
 * 直接得到HibernateTemplate(Session)，进行增删改查操作
 * @author Administrator
 * @version 5.0 2017/9/17
 */
public class BankManagerImpl extends HibernateDaoSupport implements BankManagerInterface {
	
	//定义LogManagerInterface类型的属性，并且提供set方法，用于spring的依赖注入，自动装配
	private LogManagerInterface logManager;
	public void setLogManager(LogManagerInterface logManager){
		this.logManager=logManager;
	}

	/*
	 * 注册
	 * 1.判断用户使用已经存在，已经存在就注册失败，返回false
	 * 2.不存在就完成注册 返回 true
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
			 * 创建Log对象生成日志
			 * 设到日志信息，调用业务层LogManagerImpl的方法完成日志的填充
			 * 创建set集合，将日志添加到set集合中
			 * 将set集合添加到user对象中
			 * 将请求注册的用户信息存入数据库
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
	 *登录，（不添加日志记录）
	 *直接查询数据库中有没有和用户名和密码匹配的记录
	 *有的话就返回该记录生成的对象，
	 *没有匹配的记录的话就抛出异常
	 */
	public User login(String username, String password) {
		List result=null;
		try{
			result= this.getHibernateTemplate().find("from User user where user.username=? and user.password=?",
					new Object[]{username,password}) ;
			System.out.println("登录结果"+username+"--"+result.size());
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
	 * 存款
	 * 根据id找到当前用户在数据库中记录,拿到余额
	 * 将余额加上存款金额
	 * 创建日志对象
	 * 
	 */
	public double deposit(int id, double depositMoney) {
		double money=0;
		try{
			User user= (User) this.getHibernateTemplate().load(User.class,id);
			money=depositMoney+user.getMoney();
			/**
			 * 创建Log对象生成日志
			 * 设到日志信息，调用业务层LogManagerImpl的方法完成日志的填充
			 * 创建set集合，将日志添加到set集合中
			 * 将set集合添加到user对象中
			 * 将请求存款的用户信息存入数据库
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
	 *取款
	 *先查询当前余额
	 *判断余额和取款金额的大小
	 *小于就抛出异常
	 *大于就完成取款 
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
				 * 创建Log对象生成日志
				 * 设到日志信息，调用业务层LogManagerImpl的方法完成日志的填充
				 * 创建set集合，将日志添加到set集合中
				 * 将set集合添加到user对象中
				 * 将请求存款的用户信息存入数据库
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
	 * 转账
	 * 1.查看转账账号是否存在，不存在就抛出异常
	 * 2.存在就取出对方的余额 
	 * 3.取出当前账号的余额，判断和转账金额的大小，小于就抛出异常
	 * 4.大于就完成转账，当前账号金额减去转账金额，对方账号余额增加转账金额
	 */
	public double transfer(int id, double transferMoney, int transferId) {
		double money=0;
		try{
			//这里使用get是因为如果使用load方法，transferId不存在时会直接抛出异常，但是get不会，get方法会返回null
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
					 * 创建Log对象生成日志
					 * 设到日志信息，调用业务层LogManagerImpl的方法完成日志的填充
					 * 创建set集合，将日志添加到set集合中
					 * 将set集合添加到user对象中
					 * 将请求存款的用户信息存入数据库
					 * */
					Log log=new Log();
					log.setUserid(id);
					log.setUsername(user.getUsername());
					log.setType("transfer log");
					log.setContent(user.getUsername()+" is transfering "
							+transferMoney+"YUAN，" +" to "+objUser.getId()+objUser.getUsername());
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
