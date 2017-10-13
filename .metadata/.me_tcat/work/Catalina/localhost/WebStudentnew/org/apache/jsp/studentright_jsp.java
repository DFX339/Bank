package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.util.*;
import java.text.SimpleDateFormat;;

public final class studentright_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

String getDate() 
{ 
Date now = new Date(); 
SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"); 
return sdf.format(now); 
} 

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
      out.write(" \r\n");
      out.write("  \r\n");
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
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyw\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t\tbody{\r\n");
      out.write("\t\t\tbackground-image:url(\"images/bg.gif\")\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>\r\n");
      out.write("  </head>\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  <body >\r\n");
      out.write("  \t<div class=\"nav\" id=\"container\">\r\n");
      out.write("\t<div class=\"main_top\" align=\"center\">\r\n");
      out.write("\t\t<ul class=\"main_top_title\">\r\n");
      out.write("\t\t\t<li>服务器基本信息</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<table class=\"main_con1\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n");
      out.write("\t\t<tr class=\"main_con_title\">\t\r\n");
      out.write("\t\t\t<td colspan=\"4\">服务器的有关参数</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr id=\"maindetail1\" onmouseover=\"changecolor(this);\" onmouseout=\"changecolor(this);\">\t\r\n");
      out.write("\t\t\t<td class=\"main_con_item1\">系统名称：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item2\">学生信息管理系统</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item3\">服务器操作系统：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item4\">windows XP</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr id=\"maindetail1\" onmouseover=\"changecolor(this);\" onmouseout=\"changecolor(this);\">\t\r\n");
      out.write("\t\t\t<td  class=\"main_con_item1\">服务器：</td>\r\n");
      out.write("\t\t\t<td  class=\"main_con_item2\">");
      out.print(request.getServerName());
      out.write("</td>\r\n");
      out.write("\t\t\t<td  class=\"main_con_item3\">服务器端口：</td>\r\n");
      out.write("\t\t\t<td  class=\"main_con_item4\">");
      out.print(request.getServerPort());
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr id=\"maindetail1\" onmouseover=\"changecolor(this);\" onmouseout=\"changecolor(this);\">\t\r\n");
      out.write("\t\t\t<td class=\"main_con_item1\">使用协议：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item2\">");
      out.print(request.getProtocol() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item3\">系统版本号：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item4\">1.4</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr id=\"maindetail1\" onmouseover=\"changecolor(this);\" onmouseout=\"changecolor(this);\">\t\r\n");
      out.write("\t\t\t<td class=\"main_con_item1\">服务器时间：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item2\">");
      out.print(getDate());
      out.write("</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item3\">建议分辩率：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item4\">1024*768</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\t<table class=\"main_con1\" cellpadding=\"0\" cellspacing=\"0\" align=\"center\">\r\n");
      out.write("\t\t<tr class=\"main_con_title\">\t\r\n");
      out.write("\t\t\t<td colspan=\"4\">系统维护联系方式 技术支持</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr id=\"maindetail1\" onmouseover=\"changecolor(this);\" onmouseout=\"changecolor(this);\">\t\r\n");
      out.write("\t\t\t<td class=\"main_con_item1\">学校名称：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item2\">XXXXXX</td></tr>\r\n");
      out.write("\t\t\t<tr id=\"maindetail1\" onmouseover=\"changecolor(this);\" onmouseout=\"changecolor(this);\">\r\n");
      out.write("\t\t\t<td class=\"main_con_item3\">通迅地址：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item4\">XXXXXXXX</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr id=\"maindetail1\" onmouseover=\"changecolor(this);\" onmouseout=\"changecolor(this);\">\t\r\n");
      out.write("\t\t\t<td class=\"main_con_item1\">邮政编码：</td>\r\n");
      out.write("\t\t\t<td class=\"main_con_item2\">330000</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t</table>\r\n");
      out.write("</div>\r\n");
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
