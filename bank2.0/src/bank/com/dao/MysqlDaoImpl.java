package bank.com.dao;
/**
 * 将数据存储到mysql数据库中
 * 使用mysql数据库完成对银行业务的操作
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
	 * 登录方法的实现
	 * param: User 登录的用户
	 * return :boolean 登录成功返回true，不成功返回false
	 * */
	public User login(User user)  {
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from bankuser where username=? and password=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			rs=ps.executeQuery();//执行查询语句
			while(rs.next()){
				User user1=new User();
				user1.setID(rs.getString("ID"));//将查询结果存入当前user对象中
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
	 * 注册方法的实现
	 * param: User 注册的用户
	 * return :boolean 注册成功返回true，不成功返回false
	 * 
	 * 注册前先判断用户是否存在，不存在再注册
	 * */
	public boolean regist(User user) {
		boolean flag=false;//标记， true：表示注册成功，false：表示注册失败
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from bankuser where username=? and password=?";//先从数据库中查找该用户是否已经存在
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			rs=ps.executeQuery();
			if(rs.next()){
				flag=false;
			}else{//不存在时才能完成注册
				String sql1="insert into bankuser(username,password,money) values(?,?,?)";
				ps=conn.prepareStatement(sql1);
				ps.setString(1,user.getUsername());
				ps.setString(2,user.getPassword());
				ps.setDouble(3,user.getMoney());
				ps.executeUpdate();//完成用户注册
				
				//注册成功后，通过查询，找出用户信息，将用户信息存入user对象中
				String sql2="select * from bankuser where username=? and password=? ";
				ps=conn.prepareStatement(sql2);
				ps.setString(1,user.getUsername());
				ps.setString(2,user.getPassword());
				rs=ps.executeQuery();//执行查询语句
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
	 * 存款操作
	 * 存款后返回当前余额
	 * 
	 * */
	public double deposit(double money,String id) {
		try {
			double leftMoney=this.inqury(id);//先查询出当前余额
			conn=JdbcUtils.getConnection();
			String sql="update bankuser set money=? where ID=?";
			ps=conn.prepareStatement(sql);
			money=money+leftMoney;//余额+当前存款金额
			ps.setDouble(1,money);
			ps.setString(2, id);//当前登录用户ID
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
		return money;
	}
	
	/**
	 * 查看当前余额
	 * @throws SQLException 
	 * 
	 * */
	public double inqury(String id)  {
		double mon=0;
		try {
			conn=JdbcUtils.getConnection();
			String sql="select money from bankuser where ID=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);//user.getID()获取当前登录用户的ID
			rs=ps.executeQuery();
			while(rs.next()){
				mon=new Double(rs.getString("money"));//拿到查询结果中的余额
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.free(conn, ps, rs);
		}
			return mon;
		
	}

	
	/*
	 * 转账操作
	 * 获取对方ID 判断此用户是否存在 存在才能转账，失败不能转账
	 * 获取自己的金额，判断与转账金额大小 ，大于才能转账，小于不能转账
	 * 
	 * 返回自己当前转账之后的余额
	 * */
	public double transfer(String ID, double money,String id) {
		double num=0;//接收当前用户当前余额
		double num1=0;//用来接收被转账用户的余额
		boolean flag=false;//用来标记用户是否存在，存在为true，不存在为false
		try {
			conn=JdbcUtils.getConnection();
			String sql="select * from bankuser where ID=?";//先查询ID是否存在
			ps=conn.prepareStatement(sql);
			ps.setString(1, ID);
			rs=ps.executeQuery();
			while(rs.next()){//查询结果不为null，表示用户存在时
				flag=true;
			}
			
			if(flag){//用户存在开始判断转账
				num=this.inqury(id);//查询当前用户的当前余额
				if(num>=money){//余额大于转账数的时候才能开始转账
					conn=JdbcUtils.getConnection();
					String sql1="select money from bankuser where ID=?";
					ps=conn.prepareStatement(sql1);
					ps.setString(1, ID);//ID 被转账用户的ID
					rs=ps.executeQuery();
					while(rs.next()){
						num1=new Double(rs.getString("money"));//拿到查询结果中的余额
					}
					
					String sql2="update bankuser set money=? where ID=?";//往被转账用户中添加money
					ps=conn.prepareStatement(sql2);
					num1=num1+money;//余额+转账数
					ps.setDouble(1,num1);
					ps.setString(2, ID);
					ps.executeUpdate();
					
					String sql3="update bankuser set money=? where ID=?";//当前用户money减少
					num=num-money;//转账结束后，当前用户的当前余额
					ps=conn.prepareStatement(sql3);
					ps.setDouble(1,num);
					ps.setString(2, id);//得到当前用户的ID
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
	 * 取款业务
	 * 先判断卡上余额是否大于取款数目
	 * 大于才能正常取款，小于则无法取款
	 * 
	 * 取完之后显示余额
	 * */
	public double withdrawal(double money,String id) {
		double num=0;
		try {
			num=this.inqury(id);//查询当前用户的当前余额
			if(num>=money){//判断当前余额和取款数的大小
				num=num-money;//转账结束后，当前用户的当前余额减少
				conn=JdbcUtils.getConnection();
				String sql="update bankuser set money=? where ID=?";//修改当前用户的money值
				ps=conn.prepareStatement(sql);
				ps.setDouble(1,num);//将取款后的money值设到用户账号中
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
