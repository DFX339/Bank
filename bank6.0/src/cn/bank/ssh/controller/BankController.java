package cn.bank.ssh.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.bank.ssh.bean.User;
import cn.bank.ssh.exception.BankException;
import cn.bank.ssh.service.BankImpl;
import cn.bank.ssh.service.BankService;

/**
 * ��˿�������
 * @author Administrator
 *@version 6.0 2017/9/21
 */
     
@Controller
public class BankController {
	
	@Resource(name="bankImpl")
	private BankService bankImpl;
	
	/*
	 * ����
	 */
	@RequestMapping("/chinese.do")
	public ModelAndView toChinese(HttpServletRequest request){
		
		return new ModelAndView(new RedirectView("./index.jsp")); 
	}
	
	/*
	 * Ӣ��
	 */
	@RequestMapping("/us.do")
	public ModelAndView toUs(HttpServletRequest request){
		
		return new ModelAndView(new RedirectView("./index.jsp")); 
	}
	
	/*
	 * �����¼ҳ��
	 */
	@RequestMapping("/toLogin.do")
	public ModelAndView toLogin(HttpServletRequest request){
		return new ModelAndView("login"); 
	}
	
	/*
	 * ������ҳ��
	 */
	@RequestMapping("/return.do")
	public ModelAndView returnToMain(HttpServletRequest request){
		return new ModelAndView("main"); 
	}
	
	
	
	/*
	 * ע��
	 */
	@RequestMapping("/regist.do")
	public ModelAndView regist(User user,HttpServletRequest request){
		
		boolean flag=bankImpl.regist(user);
		
		if(flag){
			return new ModelAndView("login");
		}
		return new ModelAndView("error");
	}
	
	/*
	 * ��¼
	 */
	@RequestMapping("/login.do")
	public ModelAndView login(String username,String password,HttpServletRequest request){
		
		User user=bankImpl.login(username,password);
		request.getSession().setAttribute("user",user);
		return new ModelAndView("main");
	}
	
	/*
	 * ���
	 */
	@RequestMapping("/deposit.do")
	public ModelAndView deposit(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		int id=user.getId();
		
		String reqMoney = request.getParameter("money");
		String regex="[0-9]{1,6}";
		double depositMoney=0;
		if(reqMoney.matches(regex)){
			depositMoney = new Double(reqMoney);
			double money1= bankImpl.deposit(id,depositMoney);
			
			ModelAndView mav=new ModelAndView("list");
			mav.addObject("money", money1);
			return mav;
		}else{
			throw new BankException("�������������"+reqMoney);
		}
		
	}
	
	/*
	 * ȡ��
	 */
	@RequestMapping("/withdrawal.do")
	public ModelAndView withdrawal(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		int id=user.getId();
		
		String reqMoney = request.getParameter("money");
		String regex="[0-9]{1,6}";
		double withdrawalMoney=0;
		if(reqMoney.matches(regex)){
			withdrawalMoney = new Double(reqMoney);
			double money1= bankImpl.withdrawal(id,withdrawalMoney);
			
			ModelAndView mav=new ModelAndView("list");
			mav.addObject("money", money1);
			return mav;
		}else{
			throw new BankException("ȡ������������"+reqMoney);
		}
	}
	
	/*
	 * ת��
	 */
	@RequestMapping("/transfer.do")
	public ModelAndView transfer(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		int id=user.getId();
		
		String reqMoney = request.getParameter("money");
		String reqId = request.getParameter("objId");
		String regex="[0-9]{1,6}";
		double transferMoney=0;
		int transferId=0;
		if(reqMoney.matches(regex)){
			if(reqId.matches(regex)){
				transferId=new Integer(reqId);
				transferMoney = new Double(reqMoney);
				double money1= bankImpl.transfer(id,transferMoney,transferId);
				
				ModelAndView mav=new ModelAndView("list");
				mav.addObject("money", money1);
				
				return mav;
			
			}else{
				throw new BankException("ת��ID��������"+reqId);
			}
		}else{
			throw new BankException("ת�˽����������"+reqMoney);
		}
		
		
		
	}
	
	/*
	 * ��ѯ���
	 */
	@RequestMapping("/inqury.do")
	public ModelAndView inqury(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		int id=user.getId();
		
		double money1= bankImpl.inqury(id);
		
		ModelAndView mav=new ModelAndView("list");
		mav.addObject("money", money1);
		return mav;
	}
}
