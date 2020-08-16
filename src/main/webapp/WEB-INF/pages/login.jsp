<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <c:url value="/j_spring_security_check" var="loginUrl"/>

    <form action="${loginUrl}" method="post">
        <c:if test="${error ne null}">
            <p>You enter incorrect login or password</p>
        </c:if>
        <p>Login:</p><input name="j_login" type="text" required>
        <p>Password:</p><input name="j_password" type="password" required>
        <br/><br/>
        <input type="submit" value="Enter"/>
        <br/><br/>
        <a href="/registration"><h3>Registration</h3></a>
    </form>
</div>
</body>
</html>
