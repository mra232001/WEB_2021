<%--
  Created by IntelliJ IDEA.
  User: Manh Do
  Date: 09.12.2021
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
<form action = "processFormVersion2" method="GET">
    <input type = "text" name = "username" placeholder="Your Username" />
    <input type = "password" name = "password" placeholder="Your password"/>
    <input type = "submit" />

</form>

<a href = "/mvc-demo/register"> Don't have an account? Click here!</a>

</body>
</html>
