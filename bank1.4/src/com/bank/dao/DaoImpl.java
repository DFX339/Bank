package com.bank.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import com.bank.model.Money;
import com.bank.model.User;
import com.bank.utils.AccountOverException;
import com.bank.utils.InvalidDepositException;
import com.bank.utils.MD5;
import com.bank.utils.TransferException;

/**
 * Dao��ʵ����(����ʽ�������ģʽ) 
 * ʵ�ֵ���Ҫ������
 * ��¼ϵͳ��ע���û��� ��ѯ��ת�ˣ���ȡ��˳�ϵͳ
 * 
 * @Author DFX
 * @version 1.2 2017/07/10
 * */
public class DaoImpl implements DaoInterface {
	// �������ģʽ
	private static DaoImpl daoImpl = null;

	public static DaoImpl getDaoImpl() {
		if (daoImpl == null) {
			daoImpl = new DaoImpl();
		}
		return daoImpl;
	}

	// �޲ι��췽��
	public DaoImpl() {
	}

	User user = User.getUser();// ����User���� �����õ��û����û���
	Money money = Money.getMoneyBean();// ����Money���������õ�money
	Properties props = new Properties();// ����properties����������properties�ļ���ȡ�Լ��޸ĵȲ���
	MD5 md = new MD5();// ����MD5���ܶ���ʵ�ֶ��û���������ļ��ܲ���
	public static boolean flag = false;// ������ʶ��¼�Ƿ�ɹ� �ɹ�����true ʧ�ܷ���false

	/*
	 * ת�˷�����ʵ��
	 * 
	 * @param: inputNum :����Ľ����
	 * 
	 * @return:
	 */
	public void transfer(String toUsername,double transferNum) {
		InputStream fromInput = null;// ��ǰ�����properties�ļ�
		InputStream toInput = null;// ��ת�˶����properties�ļ�
		FileOutputStream fos1 = null;// ��ת�˶����յ�ת�˺�Ĵ����ļ�
		FileOutputStream fos2 = null;// ת�˶��� ת�˺�Ĵ����ļ�
		try {
			fromInput = new FileInputStream(user.getUsername() + ".properties");// ���ص�ǰ����Ĵ洢�ļ���Ϣ
			props.load(fromInput);
			double fromMoney1 = new Double(props.getProperty("money"));// �õ���ǰ����洢���ļ��е�money

			String toUsername1=md.getMD5(toUsername);
			toInput = new FileInputStream(toUsername1 + ".properties");// ���ر�ת�˵��ļ�������Ϣ
			Properties props1 = new Properties();// ������ʱproperties�������ڼ��ش洢��ת�˶�����ļ���Ϣ
			props1.load(toInput);// ����ת���ļ����ص��ڴ�
			if (fromMoney1 >= transferNum) {// �жϵ�ǰ�������moneyֵ�Ƿ����ת�˽��
				props.setProperty("money",(fromMoney1-transferNum)+"");
				fos2=new FileOutputStream(user.getUsername()+".properties");
				props.store(fos2,user.getUsername());

				double moneyTo = new Double(props1.getProperty("money"));// �õ���ת�˶����Money
				moneyTo = moneyTo + transferNum;// ����ת�˶������е�money����ת�˽��
				// ��Ϊ��ǰmoney���浽�ļ���
				props1.setProperty("money", moneyTo + "");// ���յ�ת�˺��moneyֵ�浽�ļ���
				fos1 = new FileOutputStream(toUsername1 + ".properties");
				props1.store(fos1, toUsername);// ���յ�ת��props1����洢���ļ���
			} else {
				throw new TransferException("�������㣡����");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "�ļ������ڣ�����");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "IO�쳣������");
		} catch (TransferException e) {
			System.out.println(e.getMessage() + "�ֵ��㿨��ûǮ������");
		} finally {
			if (fromInput != null) {// �رյ�ǰת�˶���������
				try {
					fromInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (toInput != null) {// �رձ�ת�˶���������
				try {
					fromInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos1 != null) {// �رձ�ת�˶��������
				try {
					fos1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (fos2 != null) {// �ر�ת�˶��������
				try {
					fos2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	

	}

	/*
	 * ������ʵ��
	 * 
	 * @param: inputNum :����Ľ����
	 * 
	 * @return:
	 */
	@Override
	public double deposit(double inputNum) {

		InputStream is = null;
		FileOutputStream fos2=null;
		try {
			if (inputNum <= 0) {// �������С��0ʱ��ʾ����������
				throw new InvalidDepositException("���������󣬴�����С�ڵ���0������");
			} else {
				is = new FileInputStream(user.getUsername() + ".properties");
				props.load(is);// ���ļ����ص��ڴ���
				inputNum += money.getMoney();
				double money1 = new Double(props.getProperty("money"));// �õ��ļ��е�moneyֵ
				props.setProperty("money",inputNum+money1+"");
				fos2=new FileOutputStream(user.getUsername()+".properties");
				props.store(fos2,user.getUsername());

			}
		} catch (InvalidDepositException e) {
			System.out.println("��Ч�Ĵ����" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�δ�ҵ���" + e.getMessage());
		} catch (IOException e) {
			System.out.println("�ļ������쳣��" + e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
			if (fos2 != null) {// �رն��������
				try {
					fos2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return inputNum;
	}

	/*
	 * ȡ�����ʵ��
	 * 
	 * @param: outputNum :ȡ���Ľ����
	 * 
	 * @return:
	 */
	@Override
	public double withdrawals(double outputNum) {
		double money1 = new Double(props.getProperty("money"));// �õ�properties�ļ��е�moneyֵ
		InputStream is = null;
		FileOutputStream fos2=null;
		try {
			if ((money.getMoney() + money1 - outputNum) <= 0) {// ��ȡ����������ʱ��ʾ����
				throw new AccountOverException("���㣬����ȡ�����");
			} else {
				is = new FileInputStream(user.getUsername() + ".properties");
				props.load(is);// ��properties�ļ����ص��ڴ���
				outputNum = money.getMoney() - outputNum;
				props.setProperty("money",outputNum + money1+"");
				fos2=new FileOutputStream(user.getUsername()+".properties");
				props.store(fos2,user.getUsername());

			}
		} catch (AccountOverException e) {
			System.out.println("ȡ������Ч��" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�δ�ҵ���" + e.getMessage());
		} catch (IOException e) {
			System.out.println("�ļ������쳣��" + e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (fos2 != null) {// �رն��������
				try {
					fos2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return outputNum;
	}

	/*
	 * ��ѯ������ʵ��
	 * 
	 * @param: null
	 * 
	 * @return:
	 */
	@Override
	public double inqury() {
		InputStream is = null;
		double money1 = 0.0;
		try {
			is = new FileInputStream(user.getUsername() + ".properties");// ��ȡ�����ļ�
			props.load(is);// �������ļ��е���Ϣ���ص��ڴ�
			money1 = new Double(props.getProperty("money"));// �õ������ļ��е�money��

		} catch (IOException e) {
			System.out.println("�鿴ʧ�ܣ���" + e);
		} finally {

			if (is != null) {
				try {
					is.close();// �ر�������
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return money1;
	}

	/*
	 * �û���¼������ʵ��
	 * 
	 * @param: username �û��� password ����
	 * 
	 * @return: void
	 */
	@Override
	public boolean login(String username, String password) {
		username = md.getMD5(username);// ���û������ܴ洢���ļ���
		user.setUsername(username);
		password = md.getMD5(password);
		user.setPassword(password);// ��������ܴ洢��properties�ļ���
		FileInputStream is = null;
		try {
			is = new FileInputStream(username + ".properties");
			props.load(is);// ��ȡ�����ļ�
			if (username.equals(props.getProperty("username"))// �ж��û����������Ƿ�ƥ��
					&& password.equals(props.getProperty("password"))) {
				flag = true;// ƥ���flag���Ϊtrue
				System.out.println("��ϲ�㣬��¼�ɹ�������");
			} else {
				flag = false;// ��ƥ�佫flag���Ϊfalse
				System.out.println("�û��������벻ƥ�䣬�����µ�¼������");
			}
		} catch (FileNotFoundException e1) {
			System.out.println("�ļ�δ�ҵ�" + e1.getMessage());
		} catch (IOException e) {
			System.out.println("�ļ������쳣" + e.getMessage());
		} finally {
			if (is != null) {// �ж��������Ƿ�Ϊnull
				try {
					is.close();// ��Ϊnull��ʱ��ر�������
				} catch (IOException e) {
					System.out.println("�������ر��쳣" + e);
				}
			}
		}
		return flag;

	}

	/*
	 * �û�ע�᷽����ʵ��
	 * 
	 * @param: username �û��� password ����
	 * 
	 * @return: void
	 */
	@Override
	public void register(String username, String password) {
		username = md.getMD5(username);// ���û������ܴ洢���ļ���
		user.setUsername(username);
		password = md.getMD5(password);// ��������ܴ洢���ļ���
		File file = new File(username + ".properties");// �½��ļ���Ϊ username
		// ��properties�ļ�
		FileOutputStream fos = null;
		if (file.exists()) {// ����ļ��Ѿ����ڣ�����ʾ�û��Ѵ��� ������ע��
			System.out.println("�û��Ѵ��ڣ������ظ�ע��");
		} else {
			props.setProperty("username", username);// ��ע����Ϣ�赽props������
			props.setProperty("password", password);
			props.setProperty("money", "100.0");
			try {
				fos = new FileOutputStream(username + ".properties");
				props.store(fos, username);// ����Ϣ�洢��properties�ļ���
				// ��һ��������ʾ������ļ����󣬵ڶ���������˵��������û�У�
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {// �ж�������Ƿ�Ϊnull
					try {
						fos.close();// Ϊnull��ʱ��ر������
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}

	}

	/**
	 * �˳�ϵͳ
	 * 
	 * @param null
	 * @return void
	 * */
	@Override
	public void exitSystem() {
			InputStream is = null;
			FileOutputStream fos = null;
			try {
				is = new FileInputStream(user.getUsername() + ".properties");// ��ȡ�����ļ���Ϣ
				props.load(is);// �������ļ��е���Ϣ���ص��ڴ�
				double mon = new Double(props.getProperty("money"));// �õ������ļ���Ϣ�е�moneyֵ
				props.setProperty("money", money.getMoney() + mon + "");
				fos = new FileOutputStream((user.getUsername() + ".properties"));
				props.store(fos, user.getUsername());// ����Ϣ�洢�������ָ�����ļ���
			} catch (FileNotFoundException e2) {
				System.out.println("�ļ�δ�ҵ�������");
			} catch (IOException e1) {
				System.out.println("IO�쳣������");
			} finally {
				if (is != null) {// �ж��ļ��������Ƿ�Ϊnull
					try {
						is.close();// Ϊnullʱ�ر������ļ���
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

				if (fos != null) {// �ж��ļ�������Ƿ�Ϊnull
					try {
						fos.close();// Ϊnullʱ�ر�����ļ���
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
			System.out.println("лл����ʹ�á���^-^����" + user.getUsername());
			System.exit(1);// �˳�ϵͳ
		}
	
	

}