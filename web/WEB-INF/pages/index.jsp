<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Home</title>
</head>
<body>
<h2>${message}</h2>

<form action='<spring:url value="/logout"/>' method="post">
    <input value="Logout" type="submit">
</form>
</body>
</html>