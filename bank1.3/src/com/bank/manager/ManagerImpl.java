package com.bank.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.bank.dao.DaoImpl;
import com.bank.dao.DaoInterface;
import com.bank.factory.DaoFactory;
import com.bank.model.Money;
import com.bank.model.User;
import com.bank.utils.AccountOverException;
import com.bank.utils.InvalidDepositException;
import com.bank.utils.MD5;
import com.bank.utils.TransferException;

/**
 * �ӿڵ�ʵ����(����ʽ�������ģʽ)+ͬ��
 * ʵ�ֵ���Ҫ��������¼ϵͳ��ע���û��� ��ѯ��ת�ˣ���ȡ��˳�ϵͳ
 * @Author DFX
 * @version 1.3 2017/07/18
 * */
public class ManagerImpl implements ManagerInterface {
	
	
	// �������ģʽ
	private static ManagerImpl managerImpl = null;

	public static ManagerImpl getManagerImpl() {
		//����ͬ������static���͵�������Ϊ��ǰ��̬���������������.class
		synchronized(ManagerImpl.class){
		if (managerImpl == null) {
			managerImpl = new ManagerImpl();
		}
		return managerImpl;
		}
	}

	DaoInterface daoImpl;
	// �޲ι��췽��
	public ManagerImpl() {
		DaoFactory  daoFactory=DaoFactory.getInstance();//�õ����������
		daoImpl=daoFactory.getObj();//ͨ�����������õ��־ò�ӿ�ʵ�������
	}

	
	/*
	 * ����DaoImpl��transfer����
	 * 
	 * @param: inputNum :����Ľ����
	 * 
	 * @return:
	 */
	public void transfer(){
		daoImpl.transfer();
	}
		
	
	/*
	 * ����DaoImpl�еĴ���
	 * 
	 * @param: inputNum :����Ľ����
	 * 
	 * @return:
	 */
	@Override
	public double deposit(double inputNum)  {
			return daoImpl.deposit(inputNum);
	}
	

	/*
	 * ����DaoImpl��ȡ���
	 * 
	 * @param: outputNum :ȡ���Ľ����
	 * 
	 * @return:
	 */
	@Override
	public double withdrawals(double outputNum) {
		return daoImpl.withdrawals(outputNum);
	}

	/*
	 * ����DaoImpl�в�ѯ����
	 * 
	 * @param: null
	 * 
	 * @return:
	 */
	@Override
	public double inqury() {
		return daoImpl.inqury();
	}

	/*
	 * ����DaoImpl����û���¼����
	 * 
	 * @param: username �û��� password ����
	 * 
	 * @return: void
	 */
	@Override
	public boolean login(String username, String password) {
		return daoImpl.login(username, password);
	}

	/*
	 * ����DaoImpl�е��û�ע�᷽��
	 * 
	 * @param: username �û��� password ����
	 * 
	 * @return: void
	 */
	@Override
	public void register(String username, String password) {
		daoImpl.register(username, password);
	}

	/**
	 * �˳�ϵͳ
	 * 
	 * @param null
	 * @return void
	 * */
	@Override
	public void exitSystem() {
		daoImpl.exitSystem();
	}
	
}
