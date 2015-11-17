<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>: User Page :</title>
</head>
<body>
<c:if test="${empty sessionScope.currentUser}">
    <%response.sendRedirect("login");%>
</c:if>

<table border="2px" style="width: 400px">
    <tr>
        <th>ID</th>
        <th>Status</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Password</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr style="color: red">
            <td><c:if test="${user.isStatus()}">
                <div style="width: 10px ;height: 10px ;background-color: blue"></div>
            </c:if></td>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getSurname()}</td>
            <td>${user.getEmail()}</td>
            <td>${user.getPassword()}</td>
        </tr>

    </c:forEach>
</table>
<br>
<br>


<table border="2px" style="width: 400px">
    <tr>
        <th>ID</th>
        <th>city</th>
        <th>street</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <c:if test="${sessionScope.currentUser.getEmail() == user.getEmail()}">
            <c:forEach var="address" items="${address}">
                <tr style="color: green">
                    <td>${address.getAddress_id()}</td>
                    <td>${address.getCity()}</td>
                    <td>${address.getStreet()}</td>
                </tr>
            </c:forEach>
        </c:if>
    </c:forEach>
</table>

<br>
<br>

<table border="2px" style="width: 400px">
    <tr>
        <th>MobileNumber</th>
        <th>HomeNumber</th>
    </tr>
    <c:forEach var="contact" items="${contact}">
        <tr style="color: green">
            <td>${contact.getMobileNumber()}</td>
            <td>${contact.getHomeNumber()}</td>
        </tr>

    </c:forEach>
</table>

<br>
<br>

<%--<table border="2px" style="width: 400px">--%>
<%--<tr>--%>
<%--<th>MobileNumber</th>--%>
<%--<th>HomeNumber</th>--%>
<%--</tr>--%>

<%--<c:forEach var="user" items="${users}">--%>
<%--<c:if test="${sessionScope.currentUser == user}">--%>
<%--<c:forEach var="contact" items="${user}">--%>
<%--<tr>--%>
<%--<td>${contact.getMobileNumber()}</td>--%>
<%--<td>${contact.getHomeNumber()}</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</c:if>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<br>
<br>
<br>
<%--<table  border="2px" style="width: 400px">--%>
<%--<tr>--%>
<%--<th>Street</th>--%>
<%--<th>City</th>--%>
<%--</tr>--%>

<%--<c:forEach var="address" items="${address}">--%>
<%--&lt;%&ndash;<c:if test="${sessionScope.currentUser == user}">&ndash;%&gt;--%>
<%--<tr>--%>
<%--<td>${user.getAddress().getStreet()}</td>--%>
<%--<td>${user.getAddress().getCity()}</td>--%>
<%--</tr>--%>
<%--&lt;%&ndash;</c:if>&ndash;%&gt;--%>
<%--</c:forEach>--%>
<%--</table>--%>
<div>
    <a href="/registration">Register</a><br>
    <a href="/logout">Logout</a><br>
    <a href="/addContact">addContact</a><br>
    <a href="/addAddress">addAddress</a>
</div>
</body>
</html>