package com.bank.model;
/**
 * Moneyʵ����
 * �������ģʽ
 * @Author DFX
 * @version 1.0 2017/06/15
 * */
public class Money {
	
		private double money;//�������
		
		//����ʽ�������ģʽ
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
