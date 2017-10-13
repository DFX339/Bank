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
 * ת�˽���
 * @Author DFX
 * @version 1.3 201.7.8
 * 
 * */
public class TransferFrame {


	private JFrame frame=null;
	private JButton consumeButton=null;//ȷ����ť
	private JButton returnButton=null;//���ذ�ť
	private JLabel transferNumLabel=null;//ת�˽����ʾ��ʾ
	private JTextField transferNumText=null;//ת�˽�����ݽ����ı���
	private JLabel transferNameLabel=null;//ת�˶���������ʾ��ʾ
	private JTextField transferNameText=null;//ת�˶������ƽ����ı���
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	ManagerInterface mi=ManagerImpl.getManagerImpl();//�õ��������ʵ��
	
	public TransferFrame(){}
	
	public void showTransferFrame(){
		frame =new JFrame("ת�˽���");
		consumeButton =new JButton("ȷ��");
		returnButton =new JButton("����");
		transferNumLabel=new JLabel("������ת�˽�");
		transferNumText=new JTextField();
		transferNameLabel=new JLabel("������ת�˶�������");
		transferNameText=new JTextField();
		
		//��������
		Font font=new Font("����",1,18);
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
		
		//ȷ��ת�˽���
		consumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String transferNum=transferNumText.getText();
				double transferNum1=Double.valueOf(transferNum);
				String transferName=transferNameText.getText();
				mi.transfer(transferName,transferNum1);//ʵ��ת��
				frame.dispose();
				new InquryFrame().showInquryFrame();//ת�˺���ʾ��ǰ�����
				
			}
		});
		
		//���ص�����ѡ�����
		returnButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AfterLoginFrame().showAfterLoginFrame();
			}
		});
		
		//��ת�˽���ı���ӽ����¼�
		transferNumText.addFocusListener(new FocusAdapter(){
			public void focusLost(FocusEvent e){
				transferNumText=(JTextField) e.getSource();//�õ��¼�Դ
				String deposit2=transferNumText.getText();
				String regex="[0-9]{0,5}";//����������ʽ�淶��ֻ�������֣����Ҳ��ܴ���999999
				if(!deposit2.matches(regex)){//������벻ƥ������ת
					transferNumText.setText("");//�����������
					transferNumText.requestFocus();//���»�ù��
				}
				
			}
		});
		
		frame.add(lab);
		frame.setVisible(true);
		
	}
	
	
}
