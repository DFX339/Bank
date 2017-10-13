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
 * ȡ�����
 * @Author DFX
 * @version 1.3 201.7.8
 * 
 * */
public class WithdrawalsFrame {


	private JFrame frame=null;
	private JButton consumeButton=null;//ȷ����ť
	private JButton returnButton=null;//���ذ�ť
	private JLabel withdrawalsNumLabel=null;//ȡ������ʾ��ʾ
	private JTextField withdrawalsNumText=null;//ȡ�������ݽ���
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	ManagerInterface mi=ManagerImpl.getManagerImpl();//�õ��������ʵ��
	
	public WithdrawalsFrame(){}
	
	public void showWithdrawalsFrame(){
		frame =new JFrame("������");
		consumeButton =new JButton("ȷ��");
		returnButton =new JButton("����");
		withdrawalsNumLabel=new JLabel("������ȡ���");
		withdrawalsNumText=new JTextField();
		
		//��������
		Font font=new Font("����",1,18);
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
		
		//ȷ��ȡ�����
		consumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String withdrawalsNum=withdrawalsNumText.getText();
				int withdrawalsNum1=Integer.valueOf(withdrawalsNum);//��string��������ת��Ϊint����
				mi.withdrawals(withdrawalsNum1);
				frame.dispose();
				new InquryFrame().showInquryFrame();//ȡ�����ʾ��ǰ�����
				
				
			}
		});
		
		//���ص�����ѡ�����
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AfterLoginFrame().showAfterLoginFrame();
			}
		});
		
		//��ȡ���ı���ӽ����¼�
		withdrawalsNumText.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e){
				withdrawalsNumText=(JTextField) e.getSource();//�õ��¼�Դ
				String deposit2=withdrawalsNumText.getText();
				String regex="[0-9]{0,5}";//����������ʽ�淶��ֻ�������֣����Ҳ��ܴ���999999
				if(!deposit2.matches(regex)){//������벻ƥ������ת
					withdrawalsNumText.setText("");//�����������
					withdrawalsNumText.requestFocus();//���»�ù��
				}
				
			}
		});
		
		
		frame.add(lab);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args){
	}
}
