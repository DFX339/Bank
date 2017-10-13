package cn.bank.exception;
/**
 * 银行项目的异常
 * @author Administrator
 *
 */
public class BankException extends RuntimeException{

	private Object[] error;//异常的动态填充信息
	private String errorCode;//国际化异常处理资源文件中的key
	
	public BankException(String errorCode){
		this.errorCode=errorCode;
	}
	
	public BankException(String errorCode,String arg){
		this(errorCode,new Object[]{arg});
	}
	
	public BankException(String errorCode,Object[]  error){
		this.errorCode=errorCode;
		this.error=error;
	}

	public Object[] getError() {
		return error;
	}

	public String getErrorCode() {
		return errorCode;
	}
	
	
}
