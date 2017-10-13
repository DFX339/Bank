package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\tbody{margin:0px; padding:0px; width:100%;text-align:center;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t }\r\n");
      out.write("\t.top{\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tfont-size:50px;\r\n");
      out.write("\t\tpadding-top:150px;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t.bg{\r\n");
      out.write("\t\tpadding-left:50px;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\t\tbackground:url(\"");
      out.print(path );
      out.write("/images/background.jpg\");\r\n");
      out.write("\t\tbackground-repeat:no-repeat ;\r\n");
      out.write("\t\theight:645px;\r\n");
      out.write("\t}\r\n");
      out.write("\t.mid{\r\n");
      out.write("\t\tpadding-top:30px;\r\n");
      out.write("\t\ttext-align:center;\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\tfunction check1(){\r\n");
      out.write("\t\tif( document.getElementById(\"username\").value==\"\"){\r\n");
      out.write("\t\t\talert(\"请输入用户名\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif( document.getElementById(\"password\").value==\"\"){\r\n");
      out.write("\t\t\talert(\"请输入密码\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tdocument.text.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction check2(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar url=\"");
      out.print(path );
      out.write("/register.html\";\r\n");
      out.write("\t\twindow.location.href=url;\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body >\r\n");
      out.write("    <div class=\"bg\" >\r\n");
      out.write("    \t<div class=\"top\">学生信息管理系统  \r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t<form name=\"text\" action=\"login.do\" method=\"post\">\r\n");
      out.write("    \t<div class=\"mid\" >\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td>用户名：</td><td><input type=\"text\" name=\"username\" id=\"username\" ></td>\r\n");
      out.write("    \t\t\t<br>\r\n");
      out.write("    \t\t<br>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td >密 &nbsp;&nbsp;码：</td><td><input type=\"password\" name=\"password\" ></td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<br><br>\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td><input type=\"radio\" name=\"shenfen\" id=\"shenfen\" value=\"1\"  checked>管理员</td>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("    \t\t\t<td><input type=\"radio\" name=\"shenfen\" id=\"shenfen\" value=\"0\"/>学生</td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<br><br>\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td><input type=\"button\" value=\"登陆\" name=\"login\" onClick=\"check1()\"></td>&nbsp;&nbsp;\r\n");
      out.write("    \t\t\t<td ><input type=\"button\" value=\"注册\" name=\"register\" onClick=\"check2()\"></td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    \t</form>\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
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
