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
 * Hibernate的过滤器。
 * 创建SessionFactory
 * 创建session
 * 使用openSessionInview模式
 * @author Administrator
 *
 */
public class HibernateFilter implements Filter {
	
	static SessionFactory factory=null;
	
	/**
	 * 使用ThreadLocal变量将当前线程和Session对象绑定
	 * 保证并发性，threadLocal中有一个线程安全的map集合
	 * map集合中的key是当前线程对象，value是线程的变量副本
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
			 * 所有请求都结束后就关闭当前线程对应的session
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
	 * 在初始化方法里得到sessionFactory对象
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		Configuration cfg=new Configuration().configure();
		factory=cfg.buildSessionFactory();//创建SessionFactory对象
	}
	
	/**
	 * 通过线程得到session对象
	 * @return
	 */
	public static Session getSession(){
		//先查询当前线程中有没有对应的session对象，有的话就直接取出来使用
		Session session=(Session) hibernate.get();
		if(session==null){
			session=factory.openSession();
			hibernate.set(session);//将创建的session对象和当前线程绑定
		}
		return session;
	}

}
