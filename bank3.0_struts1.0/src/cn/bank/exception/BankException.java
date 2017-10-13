package cn.bank.exception;
/**
 * struts1.0�汾�������쳣��
 * @author Administrator
 *
 *һ���쳣�࣬����������Ŀ�������쳣��Ϣ
 */
public class BankException extends RuntimeException {
	
	private String errorCode;//���ʻ������key
	private Object[] error;//���ʻ�����Ķ�̬�����Ϣ
	
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
