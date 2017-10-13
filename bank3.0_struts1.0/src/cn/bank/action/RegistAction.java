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
 * ע��ǰ�˿�����
 * @author DFX
 * @version 3.0 2017/8/14
 * 
 * */
public class RegistAction  extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
BankManager bankManager=BankManager.getInstance();//�õ�ҵ������
		
		//�ռ�������
		UserForm userForm=(UserForm)form;
		//�õ����еĲ���
		String username=userForm.getUsername();
		String password=userForm.getPassword();
		double money=userForm.getMoney();
		
		//�����еĲ�����װ����bean��
		User user=User.getInstance();	
		user.setUsername(username);
		user.setPassword(password);
		user.setMoney(money);
		
		//����ҵ������ע�᷽��
		boolean flag=bankManager.regist(user);
		
		if(flag){
			//�ɹ���ת����¼ҳ��
			return mapping.findForward("login");
		}else{
			//ʧ����ת������ҳ��
			return mapping.findForward("error");
			
		}
	}
	

}
