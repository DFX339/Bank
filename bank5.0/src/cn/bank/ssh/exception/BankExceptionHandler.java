package cn.bank.ssh.exception;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;

public class BankExceptionHandler extends ExceptionHandler {

	@Override
	public ActionForward execute(Exception ex, ExceptionConfig ae,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		//�ж��Ƿ�Ϊ��ǰ��Ŀ���쳣���ͣ�����Ǿ�ʹ���Զ����쳣��������
		if(ex instanceof BankException){
			/**
			 * ����forward����
			 * 1.�鿴�쳣��Ϣ���Ƿ��趨ת����Ϣ���趨�˾�ȡ�����赽forward�����path��
			 * 2.����쳣������û���趨���ʹӷ����쳣��action�в鿴input���Ե�ֵ��Ȼ���赽forward�����path������
			 * 3.���߶�û�����þ���ת������ҳ��
			 * */
			ActionForward forward=new ActionForward();
			if(ae.getPath()!=null){
				forward.setPath(ae.getPath());
			}else if(mapping.getInput()!=null){
				forward.setPath(mapping.getInput());
			}else{
				forward.setPath("/errorMsg.jsp");
			}
			/**
			 * �Լ������쳣������
			 * 1.���쳣����ǿתΪ�Զ�������
			 * 2.�õ��쳣��Ϣ��key
			 * 3.�õ����쳣�Ķ�̬�����Ϣ
			 * 4.��key�Ͷ�̬�����Ϣ�趨��ActionMessage�����У�new�� 
			 * 5.��ActionMessage�����趨��ActionMessages�����У����쳣��Ϣ��key��Ϊkey,�ڲ���map
			 * 6.��ActionMessages����洢��request���ö����У�Globals_ERROR_KEY��Ϊ������
			 */
			BankException bankException=(BankException)ex;
		    String errorCode=bankException.getErrorCode();
		    Object[] objs=bankException.getObj();
		    ActionMessage message=new ActionMessage(errorCode,objs);
			ActionMessages error=new ActionMessages();
			error.add(errorCode,message);
			request.setAttribute(Globals.ERROR_KEY, error);
			return forward;
			
		}else{
			//�����Զ����쳣���ͣ���ʹ�ø�����쳣��������
			return super.execute(ex, ae, mapping, formInstance, request, response);
		}
	}
	
	
}
