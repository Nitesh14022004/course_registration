<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Course Registration</title>
    <link href="css/styles3.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div class="course-container">
        <header>
            <h1>Welcome to Course Registration</h1>
            <p>Please select a course to register for:</p>
        </header>

        <section class="course-selection">
            <form action="course_registration.jsp" method="POST">
                <label for="course">Select Course:</label>
                <select id="course" name="course" required>
                    <option value="web-development">Web Development</option>
                    <option value="graphic-design">Graphic Design</option>
                    <option value="data-science">Data Science</option>
                    <option value="digital-marketing">Digital Marketing</option>
                </select>

                <label for="start-date">Preferred Start Date:</label>
                <input type="date" id="start-date" name="start-date" required>

                <label for="student-name">Full Name:</label>
                <input type="text" id="student-name" name="student-name" placeholder="Enter your full name" required>

                <label for="student-email">Email Address:</label>
                <input type="email" id="student-email" name="student-email" placeholder="Enter your email" required>

                <div class="submit-button-container">
                    <button type="submit">Register for Course</button>
                </div>
            </form>
        </section>

        <footer>
            <p>&copy; 2024 Course Registration Portal</p>
        </footer>
    </div>

    <%-- Java Code for Handling Form Submission --%>
    <%
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
    %>
</body>
</html>
