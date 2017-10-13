package cn.bank.ssh.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 更改国际化语言的Action
 * @version 5.0 2017/9/17
 */
public class ChangeLanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/**
		 * 1.获取表单中的请求参数，取得参数值，根据参数值选定国际化语言
		 * 2.得到默认的Locale对象
		 * 3.根据表单中参数创建新的Locale对象
		 * 4.将新的Locale对象存放在request内置对象中
		 * 5.设定转向信息 完成跳转
		 */
		String lang=request.getParameter("lang");
		Locale locale=Locale.getDefault();
		
		
		if("zh".equals(lang)){
			locale=new Locale("zh","CH");
		}
		if("en".equals(lang)){
			locale=new Locale("en","US");
		}
		this.setLocale(request, locale);
		
		ActionForward forward =new ActionForward();
		forward.setPath("/index.jsp");
		
		return forward;
	}

}
