<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Course Registration Portal</title>
    <link href="css/styles1.css" rel="stylesheet" type="text/css" />
</head>
<body>

    <!-- Registration Form -->
    <div class="register-container">
        <h2>Create an Account</h2>
        <p>Fill in the form to register</p>

        <form action="register_handler.jsp" method="POST">
            <div class="input-group">
                <label for="username"><i class="fa fa-user"></i> Username</label>
                <input type="text" id="username" name="username" placeholder="Choose a username" required>
            </div>

            <div class="input-group">
                <label for="password"><i class="fa fa-lock"></i> Password</label>
                <input type="password" id="password" name="password" placeholder="Choose a password" required>
            </div>

            <div class="input-group">
                <label for="role"><i class="fa fa-user-tag"></i> Role</label>
                <select id="role" name="role" required>
                    <option value="student">Student</option>
                    <option value="admin">Admin</option>
                </select>
            </div>

            <button type="submit">Register</button>

            <div class="footer">
                <p>Already have an account? <a href="login.html">Login Here</a></p>
            </div>
        </form>
    </div>

</body>
</html>
