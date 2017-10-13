package cn.bank.ssh.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cn.bank.ssh.bean.User;
import cn.bank.ssh.exception.BankException;
import cn.bank.ssh.form.UserForm;
import cn.bank.ssh.manager.BankManagerInterface;
/**
 * 银行对业务操作的Action
 * @author Administrator
 *@version 5.0 2017/9/17
 */
public class BankAction extends DispatchAction{
	
	//使用spring的依赖注入bankManager，直接使用
	private BankManagerInterface bankManager;
	public void setBankManager(BankManagerInterface bankManager){
		this.bankManager=bankManager;
	}
	private User user=null;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		user = (User) request.getSession().getAttribute("user");
		if(user == null){
			return mapping.findForward("error");
		}else{
			return super.execute(mapping, form, request, response);
		}
	}
	
	/**
	 * 存款
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward deposit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String reqMoney = request.getParameter("money");
		String regex="[0-9]{1,6}";
		double depositMoney=0;
		if(reqMoney.matches(regex)){
			depositMoney = new Double(reqMoney);
			int id=user.getId();
			double money=bankManager.deposit(id, depositMoney);
			request.setAttribute("money",money);
			return mapping.findForward("list");
		}else{
			throw new BankException("user.deposit.error.num",reqMoney);
		}
	}
	
	/**
	 * 取款
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward withdrawal(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String reqMoney = request.getParameter("money");
		String regex="[0-9]{1,6}";
		double withdrawalMoney=0;
		if(reqMoney.matches(regex)){
			withdrawalMoney = new Double(reqMoney);
			int id=user.getId();
			double money=bankManager.withdrawal(id, withdrawalMoney);
			request.setAttribute("money",money);
			return mapping.findForward("list");
		}else{
			throw new BankException("user.withdrawal.num.input.error",reqMoney);
		}
	}
	
	/**
	 * 转账
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward transfer(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String reqMoney = request.getParameter("money");
		String reqId = request.getParameter("objId");
		String regex="[0-9]{1,6}";
		double transferMoney=0;
		int transferId=0;
		if(reqMoney.matches(regex)){
			if(reqId.matches(regex)){
				transferId=new Integer(reqId);
				transferMoney = new Double(reqMoney);
				int id=user.getId();
				double money=bankManager.transfer(id, transferMoney,transferId);
				request.setAttribute("money",money);
				return mapping.findForward("list");
			}else{
				throw new BankException("user.transfer.id.input.error",reqId);
			}
		}else{
			throw new BankException("user.transfer.num.input.error",reqMoney);
		}
	}

	
	/**
	 * 查询余额
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward inqury(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int id= user.getId();
		double money = bankManager.find(id);
		request.setAttribute("money", money);
		return mapping.findForward("list1");
	}

}
