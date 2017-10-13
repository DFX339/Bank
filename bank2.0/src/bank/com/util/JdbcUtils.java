package bank.com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 用来连接数据库的工具类
 * 
 * @author DFX
 * @version 2.0 2017/07/27
 * 
 * */
public class JdbcUtils {
	
	static ReadProps rp=new ReadProps();
	private  static  String url=rp.url;//连接数据库的url
	private  static  String driver=rp.driver;//连接数据的驱动
	private  static String username=rp.username;//数据库用户名
	private static  String password=rp.password;//数据库登录密码
	
	public  JdbcUtils(){//显示写出无参构造方法
	}
	
	
	
	//静态语句块，只执行一次并且在构造方法调用前执行
	static{

		try {
			Class.forName(driver);//加载驱动
		} catch (ClassNotFoundException e) {
			System.out.println("加载驱动异常"+e);
		}
		
	}
	
	
	//与数据库创建连接
	public static Connection getConnection() throws SQLException{

		return DriverManager.getConnection(url, username, password);
	}
	
	//释放资源的方法，关闭资源前先判断是否为null， 不为null时才执行关闭
	public static void free(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();//关闭结果数据资源
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(ps!=null){
					try {
						ps.close();//关闭创建查询语句资源
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();//关闭用户连接的资源
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
