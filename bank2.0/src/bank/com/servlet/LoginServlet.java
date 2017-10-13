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
 * ���ڵ�¼��servlet���
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
		//�õ��������
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User user=null;
		
		HttpSession session=request.getSession();//�õ���ǰsession�����ַ
		try {
			user=serviceImpl.login(username, password);
			if(user!=null){
				session.setAttribute("sessionID", session.getId());//���û���ǰ��sessionID����session���У�������֤�û��ĺϷ���
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
