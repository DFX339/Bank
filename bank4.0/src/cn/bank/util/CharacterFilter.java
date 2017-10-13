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
 * 文字编码过滤器
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
		//造型
		HttpServletRequest request=(HttpServletRequest)request1;
		HttpServletResponse response=(HttpServletResponse)response1;
		
		//设置服务端发给客户端的编码
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
		response.setContentType("text/html;charset=UTF-8");
		
		
	}
	
	//得到配置信息中的初始化参数
	public void init(FilterConfig config) throws ServletException {
		encoding=config.getInitParameter("encoding");
	}

}
