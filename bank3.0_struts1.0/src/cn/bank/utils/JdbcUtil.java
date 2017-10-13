package cn.bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 连接数据库的工具类
 * @author Administrator
 *
 *@version 3.0 2017/8/14
 */
public class JdbcUtil {
	
	static ReadPropUtil rpu=new ReadPropUtil();
	private static String driver=rpu.driver;//驱动
	private static String url=rpu.url;//路径名
	private static String username=rpu.username;//用户名
	private static String password=rpu.password;//密码
	
	public JdbcUtil(){}
	
	static{
		try {
			Class.forName(driver);//加载驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//获取连接（与数据库的）
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	} 
	
	//连接资源的关闭
	public static void free(ResultSet rs,PreparedStatement ps,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(ps!=null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();
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
