package cn.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.bank.bean.UserBean;
import cn.bank.form.UserForm;
import cn.bank.service.BankService;
/**
 * 注册的前端控制器
 * @author Administrator
 *
 */
public class RegistAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//得到表单中数据
		UserForm user=(UserForm)form;
		
		System.out.println("form"+user.getUsername());
		UserBean userBean=new UserBean();
		
		BeanUtils.copyProperties(userBean, user);
		
		
		BankService bankService=BankService.getInstance();//拿到业务处对象
		boolean  flag=bankService.regist(userBean);//调用业务层对象的注册方法
		
		if(!flag){
			
			return mapping.findForward("error");
			
		}else{
			
			return mapping.findForward("login");
			
		}
		
	}
}
