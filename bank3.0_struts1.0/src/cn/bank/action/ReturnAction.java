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
 * ����������ǰ�˿�����
 * @author DFX
 * @version 3.0 2017/8/14
 * 
 * */
public class ReturnAction  extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			//�ɹ���ת����ҳ��
			return mapping.findForward("main");
	
	}
	

}