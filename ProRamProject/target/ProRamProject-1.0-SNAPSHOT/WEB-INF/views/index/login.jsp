<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<!--
Jon Gillingsrud, s198618
Christoffer Fredriksen, s198583
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<h:header/>

<h2>Administrator login</h2>

<form:form method="POST" action="adminpage.htm" modelAttribute="admin">
    <table>
        <tr>
            <td><form:label path="Username">Brukernavn</form:label></td>
            <td><form:input path="Username"/></td>
        </tr>
        <tr>
            <td><form:label path="Password">Passord</form:label></td>
            <td><form:input type="password" pattern="[a-zA-ZæøåÆØÅ\s\d]*" path="Password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Logg inn"/>
            </td>
        </tr>
    </table>
</form:form>


${error}

<footer>
    <hr>
    <a href="<c:url value="index.htm" />">Tilbake</a>
</footer>

</body>
</html>
