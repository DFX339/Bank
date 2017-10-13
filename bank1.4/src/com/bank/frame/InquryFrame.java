
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
 * �鿴������
 * @Author DFX
 * @version 1.3 201.7.8
 * 
 * */
public class InquryFrame {


	private JFrame frame=null;
	private JButton returnButton=null;//���ذ�ť
	private JLabel leftNumLabel=null;//�����ʾ��ǩ
	private JTextField leftNumText=null;//ȡ�������ݽ���
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	ManagerInterface mi=ManagerImpl.getManagerImpl();//�õ��������ʵ��
	
	public InquryFrame(){}
	
	public void showInquryFrame(){
		frame =new JFrame("�鿴������");
		returnButton =new JButton("����");
		leftNumLabel=new JLabel("���ĵ�ǰ���Ϊ��");
		leftNumText=new JTextField();
		
		//��������
		Font font=new Font("����",1,18);
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
		
		double leftMoneyNumber=mi.inqury();//���ò�ѯ����
		String leftNum=leftMoneyNumber+"";//��double�������ݱ�Ϊ�ַ�������
		leftNumText.setText(leftNum);
		leftNumText.setEditable(false);

		//���ص�����ѡ�����
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

