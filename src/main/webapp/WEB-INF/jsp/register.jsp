<%--
  Created by IntelliJ IDEA.
  User: Manh Do
  Date: 09.12.2021
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Register Form</title>


</head>
<body>

${message}

<form:form action = "ProcessRegister" modelAttribute="user">

    Username: <form:input path="username"/>

    <br><br>

    Password: <form:input path="password"/>

    <br><br>

    Re-password: <form:input path="confirm"/>

    <br><br>

    <input type = "submit" value = "Submit" />

</form:form>

</body>
</html>
