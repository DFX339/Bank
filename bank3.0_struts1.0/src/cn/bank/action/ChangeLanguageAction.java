package cn.bank.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cn.bank.bean.User;
import cn.bank.form.UserForm;
import cn.bank.manager.BankManager;

/**
 * 国际化语言操作前端控制器
 * @author DFX
 * @version 3.0 2017/8/24
 * 
 * */
public class ChangeLanguageAction  extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
			ActionForward forward=new ActionForward();
			
			Locale locale=Locale.getDefault();
			
			String language=request.getParameter("lang");
			
			if("zh".equals(language)){
				locale=new Locale("zh","CH");
			}
			
			if("en".equals(language)){
				locale=new Locale("en","US");
			}
			
			forward.setPath("/index.jsp");
//			request.getSession().setAttribute(Globals.LOCALE_KEY,locale);
			
			this.setLocale(request, locale);
			
			return forward;
	
	}
	

}
