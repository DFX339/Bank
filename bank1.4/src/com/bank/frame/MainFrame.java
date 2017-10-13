package com.bank.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * 主窗口显示界面
 * 登录之前的窗口
 * @author DFX
 * @version 1.3 2017/06/20
 */
public class MainFrame {
	private JFrame frame=null;//主窗口
	private JButton registerButton=null;//注册按钮
	private JButton loginButton=null;//登录按钮
	private JButton exitButton=null;//退出系统按钮
	private ImageIcon image=new ImageIcon("image/4.jpg");
	private JLabel lab=new JLabel(image);
	private JLabel labTitle=new JLabel("欢迎使用银行项目1.4版本");
	private JMenuBar mb=new JMenuBar();//菜单条
	private JMenu m1=new JMenu("功能操作");//菜单
	private JMenuItem miRegist=new JMenuItem("注册");  
	private JMenuItem miLogin=new JMenuItem("登录");  
	private JMenuItem miExit=new JMenuItem("退出系统");  
	
	public void showMainFrame(){
		frame=new JFrame("银行项目1.4版本主界面");
		frame.setBounds(500, 160, 520, 500);//设置主窗体的位置
		frame.setLayout(null);
		registerButton=new JButton("注册");
		registerButton.setBounds(190,150,120,36);//设置注册按钮在窗口中显示的位置
		loginButton = new JButton("登录");
		loginButton.setBounds(190,225,120,36);//设置登录按钮在窗口中显示的位置
		exitButton=new JButton("退出系统");
		exitButton.setBounds(190,300,120,36);//设置退出系统按钮在窗口中显示的位置
		lab.setBounds(0, 0, 630, 760);
		labTitle.setBounds(60,36,390,48);
		
		//将按钮组件添加到窗体中
		frame.add(labTitle);
		frame.add(registerButton);
		frame.add(loginButton);
		frame.add(exitButton);
		frame.setJMenuBar(mb);//将菜单条添加到框架中
		mb.add(m1);//将菜单添加到菜单条中
		m1.add(miRegist);
		m1.add(miLogin);
		m1.add(miExit);
		
		
		//自定义字体格式， 大小
		Font font=new Font("宋体",1,18);//1表示粗体，18是字体号
		Font font1=new Font("宋体",1,29);//1表示粗体，18是字体号
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//响应窗口关闭事件
		//将按钮上的字体设置为自定义的字体显示
		registerButton.setFont(font);
		loginButton.setFont(font);
		exitButton.setFont(font);
		labTitle.setFont(font1);
		miRegist.setFont(font);
		miLogin.setFont(font);
		miExit.setFont(font);
		m1.setFont(font);
		
		//响应注册按钮事件，调到注册界面
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();//主窗口消失
				new RegisterFrame().showReisterFrame();//显示注册界面
			}
		});
		
		//响应登录按钮事件，调到登录界面
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();//主窗口消失
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
		
		//响应菜单项注册功能，跳转到注册界面
		miRegist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();//主窗口消失
				new RegisterFrame().showReisterFrame();//显示注册界面
			}
		});
		
		//响应登录菜单事件，调到登录界面
		miLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();//主窗口消失
				new LoginFrame().showLoginFrame();//显示登录界面
			}
		});
		
		//响应菜单项退出系统功能
		miExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(1);
			}
		});
		
		frame.setLayout(null);
		frame.add(lab);
		frame.setVisible(true);
		
	}
	
	
	
	public static void main(String[] args) {
		
		MainFrame mainFrame=new MainFrame();
		mainFrame.showMainFrame();
	}

}
