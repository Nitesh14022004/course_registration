package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.google.firebase.*;
import com.google.firebase.database.*;
import com.google.auth.oauth2.GoogleCredentials;
import java.util.concurrent.*;
import java.io.*;

public final class login_005fhandler_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

    // Firebase initialization (only needs to be done once per application)
    InputStream serviceAccount = new FileInputStream(application.getRealPath("WEB-INF/classes/google-services.json"));

    FirebaseOptions options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://course-17630-default-rtdb.firebaseio.com/") // Firebase Realtime Database URL
        .build();

    if (FirebaseApp.getApps().isEmpty()) {
        FirebaseApp.initializeApp(options);
    }

    // Retrieve form data
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Firebase Database reference
    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users");

    try {
        // Fetch user data from Firebase
        CompletableFuture<DataSnapshot> future = ref.child(username).get();
        DataSnapshot snapshot = future.get();

        if (snapshot.exists()) {
            String storedPassword = snapshot.child("password").getValue(String.class);

            if (storedPassword.equals(password)) {
                // Authentication successful
                response.sendRedirect("dashboard.jsp");
            } else {
                // Incorrect password
                out.println("<script>alert('Invalid username or password!'); window.location.href='login.html';</script>");
            }
        } else {
            // User does not exist
            out.println("<script>alert('Invalid username or password!'); window.location.href='login.html';</script>");
        }
    } catch (Exception e) {
        e.printStackTrace();
        out.println("<h3>Error connecting to Firebase. Please try again later.</h3>");
    }

      out.write('\n');
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
