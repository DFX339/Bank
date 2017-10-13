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
 * �����������ݿ�Ĺ�����
 * 
 * @author DFX
 * @version 2.0 2017/07/27
 * 
 * */
public class JdbcUtils {
	
	static ReadProps rp=new ReadProps();
	private  static  String url=rp.url;//�������ݿ��url
	private  static  String driver=rp.driver;//�������ݵ�����
	private  static String username=rp.username;//���ݿ��û���
	private static  String password=rp.password;//���ݿ��¼����
	
	public  JdbcUtils(){//��ʾд���޲ι��췽��
	}
	
	
	
	//��̬���飬ִֻ��һ�β����ڹ��췽������ǰִ��
	static{

		try {
			Class.forName(driver);//��������
		} catch (ClassNotFoundException e) {
			System.out.println("���������쳣"+e);
		}
		
	}
	
	
	//�����ݿⴴ������
	public static Connection getConnection() throws SQLException{

		return DriverManager.getConnection(url, username, password);
	}
	
	//�ͷ���Դ�ķ������ر���Դǰ���ж��Ƿ�Ϊnull�� ��Ϊnullʱ��ִ�йر�
	public static void free(Connection conn,PreparedStatement ps,ResultSet rs) {
		if(rs!=null){
			try {
				rs.close();//�رս��������Դ
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(ps!=null){
					try {
						ps.close();//�رմ�����ѯ�����Դ
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();//�ر��û����ӵ���Դ
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
