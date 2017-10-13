package cn.bank.service;

import cn.bank.bean.UserBean;
import cn.bank.dao.DaoImpl;
import cn.bank.dao.DaoInterface;
import cn.bank.exception.BankException;
/**
 * 业务方法处理类
 * @author Administrator
 * @version 4.0 2017/9/10
 */
public class BankService {
	
	DaoImpl daoImpl=new DaoImpl();
	
	//单例+同步
	private static BankService instance=null;
	private BankService(){}
	public static synchronized BankService getInstance(){
		if(instance==null){
			instance=new BankService();
		}
		return instance;
	}
	
	/**
	 * 登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 登录的对象
	 */
	public UserBean login(String name,String password){
		return daoImpl.login(name, password);
	}
	
	/**
	 * 注册
	 * @param user 注册对象
	 * @return
	 */
	public  boolean regist(UserBean user){
		System.out.println("被调用啊 regist");
		return daoImpl.regist(user);
	}
	
	/**
	 * 存款
	 * @param id 当前对象的id 
	 * @param depositMoney 存款金额
	 * @return 
	 */
	public  double deposit(int id,String depositMoney){
		String regix="[0-9]{1,6}";//正则表达式的格式为 数字0-999999
		//如果用户输入的存款金额为null，就抛出异常
		if(depositMoney==null){throw new BankException("user.deposit.error");}
		
		//输入的数据不为0 就对输入的数据进行格式判断
		if(depositMoney.matches(regix)){
			double numMoney=new Double(depositMoney);
			return daoImpl.deposit(id,numMoney);
		}else{
			//格式有误就抛出异常
			throw new BankException("user.deposit.error.num",depositMoney);
		}
	}
	
	/**
	 * 取款
	 * @param id 当前对象的id 
	 * @param depositMoney 存款金额
	 * @return 
	 */
	public  double withdrawal(int id,String withdrawalMoney){
		String regix="[0-9]{1,6}";//正则表达式的格式为 数字0-999999
		//如果用户输入的取款金额为null ，就抛出异常
		if(withdrawalMoney==null){throw new BankException("user.withdrawal.error.num",withdrawalMoney);}
		if(withdrawalMoney.matches(regix)){
			double numMoney=new Double(withdrawalMoney);
			return daoImpl.withdrawal(id,numMoney);
		}else{
			//当用户输入的取款金额格式有误时就抛出异常
			throw new BankException("user.withdrawal.num.input.error",withdrawalMoney);
		}
	}
	
	/**
	 * 转账
	 * @param id 当前对象的id
	 * @param transferMoney 转账金额
	 * @param transferId 转账对象的id
	 * @return
	 */
	public  double transfer(int id,String transferMoney,String transferId){
		
		if(transferId==null){//判断用户输入的ID 是否为null，如果为null就抛出异常
			throw new BankException("user.transfer.objID.error",transferId);
		}
		//判断用户输入的转账金额是否为null，为null就抛出异常
		if(transferMoney==null){
			throw new BankException("user.transfer.error");
		}
		
		String regex="[0-9]{1,6}";//定义正则表达式验证规则
		if(transferId.matches(regex)){
			
			int id1=new Integer(transferId);
			if(transferMoney.matches(regex)){
				double numMoney=new Double(transferMoney);
				return daoImpl.transfer(id,numMoney,id1);
			}else{
				//转账金额类型不匹配时就抛出异常
				throw new BankException("user.transfer.num.input.error",transferMoney);
			}
		}else{
			//转账ID类型不匹配时就抛出异常
			throw new BankException("user.transfer.id.input.error",transferId);
		}
		
		
		
	}
	
	/**
	 * 查询余额
	 * @param id 当前对象的id
	 * @return
	 */
	public double inqury(int id){
		return daoImpl.inqury(id);
	}
	
}
