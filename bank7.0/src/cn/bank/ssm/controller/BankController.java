package cn.bank.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.bank.ssm.bean.Admin;
import cn.bank.ssm.bean.User;
import cn.bank.ssm.exception.BankException;
import cn.bank.ssm.service.BankService;

/**
 * 控制器类
 * @author Administrator
 * @version 2017/9/30
 */

@Controller
public class BankController {
	
	@Resource(name="bankService")
	private BankService bankService;
	
	/*
	 * 中文
	 */
	@RequestMapping("/chinese.do")
	public ModelAndView toChinese(HttpServletRequest request){
		
		return new ModelAndView(new RedirectView("./index.jsp")); 
	}
	
	/*
	 * 英文
	 */
	@RequestMapping("/us.do")
	public ModelAndView toUs(HttpServletRequest request){
		
		return new ModelAndView(new RedirectView("./index.jsp")); 
	}
	
	/*
	 * 进入登录页面
	 */
	@RequestMapping("/toLogin.do")
	public ModelAndView toLogin(HttpServletRequest request){
		return new ModelAndView("login"); 
	}
	
	/*
	 * 返回主页面
	 */
	@RequestMapping("/return.do")
	public ModelAndView returnToMain(HttpServletRequest request){
		return new ModelAndView("main"); 
	}
	
	
	
	//登录
	@RequestMapping("/login.do")
	public ModelAndView login(String username,String password,String identity,HttpServletRequest request){
		if("user".equals(identity)||"用户".equals(identity) ){
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			User user1 = bankService.login(user);
			request.getSession().setAttribute("user", user1);
			return new ModelAndView("main");
		}else{
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			Admin admin1 = bankService.adminLogin(admin);
			request.getSession().setAttribute("admin",admin);
			return new ModelAndView("redirect:/findAll.do");
		}
	}
	
	//注册
	@RequestMapping("/regist.do")
	public String regsit(User user){
		bankService.regist(user);
		return "login";
	}
	
	//管理员管理用户账号状态
	@RequestMapping("/updateTag.do")
	public ModelAndView updateTag(int id){
		User user = bankService.findById(id);
		if(user.getTag().equals("正常状态")){
			System.out.println("o normal");
			user.setTag("冻结状态");
		}else{
			user.setTag("正常状态");
		}
		bankService.updateTag(user);
	    return new ModelAndView("redirect:/findAll.do");
	}
	
	//管理员查看所有用户
	@RequestMapping("/findAll.do")
	public String findAll(HttpServletRequest request){
		List list = bankService.findAllUser();
		System.out.println(list.size()+"--"+list);
		request.setAttribute("list",list);
		return "admin";
	}
	
	
	
	/*
	 * 存款
	 */
	@RequestMapping("/deposit.do")
	public ModelAndView deposit(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		if(user == null){
			ModelAndView mav1=new ModelAndView("error");
			return mav1;
		}
		String tag = user.getTag();
		if("冻结状态".equals(tag)){
			throw new BankException("账号已经被冻结，请先找银行相关人员解冻");
		}
		
		int id=user.getId();
		
		String reqMoney = request.getParameter("money");
		String regex="[0-9]{1,6}";
		double depositMoney=0;
		if(reqMoney.matches(regex)){
			depositMoney = new Double(reqMoney);
			double money1= bankService.deposit(id,depositMoney);
			
			ModelAndView mav=new ModelAndView("list");
			mav.addObject("money", money1);
			return mav;
		}else{
			throw new BankException("存款金额输入有误："+reqMoney);
		}
		
	}
	
	/*
	 * 取款
	 */
	@RequestMapping("/withdrawal.do")
	public ModelAndView withdrawal(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		if(user == null){
			ModelAndView mav1=new ModelAndView("error");
			return mav1;
		}
		String tag = user.getTag();
		if("冻结状态".equals(tag)){
			throw new BankException("账号已经被冻结，请先找银行相关人员解冻");
		}
		int id=user.getId();
		
		String reqMoney = request.getParameter("money");
		String regex="[0-9]{1,6}";
		double withdrawalMoney=0;
		if(reqMoney.matches(regex)){
			withdrawalMoney = new Double(reqMoney);
			double money1= bankService.withdrawal(id,withdrawalMoney);
			
			ModelAndView mav=new ModelAndView("list");
			mav.addObject("money", money1);
			return mav;
		}else{
			throw new BankException("取款金额输入有误："+reqMoney);
		}
	}
	
	/*
	 * 转账
	 */
	@RequestMapping("/transfer.do")
	public ModelAndView transfer(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		if(user == null){
			ModelAndView mav1=new ModelAndView("error");
			return mav1;
		}
		String tag = user.getTag();
		if("冻结状态".equals(tag)){
			throw new BankException("账号已经被冻结，请先找银行相关人员解冻");
		}
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
				double money1= bankService.transfer(id,transferMoney,transferId);
				
				ModelAndView mav=new ModelAndView("list");
				mav.addObject("money", money1);
				
				return mav;
			
			}else{
				throw new BankException("转账ID输入有误："+reqId);
			}
		}else{
			throw new BankException("转账金额输入有误"+reqMoney);
		}
		
		
		
	}
	
	/*
	 * 查询余额
	 */
	@RequestMapping("/inqury.do")
	public ModelAndView inqury(HttpServletRequest request){
		
		User user=(User) request.getSession().getAttribute("user");
		if(user == null){
			ModelAndView mav1=new ModelAndView("error");
			return mav1;
		}
		String tag = user.getTag();
		if("冻结状态".equals(tag)){
			throw new BankException("账号已经被冻结，请先找银行相关人员解冻");
		}
		int id=user.getId();
		
		double money1= bankService.find(id);
		
		ModelAndView mav=new ModelAndView("list");
		mav.addObject("money", money1);
		return mav;
	}

}
