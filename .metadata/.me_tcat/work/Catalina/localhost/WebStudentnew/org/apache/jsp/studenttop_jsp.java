package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class studenttop_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>My JSP 'index.jsp' starting page</title>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\t.top { padding: 0; height: 244px; background: url(images/header.gif) no-repeat 0 100%; }\r\n");
      out.write("\t\t.text{\t\r\n");
      out.write("\t\t\tmargin-left:450px;\r\n");
      out.write("\t\t\tmargin-top:20px;\r\n");
      out.write("\t\t\talign:center;\r\n");
      out.write("\t\t\tfont-size:28px;\r\n");
      out.write("\t\t\tfont-style:normal;\r\n");
      out.write("\t\t\tfont-stretch:normal;\r\n");
      out.write("\t\t\twidth:350px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.rigth{\r\n");
      out.write("\t\t\tmargin:10px;\r\n");
      out.write("\t\t\tmargin-left:790px;\r\n");
      out.write("\t\t\twidth:550px;\r\n");
      out.write("\t\t\tcolor:red;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction logout()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t   if(confirm(\"确定要退出本系统吗??\"))\r\n");
      out.write("\t\t   {\r\n");
      out.write("\t\t\t  window.parent.location=\"student.do?command=stuLoginOut\";\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction reflash(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t  window.parent.location=\"student.do?command=stuReflash\";\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body class=\"top\">\r\n");
      out.write("  \t<table >\r\n");
      out.write("  \t\t<div class=\"text\">\r\n");
      out.write("  \t\t<p >学生信息管理系统欢迎您</p></div>\r\n");
      out.write("  \t\t<div class=\"rigth\">\r\n");
      out.write("  \t\t<a href=\"#\" onclick=\"logout()\">退出系统</a> &nbsp;&nbsp;&nbsp;<a href=\"#\" onclick=\"reflash()\">刷新</a>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t</table>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
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
