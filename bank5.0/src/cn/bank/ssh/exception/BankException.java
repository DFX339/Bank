package cn.bank.ssh.exception;
/**
 * ���ʻ��쳣����
 * @author Administrator
 * �ṩget()���������ṩset()����,ͨ�����췽����ֵ
 * 
 */
public class BankException extends RuntimeException{
	
	private String errorCode;//�쳣��Ϣ��key
	private Object[] obj;//��̬�쳣��Ϣ��ʹ���������
	
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
