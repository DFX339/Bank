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
 * ��ɷ������ת��������
 * @author DFX
 * @version 2.0 2017/07/28
 * 
 * */
public class ReturnServlet extends HttpServlet {

	ServiceImpl  serviceImpl=ServiceImpl.getInstance();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//�������ת
		request.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(request,response);
	}

	

}
