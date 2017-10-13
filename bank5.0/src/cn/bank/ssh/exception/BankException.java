package cn.bank.ssh.exception;
/**
 * 国际化异常处理
 * @author Administrator
 * 提供get()方法，不提供set()方法,通过构造方法设值
 * 
 */
public class BankException extends RuntimeException{
	
	private String errorCode;//异常信息的key
	private Object[] obj;//动态异常信息。使用数组填充
	
	public BankException(String errorCode){
		this.errorCode=errorCode;
	}
	
	public BankException(String errorCode,Object obj){
		this(errorCode,new Object[]{obj});
	}
	
	public BankException(String errorCode,Object[] obj){
		this.errorCode=errorCode;
		this.obj=obj;
	}
	
	
	public String getErrorCode(){
		return this.errorCode;
	}
	
	public Object[] getObj(){
		return this.obj;
	}
	
}
