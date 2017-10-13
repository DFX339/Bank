package com.bank.utils;
/**
 * 转账金额不足异常处理类
 * @Author DFX
 * @Version 1.2 2017/06/20
 * */
public class TransferException extends Exception{
	
	public TransferException(){
		super();
	}
	
	public TransferException(String msg){
		super(msg);
	}
}
