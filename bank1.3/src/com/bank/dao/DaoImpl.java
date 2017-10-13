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
 * Dao的实现类(饱汉式单例设计模式) 
 * 实现的主要方法：
 * 登录系统，注册用户， 查询余额，转账，存款，取款，退出系统
 * 
 * @Author DFX
 * @version 1.3 2017/7/18
 * */
public class DaoImpl implements DaoInterface {
	// 单例设计模式
	private static DaoImpl daoImpl = null;

	public static DaoImpl getDaoImpl() {
		//增加同步锁，static类型的锁对象为当前静态方法所属类的类名.class
		synchronized(DaoImpl.class){
		if (daoImpl == null) {
			daoImpl = new DaoImpl();
		}
		return daoImpl;
		}
	}
	// 无参构造方法
	public DaoImpl() {
	}

	User user = User.getUser();// 创建User对象 用来得到用户的用户名
	Money money = Money.getMoneyBean();// 创建Money对象，用来得到money
	Scanner in = new Scanner(System.in);// 获取键盘输入数据
	Properties props = new Properties();// 创建properties对象，用来对properties文件读取以及修改等操作
	MD5 md = new MD5();// 创建MD5加密对象，实现对用户名和密码的加密操作
	public static boolean flag = false;// 用来标识登录是否成功 成功返回true 失败返回false

	/*
	 * 转账方法的实现
	 * 
	 * @param: inputNum :存入的金额数
	 * 
	 * @return:
	 */
	public void transfer() {
		System.out.println("请输入转账对象用户名：");
		String toUsername = in.next();// 接收转账对象用户名
		toUsername = md.getMD5(toUsername);// 使用MD5加密转换找到该对象对应的存储文件名
		System.out.println("请输入转账金额：");
		double transferNum = in.nextDouble();// 接收转账金额
		InputStream fromInput = null;// 当前对象的properties文件
		InputStream toInput = null;// 被转账对象的properties文件
		FileOutputStream fos1 = null;// 被转账对象收到转账后的存贮文件
		try {
			fromInput = new FileInputStream(user.getUsername() + ".properties");// 加载当前对象的存储文件信息
			props.load(fromInput);
			double fromMoney1 = new Double(props.getProperty("money"));// 得到当前对象存储在文件中的money
			double fromMoney2 = money.getMoney();// 得到当前对象在内存中的money
			double fromMoney = fromMoney1 + fromMoney2;// fromMoney为当前对象的总Money值

			toInput = new FileInputStream(toUsername + ".properties");// 加载被转账的文件配置信息
			Properties props1 = new Properties();// 创建临时properties对象用于加载存储被转账对象的文件信息
			props1.load(toInput);// 将被转账文件加载到内存
			if (fromMoney >= transferNum) {// 判断当前对象的总money值是否大于转账金额
				fromMoney2 = fromMoney2 - transferNum;// 当前对象中的money值减去转账金额
				System.out.println("转账后，您当前总余额为：" + (fromMoney1 + fromMoney2));// 总余额为当前对象的余额+卡上余额
				money.setMoney(fromMoney2);// 将转账后的当前对象的money值设到money对象中

				double moneyTo = new Double(props1.getProperty("money"));// 得到被转账对象的Money
				moneyTo = moneyTo + transferNum;// 将被转账对象已有的money加上转账金额
				// 作为当前money数存到文件中
				props1.setProperty("money", moneyTo + "");// 将收到转账后的money值存到文件中
				fos1 = new FileOutputStream(toUsername + ".properties");
				props1.store(fos1, toUsername);// 将收到转账props1对象存储到文件中
			} else {
				throw new TransferException("卡上余额不足！！！");
			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage() + "文件不存在！！！");
		} catch (IOException e) {
			System.out.println(e.getMessage() + "IO异常！！！");
		} catch (TransferException e) {
			System.out.println(e.getMessage() + "兄弟你卡上没钱！！！");
		} finally {
			if (fromInput != null) {// 关闭当前转账对象输入流
				try {
					fromInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (toInput != null) {// 关闭被转账对象输入流
				try {
					fromInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos1 != null) {// 关闭被转账对象输出流
				try {
					fromInput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/*
	 * 存款方法的实现
	 * 
	 * @param: inputNum :存入的金额数
	 * 
	 * @return:
	 */
	@Override
	public double deposit(double inputNum) {

		System.out.println("请输入存款金额：");
		inputNum = in.nextDouble();// 指定输入double类型的数据
		InputStream is = null;
		try {
			if (inputNum <= 0) {// 当存款数小于0时显示输入金额有误
				throw new InvalidDepositException("输入金额有误，存款金额不能小于等于0！！！");
			} else {
				is = new FileInputStream(user.getUsername() + ".properties");
				props.load(is);// 把文件加载到内存中
				System.out.println("您输入的存款金额为：" + inputNum);
				inputNum += money.getMoney();
				double money1 = new Double(props.getProperty("money"));// 得到文件中的money值
				System.out.println("您卡上的总金额为：" + (inputNum + money1));// 总金额=当前存款数+文件中已有的钱
				money.setMoney(inputNum);
			}
		} catch (InvalidDepositException e) {
			System.out.println("无效的存款金额" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到！" + e.getMessage());
		} catch (IOException e) {
			System.out.println("文件加载异常！" + e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return inputNum;
	}

	/*
	 * 取款方法的实现
	 * 
	 * @param: outputNum :取出的金额数
	 * 
	 * @return:
	 */
	@Override
	public double withdrawals(double outputNum) {
		System.out.println("请输入取款金额：");
		outputNum = in.nextDouble();// 指定输入double类型的数据
		double money1 = new Double(props.getProperty("money"));// 得到properties文件中的money值
		InputStream is = null;
		try {
			if ((money.getMoney() + money1 - outputNum) <= 0) {// 当取款金额大于余额时显示余额不足
				throw new AccountOverException("余额不足，不能取款！！！");
			} else {
				is = new FileInputStream(user.getUsername() + ".properties");
				props.load(is);// 将properties文件加载到内存中
				System.out.println("您输入的取款金额为：" + outputNum);
				outputNum = money.getMoney() - outputNum;
				System.out.println("您的卡上余额为：" + (outputNum + money1));// 卡上余额=当前余额+文件中的money值-取出的钱
				money.setMoney(outputNum);
			}
		} catch (AccountOverException e) {
			System.out.println("取款金额无效！" + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("文件未找到！" + e.getMessage());
		} catch (IOException e) {
			System.out.println("文件加载异常！" + e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return outputNum;
	}

	/*
	 * 查询余额方法的实现
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
			is = new FileInputStream(user.getUsername() + ".properties");// 读取配置文件
			props.load(is);// 将配置文件中的信息加载到内存
			money1 = new Double(props.getProperty("money"));// 得到配置文件中的money数
			System.out.println("您的余额为：" + (money1 + money.getMoney()));// 余额=当前余额+文件中的money

		} catch (IOException e) {
			System.out.println("查看失败！！" + e);
		} finally {

			if (is != null) {
				try {
					is.close();// 关闭输入流
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return money1;
	}

	/*
	 * 用户登录方法的实现
	 * 
	 * @param: username 用户名 password 密码
	 * 
	 * @return: void
	 */
	@Override
	public boolean login(String username, String password) {
		System.out.println("请输入登录用户名：");
		username = in.next();// 指定输入数据类型为字符串
		username = md.getMD5(username);// 将用户名加密存储到文件中
		user.setUsername(username);
		System.out.println("请输入登录密码：");
		password = in.next();
		password = md.getMD5(password);
		user.setPassword(password);// 将密码加密存储到properties文件中
		FileInputStream is = null;
		try {
			is = new FileInputStream(username + ".properties");
			props.load(is);// 读取配置文件
			if (username.equals(props.getProperty("username"))// 判断用户名和密码是否匹配
					&& password.equals(props.getProperty("password"))) {
				flag = true;// 匹配后将flag标记为true
				System.out.println("恭喜你，登录成功！！！");
			} else {
				flag = false;// 不匹配将flag标记为false
				System.out.println("用户名和密码不匹配，请重新登录！！！");
			}
		} catch (FileNotFoundException e1) {
			System.out.println("文件未找到" + e1.getMessage());
		} catch (IOException e) {
			System.out.println("文件加载异常" + e.getMessage());
		} finally {
			if (is != null) {// 判断输入流是否为null
				try {
					is.close();// 不为null的时候关闭输入流
				} catch (IOException e) {
					System.out.println("输入流关闭异常" + e);
				}
			}
		}
		return flag;

	}

	/*
	 * 用户注册方法的实现
	 * 
	 * @param: username 用户名 password 密码
	 * 
	 * @return: void
	 */
	@Override
	public void register(String username, String password) {

		System.out.println("请输入注册用户名：");
		username = in.next();// 指定输入数据类型为字符串
		username = md.getMD5(username);// 将用户名加密存储到文件中
		user.setUsername(username);
		System.out.println("请输入注册密码：");
		password = in.next();
		password = md.getMD5(password);// 将密码加密存储到文件中

		File file = new File(username + ".properties");// 新建文件名为 username
		// 的properties文件
		FileOutputStream fos = null;
		if (file.exists()) {// 如果文件已经存在，就提示用户已存在 不能再注册
			System.out.println("用户已存在，不能重复注册");
		} else {
			props.setProperty("username", username);// 将注册信息设到props对象中
			props.setProperty("password", password);
			props.setProperty("money", "100.0");
			try {
				fos = new FileOutputStream(username + ".properties");
				props.store(fos, username);// 将信息存储到properties文件中
				// 第一个参数表示存入的文件对象，第二个参数是说明（可以没有）
				System.out.println("恭喜你，注册成功！！！");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fos != null) {// 判断输出流是否为null
					try {
						fos.close();// 为null的时候关闭输出流
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}

	}

	/**
	 * 退出系统
	 * 
	 * @param null
	 * @return void
	 * */
	@Override
	public void exitSystem() {
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			is = new FileInputStream(user.getUsername() + ".properties");// 读取配置文件信息
			props.load(is);// 将配置文件中的信息加载到内存
			double mon = new Double(props.getProperty("money"));// 得到配置文件信息中的money值
			props.setProperty("money", money.getMoney() + mon + "");
			fos = new FileOutputStream((user.getUsername() + ".properties"));
			props.store(fos, user.getUsername());// 将信息存储到输出流指定的文件中
		} catch (FileNotFoundException e2) {
			System.out.println("文件未找到！！！");
		} catch (IOException e1) {
			System.out.println("IO异常！！！");
		} finally {
			if (is != null) {// 判断文件输入流是否为null
				try {
					is.close();// 为null时关闭输入文件流
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (fos != null) {// 判断文件输出流是否为null
				try {
					fos.close();// 为null时关闭输出文件流
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.println("谢谢您的使用……^-^……" + user.getUsername());
			System.exit(1);// 退出系统
		}
	}

}
