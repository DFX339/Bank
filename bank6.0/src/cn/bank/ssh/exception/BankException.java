package cn.bank.ssh.exception;
/**
 * 银行项目的异常处理类
 * @author Administrator
 * @version 6.0 2017/9/21
 */
public class BankException extends RuntimeException {
	
	public BankException(String msg){
		super(msg);
	}
}
