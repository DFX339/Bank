package com.bank.utils;
/**
 * ���Ϊ�����쳣
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
