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
 * �ӿڵ�ʵ����(����ʽ�������ģʽ)
 * ʵ�ֵ���Ҫ��������¼ϵͳ��ע���û��� ��ѯ��ת�ˣ���ȡ��˳�ϵͳ
 * @Author DFX
 * @version 1.2 2017/07/10
 * */
public class ManagerImpl implements ManagerInterface {
	
	DaoInterface daoImpl=null;
	
	// �������ģʽ
	private static ManagerImpl managerImpl = null;

	public synchronized static ManagerImpl getManagerImpl()  {
		if (managerImpl == null) {
			try {
				managerImpl = new ManagerImpl();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return managerImpl;
	}

	// �޲ι��췽��
	private ManagerImpl() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		DaoFactory daoFactory=DaoFactory.getInstance();//�������������
		daoImpl=(DaoImpl) daoFactory.getObj();//ͨ�����������õ��־ò������
		
	}

	/*
	 * ����DaoImpl��transfer����
	 * 
	 * @param: inputNum :����Ľ����
	 * 
	 * @return:
	 */
	public void transfer(String toUsername,double transferNum){
		daoImpl.transfer(toUsername,transferNum);
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
