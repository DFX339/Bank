package bank.com.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ����������
 * ����������������û�������֤ session
 * 
 * StringBuffer currentURL=request.getRequestURL();//�õ���ǰ����·��
 * System.out.println("��ȡ����·����"+currentURL);//
 * int index=currentURL.lastIndexOf("/",currentURL.length());//���������������һ���ַ���ʼ�������ҵ������һ�γ��ֵķ�б�ܵ�λ�ã����λ�õ��±껹�Ǵ�����ʼ������
 * System.out.println("��ȡ�����һ����б�ܵ�λ�ã�"+index);//
 * String url=currentURL.substring(index);//��ȡ����б��֮���Լ�������б�ܵ��ַ���
 * System.out.println("��ȡ���URL��"+url);
 *
 * ��������Ӧ��������Ϊ��
 * ��ȡ����·����http://user-20150330oi:8080/bank2.0/login.jsp
 * ��ȡ�����һ����б�ܵ�λ�ã�35
 * ��ȡ���URL��/login.jsp
 * 
 * str.lastIndexOf("/",10);//��ʾ�ӵ�10��λ�ÿ�ʼ�����������ҵ�һ�����ַ�б�ܵ�λ��
 * */
public class RequestFilter implements Filter{
	
	private FilterConfig config;
	//��ʼ������
	public void init(FilterConfig config)throws ServletException{
		this.config=config;//��ȡconfig���ö���
	}
	
	//���ط���
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)throws IOException ,ServletException{
		//����ΪHttp�͵�request��response
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		HttpSession session=request.getSession();//ͨ��request���ö���ĵ�ַ�õ�session���ö���ĵ�ַ
		
		StringBuffer currentURL=request.getRequestURL();//�õ���ǰ����·��
		int index=currentURL.lastIndexOf("/",currentURL.length());//�õ����һ����б�ܳ��ֵ�λ��
		String url=currentURL.substring(index);//��ȡ�����һ����б��֮����ַ�����������б�ܣ�
		
		if("/login.jsp".equals(url)||"/regist.jsp".equals(url)||"/index.jsp".equals(url)){
			
			//�ж������ ��¼���������ע������Ͳ����أ�����Ҫ����session��֤��ֱ�ӽ������´�
			chain.doFilter(request,response);
			
		}else{//�������֤session��Ϣ
			boolean flag=false;	//��������û���sessionID�Ƿ����¼ʱ��ƥ��
			
			String session1=(String)session.getAttribute("sessionID");//�õ��û���¼ʱ�洢��sessionID
			System.out.println("��ȡ����session��"+session1);//
			System.out.println("��ǰ�ĵ�session��"+session.getId());//
			if(session.getId().equals(session1)){//�ж��û���ǰsession�͵�¼ʱ��session�Ƿ�һ��
				flag=true;
			}
			
			if(flag){//flagΪtrue��ƥ��ɹ�����ʾΪ�Ϸ��û� �����´�
				chain.doFilter(request, response);
			}else{//flagΪfalse����ʾƥ��ʧ�ܣ��ǷǷ��û�����ת��index.jsp
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
			
		}
		
		
	}
	
	//���ٷ���
	public void destroy(){}
}