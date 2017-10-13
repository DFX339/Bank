
package com.bank.frame;

import java.awt.Font;
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
 * 查看余额界面
 * @Author DFX
 * @version 1.3 201.7.8
 * 
 * */
public class InquryFrame {


	private JFrame frame=null;
	private JButton returnButton=null;//返回按钮
	private JLabel leftNumLabel=null;//余额显示标签
	private JTextField leftNumText=null;//取款金额数据接收
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	ManagerInterface mi=ManagerImpl.getManagerImpl();//得到管理类的实例
	
	public InquryFrame(){}
	
	public void showInquryFrame(){
		frame =new JFrame("查看余额界面");
		returnButton =new JButton("返回");
		leftNumLabel=new JLabel("您的当前余额为：");
		leftNumText=new JTextField();
		
		//设置字体
		Font font=new Font("宋体",1,18);
		returnButton.setFont(font);
		leftNumLabel.setFont(font);
		leftNumText.setFont(font);
		
		frame.setBounds(500,160,500,450);
		lab.setBounds(0,0,1660,650);
		frame.setLayout(null);
		leftNumLabel.setBounds(100,100,160,45);
		leftNumText.setBounds(300,100,80,45);
		returnButton.setBounds(160,200,80,42);
		
		frame.add(leftNumLabel);
		frame.add(leftNumText);
		frame.add(returnButton);
		
		double leftMoneyNumber=mi.inqury();//调用查询方法
		String leftNum=leftMoneyNumber+"";//将double类型数据变为字符串类型
		leftNumText.setText(leftNum);
		leftNumText.setEditable(false);

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

