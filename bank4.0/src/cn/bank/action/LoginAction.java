package cn.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.bank.bean.UserBean;
import cn.bank.form.UserForm;
import cn.bank.service.BankService;
/**
 * 登录的前端控制器
 * @author Administrator
 *
 */
public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//得到表单中的用户名和密码
		UserForm user=(UserForm)form;
		String name=user.getUsername();
		String password=user.getPassword();
		
		BankService bankService=BankService.getInstance();//拿到业务处对象
		UserBean userBean=bankService.login(name, password);//调用业务层对象的登录方法
		System.out.println("login:"+name);
		if(userBean ==  null){
			return mapping.findForward("error");
			
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("id",userBean.getId());
			session.setAttribute("user", userBean);
			
			return mapping.findForward("main");
		}
		
	}
	
	
}
