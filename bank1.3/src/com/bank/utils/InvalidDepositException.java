package com.bank.utils;
/**
 * ���Ϊ�����쳣
 * @Author DFX
 * @version 1.3 2017/07/18
 * */
public class InvalidDepositException extends Exception {
	
	public InvalidDepositException(){
		super();
	}
	
	public InvalidDepositException(String msg){
		super(msg);
	}
}
