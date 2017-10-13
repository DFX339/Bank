package bank.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.com.service.ServiceImpl;
/**
 * 用于注册的servlet组件
 * @author DFX
 * @version 2.0 2017/07/28
 * 
 * */
public class RegistServlet extends HttpServlet {

	ServiceImpl  serviceImpl=ServiceImpl.getInstance();	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到请求参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String money=request.getParameter("money");
		double money1=new Double(money);
		
		if(!username.equals("")&&!password.equals("")){
		try {
			if(serviceImpl.regist(username, password,money1)){
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}else{
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}else{
			response.sendRedirect("error.jsp");
		}

	}

	

}
