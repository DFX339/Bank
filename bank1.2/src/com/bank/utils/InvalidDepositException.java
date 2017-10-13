package com.bank.utils;
/**
 * 存款为负数异常
 * @Author DFX
 * @version 1.2 2017/06/20
 * */
public class InvalidDepositException extends Exception {
	
	public InvalidDepositException(){
		super();
	}
	
	public InvalidDepositException(String msg){
		super(msg);
	}
}
