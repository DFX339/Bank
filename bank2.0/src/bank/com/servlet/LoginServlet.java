package bank.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.com.bean.User;
import bank.com.service.ServiceImpl;
/**
 * 用于登录的servlet组件
 * @author DFX
 * @version 2.0 2017/07/28
 * 
 * */
public class LoginServlet extends HttpServlet {

	ServiceImpl  serviceImpl= ServiceImpl.getInstance();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//得到请求参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User user=null;
		
		HttpSession session=request.getSession();//得到当前session对象地址
		try {
			user=serviceImpl.login(username, password);
			if(user!=null){
				session.setAttribute("sessionID", session.getId());//将用户当前的sessionID存入session域中，用来验证用户的合法性
				session.setAttribute("ID",user.getID());
				request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request,response);
			}else{
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
