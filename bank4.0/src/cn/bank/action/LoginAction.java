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
 * ��¼��ǰ�˿�����
 * @author Administrator
 *
 */
public class LoginAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//�õ����е��û���������
		UserForm user=(UserForm)form;
		String name=user.getUsername();
		String password=user.getPassword();
		
		BankService bankService=BankService.getInstance();//�õ�ҵ�񴦶���
		UserBean userBean=bankService.login(name, password);//����ҵ������ĵ�¼����
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
