<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>: Add Contact :</title>
</head>
<body>
<form method="post" action="/addContact">

    <fieldset>
        <table>
            <tr>
                <td><label for="mobileNumber">MobileNumber:</label></td>
                <td><input type="tel" name="mobileNumber" id="mobileNumber"/></td>
            </tr>

            <tr>
                <td><label for="homeNumber">homeNumber:</label></td>
                <td><input type="tel" name="homeNumber" id="homeNumber"/></td>
            </tr>

            <tr>
                <td><input type="submit" value="addContact"></td>
                <br>
                <td><a href="/userHome">Back</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
