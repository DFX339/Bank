package com.bank.utils;
/**
 * ���Ϊ�����쳣
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
