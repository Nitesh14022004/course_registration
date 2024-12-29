package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Register - Course Registration Portal</title>\n");
      out.write("    <link href=\"css/styles1.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <!-- Registration Form -->\n");
      out.write("    <div class=\"register-container\">\n");
      out.write("        <h2>Create an Account</h2>\n");
      out.write("        <p>Fill in the form to register</p>\n");
      out.write("\n");
      out.write("        <form action=\"register_handler.jsp\" method=\"POST\">\n");
      out.write("            <div class=\"input-group\">\n");
      out.write("                <label for=\"username\"><i class=\"fa fa-user\"></i> Username</label>\n");
      out.write("                <input type=\"text\" id=\"username\" name=\"username\" placeholder=\"Choose a username\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"input-group\">\n");
      out.write("                <label for=\"password\"><i class=\"fa fa-lock\"></i> Password</label>\n");
      out.write("                <input type=\"password\" id=\"password\" name=\"password\" placeholder=\"Choose a password\" required>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"input-group\">\n");
      out.write("                <label for=\"role\"><i class=\"fa fa-user-tag\"></i> Role</label>\n");
      out.write("                <select id=\"role\" name=\"role\" required>\n");
      out.write("                    <option value=\"student\">Student</option>\n");
      out.write("                    <option value=\"admin\">Admin</option>\n");
      out.write("                </select>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <button type=\"submit\">Register</button>\n");
      out.write("\n");
      out.write("            <div class=\"footer\">\n");
      out.write("                <p>Already have an account? <a href=\"login.html\">Login Here</a></p>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
