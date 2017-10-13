package cn.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.bank.bean.User;
import cn.bank.form.UserForm;
import cn.bank.manager.BankManager;

/**
 * 注册前端控制器
 * @author DFX
 * @version 3.0 2017/8/14
 * 
 * */
public class RegistAction  extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
BankManager bankManager=BankManager.getInstance();//得到业务层对象
		
		//收集表单数据
		UserForm userForm=(UserForm)form;
		//得到表单中的参数
		String username=userForm.getUsername();
		String password=userForm.getPassword();
		double money=userForm.getMoney();
		
		//将表单中的参数封装到表单bean中
		User user=User.getInstance();	
		user.setUsername(username);
		user.setPassword(password);
		user.setMoney(money);
		
		//调用业务对象的注册方法
		boolean flag=bankManager.regist(user);
		
		if(flag){
			//成功跳转到登录页面
			return mapping.findForward("login");
		}else{
			//失败跳转到错误页面
			return mapping.findForward("error");
			
		}
	}
	

}
