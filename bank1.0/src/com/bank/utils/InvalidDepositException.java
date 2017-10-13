package com.bank.utils;
/**
 * 存款为负数异常
 * @Author DFX
 * @version 1.0 2017/06/15
 * */
public class InvalidDepositException extends Exception {
	
	public InvalidDepositException(){
		super();
	}
	
	public InvalidDepositException(String msg){
		super(msg);
	}
}
