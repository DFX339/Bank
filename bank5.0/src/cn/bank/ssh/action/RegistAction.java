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
 * ע���ǰ�˿�����
 * @author Administrator
 * @version 5.0 2017/9/17
 */
public class RegistAction extends Action {
	//ʹ��spring������ע��bankManager��ֱ��ʹ��
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
		System.out.println("ע����Ϊ+--"+flag);
		if(flag){
			return mapping.findForward("login");
		}else{
			return mapping.findForward("error");
		}
	}

}
