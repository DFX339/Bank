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
 * ע����洰��
 * @author DFX
 * @version 1.3 2017/06/20
 * 
 * */
public class RegisterFrame {
	private JFrame frame=null;//������
	private JLabel usernameLabel=null;//��ʾ�û������û����ı�ǩ
	private JLabel passwordLabel=null;//��ʾ�û���������ı�ǩ
	private JTextField usernameText=null;//�û��������
	private TextField passwordText=null;//���������
	private JButton registerButton=null;//ע�ᰴť
	private JButton exitButton=null;//�˳�ϵͳ��ť
	private ImageIcon image=new ImageIcon("image/b.jpg");
	private JLabel lab=new JLabel(image);

	
	ManagerInterface mi=ManagerImpl.getManagerImpl();//�õ�ʵ�����ʵ��
	
	public RegisterFrame(){}
	
	public void showReisterFrame(){
		
			frame=new JFrame("��ӭʹ������1.4�汾");
			frame.setBounds(500, 160, 460, 480);//�����������λ��
			frame.setLayout(null);
			registerButton=new JButton("ע��");
			registerButton.setBounds(100,260,120,36);//����ע�ᰴť�ڴ�������ʾ��λ��
			exitButton=new JButton("�˳�ϵͳ");
			exitButton.setBounds(240,260,120,36);//�����˳�ϵͳ��ť�ڴ�������ʾ��λ��
			
			lab.setBounds(0, 0, 1660, 680);
			
			usernameLabel=new JLabel("�û�����");
			passwordLabel=new JLabel("�� �룺");
			usernameText=new JTextField();
			passwordText=new TextField();
			
			usernameLabel.setBounds(80,80,100,36);
			usernameText.setBounds(200,80,100,36);
			passwordLabel.setBounds(80,150,100,36);
			passwordText.setBounds(200,150,100,36);
			
			
			passwordText.setEchoChar('*');//ʹ����������ʱ��ʾ***
			//����ť,��ǩ���ı��������ӵ�������
			frame.add(registerButton);
			frame.add(exitButton);
			frame.add(usernameLabel);
			frame.add(usernameText);
			frame.add(passwordLabel);
			frame.add(passwordText);
			
			//�Զ��������ʽ�� ��С
			Font font=new Font("����",1,18);//1��ʾ���壬18�������
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��Ӧ���ڹر��¼�
			//����ť�ϵ���������Ϊ�Զ����������ʾ
			registerButton.setFont(font);
			exitButton.setFont(font);
			usernameLabel.setFont(font);
			usernameText.setFont(font);
			passwordLabel.setFont(font);
			passwordText.setFont(font);
			
			//��Ӧע�ᰴť�¼���ע��ɹ���ת����¼����
			registerButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					frame.dispose();//��������ʧ
					String username=usernameText.getText();//��ȡ�ı�����������û���
					String password=passwordText.getText();//��ȡ�ı��������������
					mi.register(username, password);
					new LoginFrame().showLoginFrame();//��ʾ��¼����
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
