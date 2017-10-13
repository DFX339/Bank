package com.bank.frame;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.bank.manager.ManagerImpl;
import com.bank.manager.ManagerInterface;

/**
 * 注册界面窗口
 * @author DFX
 * @version 1.3 2017/06/20
 * 
 * */
public class RegisterFrame {
	private JFrame frame=null;//主窗口
	private JLabel usernameLabel=null;//提示用户输入用户名的标签
	private JLabel passwordLabel=null;//提示用户输入密码的标签
	private JTextField usernameText=null;//用户名输入框
	private TextField passwordText=null;//密码输入框
	private JButton registerButton=null;//注册按钮
	private JButton exitButton=null;//退出系统按钮
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	
	ManagerInterface mi=ManagerImpl.getManagerImpl();//得到实现类的实例
	
	public RegisterFrame(){}
	
	public void showReisterFrame(){
		
			frame=new JFrame("欢迎使用银行1.4版本");
			frame.setBounds(500, 160, 460, 480);//设置主窗体的位置
			frame.setLayout(null);
			registerButton=new JButton("注册");
			registerButton.setBounds(100,260,120,36);//设置注册按钮在窗口中显示的位置
			exitButton=new JButton("退出系统");
			exitButton.setBounds(240,260,120,36);//设置退出系统按钮在窗口中显示的位置
			
			lab.setBounds(0, 0, 1660, 680);
			
			usernameLabel=new JLabel("用户名：");
			passwordLabel=new JLabel("密 码：");
			usernameText=new JTextField();
			passwordText=new TextField();
			
			usernameLabel.setBounds(80,80,100,36);
			usernameText.setBounds(200,80,100,36);
			passwordLabel.setBounds(80,150,100,36);
			passwordText.setBounds(200,150,100,36);
			
			
			passwordText.setEchoChar('*');//使得输入密码时显示***
			//将按钮,标签，文本框组件添加到窗体中
			frame.add(registerButton);
			frame.add(exitButton);
			frame.add(usernameLabel);
			frame.add(usernameText);
			frame.add(passwordLabel);
			frame.add(passwordText);
			
			//自定义字体格式， 大小
			Font font=new Font("宋体",1,18);//1表示粗体，18是字体号
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//响应窗口关闭事件
			//将按钮上的字体设置为自定义的字体显示
			registerButton.setFont(font);
			exitButton.setFont(font);
			usernameLabel.setFont(font);
			usernameText.setFont(font);
			passwordLabel.setFont(font);
			passwordText.setFont(font);
			
			//响应注册按钮事件，注册成功后转到登录界面
			registerButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();//主窗口消失
					String username=usernameText.getText();//获取文本款中输入的用户名
					String password=passwordText.getText();//获取文本框中输入的密码
					mi.register(username, password);
					new LoginFrame().showLoginFrame();//显示登录界面
				}
			});
			
			
			//响应退出系统按钮功能
			exitButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();
					System.exit(1);
				}
			});
			
			frame.add(lab);
			frame.setVisible(true);
			
		}
		
	}
