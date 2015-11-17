<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>: Add Address :</title>
</head>
<body>
<form method="post" action="/addAddress">

    <fieldset>
        <table>
            <tr>
                <td><label for="city">City</label></td>
                <td><input type="text" name="city" id="city"/></td>
            </tr>

            <tr>
                <td><label for="street">Street</label></td>
                <td><input type="text" name="street" id="street"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="addAddress"></td>
                <br>
                <td><a href="/userHome">back to user page</a></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
