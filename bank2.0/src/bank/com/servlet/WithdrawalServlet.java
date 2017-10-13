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
 * ����ȡ���servlet���
 * @author DFX
 * @version 2.0 2017/07/28
 * 
 * */
public class WithdrawalServlet extends HttpServlet {

	ServiceImpl  serviceImpl=ServiceImpl.getInstance();	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			String id=(String) request.getSession().getAttribute("ID");
			String money=request.getParameter("withdrawalNum");
			double money1=new Double(money);
			request.setAttribute("money",serviceImpl.withdrawal(money1,id));
				request.getRequestDispatcher("/WEB-INF/jsp/showMoney.jsp").forward(request,response);
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}

	

}
