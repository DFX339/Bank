package bank.com.dao;
/**
 * �����ݴ洢��mysql���ݿ���
 * ʹ��mysql���ݿ���ɶ�����ҵ��Ĳ���
 * 
 * @author DFX
 * @Version 2.0 2017/07/27
 * 
 * */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.com.bean.User;
import bank.com.util.JdbcUtils;

public class MysqlDaoImpl implements DaoInterface {
	
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	JdbcUtils mu=new JdbcUtils();
	
	public MysqlDaoImpl(){
	}
	
	/*
	 * ��¼������ʵ��
	 * param: User ��¼���û�
	 * return :boolean ��¼�ɹ�����true�����ɹ�����false
	 * */
	public User login(User user)  {
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from bankuser where username=? and password=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			rs=ps.executeQuery();//ִ�в�ѯ���
			while(rs.next()){
				User user1=new User();
				user1.setID(rs.getString("ID"));//����ѯ������뵱ǰuser������
				user1.setUsername(rs.getString("username"));
				user1.setPassword(rs.getString("password"));
				user1.setMoney(rs.getDouble("money"));
				return user1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
		
		return null;
	}
	
	/*
	 * ע�᷽����ʵ��
	 * param: User ע����û�
	 * return :boolean ע��ɹ�����true�����ɹ�����false
	 * 
	 * ע��ǰ���ж��û��Ƿ���ڣ���������ע��
	 * */
	public boolean regist(User user) {
		boolean flag=false;//��ǣ� true����ʾע��ɹ���false����ʾע��ʧ��
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from bankuser where username=? and password=?";//�ȴ����ݿ��в��Ҹ��û��Ƿ��Ѿ�����
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			if(rs.next()){
				flag=false;
			}else{//������ʱ�������ע��
				String sql1="insert into bankuser(username,password,money) values(?,?,?)";
				ps=conn.prepareStatement(sql1);
				ps.setString(1,user.getUsername());
				ps.setString(2,user.getPassword());
				ps.setDouble(3,user.getMoney());
				ps.executeUpdate();//����û�ע��
				
				//ע��ɹ���ͨ����ѯ���ҳ��û���Ϣ�����û���Ϣ����user������
				String sql2="select * from bankuser where username=? and password=? ";
				ps=conn.prepareStatement(sql2);
				ps.setString(1,user.getUsername());
				ps.setString(2,user.getPassword());
				rs=ps.executeQuery();//ִ�в�ѯ���
				while(rs.next()){
					flag=true;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
		return flag;
	}
	
	/**
	 * ������
	 * ���󷵻ص�ǰ���
	 * 
	 * */
	public double deposit(double money,String id) {
		try {
			double leftMoney=this.inqury(id);//�Ȳ�ѯ����ǰ���
			conn=JdbcUtils.getConnection();
			String sql="update bankuser set money=? where ID=?";
			ps=conn.prepareStatement(sql);
			money=money+leftMoney;//���+��ǰ�����
			ps.setDouble(1,money);
			ps.setString(2, id);//��ǰ��¼�û�ID
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
		return money;
	}
	
	/**
	 * �鿴��ǰ���
	 * @throws SQLException 
	 * 
	 * */
	public double inqury(String id)  {
		double mon=0;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select money from bankuser where ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);//user.getID()��ȡ��ǰ��¼�û���ID
			rs=ps.executeQuery();
			while(rs.next()){
				mon=new Double(rs.getString("money"));//�õ���ѯ����е����
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
			return mon;
		
	}

	
	/*
	 * ת�˲���
	 * ��ȡ�Է�ID �жϴ��û��Ƿ���� ���ڲ���ת�ˣ�ʧ�ܲ���ת��
	 * ��ȡ�Լ��Ľ��ж���ת�˽���С �����ڲ���ת�ˣ�С�ڲ���ת��
	 * 
	 * �����Լ���ǰת��֮������
	 * */
	public double transfer(String ID, double money,String id) {
		double num=0;//���յ�ǰ�û���ǰ���
		double num1=0;//�������ձ�ת���û������
		boolean flag=false;//��������û��Ƿ���ڣ�����Ϊtrue��������Ϊfalse
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from bankuser where ID=?";//�Ȳ�ѯID�Ƿ����
			ps=conn.prepareStatement(sql);
			ps.setString(1, ID);
			rs=ps.executeQuery();
			while(rs.next()){//��ѯ�����Ϊnull����ʾ�û�����ʱ
				flag=true;
			}
			
			if(flag){//�û����ڿ�ʼ�ж�ת��
				num=this.inqury(id);//��ѯ��ǰ�û��ĵ�ǰ���
				if(num>=money){//������ת������ʱ����ܿ�ʼת��
					conn=JdbcUtils.getConnection();
					String sql1="select money from bankuser where ID=?";
					ps=conn.prepareStatement(sql1);
					ps.setString(1, ID);//ID ��ת���û���ID
					rs=ps.executeQuery();
					while(rs.next()){
						num1=new Double(rs.getString("money"));//�õ���ѯ����е����
					}
					
					String sql2="update bankuser set money=? where ID=?";//����ת���û������money
					ps=conn.prepareStatement(sql2);
					num1=num1+money;//���+ת����
					ps.setDouble(1,num1);
					ps.setString(2, ID);
					ps.executeUpdate();
					
					String sql3="update bankuser set money=? where ID=?";//��ǰ�û�money����
					num=num-money;//ת�˽����󣬵�ǰ�û��ĵ�ǰ���
					ps=conn.prepareStatement(sql3);
					ps.setDouble(1,num);
					ps.setString(2, id);//�õ���ǰ�û���ID
					ps.executeUpdate();
			
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
		return num;
	}

	/*
	 * 
	 * ȡ��ҵ��
	 * ���жϿ�������Ƿ����ȡ����Ŀ
	 * ���ڲ�������ȡ�С�����޷�ȡ��
	 * 
	 * ȡ��֮����ʾ���
	 * */
	public double withdrawal(double money,String id) {
		double num=0;
		try {
			num=this.inqury(id);//��ѯ��ǰ�û��ĵ�ǰ���
			if(num>=money){//�жϵ�ǰ����ȡ�����Ĵ�С
				num=num-money;//ת�˽����󣬵�ǰ�û��ĵ�ǰ������
				conn=JdbcUtils.getConnection();
				String sql="update bankuser set money=? where ID=?";//�޸ĵ�ǰ�û���moneyֵ
				ps=conn.prepareStatement(sql);
				ps.setDouble(1,num);//��ȡ����moneyֵ�赽�û��˺���
				ps.setString(2,id);
				ps.executeUpdate();
			
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
		return num;
	}

	
}
