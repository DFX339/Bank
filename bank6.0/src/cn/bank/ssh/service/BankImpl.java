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
 * 银行接口实现类
 * @author Administrator
 *	@version 6.0 2017/9/21
 */
public class BankImpl implements BankService{
	
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Resource(name="logImpl")
	private LogImpl logImpl;
	
	/*
	 *登录，（不添加日志记录）
	 *直接查询数据库中有没有和用户名和密码匹配的记录
	 *有的话就返回该记录生成的对象，
	 *没有匹配的记录的话就抛出异常
	 */
	public User login(String username, String password) {
		List listLogin=null;
		listLogin=hibernateTemplate.find("from User user where user.username=? and user.password=?",
				new Object[]{username,password});
		if(listLogin.size()== 0){
			throw new LoginException("用户名和密码不匹配，请重新输入"+username+":"+password);
		}else{
			try{
				User user = (User) listLogin.get(0);
				return user;
				
			}catch(Exception e){
				throw new LoginException("登录失败");
			}
		}
	}
	
	/*
	 * 注册
	 * 1.判断用户使用已经存在，已经存在就注册失败，返回false
	 * 2.不存在就完成注册 返回 true
	 */
	public boolean regist(User user) {
		boolean flag=false;
		List listRegister=null;
		listRegister=hibernateTemplate.find("from User user where user.username=? and user.password=?",
				new Object[]{user.getUsername(),user.getPassword()});
		if(listRegister.size()!= 0){
			throw new RegistException("用户名和密码已存在，请重新输入"+user.getUsername()+":"+user.getPassword());
		}else{
			try{
				hibernateTemplate.save(user);
				
				/**
				 * 创建日志对象，设定日志信息，存入数据库
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
				throw new RegistException("注册失败");
			}
		}
		return flag;
	}
	
	/*
	 * 存款
	 * 根据id找到当前用户在数据库中记录,拿到余额
	 * 将余额加上存款金额
	 * 创建日志对象
	 */
	public double deposit(int id, double depositMoney) {
		User user=null;
		user=hibernateTemplate.load(User.class,id);
		double money=user.getMoney();//拿到当前对象的余额
			try{
				money=money+depositMoney;
				user.setMoney(money);
				hibernateTemplate.update(user);
				
				/**
				 * 创建日志对象，设定日志信息，存入数据库
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
				throw new BankException("存款失败");
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
		User user=null;
		user=hibernateTemplate.load(User.class,id);
		double money=user.getMoney();
		
		if(money<withdrawalMoney){
			throw new BankException("账户余额不足");
		}
			try{
				money=money-withdrawalMoney;
				user.setMoney(money);
				hibernateTemplate.update(user);
				
				/**
				 * 创建日志对象，设定日志信息，存入数据库
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
				throw new BankException("取款失败");
			}
	}
	
	/*
	 * 转账
	 * 1.查看转账账号是否存在，不存在就抛出异常
	 * 2.存在就取出对方的余额 
	 * 3.取出当前账号的余额，判断和转账金额的大小，小于就抛出异常
	 * 4.大于就完成转账，当前账号金额减去转账金额，对方账号余额增加转账金额
	 */
	public double transfer(int id, double transferMoney, int transferId) {
		User user=null;
		User objUser=null;
		objUser=hibernateTemplate.get(User.class,transferId);
		
		if(objUser == null){
			throw new BankException("账号["+transferId+"]不存在,请重新输入");
		}
		double objMoney=objUser.getMoney();//查询出对方的余额，用于存储
		
		user=hibernateTemplate.load(User.class, id);//查出当前登录对象的信息
		double money=user.getMoney();//拿到当前对象的余额
		
		if(money<transferMoney){
			throw new BankException("账户余额不足");
		}
			try{
				//将当前对象的余额减少并且存入数据库
				money=money-transferMoney;
				user.setMoney(money);
				hibernateTemplate.update(user);
				
				//将对方账号的约增加并且存入数据库
				objMoney = objMoney+transferMoney;
				objUser.setMoney(objMoney);
				hibernateTemplate.update(objUser);
				
				/**
				 * 创建日志对象，设定日志信息，存入数据库
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
				throw new BankException("转账失败");
			}
	}

	
	/**
	 * 查询余额
	 */
	public double inqury(int id) {
		try{
			User user=hibernateTemplate.get(User.class,id);
			System.out.println("业务层查询余额"+user.getMoney());
			return user.getMoney();
		}catch(Exception e){
			throw new BankException("余额查询失败");
		}
	}

}
