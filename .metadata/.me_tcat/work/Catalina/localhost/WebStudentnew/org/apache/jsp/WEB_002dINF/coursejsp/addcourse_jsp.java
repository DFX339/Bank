package org.apache.jsp.WEB_002dINF.coursejsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class addcourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      out.write("\t\t\t\tvar  f=document.formAdd;\r\n");
      out.write("\t\t\t\tif( document.getElementById(\"className\").value==\"\"){\r\n");
      out.write("\t\t\t\t\talert(\"请输入课程名称\");\r\n");
      out.write("\t\t\t\t    f.className.focus();\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif( document.getElementById(\"teacher\").value==\"\"){\r\n");
      out.write("\t\t\t\t\talert(\"请输入任课教师名字\");\r\n");
      out.write("\t\t\t\t\tf.teacher.focus();\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\tif( document.getElementById(\"score\").value==\"\"){\r\n");
      out.write("\t\t\t\t\talert(\"请输入该课程学分\");\r\n");
      out.write("\t\t\t\t\tf.score.focus();\r\n");
      out.write("\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t}\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tdocument.text.submit();\r\n");
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
      out.write("/course.do?command=addCourseFinish\" name=\"formAdd\" method=\"post\">\r\n");
      out.write("\t\t\t\t     <table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"4\" cellspacing=\"1\" bgcolor=\"#CBD8AC\" style=\"margin-bottom:8px\">\r\n");
      out.write("\t\t\t\t\t\t<tr bgcolor=\"#EEF4EA\">\r\n");
      out.write("\t\t\t\t\t        <td colspan=\"3\" background=\"");
      out.print(path );
      out.write("/images/wbg.gif\" class='title' align='center'><span>添加课程</span></td>\r\n");
      out.write("\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t         课程名称：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" name=\"className\" id=\"className\" size=\"20\"/>\r\n");
      out.write("\t\t\t\t\t\t  \r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t        任课教师：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t    \t <input type=\"text\" name=\"teacher\" id=\"teacher\" size=\"20\"/>\r\n");
      out.write("\t\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t\t\t     \r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t        课程学分：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" name=\"score\" id=\"score\" size=\"22\"/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t        &nbsp;\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t       <input type=\"submit\" value=\"提交\" onClick=\"check1()\"/>&nbsp; \r\n");
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
}