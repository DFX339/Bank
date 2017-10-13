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
 * ��¼���洰��
 * @author DFX
 * @version 1.3 2017/06/20
 * 
 * */
public class LoginFrame {
	
	private JFrame frame=new JFrame("��ӭʹ��������Ŀ1.4�汾");//������
	private JLabel usernameLabel=null;//��ʾ�û������û����ı�ǩ
	private JLabel passwordLabel=null;//��ʾ�û���������ı�ǩ
	private JTextField usernameText=null;//�û��������
	private TextField passwordText=null;//���������
	private JButton loginButton=null;//��¼��ť
	private JButton exitButton=null;//�˳�ϵͳ��ť
	private ImageIcon image=new ImageIcon("image/uu.jpg");
	private JLabel lab=new JLabel(image);
	
	
	ManagerInterface mi=ManagerImpl.getManagerImpl();//�õ��������ʵ��
	
	public LoginFrame(){}
	
	public void showLoginFrame(){
		frame.setBounds(500, 160, 460, 480);//�����������λ��
		frame.setLayout(null);
		loginButton=new JButton("��¼");
		loginButton.setBounds(80,260,150,36);//����ע�ᰴť�ڴ�������ʾ��λ��
		exitButton=new JButton("�˳�ϵͳ");
		exitButton.setBounds(270,260,150,36);//�����˳�ϵͳ��ť�ڴ�������ʾ��λ��
		
		usernameLabel=new JLabel("�û�����");
		passwordLabel=new JLabel("�� �룺");
		usernameText=new JTextField();
		passwordText=new TextField();
		
		usernameLabel.setBounds(80,80,100,36);
		usernameText.setBounds(200,80,100,36);
		passwordLabel.setBounds(80,150,100,36);
		passwordText.setBounds(200,150,100,36);
		
		lab.setBounds(0,0,460,480);
		passwordText.setEchoChar('*');//ʹ�����������
		
		
		//����ť,��ǩ���ı��������ӵ�������
		frame.add(loginButton);
		frame.add(exitButton);
		frame.add(usernameLabel);
		frame.add(usernameText);
		frame.add(passwordLabel);
		frame.add(passwordText);
		
		//�Զ��������ʽ�� ��С
		Font font=new Font("����",1,24);//1��ʾ���壬18�������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��Ӧ���ڹر��¼�
		//����ť�ϵ���������Ϊ�Զ����������ʾ
		loginButton.setFont(font);
		exitButton.setFont(font);
		usernameLabel.setFont(font);
		usernameText.setFont(font);
		passwordLabel.setFont(font);
		passwordText.setFont(font);
		
		//��Ӧ��¼��ť�¼���������¼��Ľ���
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String username=usernameText.getText();
				String password=passwordText.getText();
				mi.login(username, password);
				frame.dispose();//��������ʧ
				new AfterLoginFrame().showAfterLoginFrame();
			}
		});
		
		
		//��Ӧ�˳�ϵͳ��ť����
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
