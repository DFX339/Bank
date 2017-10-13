package cn.bank.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate�Ĺ�������
 * ����SessionFactory
 * ����session
 * ʹ��openSessionInviewģʽ
 * @author Administrator
 *
 */
public class HibernateFilter implements Filter {
	
	static SessionFactory factory=null;
	
	/**
	 * ʹ��ThreadLocal��������ǰ�̺߳�Session�����
	 * ��֤�����ԣ�threadLocal����һ���̰߳�ȫ��map����
	 * map�����е�key�ǵ�ǰ�̶߳���value���̵߳ı�������
	 */
	public static ThreadLocal hibernate=new ThreadLocal();
	
	public void destroy() {	
	}

	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try{
			chain.doFilter(request, response);
		}finally{
			/**
			 * �������󶼽�����͹رյ�ǰ�̶߳�Ӧ��session
			 */
			Session session=(Session) hibernate.get();
			if(session!=null){
				if(session.isOpen()){
					session.close();
				}
				hibernate.remove();
			}
		}
		
	}
	
	/**
	 * �ڳ�ʼ��������õ�sessionFactory����
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		Configuration cfg=new Configuration().configure();
		factory=cfg.buildSessionFactory();//����SessionFactory����
	}
	
	/**
	 * ͨ���̵߳õ�session����
	 * @return
	 */
	public static Session getSession(){
		//�Ȳ�ѯ��ǰ�߳�����û�ж�Ӧ��session�����еĻ���ֱ��ȡ����ʹ��
		Session session=(Session) hibernate.get();
		if(session==null){
			session=factory.openSession();
			hibernate.set(session);//��������session����͵�ǰ�̰߳�
		}
		return session;
	}

}
