package org.apache.jsp.WEB_002dINF.coursejsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SeecourseInfo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("\t<!-- \t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(path );
      out.write("/css/base.css\" />\t -->\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("           function courseDel(courseId)\r\n");
      out.write("           {\r\n");
      out.write("               if(confirm('您确定删除吗？'))\r\n");
      out.write("               {\t\r\n");
      out.write("              \r\n");
      out.write("                   window.location.href=\"");
      out.print(path );
      out.write("/course.do?command=delCourse&courseId=\"+courseId;\r\n");
      out.write("               }\r\n");
      out.write("           }\r\n");
      out.write("    </script>\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("\t\tbody {\r\n");
      out.write("\t\t\t background:url(images/bg.gif);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("        \r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body leftmargin=\"2\" topmargin=\"2\" >\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t<table width=\"98%\" border=\"0\" cellpadding=\"2\" cellspacing=\"1\" bgcolor=\"#D1DDAA\" align=\"center\" style=\"margin-top:8px\">\r\n");
      out.write("\t\t\t\t<tr bgcolor=\"#E7E7E7\">\r\n");
      out.write("\t\t\t\t\t<td height=\"14\" colspan=\"6\" align='center'>&nbsp;课程信息&nbsp;</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr align=\"center\" bgcolor=\"#FAFAF1\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t<td width=\"20%\">ID</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"20%\">课程名</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"20%\">任课教师</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"20%\">课程学分</td>\r\n");
      out.write("\t\t\t\t\t<td width=\"20%\">操作</td>\r\n");
      out.write("\t\t\t\t\t \r\n");
      out.write("\t\t        </tr>\t\r\n");
      out.write("\t\t\t\t");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/coursejsp/SeecourseInfo.jsp(50,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/coursejsp/SeecourseInfo.jsp(50,4) '${AllCourse}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${AllCourse}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      // /WEB-INF/coursejsp/SeecourseInfo.jsp(50,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("s");
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" height=\"22\">\r\n");
            out.write("\t\t\t\t\t<td bgcolor=\"#FFFFFF\" align=\"center\">\r\n");
            out.write("\t\t\t\t\t\t");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\r\n");
            out.write("\t\t\t\t\t</td>\r\n");
            out.write("\t\t\t\t\t<td bgcolor=\"#FFFFFF\" align=\"center\">\r\n");
            out.write("\t\t\t\t\t\t");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.className}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\r\n");
            out.write("\t\t\t\t\t</td>\r\n");
            out.write("\t\t\t\t\t<td bgcolor=\"#FFFFFF\" align=\"center\">\r\n");
            out.write("\t\t\t\t\t    ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.teacher}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\r\n");
            out.write("\t\t\t\t\t</td>\r\n");
            out.write("\t\t\t\t\t<td bgcolor=\"#FFFFFF\" align=\"center\">\r\n");
            out.write("\t\t\t\t\t   ");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.score}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\r\n");
            out.write("\t\t\t\t\t</td>\t \r\n");
            out.write("\t\t\t\t    <td bgcolor=\"#FFFFFF\" align=\"center\">\r\n");
            out.write("\t\t\t\t\t\t <a href=\"#\" onclick=\"courseDel(");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write(")\" >删除</a>\r\n");
            out.write("\t\t\t\t\t    <a href=\"");
            out.print(path );
            out.write("/course.do?command=updateCourse&id=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${s.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
            out.write("\">修改</a>\r\n");
            out.write("\t\t\t\t\t</td>\r\n");
            out.write("\t\t\t\t</tr>\r\n");
            out.write("\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
        _005fjspx_005ftagPool_005fc_005fforEach_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      }
      out.write("\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t    \r\n");
      out.write("\t</body>\r\n");
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
}
