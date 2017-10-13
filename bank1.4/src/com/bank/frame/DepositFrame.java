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
 * ������
 * @Author DFX
 * @version 1.3 201.7.8
 * 
 * */
public class DepositFrame {
	private JFrame frame=null;
	private JButton consumeButton=null;//ȷ����ť
	private JButton returnButton=null;//���ذ�ť
	private JLabel depositNumLabel=null;//�������ʾ��ʾ
	private JTextField depositNumText=null;//��������ݽ���
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	ManagerInterface mi=ManagerImpl.getManagerImpl();//�õ��������ʵ��
	
	public DepositFrame(){}
	
	public void showDepositFrame(){
		frame =new JFrame("������");
		consumeButton =new JButton("ȷ��");
		returnButton =new JButton("����");
		depositNumLabel=new JLabel("���������");
		depositNumText=new JTextField();
		
		//��������
		Font font=new Font("����",1,18);
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
		
		//ȷ��������
		consumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String depositNum=depositNumText.getText();
				int depositNum1=Integer.valueOf(depositNum);//��string��������ת��Ϊint����
				mi.deposit(depositNum1);
				frame.dispose();
				new InquryFrame().showInquryFrame();//������ʾ��ǰ�����
				
				
			}
		});
		
		//���ı���ӽ����¼�
		depositNumText.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e){
				depositNumText=(JTextField) e.getSource();//�õ��¼�Դ
				String deposit2=depositNumText.getText();
				String regex="[0-9]{0,5}";//����������ʽ�淶��ֻ�������֣����Ҳ��ܴ���999999
				if(!deposit2.matches(regex)){//������벻ƥ������ת
					depositNumText.setText("");//�����������
					depositNumText.requestFocus();//���»�ù��
				}
				
			}
		});
		
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
