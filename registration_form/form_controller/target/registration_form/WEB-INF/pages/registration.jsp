<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>: Registration :</title>
    <style>
        fieldset{
            width: 600px;
            margin:0 auto;
        }
    </style>
</head>
<body>
<form:form method="post" commandName="user" action="checkRegistration" modelAttribute="user">

    <fieldset>
        <table>
            <tr>
                <td><form:label path="name"> Name :</form:label></td>
                <td><form:input path="name"/></td>
                <td><form:errors path="name" cssStyle="color: red"/></td>
            </tr>

            <tr>
                <td><form:label path="surname"> Surname :</form:label></td>
                <td><form:input path="surname"/></td>
                <td><form:errors path="surname" cssStyle="color: red"/></td>
            </tr>

            <tr>
                <td><form:label path="email"> Email:</form:label></td>
                <td><form:input path="email"/></td>
                <td><form:errors path="email" cssStyle="color: red"/></td>
            </tr>

            <tr>
                <td><form:label path="password"> Password :</form:label></td>
                <td><form:password path="password"/></td>
                <td><form:errors path="password" cssStyle="color: red"/></td>
            </tr>

            <tr>
                <td><form:label path="confirmPassword"> Confirm :</form:label></td>
                <td><form:password path="confirmPassword"/></td>
                <td><form:errors path="confirmPassword" cssStyle="color: red"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Register"></td>
                <td><a href="/login">Login</a></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>