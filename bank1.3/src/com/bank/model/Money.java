package com.bank.model;
/**
 * Money实体类
 * 单例设计模式
 * @Author DFX
 * @version 1.3 2017/07/18
 * */
public class Money {
	
		private double money;//卡上余额
		
		//饱汉式单例设计模式
		private static Money moneybBean=null;
		
		public static Money getMoneyBean(){
			synchronized(Money.class){//增加同步锁，static类型的锁对象为当前静态方法所属类的类名.class
			if(moneybBean==null){
				moneybBean=new Money();
			}
			return moneybBean;
			}
		}
		public Money(){}

		public double getMoney() {
			return money;
		}

		public void setMoney(double money) {
			this.money = money;
		}
		
		
}
