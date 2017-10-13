package cn.bank.exception;
/**
 * struts1.0版本的银行异常类
 * @author Administrator
 *
 *一个异常类，处理整个项目的所有异常信息
 */
public class BankException extends RuntimeException {
	
	private String errorCode;//国际化编码的key
	private Object[] error;//国际化编码的动态填充信息
	
	public String getErrorCode(){
		return this.errorCode;
	}
	
	public Object[] getError(){
		return this.error;
	}
	
	public BankException(String errorCode){
		super(errorCode);
	}
	
	public BankException(String errorCode,Object obj){
		this(errorCode,new Object[]{obj});
	}
	
	public BankException(String errorCode,Object[] error){
		this.errorCode=errorCode;
		this.error=error;
	}
}
