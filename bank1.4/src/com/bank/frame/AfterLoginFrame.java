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
 * 登录后的界面（功能使用界面）
 * @Author DFX
 * @Version 1.3 2017.7.8
 * 
 * */
public class AfterLoginFrame {
	
	private JFrame frame=null;//主窗口
	private JButton depositButton=null;//存款按钮
	private JButton withdrawalsButton=null;//取款按钮
	private JButton transferButton=null;//转账按钮
	private JButton inquryButton=null;//查看余额按钮
	private JButton exitSystemButton=null;//退出系统按钮
	private ImageIcon image=new ImageIcon("image/4.jpg");
	private JLabel lab=new JLabel(image);
	private JMenuBar mb=new JMenuBar();//菜单条
	private JMenu m1=new JMenu("功能操作");//菜单
	private JMenuItem miDeposit=new JMenuItem("存款"); //菜单项
	private JMenuItem miWithDrawals=new JMenuItem("取款");  
	private JMenuItem miTransfer=new JMenuItem("转账");  
	private JMenuItem miInqury=new JMenuItem("查询余额");  
	private JMenuItem miExit=new JMenuItem("退出系统");  
	
	
	public AfterLoginFrame(){}
	public void showAfterLoginFrame(){
		frame=new JFrame("欢迎使用银行项目1.4版本");
		depositButton = new JButton("存款");
		withdrawalsButton =  new JButton("取款");
		transferButton =new JButton("转账");
		inquryButton =new JButton("查询余额");
		exitSystemButton=new JButton("退出系统");
		
		frame.setJMenuBar(mb);
		mb.add(m1);
		m1.add(miDeposit);
		m1.add(miWithDrawals);
		m1.add(miTransfer);
		m1.add(miInqury);
		m1.add(miExit);
		
		Font font =new Font("宋体",1,24);
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
		
		//存款业务操作按钮
		depositButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new DepositFrame().showDepositFrame();
			}
			
		});
		
		//存款业务操作菜单项
		miDeposit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new DepositFrame().showDepositFrame();
			}
			
		});
		
		//取款业务操作按钮
		withdrawalsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new WithdrawalsFrame().showWithdrawalsFrame();
			}
		});
		
		//取款业务操作菜单项
		miWithDrawals.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new WithdrawalsFrame().showWithdrawalsFrame();
			}
		});
		
		//转账业务操作按钮
		transferButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new TransferFrame().showTransferFrame();
			}
		});
		//转账业务操作菜单项
		miTransfer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new TransferFrame().showTransferFrame();
			}
		});
		
		
		//查询余额业务操作按钮
		inquryButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new InquryFrame().showInquryFrame();
			}
		});
		
		//查询余额业务操作菜单项
		miInqury.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new InquryFrame().showInquryFrame();
			}
		});
		
		//退出系统业务操作按钮
		exitSystemButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(1);//结束进程
			}
		});
		//退出系统业务操作菜单项
		miExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(1);//结束进程
			}
		});
		
		frame.add(lab);
		frame.setVisible(true);
	}
	
	
	
}
