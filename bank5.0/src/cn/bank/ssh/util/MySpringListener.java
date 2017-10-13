package cn.bank.ssh.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 监听器，用来监听application内置对象的创建
 * 然后创建BeanFactory
 * @author Administrator
 *
 */
public class MySpringListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	public void contextInitialized(ServletContextEvent sce) {
		
		/**
		 * 1.通过注入的事件对象拿到application内置对象
		 * 2.通过application拿到全局初始化参数信息，spring配置文件的位置
		 * 3.根据spring的配置文件创建BeanFactory
		 * 4.将创建BeanFactory存入application内置对象中,属性名为beanFactory
		 */
		ServletContext application=sce.getServletContext();
		String contextConfigLocation= application.getInitParameter("contextConfigLocation");
		BeanFactory factory=new ClassPathXmlApplicationContext(contextConfigLocation);
		application.setAttribute("beanFactory", factory);
	}

}
