package cn.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.bank.bean.User;
import cn.bank.form.UserForm;
import cn.bank.manager.BankManager;
/**
 * 银行项目的DispatchAction,一个ACTION类处理多个请求
 * @author Administrator
 *	关于操作功能都通过这个Action实现，取款 存款 转账 查询余额
 *	先验证 再完成请求
 */
public class BankAction extends DispatchAction {
	
	private User userBean=null;//存在session中的结果bean
	/*
	 * 父类的execute方法，先对请求用户验证
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		userBean=(User) request.getSession().getAttribute("user");
		
		//判断用户中是否有验证信息，没有的话就视为非法用户，转到登录页面
		if(userBean==null){
			ActionForward forward=new ActionForward();
			forward.setPath("/login.jsp");
			return forward;
		}
		//有验证信息就执行父类的execute()方法
		return super.execute(mapping, form, request, response);
	}
	
	
	/*
	 * 如果没有command参数初入时，默认执行该方法(默认执行查询余额的方法)
	 */
	@Override
	protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BankManager bankManager=BankManager.getInstance();//得到业务层对象
		User user=User.getInstance();
		
		int id=userBean.getId();//得到当前登录用户的ID
		//调用业务对象的登录验证方法
		user =bankManager.inqury(id);
		if(user!=null){
			//将user对象设置到request域中
			request.setAttribute("user", user);
			//成功跳转到显示余额页面
			return mapping.findForward("list");
		}else{
			//失败跳转到错误页面
			return mapping.findForward("error");
		}
	}



	/*
	 * 存款方法
	 */
	public ActionForward deposit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BankManager bankManager=BankManager.getInstance();//得到业务层对象
		String money=request.getParameter("money");
		System.out.println("你输入的存款金额为："+money);
		User user=User.getInstance();
		
		int id=userBean.getId();//得到当前登录用户的ID
		//调用业务对象的存款方法
		user =bankManager.deposit(money,id);
		if(user!=null){
			//将user对象设置到request域中
			request.setAttribute("user", user);
			//成功跳转到显示余额页面
			return mapping.findForward("list");
		}else{
			//失败跳转到错误页面
			return mapping.findForward("error");
		}
	}
	
	/*
	 * 取款方法
	 */
	public ActionForward withdrawal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BankManager bankManager=BankManager.getInstance();//得到业务层对象
		User user=User.getInstance();
		String money=request.getParameter("money");
		int id=userBean.getId();//得到当前登录用户的ID
		//调用业务对象的取款方法
		user =bankManager.withdrawal(money,id);
		if(user!=null){
			//将user对象设置到request域中
			request.setAttribute("user", user);
			//成功跳转到显示余额页面
			return mapping.findForward("list");
		}else{
			//失败跳转到错误页面
			return mapping.findForward("error");
		}
	}
	
	
	/*
	 * 转账方法
	 */
	public ActionForward transfer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BankManager bankManager=BankManager.getInstance();//得到业务层对象
		
		String objId=request.getParameter("objId");
		String money=request.getParameter("money");
		User user=User.getInstance();
		int id=userBean.getId();//得到当前登录用户的ID
		//调用业务对象的存款方法
		user =bankManager.transfer(objId,money,id);
		if(user!=null){
			//将user对象设置到request域中
			request.setAttribute("user", user);
			//成功跳转到显示余额页面
			return mapping.findForward("list");
		}else{
			//失败跳转到错误页面
			return mapping.findForward("error");
		}
			
	}
	
	/*
	 * 查询余额方法
	 */
	public ActionForward inqury(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BankManager bankManager=BankManager.getInstance();//得到业务层对象
		User user=User.getInstance();
		int id=userBean.getId();//得到当前登录用户的ID
		//调用业务对象的登录验证方法
		user =bankManager.inqury(id);
		if(user!=null){
			//将user对象设置到request域中
			request.setAttribute("user", user);
			//成功跳转到显示余额页面
			return mapping.findForward("list1");
		}else{
			//失败跳转到错误页面
			return mapping.findForward("error");
		}
	}

}
