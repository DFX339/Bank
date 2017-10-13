package org.apache.jsp.WEB_002dINF.scorejsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class StudentGradeAdd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write(" \r\n");
      out.write(" \r\n");

	String path = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"pragma\" content=\"no-cache\" />\r\n");
      out.write("\t\t<meta http-equiv=\"cache-control\" content=\"no-cache\" />\r\n");
      out.write("\t\t<meta http-equiv=\"expires\" content=\"0\" />\r\n");
      out.write("\t\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\" />\r\n");
      out.write("\t\t<meta http-equiv=\"description\" content=\"This is my page\" />\r\n");
      out.write("        \r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path );
      out.write("/css/base.css\" />\r\n");
      out.write("        \r\n");
      out.write("        <script language=\"javascript\">\r\n");
      out.write("            function closeOpen()\r\n");
      out.write("\t\t    {\r\n");
      out.write("\t\t       window.returnValue=false;\r\n");
      out.write("\t\t       window.close();\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t\tfunction check1(){\r\n");
      out.write("\t\t\t\tif( document.getElementById(\"grade\").value==\"\"){\r\n");
      out.write("\t\t\t\t\talert(\"请输入学生成绩\");\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t\tdocument.formAdd.submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("        </script>\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\t background:url(images/bg.gif);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body leftmargin=\"2\" topmargin=\"9\" background='");
      out.print(path );
      out.write("/images/allbg.gif'> \r\n");
      out.write("\t\t\t<form action=\"");
      out.print(path );
      out.write("/score.do?command=addGradeFinish\" name=\"formAdd\" method=\"post\">\r\n");
      out.write("\t\t\t\t     <table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"4\" cellspacing=\"1\" bgcolor=\"#CBD8AC\" style=\"margin-bottom:8px\">\r\n");
      out.write("\t\t\t\t\t\t<tr bgcolor=\"#EEF4EA\">\r\n");
      out.write("\t\t\t\t\t        <td colspan=\"3\" background=\"");
      out.print(path );
      out.write("/images/wbg.gif\" class='title' align='center'><span>学生成绩添加</span></td>\r\n");
      out.write("\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t         学生名：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <select name=\"studentId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=0 selected>请选择</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\t\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t        课程名：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <select name=\"classId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=0 selected>请选择</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\t\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t     成绩：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" name=\"grade\" id=\"grade\" size=\"22\"/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t        &nbsp;\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t       <input type=\"button\" value=\"提交\" onClick=\"check1()\"/>&nbsp; \r\n");
      out.write("\t\t\t\t\t\t       <input type=\"reset\" value=\"重置\"/>&nbsp;\r\n");
      out.write("\t\t\t\t\t\t       <input type=\"button\" value=\"取消\" onclick=\"closeOpen()\"/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t </table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("   </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/scorejsp/StudentGradeAdd.jsp(55,10) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/scorejsp/StudentGradeAdd.jsp(55,10) '${studentAllId}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${studentAllId}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/scorejsp/StudentGradeAdd.jsp(55,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("s");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/scorejsp/StudentGradeAdd.jsp(69,10) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/scorejsp/StudentGradeAdd.jsp(69,10) '${classAllId}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${classAllId}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/scorejsp/StudentGradeAdd.jsp(69,10) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("s");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write(' ');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.className}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
