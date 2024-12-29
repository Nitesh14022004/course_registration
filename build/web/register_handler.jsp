<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Course Registration Portal</title>
    <link href="css/styles1.css" rel="stylesheet" type="text/css" />
</head>
<body>

<%
    // Getting form data from the request
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String role = request.getParameter("role");

    // Database connection details
    String dbURL = "jdbc:mysql://localhost:3306/course_registration?useSSL=false&serverTimezone=UTC";
    String dbUser = "root"; // MySQL username
    String dbPass = "shiv9925"; // MySQL password

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String insertSQL = "INSERT INTO register (username, password, role) VALUES (?, ?, ?)";

    try {
        // Load MySQL JDBC driver (optional for newer versions)
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection to the database
        connection = DriverManager.getConnection(dbURL, dbUser, dbPass);

        // Create a prepared statement to insert data
        preparedStatement = connection.prepareStatement(insertSQL);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, role);

        // Execute the query
        int rowsInserted = preparedStatement.executeUpdate();

        if (rowsInserted > 0) {
            out.println("<h3>Registration successful! You can now <a href='login.html'>login</a></h3>");
        } else {
            out.println("<h3>Error occurred while registering. Please try again.</h3>");
        }

    } catch (SQLException e) {
        e.printStackTrace();
        out.println("<h3>Error: Unable to connect to the database.</h3>");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
        out.println("<h3>MySQL JDBC Driver not found. Make sure to include the driver in your project.</h3>");
    } finally {
        // Close resources
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
%>

</body>
</html>
