<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<fmt:setLocale value="${requestScope.locale}"/>
<fmt:setBundle basename="language.title" var="language" scope="request"/>
<html>
<head>
    <title>Library</title>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="resources/favicon.ico"/>
    <link rel="stylesheet" href="resources/css/main.css"/>
</head>
<body>
<div class="page">
    <sec:authorize access="hasRole('ADMIN') and isAuthenticated()">
        <div class="context header">
            <c:import url="admin/header.jsp" charEncoding="utf-8"/>
        </div>
        <div class="context middle">
            <!--menu left-->
            <div class="middle-menu">
                <c:import url="admin/menu.jsp" charEncoding="utf-8"/>
            </div>
            <div class="middle-context">
                <!--menu top-->
                <c:if test="${not empty pageMenu}">
                    <div class="middle-context-menu-top">
                        <c:import url="${pageMenu}" charEncoding="utf-8"/>
                    </div>
                </c:if>
                <!--content-->
                <c:if test="${not empty page}">
                    <div class="middle-context-data"><c:import url="${page}" charEncoding="utf-8"/></div>
                </c:if>
            </div>
        </div>
    </sec:authorize>
    <sec:authorize access="hasRole('READER') and isAuthenticated()">
        <div class="context header">
            <c:import url="reader/header.jsp" charEncoding="utf-8"/>
        </div>
        <div class="context middle">
            <!--menu left-->
            <div class="middle-menu">
                <c:import url="reader/menu.jsp" charEncoding="utf-8"/>
            </div>
            <div class="middle-context">
                <!--menu top-->
                <c:if test="${not empty pageMenu}">
                    <div class="middle-context-menu-top">
                        <c:import url="${pageMenu}" charEncoding="utf-8"/>
                    </div>
                </c:if>
                <!--content-->
                <c:if test="${not empty page}">
                    <div class="middle-context-data"><c:import url="${page}" charEncoding="utf-8"/></div>
                </c:if>
            </div>
        </div>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <div class="context header">
            <c:import url="guest/header.jsp" charEncoding="utf-8"/>
        </div>
        <div class="context middle">
            <!--menu left-->
            <div class="middle-menu">
                <c:import url="guest/menu.jsp" charEncoding="utf-8"/>
            </div>
            <div class="middle-context">
                <!--menu top-->
                <c:if test="${not empty pageMenu}">
                    <div class="middle-context-menu-top">
                        <c:import url="${pageMenu}" charEncoding="utf-8"/>
                    </div>
                </c:if>
                <!--content-->
                <c:if test="${not empty page}">
                    <div class="middle-context-data"><c:import url="${page}" charEncoding="utf-8"/></div>
                </c:if>
            </div>
        </div>
    </sec:authorize>
    <div class="context footer">
        <c:import url="common/footer.jsp" charEncoding="utf-8"/>
    </div>
</div>
</body>
</html>
