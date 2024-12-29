package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registersuccess_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>Successful</title>\n");
      out.write("    <link href=\"css/styles1.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"completion-container\">\n");
      out.write("        <header>\n");
      out.write("            <h1>Registration Successful!</h1>\n");
      out.write("            <p>Thank you for registering. Here are your registration details:</p>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <section class=\"registration-details\">\n");
      out.write("            <h2>Your Registration Details</h2>\n");
      out.write("            <div class=\"details\">\n");
      out.write("                <p><strong>Name:</strong> </p>\n");
      out.write("                <p><strong>Email:</strong> </p>\n");
      out.write("                <p><strong>Course Registered:</strong> </p>\n");
      out.write("                <p><strong>Start Date:</strong> </p>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <p>We look forward to seeing you in the course!</p>\n");
      out.write("            <a href=\"courselist.jsp\" class=\"back-button\">Go Back to Course Registration</a>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <p>&copy; 2024 Course Registration Portal</p>\n");
      out.write("        </footer>\n");
      out.write("    </div>\n");
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
