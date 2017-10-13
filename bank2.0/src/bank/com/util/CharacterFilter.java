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
 * 编码拦截过滤器 实现Filter接口 复写init destroy doFilter方法
 * 
 * chain.doFilter(request, response);
 * 此方法之前的语句为 请求拦截
 * 此方法之后的语句为 结果拦截
 * @author DFX
 * @version 2.0 2017/08/02
 * 
 * */
public class CharacterFilter implements Filter {
	private String encoding;
	
	//初始化方法 tomcat一启动，Filter对象一创建就调用
	public void init(FilterConfig config)throws ServletException{
		encoding=config.getInitParameter("encoding");//获取web.xml配置CharacterFilter中的初始化参数
	}
	
	public void doFilter(ServletRequest req,ServletResponse resp,FilterChain chain)throws IOException,ServletException{
		
		HttpServletRequest request=(HttpServletRequest)req;//造型为HttpServeltRequest
		HttpServletResponse response=(HttpServletResponse)resp;
		
		request.setCharacterEncoding(encoding);//对所有请求参数进行编码拦截，一次配置 终身使用
		chain.doFilter(request, response);//先判断有没有别的拦截器，有的话就激活别的拦截器，没有的话就请求下传
		response.setContentType("text/html;charset=utf-8");//对结果进行编码拦截
	}
	
	//销毁方法，Tomcat关闭，Filter对象一销毁就调用
	public void destroy(){}
	
}
