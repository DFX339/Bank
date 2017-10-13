package cn.bank.ssm.exception;

public class LoginException extends RuntimeException {
	
	public LoginException(String msg){
		super(msg);
	}
}
