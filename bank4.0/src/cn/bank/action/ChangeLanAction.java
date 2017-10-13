package cn.bank.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ChangeLanAction extends Action{

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
			
			this.setLocale(request, locale);
			
			return forward;
	
	}
	
}
