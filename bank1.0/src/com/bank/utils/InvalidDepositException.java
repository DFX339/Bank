package com.bank.utils;
/**
 * ���Ϊ�����쳣
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
