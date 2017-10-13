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
      out.write("<!-- 获取当前项目名 /bank2.0 -->\r\n");
String path=request.getContextPath(); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 获取当前 http://127.0.0.1:8080/bank2.0/ -->\r\n");
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>bank</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"index.css\">\r\n");
      out.write("\t<script src=\"jquery-3.2.1.min.js\"></script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\twindow.onload=function(){\r\n");
      out.write("\t\t\tvar img=document.getElementById('imga');\r\n");
      out.write("\t\t\tvar imgs=img.getElementsByTagName('img');\r\n");
      out.write("\t\t\tvar curIndex=0;\r\n");
      out.write("\t\t\tvar handler=null;\r\n");
      out.write("\t\t\thandler=setInterval(changeImg,2000);\r\n");
      out.write("\t\t\tfunction changeImg(){\r\n");
      out.write("\t\t\t\t\t\tvar img=document.getElementById('imga');\r\n");
      out.write("\t\t\t\t\t\tvar imgs=img.getElementsByTagName('img');\r\n");
      out.write("\t\t\t\t\t\timgs[curIndex].className='hide';\r\n");
      out.write("\t\t\t\t\t\tvar nextIndex=curIndex+1>=imgs.length?0:curIndex+1;\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\timgs[nextIndex].className='show';\r\n");
      out.write("\t\t\t\t\t\tcurIndex=nextIndex;\r\n");
      out.write("\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"net\">\r\n");
      out.write("\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t<div class=\"logo\">\r\n");
      out.write("\t\t\t\t<span class=\"logo-left\">DFX</span>\r\n");
      out.write("\t\t\t\t<img src=\"images/logo.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t\t<span class=\"logo-right\">段飞霞个人银行</span>\r\n");
      out.write("\t\t\t\t<input type=\"search\" placeholder=\"新版网银\">\r\n");
      out.write("\t\t\t\t<label for=\"\"><img src=\"images/yi.jpg\" alt=\"\"></label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>首页</li>\r\n");
      out.write("\t\t\t\t<li>个人业务</li>\r\n");
      out.write("\t\t\t\t<li>公司业务</li>\r\n");
      out.write("\t\t\t\t<li>信用卡</li>\r\n");
      out.write("\t\t\t\t<li>帮助</li>\r\n");
      out.write("\t\t\t\t<li class=\"lastchild\"><a href=\"toLogin.do\">登录</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"lunbo\">\r\n");
      out.write("\t\t\t<ul class='mainMenu2'>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<span class=\"first\"><a href=\"toLogin.do\">用户登录</a></span><br/>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<span><a href=\"\">个人网上银行</a></span><br/>\r\n");
      out.write("\t\t\t\t\t<ul class='subMenu'>\r\n");
      out.write("\t\t\t\t\t\t<li>><a href=\"regist.jsp\">>注册</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li>><a href=\"\">>指南</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">>网银助手</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">>安全专区</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">>防范假网站</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<span><a href=\"\">企业网上银行</a></span><br/>\r\n");
      out.write("\t\t\t\t\t<ul class='subMenu'>\r\n");
      out.write("\t\t\t\t\t\t<li>><a href=\"\">>注册</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li>><a href=\"\">>演示</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">>指南</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">>网银助手</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t<span><a href=\"\">合作软件</a></span><br/>\r\n");
      out.write("\t\t\t\t\t<ul class='subMenu'>\r\n");
      out.write("\t\t\t\t\t\t<li>><a href=\"\">>拼多多</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li>><a href=\"\">>融已购</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">>开心银行</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"\">>快乐购</a></li>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<ul class=\"img\" id=\"imga\">\r\n");
      out.write("\t\t\t\t<li><img src=\"images/1.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t<li><img src=\"images/2.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t<li><img src=\"images/3.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t\t<li><img src=\"images/4.jpg\" alt=\"\"></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"news\">\r\n");
      out.write("\t\t\t<div class=\"n-left\">\r\n");
      out.write("\t\t\t\t<h4>重要公告</h4>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\">关于我行系统升级的通告</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\">关于国家开发银行2017年第七期金融债券柜台市...</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\">关于销售国家开发银行2017年第七期金融债券的...</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\">关于开办账户农产品和账户基本金属连续产品业..</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span>\r\n");
      out.write("\t\t\t\t\t\t<a href=\"\">关于调整人民币和美元账户钯金报价价差的通告</a>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"n-right\">\r\n");
      out.write("\t\t\t\t<h4>优惠活动</h4>\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span><a href=\"\">\"点差优惠 直通年底\"账户贵金属垫差优惠活动</a><span class=\"rp\">即日起至2017年12月31日</span></li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span><a href=\"\">西瓜+WIFI+冰淇淋+爱奇艺 手机银行多重优惠过暑假</a><span class=\"rp\">即日起至2017年8月10日</span>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span><a href=\"\">免押金+30天免费骑的摩拜单车 快来领福利啦！</a><span class=\"rp\">即日起至2017年7月31日</span>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<span class=\"lp\">></span><a href=\"\">关于开办账户农产品和账户基本金属连续产品业..</a><span class=\"rp\">即日起至2017年12月31日</span>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"little-a\">\r\n");
      out.write("\t\t\t\t\t\t\t<li>看电影</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>去旅行</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>尝美食</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>兑积分</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>骑车行</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li>分期购</li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"selector\">\r\n");
      out.write("\t\t\t\t<select name=\"\" id=\"selec1\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\" selected>中国DFX系列银行</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">美国分行网站</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">加拿大分行网站</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">南非分行网站</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">俄罗斯分行网站</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"\" id=\"selec2\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\" selected>境内分支银行</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">北京分行</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">上海分行</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">深圳分行</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">南京分行</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t<select name=\"\" id=\"selec3\">\r\n");
      out.write("\t\t\t\t\t<option value=\"\" selected>友情链接</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">淘宝网</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">百度</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">阿里巴巴</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"\">网易</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"footer\">\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li><a href=\"\">网站声明</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"\">服务网点</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"\">网站地图</a></li>\r\n");
      out.write("\t\t\t\t<li><a href=\"\">联系我行</a></li>\r\n");
      out.write("\t\t\t\t<li>服务热线888888</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<img src=\"images/LOG.jpg\" alt=\"\">\r\n");
      out.write("\t\t\t<span>中国DFX银行版权所有  赣ICP站666666号</span>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
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
