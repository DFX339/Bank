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
 * 请求拦截器
 * 对所有请求操作的用户进行验证 session
 * 
 * StringBuffer currentURL=request.getRequestURL();//得到当前访问路径
 * System.out.println("获取到的路径："+currentURL);//
 * int index=currentURL.lastIndexOf("/",currentURL.length());//反向搜索，从最后一个字符开始搜索，找到反向第一次出现的反斜杠的位置（这个位置的下标还是从正向开始计数）
 * System.out.println("获取到最后一个反斜杠的位置："+index);//
 * String url=currentURL.substring(index);//截取出反斜杠之后以及包括反斜杠的字符串
 * System.out.println("截取后的URL："+url);
 *
 * 以上语句对应的输出结果为：
 * 获取到的路径：http://user-20150330oi:8080/bank2.0/login.jsp
 * 获取到最后一个反斜杠的位置：35
 * 截取后的URL：/login.jsp
 * 
 * str.lastIndexOf("/",10);//表示从第10个位置开始反向搜索，找到一个出现反斜杠的位置
 * */
public class RequestFilter implements Filter{
	
	private FilterConfig config;
	//初始化方法
	public void init(FilterConfig config)throws ServletException{
		this.config=config;//获取config内置对象
	}
	
	//拦截方法
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)throws IOException ,ServletException{
		//造型为Http型的request和response
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		HttpSession session=request.getSession();//通过request内置对象的地址得到session内置对象的地址
		
		StringBuffer currentURL=request.getRequestURL();//得到当前访问路径
		int index=currentURL.lastIndexOf("/",currentURL.length());//得到最后一个反斜杠出现的位置
		String url=currentURL.substring(index);//截取出最后一个反斜杠之后的字符串（包括反斜杠）
		
		if("/login.jsp".equals(url)||"/regist.jsp".equals(url)||"/index.jsp".equals(url)){
			
			//判断如果是 登录请求或者是注册请求就不拦截，不需要经过session验证，直接将请求下传
			chain.doFilter(request,response);
			
		}else{//否则就验证session信息
			boolean flag=false;	//用来标记用户的sessionID是否与登录时的匹配
			
			String session1=(String)session.getAttribute("sessionID");//得到用户登录时存储的sessionID
			System.out.println("获取到的session："+session1);//
			System.out.println("当前的的session："+session.getId());//
			if(session.getId().equals(session1)){//判断用户当前session和登录时的session是否一致
				flag=true;
			}
			
			if(flag){//flag为true，匹配成功，表示为合法用户 请求下传
				chain.doFilter(request, response);
			}else{//flag为false，表示匹配失败，是非法用户，跳转到index.jsp
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
			
		}
		
		
	}
	
	//销毁方法
	public void destroy(){}
}