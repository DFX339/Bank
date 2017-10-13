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
		
		//判断是否为当前项目的异常类型，如果是就使用自定义异常处理流程
		if(ex instanceof BankException){
			/**
			 * 创建forward对象
			 * 1.查看异常信息中是否设定转向信息，设定了就取出来设到forward对象的path中
			 * 2.如果异常配置中没有设定，就从发生异常的action中查看input属性的值，然后设到forward对象的path属性中
			 * 3.两者都没有配置就跳转到错误页面
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
			 * 自己处理异常的流程
			 * 1.将异常类型强转为自定义类型
			 * 2.得到异常信息的key
			 * 3.得到你异常的动态填充信息
			 * 4.将key和动态填充信息设定到ActionMessage对象中（new） 
			 * 5.将ActionMessage对象设定到ActionMessages对象中，以异常信息的key作为key,内部是map
			 * 6.将ActionMessages对象存储到request内置对象中，Globals_ERROR_KEY作为属性名
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
			//不是自定义异常类型，便使用父类的异常处理流程
			return super.execute(ex, ae, mapping, formInstance, request, response);
		}
	}
	
	
}
