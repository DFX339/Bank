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
 * 注册的前端控制器
 * @author Administrator
 * @version 5.0 2017/9/17
 */
public class RegistAction extends Action {
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
		double money=userForm.getMoney();
		
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMoney(money);
		
		boolean flag=bankManager.regist(user);
		System.out.println("注册结果为+--"+flag);
		if(flag){
			return mapping.findForward("login");
		}else{
			return mapping.findForward("error");
		}
	}

}
