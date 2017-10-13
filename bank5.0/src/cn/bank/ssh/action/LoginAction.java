package cn.bank.ssh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.bank.ssh.bean.User;
import cn.bank.ssh.form.UserForm;
import cn.bank.ssh.manager.BankManagerInterface;
/**
 * 登录的前端控制器
 * @author Administrator
 * @version 5.0 2017/9/17
 */
public class LoginAction extends Action {
	
	//使用spring的依赖注入bankManager，直接使用
	private BankManagerInterface bankManager;
	public void setBankManager(BankManagerInterface bankManager){
		this.bankManager=bankManager;
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UserForm userForm=(UserForm)form;
		String username=userForm.getUsername();
		String password=userForm.getPassword();
		
		User user=bankManager.login(username, password);
		if(user != null){
			request.getSession().setAttribute("user",user);
			return mapping.findForward("main");
		}else{
			return mapping.findForward("error");
		}
	}

	
}
