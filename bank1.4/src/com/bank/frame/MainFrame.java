package com.bank.frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * ��������ʾ����
 * ��¼֮ǰ�Ĵ���
 * @author DFX
 * @version 1.3 2017/06/20
 */
public class MainFrame {
	private JFrame frame=null;//������
	private JButton registerButton=null;//ע�ᰴť
	private JButton loginButton=null;//��¼��ť
	private JButton exitButton=null;//�˳�ϵͳ��ť
	private ImageIcon image=new ImageIcon("image/4.jpg");
	private JLabel lab=new JLabel(image);
	private JLabel labTitle=new JLabel("��ӭʹ��������Ŀ1.4�汾");
	private JMenuBar mb=new JMenuBar();//�˵���
	private JMenu m1=new JMenu("���ܲ���");//�˵�
	private JMenuItem miRegist=new JMenuItem("ע��");  
	private JMenuItem miLogin=new JMenuItem("��¼");  
	private JMenuItem miExit=new JMenuItem("�˳�ϵͳ");  
	
	public void showMainFrame(){
		frame=new JFrame("������Ŀ1.4�汾������");
		frame.setBounds(500, 160, 520, 500);//�����������λ��
		frame.setLayout(null);
		registerButton=new JButton("ע��");
		registerButton.setBounds(190,150,120,36);//����ע�ᰴť�ڴ�������ʾ��λ��
		loginButton = new JButton("��¼");
		loginButton.setBounds(190,225,120,36);//���õ�¼��ť�ڴ�������ʾ��λ��
		exitButton=new JButton("�˳�ϵͳ");
		exitButton.setBounds(190,300,120,36);//�����˳�ϵͳ��ť�ڴ�������ʾ��λ��
		lab.setBounds(0, 0, 630, 760);
		labTitle.setBounds(60,36,390,48);
		
		//����ť�����ӵ�������
		frame.add(labTitle);
		frame.add(registerButton);
		frame.add(loginButton);
		frame.add(exitButton);
		frame.setJMenuBar(mb);//���˵�����ӵ������
		mb.add(m1);//���˵���ӵ��˵�����
		m1.add(miRegist);
		m1.add(miLogin);
		m1.add(miExit);
		
		
		//�Զ��������ʽ�� ��С
		Font font=new Font("����",1,18);//1��ʾ���壬18�������
		Font font1=new Font("����",1,29);//1��ʾ���壬18�������
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��Ӧ���ڹر��¼�
		//����ť�ϵ���������Ϊ�Զ����������ʾ
		registerButton.setFont(font);
		loginButton.setFont(font);
		exitButton.setFont(font);
		labTitle.setFont(font1);
		miRegist.setFont(font);
		miLogin.setFont(font);
		miExit.setFont(font);
		m1.setFont(font);
		
		//��Ӧע�ᰴť�¼�������ע�����
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();//��������ʧ
				new RegisterFrame().showReisterFrame();//��ʾע�����
			}
		});
		
		//��Ӧ��¼��ť�¼���������¼����
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();//��������ʧ
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
		
		//��Ӧ�˵���ע�Ṧ�ܣ���ת��ע�����
		miRegist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();//��������ʧ
				new RegisterFrame().showReisterFrame();//��ʾע�����
			}
		});
		
		//��Ӧ��¼�˵��¼���������¼����
		miLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();//��������ʧ
				new LoginFrame().showLoginFrame();//��ʾ��¼����
			}
		});
		
		//��Ӧ�˵����˳�ϵͳ����
		miExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(1);
			}
		});
		
		frame.setLayout(null);
		frame.add(lab);
		frame.setVisible(true);
		
	}
	
	
	
	public static void main(String[] args) {
		
		MainFrame mainFrame=new MainFrame();
		mainFrame.showMainFrame();
	}

}
