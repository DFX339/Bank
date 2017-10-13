package bank.com.exception;
/**
 * 自定义异常类
 * 保存异常信息
 * 
 * @author DFX
 * @version 2.0 2017/07/28
 * */
public class BankException extends Exception {
	
	public BankException(){}
	
	public BankException(String msg){
		super(msg);
	}
}
