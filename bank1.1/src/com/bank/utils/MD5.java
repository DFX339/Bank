package com.bank.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5算法的实现
 * @Author DFX
 * @version 1.1 2017/06/19
 * 
 * */
public class MD5 {
	
	public MD5(){}
	
	public String encode(byte[] source){
		String str=null;
		//用来转换成16进制的表示字符
		char[] hexDigits={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			md.update(source);
			byte[] temp=md.digest();//MD5计算的结果是128位的长整数
			char[] str1=new char[16*2];//16进制表示，每个字节两个字符，16进制32个字符
			int k=0;//表示转换结果中对应字符的位置
			for(int i=0;i<16;i++){//从第0个字节开始，对MD5的每个字节转换成16进制的字符
				byte byte0=temp[i];//取出第i个字节
				str1[k++]=hexDigits[byte0 >>> 4 & 0xf];//取字节中高四位的数字转换，>>>逻辑右移
				str1[k++]=hexDigits[byte0 & 0xf];//取字节中低四位的数字转换
			}
			str=new String(str1);//将转换后的结果转换为字符串
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	public String getMD5(String source){
		return(source==null||"".equals(source)?"":encode(source.getBytes()));
	}
}
