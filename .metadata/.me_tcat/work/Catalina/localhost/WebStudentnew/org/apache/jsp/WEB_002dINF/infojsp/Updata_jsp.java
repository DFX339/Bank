package org.apache.jsp.WEB_002dINF.infojsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class Updata_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");

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
      out.write("        \tfunction check4(){\r\n");
      out.write("\t\t\t\t var  f=document.formAdd;\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t  if(f.name.value==\"\")\r\n");
      out.write("\t\t   \r\n");
      out.write("\t        {\r\n");
      out.write("\t\t\t  alert(\"请输入用户名\");\r\n");
      out.write("\t\t\t  f.name.focus();\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  if((f.password.value.length < 6)||(f.password.value==\"\"))\r\n");
      out.write("\t\t   {\r\n");
      out.write("\t\t\t  alert(\"请输入至少 6 个字符的密码!\");\r\n");
      out.write("\t\t\t  f.password.focus();\r\n");
      out.write("\t\t\t  return false;\r\n");
      out.write("\t\t   }\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t   \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  if (f.sex.value==\"\")\r\n");
      out.write("            {\r\n");
      out.write("             alert(\"请指定性别\");\r\n");
      out.write("             f.sex.focus();\r\n");
      out.write("             return false; \r\n");
      out.write("            }\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t   var q1=f.email.value.indexOf(\"@\");\r\n");
      out.write("           var q2=f.email.value.indexOf(\".\");\r\n");
      out.write("           if (q1==-1||q2==-1)\r\n");
      out.write("             {\r\n");
      out.write("              alert(\"请输入有效的电子邮件地址\");\r\n");
      out.write("              f.email.focus();\r\n");
      out.write("              return false;\r\n");
      out.write("             }\t\r\n");
      out.write("\t\t      \r\n");
      out.write("\t\t\t document.formAdd.submit();\r\n");
      out.write("\t\t\t}\r\n");
      out.write("        </script>\r\n");
      out.write("        <style type=\"text/css\">\r\n");
      out.write("\tbody {\r\n");
      out.write("\t\t background:url(images/bg.gif);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</style>  \r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body leftmargin=\"2\" topmargin=\"9\" background='");
      out.print(path );
      out.write("/images/allbg.gif'>\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(path );
      out.write("/modifyUser.do\" name=\"formAdd\" method=\"post\" >\r\n");
      out.write("\t\t\t\t     <table width=\"98%\" align=\"center\" border=\"0\" cellpadding=\"4\" cellspacing=\"1\" bgcolor=\"#CBD8AC\" style=\"margin-bottom:8px\">\r\n");
      out.write("\t\t\t\t\t\t<tr bgcolor=\"#EEF4EA\">\r\n");
      out.write("\t\t\t\t\t        <td colspan=\"3\" background=\"");
      out.print(path );
      out.write("/images/wbg.gif\" class='title' align='center'><span>学生信息修改</span></td>\r\n");
      out.write("\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t     <input type=\"hidden\" name=\"id\" size=\"20\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t   \r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t         用户名：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" name=\"name\" size=\"20\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" readonly=true/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t        密码：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"password\" name=\"password\" id=\"userPw\" size=\"22\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.password}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t        性别：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" name=\"sex\" id=\"userSex\" size=\"22\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.sex}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t       电子邮箱：\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t        <input type=\"text\" name=\"email\" id=\"userEm\" size=\"22\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align='center' bgcolor=\"#FFFFFF\" onMouseMove=\"javascript:this.bgColor='red';\" onMouseOut=\"javascript:this.bgColor='#FFFFFF';\" height=\"22\">\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"25%\" bgcolor=\"#FFFFFF\" align=\"right\">\r\n");
      out.write("\t\t\t\t\t\t        &nbsp;\r\n");
      out.write("\t\t\t\t\t\t    </td>\r\n");
      out.write("\t\t\t\t\t\t    <td width=\"75%\" bgcolor=\"#FFFFFF\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t       <input type=\"button\" value=\"修改\" onClick=\"check4()\"/>&nbsp; \r\n");
      out.write("\t\t\t\t\t\t       <input type=\"reset\" value=\"重置\"/>&nbsp;\r\n");
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
