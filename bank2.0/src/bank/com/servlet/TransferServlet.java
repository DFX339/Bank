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
 * 用于转账的servlet组件
 * @author DFX
 * @version 2.0 2017/07/28
 * 
 * */
public class TransferServlet extends HttpServlet {

	ServiceImpl  serviceImpl=ServiceImpl.getInstance();	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String id=(String) request.getSession().getAttribute("ID");
			String ID=request.getParameter("ID");
			String money=request.getParameter("transferNum");
			double money1=new Double(money);
			request.setAttribute("money",serviceImpl.transfer(ID,money1,id));
				request.getRequestDispatcher("/WEB-INF/jsp/showMoney.jsp").forward(request,response);
		} catch (Exception e) {
			response.sendRedirect("error.jsp");
			e.printStackTrace();
		}
	}

	

}
