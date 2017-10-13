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
 * 取款界面
 * @Author DFX
 * @version 1.3 201.7.8
 * 
 * */
public class WithdrawalsFrame {


	private JFrame frame=null;
	private JButton consumeButton=null;//确定按钮
	private JButton returnButton=null;//返回按钮
	private JLabel withdrawalsNumLabel=null;//取款金额提示显示
	private JTextField withdrawalsNumText=null;//取款金额数据接收
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	ManagerInterface mi=ManagerImpl.getManagerImpl();//得到管理类的实例
	
	public WithdrawalsFrame(){}
	
	public void showWithdrawalsFrame(){
		frame =new JFrame("存款界面");
		consumeButton =new JButton("确定");
		returnButton =new JButton("返回");
		withdrawalsNumLabel=new JLabel("请输入取款金额：");
		withdrawalsNumText=new JTextField();
		
		//设置字体
		Font font=new Font("宋体",1,18);
		consumeButton.setFont(font);
		returnButton.setFont(font);
		withdrawalsNumLabel.setFont(font);
		withdrawalsNumText.setFont(font);
		
		frame.setBounds(500,160,500,450);
		lab.setBounds(0,0,1660,680);
		frame.setLayout(null);
		withdrawalsNumLabel.setBounds(100,100,160,45);
		withdrawalsNumText.setBounds(300,100,80,45);
		consumeButton.setBounds(120,200,80,42);
		returnButton.setBounds(280,200,80,42);
		
		frame.add(withdrawalsNumLabel);
		frame.add(withdrawalsNumText);
		frame.add(consumeButton);
		frame.add(returnButton);
		
		//确定取款界面
		consumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String withdrawalsNum=withdrawalsNumText.getText();
				int withdrawalsNum1=Integer.valueOf(withdrawalsNum);//将string类型数据转换为int类型
				mi.withdrawals(withdrawalsNum1);
				frame.dispose();
				new InquryFrame().showInquryFrame();//取款后显示当前总余额
				
				
			}
		});
		
		//返回到功能选择界面
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AfterLoginFrame().showAfterLoginFrame();
			}
		});
		
		//对取款文本添加焦点事件
		withdrawalsNumText.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e){
				withdrawalsNumText=(JTextField) e.getSource();//拿到事件源
				String deposit2=withdrawalsNumText.getText();
				String regex="[0-9]{0,5}";//定义正则表达式规范，只能是数字，并且不能大于999999
				if(!deposit2.matches(regex)){//如果输入不匹配则不跳转
					withdrawalsNumText.setText("");//清空输入数据
					withdrawalsNumText.requestFocus();//重新获得光标
				}
				
			}
		});
		
		
		frame.add(lab);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args){
	}
}
