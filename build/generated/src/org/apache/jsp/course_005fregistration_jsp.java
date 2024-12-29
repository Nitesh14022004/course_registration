package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;

public final class course_005fregistration_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <title>Course Registration</title>\n");
      out.write("    <link href=\"css/styles3.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"course-container\">\n");
      out.write("        <header>\n");
      out.write("            <h1>Welcome to Course Registration</h1>\n");
      out.write("            <p>Please select a course to register for:</p>\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <section class=\"course-selection\">\n");
      out.write("            <form action=\"course_registration.jsp\" method=\"POST\">\n");
      out.write("                <label for=\"course\">Select Course:</label>\n");
      out.write("                <select id=\"course\" name=\"course\" required>\n");
      out.write("                    <option value=\"web-development\">Web Development</option>\n");
      out.write("                    <option value=\"graphic-design\">Graphic Design</option>\n");
      out.write("                    <option value=\"data-science\">Data Science</option>\n");
      out.write("                    <option value=\"digital-marketing\">Digital Marketing</option>\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("                <label for=\"start-date\">Preferred Start Date:</label>\n");
      out.write("                <input type=\"date\" id=\"start-date\" name=\"start-date\" required>\n");
      out.write("\n");
      out.write("                <label for=\"student-name\">Full Name:</label>\n");
      out.write("                <input type=\"text\" id=\"student-name\" name=\"student-name\" placeholder=\"Enter your full name\" required>\n");
      out.write("\n");
      out.write("                <label for=\"student-email\">Email Address:</label>\n");
      out.write("                <input type=\"email\" id=\"student-email\" name=\"student-email\" placeholder=\"Enter your email\" required>\n");
      out.write("\n");
      out.write("                <div class=\"submit-button-container\">\n");
      out.write("                    <button type=\"submit\">Register for Course</button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <footer>\n");
      out.write("            <p>&copy; 2024 Course Registration Portal</p>\n");
      out.write("        </footer>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("    ");

        // Check if form is submitted
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // Get form data
            String course = request.getParameter("course");
            String startDate = request.getParameter("start-date");
            String studentName = request.getParameter("student-name");
            String studentEmail = request.getParameter("student-email");

            // Database connection details
            String dbURL = "jdbc:mysql://localhost:3306/course_registration?useSSL=false&serverTimezone=UTC";
            String dbUser = "root"; // MySQL username
            String dbPass = "shiv9925"; // MySQL password

            // SQL query to insert data
            String sql = "INSERT INTO course_registrations (course, start_date, student_name, student_email) VALUES (?, ?, ?, ?)";

            // Database connection and statement
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                 Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
                    
                    PreparedStatement stmt = conn.prepareStatement(sql);

                // Set parameters for the query
                stmt.setString(1, course);
                stmt.setDate(2, Date.valueOf(startDate)); // Convert String to Date
                stmt.setString(3, studentName);
                stmt.setString(4, studentEmail);

                // Execute the update (insert data)
                int rowsInserted = stmt.executeUpdate();

                if (rowsInserted > 0) {
                    // Set attributes to pass to the next page
                    request.setAttribute("course", course);
                    request.setAttribute("start_date", startDate);
                    request.setAttribute("student_name", studentName);
                    request.setAttribute("student_email", studentEmail);

                    // Redirect to successful registration page
                    response.sendRedirect("registersuccess.jsp");
                } else {
                    out.println("<h3>Registration failed. Please try again.</h3>");
                }

            } catch (SQLException e) {
                e.printStackTrace();
                out.println("<h3>Error: Could not connect to the database.</h3>");
            } catch (Exception e) {
                e.printStackTrace();
                out.println("<h3>Unexpected error occurred.</h3>");
            }
        }
    
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
