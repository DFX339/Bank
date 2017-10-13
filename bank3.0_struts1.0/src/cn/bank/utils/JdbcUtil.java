package cn.bank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * �������ݿ�Ĺ�����
 * @author Administrator
 *
 *@version 3.0 2017/8/14
 */
public class JdbcUtil {
	
	static ReadPropUtil rpu=new ReadPropUtil();
	private static String driver=rpu.driver;//����
	private static String url=rpu.url;//·����
	private static String username=rpu.username;//�û���
	private static String password=rpu.password;//����
	
	public JdbcUtil(){}
	
	static{
		try {
			Class.forName(driver);//��������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//��ȡ���ӣ������ݿ�ģ�
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url,username,password);
	} 
	
	//������Դ�Ĺر�
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
