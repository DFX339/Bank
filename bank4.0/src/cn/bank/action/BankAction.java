package cn.bank.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.bank.bean.UserBean;
import cn.bank.service.BankService;

public class BankAction extends DispatchAction {
	
	String ID;
	private UserBean user=null;
	
	/**
	 * ���û�����֤
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		user=(UserBean) request.getSession().getAttribute("user");
		
		//�ж��û����Ƿ�����֤��Ϣ��û�еĻ�����Ϊ�Ƿ��û���ת����¼ҳ��
		if(user==null){
			ActionForward forward=new ActionForward();
			forward.setPath("/login.jsp");
			return forward;
		}
		return super.execute(mapping, form, request, response);
	}
	
	/**
	 * ���
	 */
	public ActionForward deposit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String depositMoney=request.getParameter("money");
		BankService bankService=BankService.getInstance();
		
		int id=user.getId();
		System.out.println("Action+"+id);
		double money = bankService.deposit(id, depositMoney);
		request.setAttribute("money",money);
		
		return mapping.findForward("list");
	}
	
	/**
	 * ȡ��
	 */
	public ActionForward withdrawal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String withdrawalMoney=request.getParameter("money");
		BankService bankService=BankService.getInstance();
		
		int id=user.getId();
		double money = bankService.withdrawal(id, withdrawalMoney);
		request.setAttribute("money",money);
		
		return mapping.findForward("list");
	}
	
	/**
	 * ת��
	 */
	public ActionForward transfer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String transferMoney=request.getParameter("money");
		String transferId=request.getParameter("objId");
		BankService bankService=BankService.getInstance();
		
		int id=user.getId();
		double money = bankService.transfer(id, transferMoney,transferId);
		request.setAttribute("money",money);
		
		return mapping.findForward("list");
	}
	
	/**
	 * ��ѯ���
	 */
	public ActionForward inqury(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BankService bankService=BankService.getInstance();
		
		int id=user.getId();
		double money = bankService.inqury(id);
		request.setAttribute("money",money);
		
		return mapping.findForward("list1");
	}
}
