package bank.com.util;

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
 * 
 * �������ع����� ʵ��Filter�ӿ� ��дinit destroy doFilter����
 * 
 * chain.doFilter(request, response);
 * �˷���֮ǰ�����Ϊ ��������
 * �˷���֮������Ϊ �������
 * @author DFX
 * @version 2.0 2017/08/02
 * 
 * */
public class CharacterFilter implements Filter {
	private String encoding;
	
	//��ʼ������ tomcatһ������Filter����һ�����͵���
	public void init(FilterConfig config)throws ServletException{
		encoding=config.getInitParameter("encoding");//��ȡweb.xml����CharacterFilter�еĳ�ʼ������
	}
	
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)throws IOException,ServletException{
		
		HttpServletRequest request=(HttpServletRequest)req;//����ΪHttpServeltRequest
		HttpServletResponse response=(HttpServletResponse)resp;
		
		request.setCharacterEncoding(encoding);//����������������б������أ�һ������ ����ʹ��
		chain.doFilter(request, response);//���ж���û�б�����������еĻ��ͼ�������������û�еĻ��������´�
		response.setContentType("text/html;charset=utf-8");//�Խ�����б�������
	}
	
	//���ٷ�����Tomcat�رգ�Filter����һ���پ͵���
	public void destroy(){}
	
}
