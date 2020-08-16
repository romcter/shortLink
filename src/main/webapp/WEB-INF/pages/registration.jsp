<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div align="center">
    <form method="post">
        <c:if test="${emailEr ne null}">
            <p>This email is occupied</p>
        </c:if>

        <c:if test="${phoneEr ne null}">
            <p>This phone is occupied</p>
        </c:if>

        <c:if test="${loginEr ne null}">
            <p>This login is occupied</p>
        </c:if>
        <h3>Login, email and phone must be unique</h3>
        <label>
            *Create login:<input type="text" name="j_login" required/>
        </label>
        <br/><br/>
        <label>
            *Create password:<input type="password" name="j_password" required/>
        </label>
        <br/><br/>
        <label>
            Input your first name:<input type="text" name="j_firstName"/>
        </label>
        <br/><br/>
        <label>
            Input your last name:<input type="text" name="j_lastName"/>
        </label>
        <br/><br/>
        <label>
            *Enter your email:<input type="text" name="j_email" required/>
        </label>
        <br/><br/>
        <label>
            *Enter your phone:<input type="text" name="j_phone" required/>
        </label>
        <br/><br/>
        <input type="submit" value="Create account"/>
    </form>
</div>
</body>
</html>
