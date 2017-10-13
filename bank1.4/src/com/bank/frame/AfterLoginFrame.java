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
 * ��¼��Ľ��棨����ʹ�ý��棩
 * @Author DFX
 * @Version 1.3 2017.7.8
 * 
 * */
public class AfterLoginFrame {
	
	private JFrame frame=null;//������
	private JButton depositButton=null;//��ť
	private JButton withdrawalsButton=null;//ȡ�ť
	private JButton transferButton=null;//ת�˰�ť
	private JButton inquryButton=null;//�鿴��ť
	private JButton exitSystemButton=null;//�˳�ϵͳ��ť
	private ImageIcon image=new ImageIcon("image/4.jpg");
	private JLabel lab=new JLabel(image);
	private JMenuBar mb=new JMenuBar();//�˵���
	private JMenu m1=new JMenu("���ܲ���");//�˵�
	private JMenuItem miDeposit=new JMenuItem("���"); //�˵���
	private JMenuItem miWithDrawals=new JMenuItem("ȡ��");  
	private JMenuItem miTransfer=new JMenuItem("ת��");  
	private JMenuItem miInqury=new JMenuItem("��ѯ���");  
	private JMenuItem miExit=new JMenuItem("�˳�ϵͳ");  
	
	
	public AfterLoginFrame(){}
	public void showAfterLoginFrame(){
		frame=new JFrame("��ӭʹ��������Ŀ1.4�汾");
		depositButton = new JButton("���");
		withdrawalsButton =  new JButton("ȡ��");
		transferButton =new JButton("ת��");
		inquryButton =new JButton("��ѯ���");
		exitSystemButton=new JButton("�˳�ϵͳ");
		
		frame.setJMenuBar(mb);
		mb.add(m1);
		m1.add(miDeposit);
		m1.add(miWithDrawals);
		m1.add(miTransfer);
		m1.add(miInqury);
		m1.add(miExit);
		
		Font font =new Font("����",1,24);
		m1.setFont(font);
		miDeposit.setFont(font);
		miWithDrawals.setFont(font);
		miTransfer.setFont(font);
		miInqury.setFont(font);
		miExit.setFont(font);
		depositButton.setFont(font);
		withdrawalsButton.setFont(font);
		transferButton.setFont(font);
		inquryButton.setFont(font);
		exitSystemButton.setFont(font);
		
		frame.setBounds(500,100,550,600);
		lab.setBounds(0,0,720,880);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		depositButton.setBounds(78,50,160,45);
		withdrawalsButton.setBounds(78,140,160,45);
		transferButton.setBounds(78,230,160,45);
		inquryButton.setBounds(78,320,160,45);
		exitSystemButton.setBounds(78,410,160,45);
		
		frame.add(depositButton);
		frame.add(withdrawalsButton);
		frame.add(transferButton);
		frame.add(inquryButton);
		frame.add(exitSystemButton);
		
		//���ҵ�������ť
		depositButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new DepositFrame().showDepositFrame();
			}
			
		});
		
		//���ҵ������˵���
		miDeposit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new DepositFrame().showDepositFrame();
			}
			
		});
		
		//ȡ��ҵ�������ť
		withdrawalsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new WithdrawalsFrame().showWithdrawalsFrame();
			}
		});
		
		//ȡ��ҵ������˵���
		miWithDrawals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new WithdrawalsFrame().showWithdrawalsFrame();
			}
		});
		
		//ת��ҵ�������ť
		transferButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new TransferFrame().showTransferFrame();
			}
		});
		//ת��ҵ������˵���
		miTransfer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new TransferFrame().showTransferFrame();
			}
		});
		
		
		//��ѯ���ҵ�������ť
		inquryButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new InquryFrame().showInquryFrame();
			}
		});
		
		//��ѯ���ҵ������˵���
		miInqury.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new InquryFrame().showInquryFrame();
			}
		});
		
		//�˳�ϵͳҵ�������ť
		exitSystemButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(1);//��������
			}
		});
		//�˳�ϵͳҵ������˵���
		miExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(1);//��������
			}
		});
		
		frame.add(lab);
		frame.setVisible(true);
	}
	
	
	
}
