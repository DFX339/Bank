package cn.bank.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ���ֱ��������
 * @author Administrator
 * @version 4.0
 * 2017/9/10
 */
public class CharacterFilter  implements Filter{

	private String encoding=null;
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request1, ServletResponse response1,
			FilterChain chain) throws IOException, ServletException {
		//����
		HttpServletRequest request=(HttpServletRequest)request1;
		HttpServletResponse response=(HttpServletResponse)response1;
		
		//���÷���˷����ͻ��˵ı���
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
		
		
	}
	
	//�õ�������Ϣ�еĳ�ʼ������
	public void init(FilterConfig config) throws ServletException {
		encoding=config.getInitParameter("encoding");
	}

}
