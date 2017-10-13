package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(path );
      out.write("/css/base.css\" type=\"text/css\" />\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"");
      out.print(path );
      out.write("/css/dtree.css\" type=\"text/css\" />\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t    div {\r\n");
      out.write("\t\t\tpadding:0px;\r\n");
      out.write("\t\t\tmargin:0px;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tbody {\r\n");
      out.write("\t\t scrollbar-base-color:#bae87c;\r\n");
      out.write("\t\t scrollbar-arrow-color:#FFFFFF;\r\n");
      out.write("\t\t scrollbar-shadow-color:#c1ea8b;\r\n");
      out.write("\t\t padding:0px;\r\n");
      out.write("\t\t margin:auto;\r\n");
      out.write("\t\t text-align:center;\r\n");
      out.write("\t\t background-color:#ffffff;\r\n");
      out.write("\t\t background:url(images/bg.gif);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t.bitem {\r\n");
      out.write("\t\t  background:url(images/side_snow.gif);\r\n");
      out.write("\t\t  height:26px;\r\n");
      out.write("\t\t  line-height:26px;\r\n");
      out.write("\t\t  text-align:center;\r\n");
      out.write("\t\t  cursor:pointer;\r\n");
      out.write("\t\t  background-repeat: no-repeat;\r\n");
      out.write("\t\t  margin-top:0px;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t.title{\r\n");
      out.write("\t\t\tmargin-left:2px;\r\n");
      out.write("\t\t\tbackground:url(images/menubg.gif);\r\n");
      out.write("\t\t\tbackground-repeat:no-repeat;\r\n");
      out.write("\t\t\ttext-align:center;\r\n");
      out.write("\t\t\tcursor:pointer;\r\n");
      out.write("\t\t\theight:26px;\r\n");
      out.write("\t\t  \tline-height:26px;\r\n");
      out.write("\t</style>\r\n");
      out.write("\t<script language='javascript'>var curopenItem = '1';</script>\r\n");
      out.write("\t<script language=\"javascript\" type=\"text/javascript\" src=\"js/menu.js\"></script>\r\n");
      out.write("\t<base target=\"main\" />\r\n");
      out.write("  </head>\r\n");
      out.write("  <body target=\"main\">\r\n");
      out.write("  \t<div class='bitem'>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<div class='title'><tr>学生信息</tr><br></div>\r\n");
      out.write("  \t\t<tr><a href='");
      out.print(path );
      out.write("/stuInfo.do' target='main'>学生信息管理</a></tr><br>\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \r\n");
      out.write("  \t<div class='bitem'>\r\n");
      out.write("  \t\t<div class='title'><tr >学生成绩</tr><br/></div>\r\n");
      out.write("  \t\t<tr><a href='");
      out.print(path );
      out.write("/score.do?command=findGrade' target='main'>学生成绩管理</a></tr><br>\r\n");
      out.write("  \t\t<tr><a href='");
      out.print(path );
      out.write("/score.do?command=addGrade' target='main'>学生成绩录入</a></tr><br>\r\n");
      out.write("\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \t<div class='bitem'>\r\n");
      out.write("  \t\t<div class='title'><tr >课程</tr><br/></div>\r\n");
      out.write("  \t\t<tr><a href='");
      out.print(path );
      out.write("/course.do?command=findCourse' target='main'>课程管理</a></tr><br>\r\n");
      out.write("  \t    <tr><a href='");
      out.print(path );
      out.write("/course.do?command=addCourse' target='main'>课程录入</a></tr><br>\r\n");
      out.write("\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \t\r\n");
      out.write("  \t<div class='bitem'>\r\n");
      out.write("  \t\t<div class='title'><tr >通告</tr><br></div>\r\n");
      out.write("  \t\t<tr><a href='");
      out.print(path );
      out.write("/notice.do?command=findNotice' target='main'>通告信息管理</a></tr><br>\r\n");
      out.write("  \t\t<tr><a href='");
      out.print(path );
      out.write("/notice.do?command=forwardAddNotice' target='main'>添加通告</a></tr>\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \t<div class='bitem'>\r\n");
      out.write("  \t\t<div class='title'><tr>管理员账号</tr><br></div>\r\n");
      out.write("  \t\t<tr><a href='");
      out.print(path );
      out.write("/admin.do?command=findAdmin' target='main'>管理员账号管理</a></tr><br>\r\n");
      out.write("  \t\t<tr><a href='");
      out.print(path );
      out.write("/admin.do?command=updateAdmin' target='main'>修改密码</a></tr>\r\n");
      out.write("  \t</div>\r\n");
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
