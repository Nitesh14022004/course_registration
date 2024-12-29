<%@ page import="java.sql.*, java.io.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Course Registration Portal</title>
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
    // Retrieve username and password from the form
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    
    // Database connection variables
    String dbURL = "jdbc:mysql://localhost:3306/course_registration";
    String dbUser = "root"; // Your MySQL username
    String dbPass = "shiv9925"; // Your MySQL password
    
    // SQL query to verify user credentials
    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        // Load MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection to the database
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // Create a PreparedStatement to prevent SQL injection
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);

        // Execute the query
        rs = stmt.executeQuery();

        // Check if a record was returned
        if (rs.next()) {
            // User authenticated, redirect to the dashboard or home page
            response.sendRedirect("dashboard.jsp");
        } else {
            // Authentication failed, show error message
            out.println("<script>alert('Invalid username or password!'); window.location.href='login.jsp';</script>");
        }
    } catch (Exception e) {
        // Handle errors (e.g., print error message)
        e.printStackTrace();
        out.println("<h3>MySQL JDBC Driver not found. Make sure to include the driver in your project.</h3>");
    } finally {
        // Close database resources
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>
</body>
</html>