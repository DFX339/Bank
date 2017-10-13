package com.bank.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5�㷨��ʵ��
 * @Author DFX
 * @version 1.1 2017/06/19
 * 
 * */
public class MD5 {
	
	public MD5(){}
	
	public String encode(byte[] source){
		String str=null;
		//����ת����16���Ƶı�ʾ�ַ�
		char[] hexDigits={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(source);
			byte[] temp=md.digest();//MD5����Ľ����128λ�ĳ�����
			char[] str1=new char[16*2];//16���Ʊ�ʾ��ÿ���ֽ������ַ���16����32���ַ�
			int k=0;//��ʾת������ж�Ӧ�ַ���λ��
			for(int i=0;i<16;i++){//�ӵ�0���ֽڿ�ʼ����MD5��ÿ���ֽ�ת����16���Ƶ��ַ�
				byte byte0=temp[i];//ȡ����i���ֽ�
				str1[k++]=hexDigits[byte0 >>> 4 & 0xf];//ȡ�ֽ��и���λ������ת����>>>�߼�����
				str1[k++]=hexDigits[byte0 & 0xf];//ȡ�ֽ��е���λ������ת��
			}
			str=new String(str1);//��ת����Ľ��ת��Ϊ�ַ���
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	public String getMD5(String source){
		return(source==null||"".equals(source)?"":encode(source.getBytes()));
	}
}
