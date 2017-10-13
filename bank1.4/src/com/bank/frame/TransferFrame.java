package com.bank.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.bank.manager.ManagerImpl;
import com.bank.manager.ManagerInterface;

/**
 * 转账界面
 * @Author DFX
 * @version 1.3 201.7.8
 * 
 * */
public class TransferFrame {


	private JFrame frame=null;
	private JButton consumeButton=null;//确定按钮
	private JButton returnButton=null;//返回按钮
	private JLabel transferNumLabel=null;//转账金额提示显示
	private JTextField transferNumText=null;//转账金额数据接收文本框
	private JLabel transferNameLabel=null;//转账对象名称提示显示
	private JTextField transferNameText=null;//转账对象名称接收文本框
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	ManagerInterface mi=ManagerImpl.getManagerImpl();//得到管理类的实例
	
	public TransferFrame(){}
	
	public void showTransferFrame(){
		frame =new JFrame("转账界面");
		consumeButton =new JButton("确定");
		returnButton =new JButton("返回");
		transferNumLabel=new JLabel("请输入转账金额：");
		transferNumText=new JTextField();
		transferNameLabel=new JLabel("请输入转账对象名：");
		transferNameText=new JTextField();
		
		//设置字体
		Font font=new Font("宋体",1,18);
		consumeButton.setFont(font);
		returnButton.setFont(font);
		transferNumLabel.setFont(font);
		transferNumText.setFont(font);
		transferNameLabel.setFont(font);
		transferNameText.setFont(font);
		
		frame.setBounds(500,160,500,450);
		lab.setBounds(0,0,1660,680);
		frame.setLayout(null);
		transferNameLabel.setBounds(100,100,200,45);
		transferNameText.setBounds(330,100,80,45);
		
		transferNumLabel.setBounds(100,180,200,45);
		transferNumText.setBounds(330,180,80,45);
		consumeButton.setBounds(120,260,80,42);
		returnButton.setBounds(280,260,80,42);
		
		frame.add(transferNumLabel);
		frame.add(transferNameLabel);
		frame.add(transferNumText);
		frame.add(transferNameText);
		frame.add(consumeButton);
		frame.add(returnButton);
		
		//确定转账界面
		consumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String transferNum=transferNumText.getText();
				double transferNum1=Double.valueOf(transferNum);
				String transferName=transferNameText.getText();
				mi.transfer(transferName,transferNum1);//实现转账
				frame.dispose();
				new InquryFrame().showInquryFrame();//转账后显示当前总余额
				
			}
		});
		
		//返回到功能选择界面
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AfterLoginFrame().showAfterLoginFrame();
			}
		});
		
		//对转账金额文本添加焦点事件
		transferNumText.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e){
				transferNumText=(JTextField) e.getSource();//拿到事件源
				String deposit2=transferNumText.getText();
				String regex="[0-9]{0,5}";//定义正则表达式规范，只能是数字，并且不能大于999999
				if(!deposit2.matches(regex)){//如果输入不匹配则不跳转
					transferNumText.setText("");//清空输入数据
					transferNumText.requestFocus();//重新获得光标
				}
				
			}
		});
		
		frame.add(lab);
		frame.setVisible(true);
		
	}
	
	
}
