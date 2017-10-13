package com.bank.model;
/**
 * Moneyʵ����
 * �������ģʽ
 * @Author DFX
 * @version 1.3 2017/07/18
 * */
public class Money {
	
		private double money;//�������
		
		//����ʽ�������ģʽ
		private static Money moneybBean=null;
		
		public static Money getMoneyBean(){
			synchronized(Money.class){//����ͬ������static���͵�������Ϊ��ǰ��̬���������������.class
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
