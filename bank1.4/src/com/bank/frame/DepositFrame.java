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
 * 存款界面
 * @Author DFX
 * @version 1.3 201.7.8
 * 
 * */
public class DepositFrame {
	private JFrame frame=null;
	private JButton consumeButton=null;//确定按钮
	private JButton returnButton=null;//返回按钮
	private JLabel depositNumLabel=null;//存款金额提示显示
	private JTextField depositNumText=null;//存款金额数据接收
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	ManagerInterface mi=ManagerImpl.getManagerImpl();//得到管理类的实例
	
	public DepositFrame(){}
	
	public void showDepositFrame(){
		frame =new JFrame("存款界面");
		consumeButton =new JButton("确定");
		returnButton =new JButton("返回");
		depositNumLabel=new JLabel("请输入存款金额：");
		depositNumText=new JTextField();
		
		//设置字体
		Font font=new Font("宋体",1,18);
		consumeButton.setFont(font);
		returnButton.setFont(font);
		depositNumLabel.setFont(font);
		depositNumText.setFont(font);
		
		frame.setBounds(500,160,500,450);
		lab.setBounds(0,0,1660,590);
		frame.setLayout(null);
		depositNumLabel.setBounds(100,100,160,45);
		depositNumText.setBounds(300,100,80,45);
		consumeButton.setBounds(120,200,80,42);
		returnButton.setBounds(280,200,80,42);
		
		frame.add(depositNumLabel);
		frame.add(depositNumText);
		frame.add(consumeButton);
		frame.add(returnButton);
		
		//确定存款界面
		consumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String depositNum=depositNumText.getText();
				int depositNum1=Integer.valueOf(depositNum);//将string类型数据转换为int类型
				mi.deposit(depositNum1);
				frame.dispose();
				new InquryFrame().showInquryFrame();//存款后显示当前总余额
				
				
			}
		});
		
		//对文本添加焦点事件
		depositNumText.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e){
				depositNumText=(JTextField) e.getSource();//拿到事件源
				String deposit2=depositNumText.getText();
				String regex="[0-9]{0,5}";//定义正则表达式规范，只能是数字，并且不能大于999999
				if(!deposit2.matches(regex)){//如果输入不匹配则不跳转
					depositNumText.setText("");//清空输入数据
					depositNumText.requestFocus();//重新获得光标
				}
				
			}
		});
		
		//返回到功能选择界面
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AfterLoginFrame().showAfterLoginFrame();
			}
		});
		
		frame.add(lab);
		frame.setVisible(true);
		
	}
	
	
}
