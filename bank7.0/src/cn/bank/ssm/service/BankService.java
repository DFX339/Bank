package cn.bank.ssm.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import cn.bank.ssm.bean.Admin;
import cn.bank.ssm.bean.Log;
import cn.bank.ssm.bean.User;
import cn.bank.ssm.dao.BankDaoInterface;
import cn.bank.ssm.exception.BankException;
import cn.bank.ssm.exception.LoginException;
import cn.bank.ssm.exception.RegistException;
/**
 * 银行的业务类
 * @author Administrator
 *
 */
public class BankService {
	
	@Resource(name="Mapper")
	private BankDaoInterface Mapper;
	
	//注册
	public void regist(User user){
		try{
			user.setTag("正常状态");
			Mapper.regist(user);
			
			Log log = new Log();
			log.setLogType("Regist Log");
			log.setLogContent(user.getUsername()+" is registting");
			log.setOperateTime(new Date());
			log.setUserid(user.getId());
			Mapper.addLog(log);
		}catch(Exception e){
			throw new RegistException("注册失败");
		}
	}
	
	//普通用户登录
	public User login(User user){
		User user1 =  Mapper.login(user);
		if(user1 == null){
			throw new LoginException("账号和密码不匹配"+user.getUsername()+user.getPassword());
		}
		return Mapper.login(user);
	}
	
	//管理员登录
	public Admin adminLogin(Admin admin){
		Admin admin1 = Mapper.adminLogin(admin);
		if(admin1 == null){
			throw new LoginException("账号和密码不匹配"+admin.getUsername()+admin.getPassword());
		}
		return Mapper.adminLogin(admin);
	}
	
	//存款
	public double deposit(int id,double money){
		try{
			User user = Mapper.findById(id);
			double money1=user.getMoney();
			money1 = money1+money;
			user.setMoney(money1);
			Mapper.updateMoney(user);
			
			Log log = new Log();
			log.setLogType("Deposit Log");
			log.setLogContent(user.getUsername()+" is depositting "+money+" YUAN");
			log.setOperateTime(new Date());
			log.setUserid(user.getId());
			Mapper.addLog(log);
			return money1;
		}catch(Exception e){
		throw new RegistException("存款失败");
	}
		
	}
	
	
	//取款
	public double withdrawal(int id,double money){
		try{
			User user = Mapper.findById(id);
			double money1=user.getMoney();
			if(money1 < money){
				throw new BankException("余额不足");
			}
			money1 = money1 - money;
			user.setMoney(money1);
			Mapper.updateMoney(user);
			
			Log log = new Log();
			log.setLogType("Withdrawal Log");
			log.setLogContent(user.getUsername()+" is withdrawaling "+money+" YUAN");
			log.setOperateTime(new Date());
			log.setUserid(user.getId());
			Mapper.addLog(log);
			return money1;
	}catch(Exception e){
		throw new RegistException("取款失败");
	}
		
	}
	
	//查询余额
	public  double find(int id){
		User user = Mapper.findById(id);
		return user.getMoney();
	}
	
	//根据id查找用户
	public  User findById(int id){
		User user = Mapper.findById(id);
		return user;
	}
	
	//管理员更改用户状态
	public  void updateTag(User user){
		 Mapper.updateTag(user);
	}
	
	//添加日志
	public void addLog(Log log){ 
		Mapper.addLog(log);
	}
	
	//管理员查询所有的用户
	public List findAllUser(){
		return Mapper.findAll();
	}
	
	//转账
	public  double transfer(int id,double money,int transferID){
		try{
			//查询转账用户是否存在
			if(Mapper.findById(transferID)  == null){
				throw new BankException("转账用户不存在"+transferID);
			}
			//存在的话就查询出该账户的余额
			User objUser = Mapper.findById(transferID);
			double objMoney = objUser.getMoney();
			
			//得到当前账号的余额
			User user = Mapper.findById(id);
			double money1 = user.getMoney();
			if(money1 < money){
				throw new BankException("卡上余额不足");
			}
			user.setMoney(money1-money);
			objUser.setMoney(objMoney+money);
			
			Mapper.updateMoney(user);
			Mapper.updateMoney(objUser);
			
			Log log = new Log();
			log.setLogType("Transfer Log");
			log.setLogContent(id+" is transfering "+money+" YUAN to "+transferID);
			log.setOperateTime(new Date());
			log.setUserid(user.getId());
			Mapper.addLog(log);
			
			Log log1 = new Log();
			log1.setLogType("Transfer Log");
			log1.setLogContent(transferID+" is recieving "+money+" YUAN from "+id);
			log1.setOperateTime(new Date());
			log1.setUserid(transferID);
			Mapper.addLog(log1);
			return money1;
	}catch(Exception e){
		throw new RegistException("转账失败");
	}
	}
}
