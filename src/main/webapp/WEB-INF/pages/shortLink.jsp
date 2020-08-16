<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Short Link</title>
</head>
<body>
<div align="center">
    <c:if test="${noExists ne null}">
        <h2>You don't have this link</h2>
    </c:if>
    <c:if test="${occupied ne null}">
        <h2>You alredy use the link</h2>
    </c:if>
    <form method="post">
        Input the link that you want to do short<br/><input type="text" name="j_longLink" required><br/><br/>
        <input value="Сократить ссылку" type="submit">
    </form>

    <c:if test="${j_shortLink ne null}">
        Your shortLink: <a
            href="/find?find=http://localhost:8888/${j_shortLink}">http://localhost:8888/${j_shortLink}</a>
    </c:if>
    <c:choose>
        <c:when test="${j_listShortLink ne null}">

        <h3>All your short link</h3>
        <table border="1">
        <tr>
            <th>Short link:</th>
            <th>How much use the link:</th>
        </tr>
        <c:forEach var="shortLink" items="${j_listShortLink}">
            <tr>
                <td><a href="/find?find=http://localhost:8888/${shortLink.shortlink}">http://localhost:8888/${shortLink.shortlink}</a></td>
                <td><c:out value="${shortLink.count}"/></td>
            </tr>
        </c:forEach>
        </table>
        </c:when>
        <c:when test="${j_listShortLink == null}">
            <h2>Now you don't have short link</h2>
        </c:when>
    </c:choose>

    <c:url value="/logout" var="logoutUrl"/>
    <p>Click to logout: <a href="${logoutUrl}">LOGOUT</a></p>
</div>
</body>
</html>
