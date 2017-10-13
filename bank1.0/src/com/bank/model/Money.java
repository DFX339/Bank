package com.bank.model;
/**
 * Money实体类
 * 单例设计模式
 * @Author DFX
 * @version 1.0 2017/06/15
 * */
public class Money {
	
		private double money;//卡上余额
		
		//饱汉式单例设计模式
		private static Money moneybBean=null;
		
		public static Money getMoneyBean(){
			if(moneybBean==null){
				moneybBean=new Money();
			}
			return moneybBean;
			
		}
		public Money(){}

		public double getMoney() {
			return money;
		}

		public void setMoney(double money) {
			this.money = money;
		}
		
		
}
