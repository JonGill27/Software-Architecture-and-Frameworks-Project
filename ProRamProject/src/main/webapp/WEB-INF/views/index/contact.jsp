<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--
Jon Gillingsrud, s198618
Christoffer Fredriksen, s198583
-->

<html>
<head>
    <title>Kontakt oss</title>
</head>
<body>
<h:header/>

<h2>#Kontakt oss</h2>

<form:form method="POST" action="index.htm" modelAttribute="contact">
    <table>
        <tr>
            <td><form:label path="Name">Navn</form:label></td>
            <td><form:input path="Name" pattern="[a-zA-ZæøåÆØÅ\s]*" required="required"/></td>
        </tr>
        <tr>
            <td><form:label path="Email">E-post</form:label></td>
            <td><form:input path="Email" type="email" required="required"/></td>
        </tr>

        <tr>
            <td><form:label path="Message">Melding</form:label></td>
            <td><form:textarea path="Message" rows="5" cols="30" required="required"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Send"/>
            </td>
        </tr>
    </table>
</form:form>


${error}

<h:footer/>
</body>
</html>
