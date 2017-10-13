package cn.bank.exception;

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

/**
 * 自定义的异常处理类
 * @author Administrator
 * @version 3.0  2017/8/23
 *
 */
public class BankExceptionHandler extends ExceptionHandler{

	@Override
	public ActionForward execute(Exception ex, ExceptionConfig ae,
			ActionMapping mapping, ActionForm formInstance,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		//判断如果为自定义异常类型，就自己处理
		if(ex instanceof BankException){
			ActionForward forward=new ActionForward();
			
			/*
			 * 通过mapping对象得到ActionForward对象，根据配置找到转向路径，
			 * 先判断<exception>标签中是否有path属性，如果有就按照path属性跳转，
			 * 如果没有就从对应的<action>标签中判断是否有input属性，根据input属性完成跳转
			 */
			if(ae.getPath()!=null){
				forward.setPath(ae.getPath());
			}else if(mapping.getInput()!=null){
				forward.setPath(mapping.getInput());
			}else{
				forward.setPath("/errorMsg.jsp");
			}
			
			/*
			 * 自己处理异常的流程
			 * 1、异常类型转型
			 * 2、得到国际化资源文件的key
			 * 3、得到国际化资源文件的动态填充信息
			 * 4、创建国际化文本对象，将key 和 填充信息设定到该对象中
			 * 5、创建ActionMessages对管理国际化文本对象
			 * 6、将国际化文本对象设定到ActionMessages中
			 * 7、将ActionMessages对象设定到request内置对象中，Globals.ERROR_KEY作为属性名
			 */
			BankException bankExe=(BankException)ex;
			String errorCode=bankExe.getErrorCode();
			Object[] error=bankExe.getError();
			ActionMessage errorMsg=new ActionMessage(errorCode,error);
			ActionMessages errors=new ActionMessages();
			errors.add(errorCode,errorMsg);
			request.setAttribute(Globals.ERROR_KEY, errors);
			
			return forward;
			
		}else{
		
		//如果抛出的异常不是BankException类型就执行父类的异常处理方法
		return super.execute(ex, ae, mapping, formInstance, request, response);
		}
	}
	
	
}
