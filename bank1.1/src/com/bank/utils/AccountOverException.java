package com.bank.utils;
/**
 * 取款超出余额异常
 * @Author DFX
 * @version 1.1 2017/06/16
 * */
 
	public class AccountOverException extends Exception {
		
		public AccountOverException(){
			super();
		}
		
		public AccountOverException(String msg){
			super(msg);
		}
	}


