package cn.bank.ssh.action;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * ���Ĺ��ʻ����Ե�Action
 * @version 5.0 2017/9/17
 */
public class ChangeLanAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/**
		 * 1.��ȡ���е����������ȡ�ò���ֵ�����ݲ���ֵѡ�����ʻ�����
		 * 2.�õ�Ĭ�ϵ�Locale����
		 * 3.���ݱ��в��������µ�Locale����
		 * 4.���µ�Locale��������request���ö�����
		 * 5.�趨ת����Ϣ �����ת
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
