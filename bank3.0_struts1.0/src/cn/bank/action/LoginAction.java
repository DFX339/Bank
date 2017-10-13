package cn.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.bank.bean.User;
import cn.bank.form.UserForm;
import cn.bank.manager.BankManager;

/**
 * ��¼ǰ�˿�����
 * @author DFX
 * @version 3.0 2017/8/14
 * 
 * */
public class LoginAction  extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BankManager bankManager=BankManager.getInstance();//�õ�ҵ������
		
		//�ռ���������
		UserForm userForm=(UserForm)form;
		//�õ������еĲ���
		String username=userForm.getUsername();
		String password=userForm.getPassword();
		
		//�������еĲ�����װ�����bean��
		User user=User.getInstance();
		
		//����ҵ�����ĵ�¼��֤����
		user=bankManager.login(username,password);
		
		HttpSession session=request.getSession();
		
		if(user!=null){
			
			session.setAttribute("user",user);
			//��user�������õ�request����
			request.setAttribute("user", user);
			
			//�ɹ���ת����ҳ��
			return mapping.findForward("main");
		}else{
			//ʧ����ת������ҳ��
			return mapping.findForward("error");
			
		}
	}
	

}