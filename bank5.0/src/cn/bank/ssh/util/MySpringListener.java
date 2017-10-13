package cn.bank.ssh.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ����������������application���ö���Ĵ���
 * Ȼ�󴴽�BeanFactory
 * @author Administrator
 *
 */
public class MySpringListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		
		/**
		 * 1.ͨ��ע����¼������õ�application���ö���
		 * 2.ͨ��application�õ�ȫ�ֳ�ʼ��������Ϣ��spring�����ļ���λ��
		 * 3.����spring�������ļ�����BeanFactory
		 * 4.������BeanFactory����application���ö�����,������ΪbeanFactory
		 */
		ServletContext application=sce.getServletContext();
		String contextConfigLocation= application.getInitParameter("contextConfigLocation");
		BeanFactory factory=new ClassPathXmlApplicationContext(contextConfigLocation);
		application.setAttribute("beanFactory", factory);
	}

}
