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
 * ע���ǰ�˿�����
 * @author Administrator
 *
 */
public class RegistAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//�õ���������
		UserForm user=(UserForm)form;
		
		System.out.println("form"+user.getUsername());
		UserBean userBean=new UserBean();
		
		BeanUtils.copyProperties(userBean, user);
		
		
		BankService bankService=BankService.getInstance();//�õ�ҵ�񴦶���
		boolean  flag=bankService.regist(userBean);//����ҵ�������ע�᷽��
		
		if(!flag){
			
			return mapping.findForward("error");
			
		}else{
			
			return mapping.findForward("login");
			
		}
		
	}
}
