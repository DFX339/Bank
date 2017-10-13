package cn.bank.utils;

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
 * 银行项目3.0版本的编码过滤器
 * @author Administrator
 *@version 3.0 2017、8、15
 */
public class CharacterFilter implements Filter{
	
	public String encoding=null;
	
	public void init(FilterConfig config) throws ServletException {
		encoding=config.getInitParameter("encoding");
	}
	

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		response.setContentType("text/html;charset=UTF-8");
	}

	public void destroy() {	}

}
