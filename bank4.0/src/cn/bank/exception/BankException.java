package cn.bank.exception;
/**
 * ������Ŀ���쳣
 * @author Administrator
 *
 */
public class BankException extends RuntimeException{

	private Object[] error;//�쳣�Ķ�̬�����Ϣ
	private String errorCode;//���ʻ��쳣������Դ�ļ��е�key
	
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
