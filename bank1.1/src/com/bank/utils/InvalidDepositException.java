package com.bank.utils;
/**
 * 存款为负数异常
 * @Author DFX
 * @version 1.1 2017/06/16
 * */
public class InvalidDepositException extends Exception {
	
	public InvalidDepositException(){
		super();
	}
	
	public InvalidDepositException(String msg){
		super(msg);
	}
}
