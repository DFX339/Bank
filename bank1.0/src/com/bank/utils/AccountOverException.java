package com.bank.utils;
/**
 * 取款超出余额异常
 * @Author DFX
 * @version 1.0 2017/06/15
 * */
 
	public class AccountOverException extends Exception {
		
		public AccountOverException(){
			super();
		}
		
		public AccountOverException(String msg){
			super(msg);
		}
	}


